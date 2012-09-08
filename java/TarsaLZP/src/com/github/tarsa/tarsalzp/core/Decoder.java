package com.github.tarsa.tarsalzp.core;

import com.github.tarsa.tarsalzp.Options;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Piotr Tarsa
 */
public final class Decoder extends Common {

    private int rcBuffer;
    private int rcRange;
    private boolean started;
    private int nextHighBit = 0;

    public Decoder(final InputStream inputStream,
            final OutputStream outputStream, final Options options) {
        super(inputStream, outputStream, options);
        started = false;
    }

    private int inputByte() throws IOException {
        final int inputByte = inputStream.read();
        if (inputByte == -1) {
            throw new IOException("Unexpected end of file.");
        }
        final int currentByte = (inputByte >> 1) + (nextHighBit << 7);
        nextHighBit = inputByte & 1;
        return currentByte;
    }

    private void init() throws IOException {
        rcBuffer = 0;
        for (int i = 0; i < 4; i++) {
            rcBuffer = (rcBuffer << 8) + inputByte();
        }
        rcRange = 0x7FFFFFFF;
        started = true;
    }

    private void normalize() throws IOException {
        while (rcRange < 0x00800000) {
            rcBuffer = (rcBuffer << 8) + inputByte();
            rcRange <<= 8;
        }
    }

    private boolean decodeFlag(final int probability) throws IOException {
        normalize();
        final int rcHelper = (rcRange >> 15) * probability;
        if (rcHelper > rcBuffer) {
            rcRange = rcHelper;
            return true;
        } else {
            rcRange -= rcHelper;
            rcBuffer -= rcHelper;
            return false;
        }
    }

    private boolean decodeSkewed() throws IOException {
        normalize();
        if (rcBuffer < rcRange - 1) {
            rcRange--;
            return true;
        } else {
            rcBuffer = 0;
            rcRange = 1;
            return false;
        }
    }

    private int decodeSingleOnlyLowLzp() throws IOException {
        computeHashes();
        final int modelLowFrequency =
                getSeeLow(getLzpStateLow(getLastHashLow()));
        final int predictedSymbol = getLzpPredictedSymbolLow(getLastHashLow());
        final boolean match = decodeFlag(modelLowFrequency);
        updateSeeLow(getLzpStateLow(getLastHashLow()), match);
        final int nextSymbol = match ? predictedSymbol
                : decodeSymbol(predictedSymbol);
        updateLzpStateLow(getLastHashLow(), nextSymbol, match);
        updateContext(nextSymbol);
        return nextSymbol;
    }

    private int decodeSingle() throws IOException {
        computeHashes();
        final int modelLowFrequency =
                getSeeLow(getLzpStateLow(getLastHashLow()));
        final int modelHighFrequency =
                getSeeHigh(getLzpStateHigh(getLastHashHigh()));
        boolean match;
        int predictedSymbol;
        int nextSymbol;
        if (modelLowFrequency >= modelHighFrequency) {
            predictedSymbol = getLzpPredictedSymbolLow(getLastHashLow());
            match = decodeFlag(modelLowFrequency);
            updateSeeLow(getLzpStateLow(getLastHashLow()), match);
            if (match) {
                nextSymbol = predictedSymbol;
            } else {
                nextSymbol = decodeSymbol(predictedSymbol);
            }
            updateLzpStateLow(getLastHashLow(), nextSymbol, match);
            predictedSymbol = getLzpPredictedSymbolHigh(getLastHashHigh());
            match = nextSymbol == predictedSymbol;
            updateSeeHistoryHigh(match);
            updateLzpStateHigh(getLastHashHigh(), nextSymbol, match);
        } else {
            predictedSymbol = getLzpPredictedSymbolHigh(getLastHashHigh());
            match = decodeFlag(modelHighFrequency);
            updateSeeHigh(getLzpStateHigh(getLastHashHigh()), match);
            if (match) {
                nextSymbol = predictedSymbol;
            } else {
                nextSymbol = decodeSymbol(predictedSymbol);
            }
            updateLzpStateHigh(getLastHashHigh(), nextSymbol, match);
            predictedSymbol = getLzpPredictedSymbolLow(getLastHashLow());
            match = nextSymbol == predictedSymbol;
            updateSeeHistoryLow(match);
            updateLzpStateLow(getLastHashLow(), nextSymbol, match);
        }
        updateContext(nextSymbol);
        return nextSymbol;
    }

    private int decodeSymbol(final int mispredictedSymbol) throws IOException {
        normalize();
        computePpmContext();
        final short mispredictedSymbolFrequency =
                rangesSingle[(getLastPpmContext() << 8) + mispredictedSymbol];
        rcRange = rcRange / (rangesTotal[getLastPpmContext()]
                - mispredictedSymbolFrequency);
        rangesSingle[(getLastPpmContext() << 8) + mispredictedSymbol] = 0;
        rangesGrouped[((getLastPpmContext() << 8) + mispredictedSymbol) >> 4] -=
                mispredictedSymbolFrequency;
        int rcHelper = rcBuffer / rcRange;
        final int cumulativeFrequency = rcHelper;
        int index;
        for (index = getLastPpmContext() << 4; rcHelper >= rangesGrouped[index];
                index++) {
            rcHelper -= rangesGrouped[index];
        }
        for (index <<= 4; rcHelper >= rangesSingle[index]; index++) {
            rcHelper -= rangesSingle[index];
        }
        rcBuffer -= (cumulativeFrequency - rcHelper) * rcRange;
        rcRange *= rangesSingle[index];
        final int nextSymbol = index & 0xff;
        rangesSingle[(getLastPpmContext() << 8) + mispredictedSymbol] =
                mispredictedSymbolFrequency;
        rangesGrouped[((getLastPpmContext() << 8) + mispredictedSymbol) >> 4] +=
                mispredictedSymbolFrequency;
        updatePpm(index);
        return nextSymbol;
    }

    boolean decode(final long limit) throws IOException {
        if (!started) {
            init();
        }
        boolean endReached = false;
        for (int i = 0; i < limit; i++) {
            endReached = !decodeSkewed();
            if (!endReached) {
                final int symbol = onlyLowLzp ? decodeSingleOnlyLowLzp()
                        : decodeSingle();
                outputStream.write(symbol);
            } else {
                break;
            }
        }
        return endReached;
    }
}

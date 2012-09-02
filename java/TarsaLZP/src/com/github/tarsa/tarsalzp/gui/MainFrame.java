package com.github.tarsa.tarsalzp.gui;

import com.github.tarsa.tarsalzp.Options;
import com.github.tarsa.tarsalzp.core.Coder;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.Bindings;

/**
 *
 * @author Piotr Tarsa
 */
public class MainFrame extends JFrame {

    private static final long serialVersionUID = -3240444466539184363L;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        actionButtonGroup = new javax.swing.ButtonGroup();
        optionsBean = new com.github.tarsa.tarsalzp.gui.OptionsBean();
        actionBean = new com.github.tarsa.tarsalzp.gui.ActionBean();
        filenamesPanel = new javax.swing.JPanel();
        inputFileLabel = new javax.swing.JLabel();
        outputFileLabel = new javax.swing.JLabel();
        inputPathTextField = new javax.swing.JTextField();
        outputPathTextField = new javax.swing.JTextField();
        inputFileChooseButton = new javax.swing.JButton();
        outputFileChooseButton = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        optionsPanel = new javax.swing.JPanel();
        lzpLowContextLengthLabel = new javax.swing.JLabel();
        lzpLowMaskSizeLabel = new javax.swing.JLabel();
        lzpHighContextLengthLabel = new javax.swing.JLabel();
        lzpHighMaskSizeLabel = new javax.swing.JLabel();
        lzpLowContextLengthSpinner = new javax.swing.JSpinner();
        lzpLowMaskSizeSpinner = new javax.swing.JSpinner();
        lzpHighContextLengthSpinner = new javax.swing.JSpinner();
        lzpHighMaskSizeSpinner = new javax.swing.JSpinner();
        ppmOrderLabel = new javax.swing.JLabel();
        ppmInitLabel = new javax.swing.JLabel();
        ppmStepLabel = new javax.swing.JLabel();
        ppmLimitLabel = new javax.swing.JLabel();
        ppmOrderSpinner = new javax.swing.JSpinner();
        ppmInitSpinner = new javax.swing.JSpinner();
        ppmStepSpinner = new javax.swing.JSpinner();
        ppmLimitSpinner = new javax.swing.JSpinner();
        actionPanel = new javax.swing.JPanel();
        actionSelectionPanel = new javax.swing.JPanel();
        encodeRadioButton = new javax.swing.JRadioButton();
        decodeRadioButton = new javax.swing.JRadioButton();
        showDetailsRadioButton = new javax.swing.JRadioButton();
        actionButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        lafListMenu = new javax.swing.JMenu();
        fillLafsMenu(lafListMenu);
        aboutMenu = new javax.swing.JMenu();

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, inputPathTextField, org.jdesktop.beansbinding.ELProperty.create("${text}"), actionBean, org.jdesktop.beansbinding.BeanProperty.create("inputFilePath"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, outputPathTextField, org.jdesktop.beansbinding.ELProperty.create("${text}"), actionBean, org.jdesktop.beansbinding.BeanProperty.create("outputFilePath"));
        bindingGroup.addBinding(binding);

        actionBean.setOptionsBean(optionsBean);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        filenamesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Files"));

        inputFileLabel.setText("Input file");
        inputFileLabel.setToolTipText("Input file path");

        outputFileLabel.setText("Output file");
        outputFileLabel.setToolTipText("Output file path");

        inputPathTextField.setText("Enter path to input file here");

        outputPathTextField.setText("Enter path to output file here");

        inputFileChooseButton.setText("File Chooser");
        inputFileChooseButton.setToolTipText("Browse filesystem for input file");
        inputFileChooseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputFileChooseButtonActionPerformed(evt);
            }
        });

        outputFileChooseButton.setText("File Chooser");
        outputFileChooseButton.setToolTipText("Browse filesystem for output file");
        outputFileChooseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputFileChooseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout filenamesPanelLayout = new javax.swing.GroupLayout(filenamesPanel);
        filenamesPanel.setLayout(filenamesPanelLayout);
        filenamesPanelLayout.setHorizontalGroup(
            filenamesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filenamesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(filenamesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(outputFileLabel)
                    .addComponent(inputFileLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(filenamesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputPathTextField)
                    .addComponent(outputPathTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(filenamesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputFileChooseButton, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(outputFileChooseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        filenamesPanelLayout.setVerticalGroup(
            filenamesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filenamesPanelLayout.createSequentialGroup()
                .addGroup(filenamesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputPathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputFileChooseButton)
                    .addComponent(inputFileLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(filenamesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(outputFileLabel)
                    .addComponent(outputPathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputFileChooseButton)))
        );

        progressBar.setEnabled(false);

        optionsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Options"));

        lzpLowContextLengthLabel.setText("LZP Low Context Length");

        lzpLowMaskSizeLabel.setText("LZP Low Mask Size");
        lzpLowMaskSizeLabel.setToolTipText("Model size is 2^(Mask Size) entries with 2 bytes per entry");

        lzpHighContextLengthLabel.setText("LZP High Context Length");

        lzpHighMaskSizeLabel.setText("LZP High Mask Size");
        lzpHighMaskSizeLabel.setToolTipText("Model size is 2^(Mask Size) entries with 2 bytes per entry");

        lzpLowContextLengthSpinner.setToolTipText("Value must be higher than PPM Order and not higher than LZP High Context Length");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, optionsBean, org.jdesktop.beansbinding.ELProperty.create("${lzpLowContextLength}"), lzpLowContextLengthSpinner, org.jdesktop.beansbinding.BeanProperty.create("value"), "");
        bindingGroup.addBinding(binding);

        lzpLowMaskSizeSpinner.setToolTipText("Value must be between 15 and 30 (inclusive)");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, optionsBean, org.jdesktop.beansbinding.ELProperty.create("${lzpLowMaskSize}"), lzpLowMaskSizeSpinner, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        lzpHighContextLengthSpinner.setToolTipText("Value must not be lower than LZP Low Context Length and not higher than 8");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, optionsBean, org.jdesktop.beansbinding.ELProperty.create("${lzpHighContextLength}"), lzpHighContextLengthSpinner, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        lzpHighMaskSizeSpinner.setToolTipText("Value must be between 15 and 30 (inclusive)");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, optionsBean, org.jdesktop.beansbinding.ELProperty.create("${lzpHighMaskSize}"), lzpHighMaskSizeSpinner, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        ppmOrderLabel.setText("PPM Order");

        ppmInitLabel.setText("PPM Init");

        ppmStepLabel.setText("PPM Step");

        ppmLimitLabel.setText("PPM Limit");

        ppmOrderSpinner.setToolTipText("Value must be not lower than 1 and not higher than 2 or LZP Low Context Length");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, optionsBean, org.jdesktop.beansbinding.ELProperty.create("${ppmOrder}"), ppmOrderSpinner, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        ppmInitSpinner.setToolTipText("Value must be between 1 and 127 (inclusive)");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, optionsBean, org.jdesktop.beansbinding.ELProperty.create("${ppmInit}"), ppmInitSpinner, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        ppmStepSpinner.setToolTipText("Value must be between 1 and 127 (inclusive)");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, optionsBean, org.jdesktop.beansbinding.ELProperty.create("${ppmStep}"), ppmStepSpinner, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        ppmLimitSpinner.setToolTipText("Value must be between PPM Init * 256 and 32767 - PPM Step (inclusive)");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, optionsBean, org.jdesktop.beansbinding.ELProperty.create("${ppmLimit}"), ppmLimitSpinner, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout optionsPanelLayout = new javax.swing.GroupLayout(optionsPanel);
        optionsPanel.setLayout(optionsPanelLayout);
        optionsPanelLayout.setHorizontalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lzpLowContextLengthLabel)
                    .addComponent(lzpLowMaskSizeLabel)
                    .addComponent(lzpHighContextLengthLabel)
                    .addComponent(lzpHighMaskSizeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lzpHighMaskSizeSpinner)
                    .addComponent(lzpHighContextLengthSpinner, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lzpLowMaskSizeSpinner, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lzpLowContextLengthSpinner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ppmInitLabel)
                    .addComponent(ppmOrderLabel)
                    .addComponent(ppmStepLabel)
                    .addComponent(ppmLimitLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ppmLimitSpinner)
                    .addComponent(ppmStepSpinner)
                    .addComponent(ppmInitSpinner)
                    .addComponent(ppmOrderSpinner))
                .addContainerGap())
        );
        optionsPanelLayout.setVerticalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsPanelLayout.createSequentialGroup()
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lzpLowContextLengthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ppmOrderLabel)
                    .addComponent(ppmOrderSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lzpLowContextLengthLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lzpLowMaskSizeLabel)
                    .addComponent(lzpLowMaskSizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ppmInitLabel)
                    .addComponent(ppmInitSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lzpHighContextLengthLabel)
                    .addComponent(lzpHighContextLengthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ppmStepLabel)
                    .addComponent(ppmStepSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lzpHighMaskSizeLabel)
                    .addComponent(lzpHighMaskSizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ppmLimitLabel)
                    .addComponent(ppmLimitSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        actionSelectionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Action"));

        actionButtonGroup.add(encodeRadioButton);
        encodeRadioButton.setText("Encode input file to output file");
        encodeRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encodeRadioButtonActionPerformed(evt);
            }
        });

        actionButtonGroup.add(decodeRadioButton);
        decodeRadioButton.setText("Decode input file to output file");
        decodeRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decodeRadioButtonActionPerformed(evt);
            }
        });

        actionButtonGroup.add(showDetailsRadioButton);
        showDetailsRadioButton.setText("Show input file compression options");
        showDetailsRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showDetailsRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout actionSelectionPanelLayout = new javax.swing.GroupLayout(actionSelectionPanel);
        actionSelectionPanel.setLayout(actionSelectionPanelLayout);
        actionSelectionPanelLayout.setHorizontalGroup(
            actionSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionSelectionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(actionSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(encodeRadioButton)
                    .addComponent(decodeRadioButton)
                    .addComponent(showDetailsRadioButton))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        actionSelectionPanelLayout.setVerticalGroup(
            actionSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionSelectionPanelLayout.createSequentialGroup()
                .addComponent(encodeRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(decodeRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showDetailsRadioButton))
        );

        actionButton.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        actionButton.setText("Do it!");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, actionBean, org.jdesktop.beansbinding.ELProperty.create("${actionAllowed}"), actionButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        actionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout actionPanelLayout = new javax.swing.GroupLayout(actionPanel);
        actionPanel.setLayout(actionPanelLayout);
        actionPanelLayout.setHorizontalGroup(
            actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionPanelLayout.createSequentialGroup()
                .addComponent(actionSelectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(actionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        actionPanelLayout.setVerticalGroup(
            actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(actionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(actionSelectionPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        lafListMenu.setText("Look and Feel");
        menuBar.add(lafListMenu);

        aboutMenu.setText("About");
        aboutMenu.setEnabled(false);
        menuBar.add(aboutMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(filenamesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(actionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filenamesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(actionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputFileChooseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputFileChooseButtonActionPerformed
        final JFileChooser chooser = new JFileChooser(
                actionBean.getInputFilePath());
        chooser.setMultiSelectionEnabled(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            actionBean.setInputFilePath(
                    chooser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_inputFileChooseButtonActionPerformed

    private void outputFileChooseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputFileChooseButtonActionPerformed
        final JFileChooser chooser = new JFileChooser(
                actionBean.getOutputFilePath());
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            actionBean.setOutputFilePath(
                    chooser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_outputFileChooseButtonActionPerformed

    private void encodeRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encodeRadioButtonActionPerformed
        actionBean.setAction(ActionBean.Action.Encode);
    }//GEN-LAST:event_encodeRadioButtonActionPerformed

    private void decodeRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decodeRadioButtonActionPerformed
        actionBean.setAction(ActionBean.Action.Decode);
    }//GEN-LAST:event_decodeRadioButtonActionPerformed

    private void showDetailsRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showDetailsRadioButtonActionPerformed
        actionBean.setAction(ActionBean.Action.ShowOptions);
    }//GEN-LAST:event_showDetailsRadioButtonActionPerformed

    private void actionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionButtonActionPerformed
        final String inputFilePath = actionBean.getInputFilePath();
        final String outputFilePath = actionBean.getOutputFilePath();
        try {
            switch (actionBean.getAction()) {
                case Encode: {
                    final EncodingWorker encodingWorker = new EncodingWorker(
                            inputFilePath, outputFilePath,
                            optionsBean.toOptions());
                    actionBean.setActionInProgress(true);
                    new Thread(encodingWorker).start();
                    break;
                }
                case Decode: {
                    final DecodingWorker decodingWorker = new DecodingWorker(
                            inputFilePath, outputFilePath);
                    actionBean.setActionInProgress(true);
                    new Thread(decodingWorker).start();
                    break;
                }
                case ShowOptions: {
                    final BufferedInputStream inputStream =
                            new BufferedInputStream(new FileInputStream(
                            inputFilePath), 64 * 1024);
                    JOptionPane.showMessageDialog(MainFrame.this,
                            Coder.getOptions(inputStream),
                            "Compression options",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }
        } catch (final Exception ex) {
            JOptionPane.showMessageDialog(MainFrame.this, ex.getMessage(),
                    "Exception thrown", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_actionButtonActionPerformed

    abstract class CommonWorker extends SwingWorker<Object, Object> {

        final InputStream inputStream;
        final FileChannel inputFileChannel;
        final OutputStream outputStream;
        final long inputFileSize;
        long startTime;
        final Binding binding;

        public CommonWorker(final String inputFilePath,
                final String outputFilePath) throws IOException {
            final FileInputStream fileInputStream =
                    new FileInputStream(inputFilePath);
            inputFileChannel = fileInputStream.getChannel();
            this.inputStream = new BufferedInputStream(
                    fileInputStream, 64 * 1024);
            this.outputStream = new BufferedOutputStream(
                    new FileOutputStream(outputFilePath), 64 * 1024);
            inputFileSize = new File(inputFilePath).length();
            progressBar.setEnabled(true);
            binding = Bindings.createAutoBinding(
                    AutoBinding.UpdateStrategy.READ, this,
                    BeanProperty.create("progress"), progressBar,
                    BeanProperty.create("value"));
        }
    }

    class EncodingWorker extends CommonWorker {

        final Options options;

        public EncodingWorker(final String inputFilePath,
                final String outputFilePath, final Options options)
                throws IOException {
            super(inputFilePath, outputFilePath);
            this.options = options;
        }

        @Override
        protected Object doInBackground() throws Exception {
            binding.bind();
            startTime = System.currentTimeMillis();
            Coder.encode(inputStream, outputStream, new Coder.Callback() {
                @Override
                public void progressChanged(final long processedSymbols) {
                    if (inputFileSize != 0) {
                        setProgress((int) (((double) processedSymbols)
                                / inputFileSize * 100));
                    }
                }
            }, 64 * 1024, options);
            inputStream.close();
            outputStream.close();
            return null;
        }

        @Override
        protected void done() {
            binding.unbind();
            progressBar.setValue(0);
            progressBar.setEnabled(false);
            try {
                get();
                JOptionPane.showMessageDialog(MainFrame.this, "Time taken: "
                        + (System.currentTimeMillis() - startTime));
            } catch (final Exception ex) {
                if (ex.getCause() instanceof OutOfMemoryError) {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "Out of memory - try lowering mask sizes or "
                            + "increasing heap size.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            ex.getMessage(), "Exception thrown",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            actionBean.setActionInProgress(false);
        }
    }

    class DecodingWorker extends CommonWorker {

        public DecodingWorker(final String inputFilePath,
                final String outputFilePath) throws IOException {
            super(inputFilePath, outputFilePath);
        }

        @Override
        protected Object doInBackground() throws Exception {
            binding.bind();
            startTime = System.currentTimeMillis();
            Coder.decode(inputStream, outputStream, new Coder.Callback() {
                @Override
                public void progressChanged(final long processedSymbols) {
                    if (inputFileSize != 0) {
                        try {
                            setProgress((int) ((double) inputFileChannel
                                    .position() / inputFileSize * 100));
                        } catch (final IOException ex) {
                        }
                    }
                }
            }, 64 * 1024);
            inputStream.close();
            outputStream.close();
            return null;
        }

        @Override
        protected void done() {
            binding.unbind();
            progressBar.setValue(0);
            progressBar.setEnabled(false);
            try {
                get();
                JOptionPane.showMessageDialog(MainFrame.this, "Time taken: "
                        + (System.currentTimeMillis() - startTime));
            } catch (final Exception ex) {
                if (ex.getCause() instanceof OutOfMemoryError) {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "Out of memory - try increasing heap size.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            ex.getMessage(), "Exception thrown",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            actionBean.setActionInProgress(false);
        }
    }

    private void fillLafsMenu(final JMenu menu) {
        try {
            final ButtonGroup buttonGroup = new ButtonGroup();
            final String currentLafName = UIManager.getLookAndFeel() == null
                    ? null : UIManager.getLookAndFeel().getName();
            for (final UIManager.LookAndFeelInfo info :
                    UIManager.getInstalledLookAndFeels()) {
                final JRadioButtonMenuItem menuItem = new JRadioButtonMenuItem(
                        info.getName(), info.getName().equals(currentLafName));
                menuItem.addActionListener(
                        new LafSelector(this, info.getName()));
                buttonGroup.add(menuItem);
                menu.add(menuItem);
            }
        } catch (final Exception ex) {
            Logger.getLogger(MainFrame.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    private static class LafSelector implements ActionListener {

        private final JFrame frame;
        private final String lafName;

        public LafSelector(final JFrame frame, final String lafName) {
            this.frame = frame;
            this.lafName = lafName;
        }

        public void select() {
            try {
                for (final UIManager.LookAndFeelInfo info :
                        UIManager.getInstalledLookAndFeels()) {
                    if (info.getName().equals(lafName)) {
                        UIManager.setLookAndFeel(info.getClassName());
                        if (frame != null) {
                            SwingUtilities.updateComponentTreeUI(frame);
                            frame.pack();
                        }
                        break;
                    }
                }
            } catch (final Exception ex) {
                Logger.getLogger(MainFrame.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void actionPerformed(final ActionEvent e) {
            select();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(final String args[]) {

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LafSelector(null, "Nimbus").select();
                final MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu aboutMenu;
    private com.github.tarsa.tarsalzp.gui.ActionBean actionBean;
    private javax.swing.JButton actionButton;
    private javax.swing.ButtonGroup actionButtonGroup;
    private javax.swing.JPanel actionPanel;
    private javax.swing.JPanel actionSelectionPanel;
    private javax.swing.JRadioButton decodeRadioButton;
    private javax.swing.JRadioButton encodeRadioButton;
    private javax.swing.JPanel filenamesPanel;
    private javax.swing.JButton inputFileChooseButton;
    private javax.swing.JLabel inputFileLabel;
    private javax.swing.JTextField inputPathTextField;
    private javax.swing.JMenu lafListMenu;
    private javax.swing.JLabel lzpHighContextLengthLabel;
    private javax.swing.JSpinner lzpHighContextLengthSpinner;
    private javax.swing.JLabel lzpHighMaskSizeLabel;
    private javax.swing.JSpinner lzpHighMaskSizeSpinner;
    private javax.swing.JLabel lzpLowContextLengthLabel;
    private javax.swing.JSpinner lzpLowContextLengthSpinner;
    private javax.swing.JLabel lzpLowMaskSizeLabel;
    private javax.swing.JSpinner lzpLowMaskSizeSpinner;
    private javax.swing.JMenuBar menuBar;
    private com.github.tarsa.tarsalzp.gui.OptionsBean optionsBean;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JButton outputFileChooseButton;
    private javax.swing.JLabel outputFileLabel;
    private javax.swing.JTextField outputPathTextField;
    private javax.swing.JLabel ppmInitLabel;
    private javax.swing.JSpinner ppmInitSpinner;
    private javax.swing.JLabel ppmLimitLabel;
    private javax.swing.JSpinner ppmLimitSpinner;
    private javax.swing.JLabel ppmOrderLabel;
    private javax.swing.JSpinner ppmOrderSpinner;
    private javax.swing.JLabel ppmStepLabel;
    private javax.swing.JSpinner ppmStepSpinner;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JRadioButton showDetailsRadioButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}

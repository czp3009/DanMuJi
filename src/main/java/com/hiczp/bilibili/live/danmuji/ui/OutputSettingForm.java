package com.hiczp.bilibili.live.danmuji.ui;

import com.hiczp.bilibili.live.danmuji.Config;
import com.hiczp.bilibili.live.danmuji.Main;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.Arrays;

/**
 * Created by czp on 17-6-2.
 */
public class OutputSettingForm extends JFrame {
    private JPanel configFormJPanel;
    private JCheckBox DanMuOn;
    private JCheckBox SysMSGOn;
    private JCheckBox SendGiftOn;
    private JCheckBox SysGiftOn;
    private JCheckBox WelcomeOn;
    private JCheckBox WelcomeGuardOn;
    private JCheckBox LiveOn;
    private JCheckBox PreparingOn;
    private JCheckBox RoomAdminsOn;
    private JSpinner DanMuSize;
    private JSpinner SysMSGSize;
    private JSpinner SendGiftSize;
    private JSpinner SysGiftSize;
    private JSpinner WelcomeSize;
    private JSpinner WelcomeGuardSize;
    private JSpinner LiveSize;
    private JSpinner PreparingSize;
    private JSpinner RoomAdminsSize;
    private JSpinner DanMuR;
    private JSpinner DanMuG;
    private JSpinner DanMuB;
    private JSpinner SysMSGR;
    private JSpinner SysMSGG;
    private JSpinner SysMSGB;
    private JSpinner SendGiftR;
    private JSpinner SendGiftG;
    private JSpinner SendGiftB;
    private JSpinner SysGiftR;
    private JSpinner SysGiftG;
    private JSpinner SysGiftB;
    private JSpinner WelcomeR;
    private JSpinner WelcomeG;
    private JSpinner WelcomeB;
    private JSpinner WelcomeGuardR;
    private JSpinner WelcomeGuardG;
    private JSpinner WelcomeGuardB;
    private JSpinner LiveR;
    private JSpinner LiveG;
    private JSpinner LiveB;
    private JSpinner PreparingR;
    private JSpinner PreparingG;
    private JSpinner PreparingB;
    private JSpinner RoomAdminsR;
    private JSpinner RoomAdminsG;
    private JSpinner RoomAdminsB;
    private JSpinner DisconnectSize;
    private JSpinner DisconnectR;
    private JSpinner DisconnectG;
    private JSpinner DisconnectB;
    private JCheckBox DisconnectOn;
    private JSpinner ConnectSize;
    private JSpinner ConnectR;
    private JSpinner ConnectG;
    private JSpinner ConnectB;
    private JCheckBox ConnectOn;
    private JButton cancelButton;
    private JButton saveButton;
    private JButton applyButton;

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    public OutputSettingForm() {
        setupDate();

        //监听器
        cancelButton.addActionListener(actionEvent -> dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING)));

        saveButton.addActionListener(actionEvent -> {
            storeDate();
            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        });

        applyButton.addActionListener(actionEvent -> storeDate());

        setTitle("OutputSettingForm");
        setContentPane(configFormJPanel);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    private void setupDate() {
        Class outputSettingForm = OutputSettingForm.class;
        Arrays.stream(Config.class.getDeclaredFields())
                .filter(field -> field.getType() == Config.OutputOptions.class)
                .forEach(field -> {
                    try {
                        String fieldName = field.getName();
                        Config.OutputOptions outputOptions = (Config.OutputOptions) field.get(Main.getConfig());
                        JSpinner size = (JSpinner) outputSettingForm.getDeclaredField(fieldName + "Size").get(this);
                        size.setValue(outputOptions.size);
                        JSpinner r = (JSpinner) outputSettingForm.getDeclaredField(fieldName + "R").get(this);
                        r.setValue(outputOptions.color.getRed());
                        JSpinner g = (JSpinner) outputSettingForm.getDeclaredField(fieldName + "G").get(this);
                        g.setValue(outputOptions.color.getGreen());
                        JSpinner b = (JSpinner) outputSettingForm.getDeclaredField(fieldName + "B").get(this);
                        b.setValue(outputOptions.color.getBlue());
                        JCheckBox on = (JCheckBox) outputSettingForm.getDeclaredField(fieldName + "On").get(this);
                        on.setSelected(outputOptions.on);
                    } catch (IllegalAccessException | NoSuchFieldException e) {
                        e.printStackTrace();
                    }
                });
    }

    private void storeDate() {
        Class outputSettingForm = OutputSettingForm.class;
        Arrays.stream(Config.class.getDeclaredFields())
                .filter(field -> field.getType() == Config.OutputOptions.class)
                .forEach(field -> {
                    try {
                        String fieldName = field.getName();
                        Config.OutputOptions outputOptions = (Config.OutputOptions) field.get(Main.getConfig());
                        JSpinner size = (JSpinner) outputSettingForm.getDeclaredField(fieldName + "Size").get(this);
                        outputOptions.size = (int) size.getValue();
                        JSpinner r = (JSpinner) outputSettingForm.getDeclaredField(fieldName + "R").get(this);
                        JSpinner g = (JSpinner) outputSettingForm.getDeclaredField(fieldName + "G").get(this);
                        JSpinner b = (JSpinner) outputSettingForm.getDeclaredField(fieldName + "B").get(this);
                        outputOptions.color = new Color((int) r.getValue(), (int) g.getValue(), (int) b.getValue());
                        JCheckBox on = (JCheckBox) outputSettingForm.getDeclaredField(fieldName + "On").get(this);
                        outputOptions.on = on.isSelected();
                    } catch (IllegalAccessException | NoSuchFieldException e) {
                        e.printStackTrace();
                    }
                });
        Main.getMainForm().reloadStyle();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        configFormJPanel = new JPanel();
        configFormJPanel.setLayout(new GridLayoutManager(13, 6, new Insets(5, 5, 5, 5), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText("Size");
        configFormJPanel.add(label1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("DanMu");
        configFormJPanel.add(label2, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("SysMSG");
        configFormJPanel.add(label3, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("SendGift");
        configFormJPanel.add(label4, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("SysGift");
        configFormJPanel.add(label5, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Welcome");
        configFormJPanel.add(label6, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("WelcomeGuard");
        configFormJPanel.add(label7, new GridConstraints(8, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("Live");
        configFormJPanel.add(label8, new GridConstraints(9, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label9 = new JLabel();
        label9.setText("Preparing");
        configFormJPanel.add(label9, new GridConstraints(10, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label10 = new JLabel();
        label10.setText("RoomAdmins");
        configFormJPanel.add(label10, new GridConstraints(11, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label11 = new JLabel();
        label11.setText("On");
        configFormJPanel.add(label11, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        DanMuOn = new JCheckBox();
        DanMuOn.setText("");
        configFormJPanel.add(DanMuOn, new GridConstraints(3, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        SysMSGOn = new JCheckBox();
        SysMSGOn.setText("");
        configFormJPanel.add(SysMSGOn, new GridConstraints(4, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        SendGiftOn = new JCheckBox();
        SendGiftOn.setText("");
        configFormJPanel.add(SendGiftOn, new GridConstraints(5, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        SysGiftOn = new JCheckBox();
        SysGiftOn.setText("");
        configFormJPanel.add(SysGiftOn, new GridConstraints(6, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        WelcomeOn = new JCheckBox();
        WelcomeOn.setText("");
        configFormJPanel.add(WelcomeOn, new GridConstraints(7, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        WelcomeGuardOn = new JCheckBox();
        WelcomeGuardOn.setText("");
        configFormJPanel.add(WelcomeGuardOn, new GridConstraints(8, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        LiveOn = new JCheckBox();
        LiveOn.setText("");
        configFormJPanel.add(LiveOn, new GridConstraints(9, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        PreparingOn = new JCheckBox();
        PreparingOn.setText("");
        configFormJPanel.add(PreparingOn, new GridConstraints(10, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        RoomAdminsOn = new JCheckBox();
        RoomAdminsOn.setText("");
        configFormJPanel.add(RoomAdminsOn, new GridConstraints(11, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label12 = new JLabel();
        label12.setText("Type");
        configFormJPanel.add(label12, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label13 = new JLabel();
        label13.setText("R");
        configFormJPanel.add(label13, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        DanMuSize = new JSpinner();
        configFormJPanel.add(DanMuSize, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        SysMSGSize = new JSpinner();
        configFormJPanel.add(SysMSGSize, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        SendGiftSize = new JSpinner();
        configFormJPanel.add(SendGiftSize, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        SysGiftSize = new JSpinner();
        configFormJPanel.add(SysGiftSize, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        WelcomeSize = new JSpinner();
        configFormJPanel.add(WelcomeSize, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        WelcomeGuardSize = new JSpinner();
        configFormJPanel.add(WelcomeGuardSize, new GridConstraints(8, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        LiveSize = new JSpinner();
        configFormJPanel.add(LiveSize, new GridConstraints(9, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        PreparingSize = new JSpinner();
        configFormJPanel.add(PreparingSize, new GridConstraints(10, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        RoomAdminsSize = new JSpinner();
        configFormJPanel.add(RoomAdminsSize, new GridConstraints(11, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        DanMuR = new JSpinner();
        configFormJPanel.add(DanMuR, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        DanMuG = new JSpinner();
        configFormJPanel.add(DanMuG, new GridConstraints(3, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        DanMuB = new JSpinner();
        configFormJPanel.add(DanMuB, new GridConstraints(3, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label14 = new JLabel();
        label14.setText("G");
        configFormJPanel.add(label14, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label15 = new JLabel();
        label15.setText("B");
        configFormJPanel.add(label15, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        SysMSGR = new JSpinner();
        configFormJPanel.add(SysMSGR, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        SendGiftR = new JSpinner();
        configFormJPanel.add(SendGiftR, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        SysGiftR = new JSpinner();
        configFormJPanel.add(SysGiftR, new GridConstraints(6, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        WelcomeR = new JSpinner();
        configFormJPanel.add(WelcomeR, new GridConstraints(7, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        WelcomeGuardR = new JSpinner();
        configFormJPanel.add(WelcomeGuardR, new GridConstraints(8, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        LiveR = new JSpinner();
        configFormJPanel.add(LiveR, new GridConstraints(9, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        PreparingR = new JSpinner();
        configFormJPanel.add(PreparingR, new GridConstraints(10, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        RoomAdminsR = new JSpinner();
        configFormJPanel.add(RoomAdminsR, new GridConstraints(11, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        RoomAdminsG = new JSpinner();
        configFormJPanel.add(RoomAdminsG, new GridConstraints(11, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        PreparingG = new JSpinner();
        configFormJPanel.add(PreparingG, new GridConstraints(10, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        LiveG = new JSpinner();
        configFormJPanel.add(LiveG, new GridConstraints(9, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        WelcomeGuardG = new JSpinner();
        configFormJPanel.add(WelcomeGuardG, new GridConstraints(8, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        WelcomeG = new JSpinner();
        configFormJPanel.add(WelcomeG, new GridConstraints(7, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        SysGiftG = new JSpinner();
        configFormJPanel.add(SysGiftG, new GridConstraints(6, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        SendGiftG = new JSpinner();
        configFormJPanel.add(SendGiftG, new GridConstraints(5, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        SysMSGG = new JSpinner();
        configFormJPanel.add(SysMSGG, new GridConstraints(4, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        SysMSGB = new JSpinner();
        configFormJPanel.add(SysMSGB, new GridConstraints(4, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        SendGiftB = new JSpinner();
        configFormJPanel.add(SendGiftB, new GridConstraints(5, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        SysGiftB = new JSpinner();
        configFormJPanel.add(SysGiftB, new GridConstraints(6, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        WelcomeB = new JSpinner();
        configFormJPanel.add(WelcomeB, new GridConstraints(7, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        WelcomeGuardB = new JSpinner();
        configFormJPanel.add(WelcomeGuardB, new GridConstraints(8, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        LiveB = new JSpinner();
        configFormJPanel.add(LiveB, new GridConstraints(9, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        PreparingB = new JSpinner();
        configFormJPanel.add(PreparingB, new GridConstraints(10, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        RoomAdminsB = new JSpinner();
        configFormJPanel.add(RoomAdminsB, new GridConstraints(11, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label16 = new JLabel();
        label16.setText("Disconnect");
        configFormJPanel.add(label16, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        DisconnectSize = new JSpinner();
        configFormJPanel.add(DisconnectSize, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        DisconnectR = new JSpinner();
        configFormJPanel.add(DisconnectR, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        DisconnectG = new JSpinner();
        configFormJPanel.add(DisconnectG, new GridConstraints(2, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        DisconnectB = new JSpinner();
        configFormJPanel.add(DisconnectB, new GridConstraints(2, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        DisconnectOn = new JCheckBox();
        DisconnectOn.setText("");
        configFormJPanel.add(DisconnectOn, new GridConstraints(2, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label17 = new JLabel();
        label17.setText("Connect");
        configFormJPanel.add(label17, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ConnectSize = new JSpinner();
        configFormJPanel.add(ConnectSize, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ConnectR = new JSpinner();
        configFormJPanel.add(ConnectR, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ConnectG = new JSpinner();
        configFormJPanel.add(ConnectG, new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ConnectB = new JSpinner();
        configFormJPanel.add(ConnectB, new GridConstraints(1, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ConnectOn = new JCheckBox();
        ConnectOn.setText("");
        configFormJPanel.add(ConnectOn, new GridConstraints(1, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cancelButton = new JButton();
        cancelButton.setText("Cancel");
        configFormJPanel.add(cancelButton, new GridConstraints(12, 4, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        saveButton = new JButton();
        saveButton.setText("Save");
        configFormJPanel.add(saveButton, new GridConstraints(12, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        applyButton = new JButton();
        applyButton.setText("Apply");
        configFormJPanel.add(applyButton, new GridConstraints(12, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return configFormJPanel;
    }
}

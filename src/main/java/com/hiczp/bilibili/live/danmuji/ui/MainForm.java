package com.hiczp.bilibili.live.danmuji.ui;

import com.hiczp.bilibili.live.danmu.api.LiveDanMuAPI;
import com.hiczp.bilibili.live.danmuji.Config;
import com.hiczp.bilibili.live.danmuji.LiveDanMuCallback;
import com.hiczp.bilibili.live.danmuji.Main;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by czp on 17-5-31.
 */
public class MainForm extends JFrame {
    private static final String FORM_TITLE = "DanMuJi";
    private static final String BILIBILI_LIVE_URL_PREFIX = "http://live.bilibili.com/";

    private JPanel mainFormJPanel;
    private JTextField textField;
    private JButton startButton;
    private JButton stopButton;
    private JTextPane textPane;
    private JPanel mainOperationJPanel;

    private LiveDanMuAPI liveDanMuAPI;
    private StyledDocument styledDocument;

    //JMenuBar
    {
        JMenuBar jMenuBar = new JMenuBar();

        JMenu window = new JMenu("Window");
        JMenuItem operationArea = new JCheckBoxMenuItem("Operation area", true);
        operationArea.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        window.add(operationArea);
        window.addSeparator();
        JMenuItem exit = new JMenuItem("exit");
        window.add(exit);
        jMenuBar.add(window);

        JMenu config = new JMenu("Config");
        JMenuItem outputSetting = new JMenuItem("Output setting");
        config.add(outputSetting);
        jMenuBar.add(config);

        JMenu help = new JMenu("Help");
        JMenuItem checkUpdates = new JMenuItem("Check updates");
        help.add(checkUpdates);
        JMenuItem about = new JMenuItem("About");
        help.add(about);
        jMenuBar.add(help);

        setJMenuBar(jMenuBar);

        //监听器
        operationArea.addItemListener(itemEvent -> mainOperationJPanel.setVisible(operationArea.isSelected()));

        exit.addActionListener(actionEvent -> dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING)));

        outputSetting.addActionListener(actionEvent -> new OutputSettingForm());

        checkUpdates.addActionListener(actionEvent -> {
            try {
                Desktop.getDesktop().browse(new URI(Config.GITHUB_REPOSITORY + "/releases"));
            } catch (URISyntaxException | IOException e) {
                e.printStackTrace();
            }
        });

        about.addActionListener(actionEvent -> new AboutDialog());
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    public MainForm() {
        //变量
        styledDocument = textPane.getStyledDocument();

        //监听器
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
                    startButton.doClick();
                }
            }
        });

        startButton.addActionListener(actionEvent -> {
            try {
                liveDanMuAPI = new LiveDanMuAPI(BILIBILI_LIVE_URL_PREFIX + textField.getText())
                        .setPrintDebugInfo(true)
                        .addCallback(new LiveDanMuCallback(this, textPane))
                        .connect();
            } catch (IOException | IllegalArgumentException e) {
                printInfo("%s: %s", e.getClass().getName(), e.getMessage());
                printInfo("Connect failed!");
                e.printStackTrace();
            }
        });

        stopButton.addActionListener(actionEvent -> {
            try {
                liveDanMuAPI.close();
            } catch (IOException e) {
                printInfo("%s: %s", e.getClass().getName(), e.getMessage());
                printInfo("Cannot close connection, reopen program may solve this problem.");
                e.printStackTrace();
            } finally {
                onDisconnect();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                Main.getConfig().storeToFile();
            }
        });

        //显示窗口
        setTitle(FORM_TITLE);
        setContentPane(mainFormJPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    private void printInfo(String message, Object... objects) {
        try {
            styledDocument.insertString(styledDocument.getLength(), String.format("[%s] ", new Date()) + String.format(message, objects) + "\n", null);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    public void onConnect() {
        textField.setEnabled(false);
        startButton.setEnabled(false);
        stopButton.setEnabled(true);
    }

    public void onDisconnect() {
        stopButton.setEnabled(false);
        textField.setEnabled(true);
        startButton.setEnabled(true);
        setTitle(FORM_TITLE);
    }

    public void reloadStyle() {
        Style defaultStyle = styledDocument.getStyle(StyleContext.DEFAULT_STYLE);
        Arrays.stream(Config.class.getDeclaredFields())
                .filter(field -> field.getType() == Config.OutputOptions.class)
                .forEach(field -> {
                    try {
                        String fieldName = field.getName();
                        Config.OutputOptions outputOptions = (Config.OutputOptions) field.get(Main.getConfig());
                        Style style = styledDocument.addStyle(fieldName + "Style", defaultStyle);
                        StyleConstants.setFontSize(style, outputOptions.size);
                        StyleConstants.setForeground(style, outputOptions.color);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainFormJPanel = new JPanel();
        mainFormJPanel.setLayout(new GridLayoutManager(2, 1, new Insets(5, 5, 5, 5), -1, -1));
        final JScrollPane scrollPane1 = new JScrollPane();
        mainFormJPanel.add(scrollPane1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(-1, 300), null, 0, false));
        textPane = new JTextPane();
        textPane.setEditable(false);
        scrollPane1.setViewportView(textPane);
        mainOperationJPanel = new JPanel();
        mainOperationJPanel.setLayout(new GridLayoutManager(1, 4, new Insets(0, 0, 0, 0), -1, -1));
        mainFormJPanel.add(mainOperationJPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 1, false));
        final JLabel label1 = new JLabel();
        label1.setText("http://live.bilibili.com/");
        mainOperationJPanel.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textField = new JTextField();
        textField.setText("");
        mainOperationJPanel.add(textField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        startButton = new JButton();
        startButton.setText("Start");
        mainOperationJPanel.add(startButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        stopButton = new JButton();
        stopButton.setEnabled(false);
        stopButton.setText("Stop");
        mainOperationJPanel.add(stopButton, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainFormJPanel;
    }
}

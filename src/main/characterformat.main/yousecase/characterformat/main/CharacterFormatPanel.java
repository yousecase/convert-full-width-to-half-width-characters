package yousecase.characterformat.main;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class CharacterFormatPanel extends JPanel {
    private static final long serialVersionUID = 8626980197812609016L;

    private JPanel northPanel;
    private JButton undoButton;
    private JButton redoButton;
    private JButton pasteButton;
    private JButton fullToHalfButton;
    private JButton halfToFullButton;

    private JScrollPane pane;
    private JTextArea textArea;

    public CharacterFormatPanel() {

        // ボタン生成
        undoButton = new JButton("←");
        redoButton = new JButton("→");
        pasteButton = new JButton("paste");
        fullToHalfButton = new JButton("full → half");
        halfToFullButton = new JButton("half → full");

        // 上部パネル配置
        northPanel = new JPanel();
        northPanel.add(undoButton);
        northPanel.add(redoButton);
        northPanel.add(pasteButton);
        northPanel.add(fullToHalfButton);
        northPanel.add(halfToFullButton);

        // テキストエリア
        pane = new JScrollPane();
        textArea = new JTextArea();
        pane.getViewport().add(textArea);
        pane.setPreferredSize(new Dimension(400, 400));

        // レイアウト
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(northPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1d;
        gbc.weighty = 1d;
        gbc.fill = GridBagConstraints.BOTH;
        add(pane, gbc);
    }

    // コンポーネントのgetter
    public JButton getUndoButton() {
        return undoButton;
    }

    public JButton getRedoButton() {
        return redoButton;
    }

    public JButton getPasteButton() {
        return pasteButton;
    }

    public JButton getFullToHalfButton() {
        return fullToHalfButton;
    }

    public JButton getHalfToFullButton() {
        return halfToFullButton;
    }

    public JTextArea getTextArea() {
        return textArea;
    }
}

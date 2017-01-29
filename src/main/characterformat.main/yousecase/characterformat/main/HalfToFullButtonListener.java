package yousecase.characterformat.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import yousecase.format.string.StringFormat;

class HalfToFullButtonListener implements ActionListener {
    private static final StringFormat stringFormat = StringFormat.getAlphabetNumberSymbolSpaceHalfToFullStringFormat();
    private JTextArea textArea;

    public HalfToFullButtonListener(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String before = textArea.getText();
        String after = stringFormat.format(before);
        if (!before.equals(after)) {
            textArea.setText(after);
        }
    }
}

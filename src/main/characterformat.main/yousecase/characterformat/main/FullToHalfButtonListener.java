package yousecase.characterformat.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import yousecase.format.string.StringFormat;

class FullToHalfButtonListener implements ActionListener {
    private static final StringFormat stringFormat = StringFormat.getAlphabetNumberSymbolSpaceFullToHalfStringFormat();
    private JTextArea textArea;

    public FullToHalfButtonListener(JTextArea textArea) {
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

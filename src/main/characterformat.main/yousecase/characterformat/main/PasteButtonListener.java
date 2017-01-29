package yousecase.characterformat.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

import javax.swing.JTextArea;

import yousecase.util.ClipboardManager;

class PasteButtonListener implements ActionListener {
    private JTextArea textArea;

    public PasteButtonListener(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String before = textArea.getText();
        String after = null;
        try {
            after = ClipboardManager.getString();
        } catch (IOException e) {
        }

        if (Objects.nonNull(after) && !before.equals(after)) {
            textArea.setText(after);
        }
    }
}

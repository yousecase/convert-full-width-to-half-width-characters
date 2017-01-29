package yousecase.characterformat.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.undo.UndoManager;

class UndoButtonListener implements ActionListener {
    private UndoManager manager;
    private JTextArea textArea;

    public UndoButtonListener(UndoManager manager, JTextArea textArea) {
        this.manager = manager;
        this.textArea = textArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (manager.canUndo()) {
            manager.undo();
        }

        // JTextArea#setText時にUndoManagerに追加される空の編集結果をとばす
        if (textArea.getText().isEmpty() && manager.canUndo()) {
            manager.undo();
        }
    }
}

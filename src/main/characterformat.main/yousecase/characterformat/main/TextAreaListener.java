package yousecase.characterformat.main;

import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

class TextAreaListener implements UndoableEditListener, DocumentListener {
    private JButton undoButton;
    private JButton redoButton;
    private UndoManager manager;

    public TextAreaListener(JButton undoButton, JButton redoButton, UndoManager manager) {
        this.undoButton = undoButton;
        this.redoButton = redoButton;
        this.manager = manager;
    }

    @Override
    public void undoableEditHappened(UndoableEditEvent e) {
        updateButtons();
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        updateButtons();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        updateButtons();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        updateButtons();
    }

    private void updateButtons() {
        undoButton.setEnabled(manager.canUndo());
        redoButton.setEnabled(manager.canRedo());
    }
}

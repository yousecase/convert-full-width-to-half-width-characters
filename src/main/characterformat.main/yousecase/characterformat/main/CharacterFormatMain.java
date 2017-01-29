package yousecase.characterformat.main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.text.Document;
import javax.swing.undo.UndoManager;

class CharacterFormatMain {
    public static void main(String[] args) {
        CharacterFormatPanel panel = new CharacterFormatPanel();

        // コンポーネント取得
        JButton undoButton = panel.getUndoButton();
        JButton redoButton = panel.getRedoButton();
        JButton pasteButton = panel.getPasteButton();
        JButton fullToHalfButton = panel.getFullToHalfButton();
        JButton halfToFullButton = panel.getHalfToFullButton();
        JTextArea textArea = panel.getTextArea();

        // コンポーネント初期設定
        undoButton.setEnabled(false);
        redoButton.setEnabled(false);
        textArea.setDragEnabled(true);
        textArea.setLineWrap(true);

        // JTextAreaのリスナー設定
        UndoManager manager = new UndoManager();
        TextAreaListener textAreaListener = new TextAreaListener(undoButton, redoButton, manager);

        // Listenerは登録した順番の逆順で実行される。 Listenerを二重に登録しているので一部処理が重複する
        // DocumentListener,UndoableEditListenerのどちらか一つだと正常に動作しない
        // UndoableEditListenerはUndoRedo時にイベントが発生しない
        // DocumentListenerは文字入力後ではなく入力直前にイベントが発生するため入力前のcanUndoを取得してしまう
        Document document = textArea.getDocument();
        document.addUndoableEditListener(textAreaListener);
        document.addDocumentListener(textAreaListener);
        document.addUndoableEditListener(manager);

        // JButtonにActionListenerを追加
        undoButton.addActionListener(new UndoButtonListener(manager, textArea));
        redoButton.addActionListener(new RedoButtonListener(manager, textArea));
        pasteButton.addActionListener(new PasteButtonListener(textArea));
        fullToHalfButton.addActionListener(new FullToHalfButtonListener(textArea));
        halfToFullButton.addActionListener(new HalfToFullButtonListener(textArea));

        // JFrameの初期化設定
        JFrame frame = new JFrame();
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setMinimumSize(frame.getSize());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

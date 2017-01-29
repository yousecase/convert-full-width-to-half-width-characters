package yousecase.util;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.Objects;

/**
 * クリップボードの操作を行うクラスです。
 */
public class ClipboardManager {
    private static final Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    private static final DataFlavor stringFlavor = DataFlavor.stringFlavor;

    /**
     * クリップボードに文字列をセットします。
     * 
     * @param string
     *            セットする文字列
     */
    public static void setString(String string) {
        Objects.requireNonNull(string);
        StringSelection selection = new StringSelection(string);
        clipboard.setContents(selection, null);
    }

    /**
     * クリップボードから文字列を取得します。
     * 
     * @return 取得した文字列
     * @throws IOException
     *             文字列の取得に失敗した場合
     */
    public static String getString() throws IOException {
        try {
            if (clipboard.isDataFlavorAvailable(stringFlavor)) {
                return (String) clipboard.getData(stringFlavor);
            } else {
                throw new UnsupportedFlavorException(stringFlavor);
            }
        } catch (UnsupportedFlavorException e) {
            throw new IOException(e);
        }
    }

    private ClipboardManager() {
    }
}

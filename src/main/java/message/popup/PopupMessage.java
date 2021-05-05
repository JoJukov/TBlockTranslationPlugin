package message.popup;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.popup.Balloon;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.ui.JBColor;
import com.intellij.ui.awt.RelativePoint;
import message.selection.PopupMessageSelector;

import javax.swing.JComponent;
import java.awt.Point;

public class PopupMessage {

    private final JComponent jComponent;
    private final Point point;

    public PopupMessage(AnActionEvent e) {
        PopupMessageSelector textSelector = new PopupMessageSelector(e);
        jComponent = textSelector.getCurrentComponent();
        point = textSelector.extractPoint();
    }

    public void createPopupMessage(String text, JBColor textColor) {
        JBPopupFactory.getInstance()
                .createHtmlTextBalloonBuilder(
                        text,
                        null,
                        textColor,
                        JBColor.LIGHT_GRAY,
                        null)
                .createBalloon()
                .show(new RelativePoint(jComponent, point),
                        Balloon.Position.below);
    }

    public void showTranslatedText(String text) {
        createPopupMessage(text, JBColor.WHITE);
    }

    public void showErrorMessage(String text) {
        createPopupMessage(text, JBColor.RED);
    }
}

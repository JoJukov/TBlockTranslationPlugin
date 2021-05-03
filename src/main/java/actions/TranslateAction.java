package actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;
import message.popup.PopupMessage;
import org.jetbrains.annotations.NotNull;

public class TranslateAction extends AnAction {


    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        PopupMessage popupMessage = new PopupMessage(e);
        popupMessage.showTranslatedText("aboba");
    }

    @Override
    public boolean isDumbAware() {
        return true;
    }
}

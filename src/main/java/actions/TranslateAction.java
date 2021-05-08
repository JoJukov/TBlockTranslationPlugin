package actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import message.popup.PopupMessage;
import message.selection.PopupMessageSelector;
import org.jetbrains.annotations.NotNull;

public class TranslateAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        PopupMessage popupMessage = new PopupMessage(e);
        PopupMessageSelector popupMessageSelector = new PopupMessageSelector(e);
        try {
            TranslationProvider translationProvider = TranslationProvider.getInstance();
            String translated = translationProvider.getGoogleTranslator().translate(popupMessageSelector.getSelectedText());
            popupMessage.showTranslatedText(translated);
        } catch (Exception ex) {
            popupMessage.showErrorMessage(ex.getMessage());
        }
    }

    @Override
    public boolean isDumbAware() {
        return true;
    }
}

package com.zhuvar.tblock.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.zhuvar.tblock.message.popup.PopupMessage;
import com.zhuvar.tblock.message.selection.PopupMessageSelector;
import org.jetbrains.annotations.NotNull;

public class TranslateAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        PopupMessage popupMessage = new PopupMessage(e);
        PopupMessageSelector popupMessageSelector = new PopupMessageSelector(e);
        try {
            TranslationProvider translationProvider = TranslationProvider.getInstance();
            String translated = translationProvider.
                    getGoogleTranslator()
                    .translate
                            (translationProvider
                                    .getMessageConverter()
                                    .convert
                                            (popupMessageSelector.getSelectedText()));
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

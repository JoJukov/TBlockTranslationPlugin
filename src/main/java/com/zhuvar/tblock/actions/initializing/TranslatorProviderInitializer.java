package com.zhuvar.tblock.actions.initializing;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.StartupActivity;
import com.zhuvar.tblock.actions.TranslationProvider;
import com.zhuvar.tblock.configuration.state.TBlockSettingsState;
import com.zhuvar.tblock.text.formatting.impl.MessageConverter;
import com.zhuvar.tblock.text.translation.impl.GoogleTranslator;
import org.jetbrains.annotations.NotNull;

public class TranslatorProviderInitializer implements StartupActivity {

    @Override
    public void runActivity(@NotNull Project project) {
        TranslationProvider provider = TranslationProvider.getInstance();
        TBlockSettingsState state = TBlockSettingsState.getInstance();

        GoogleTranslator googleTranslator = provider.getGoogleTranslator();
        MessageConverter messageConverter = provider.getMessageConverter();

        googleTranslator.setDestLang(state.getDestLang());

        messageConverter.setConvertFromCamelCaseToNormalCase(state.isCamelCase());
        messageConverter.setConvertFromKebabCaseToNormalCase(state.isKebabCase());
        messageConverter.setConvertFromSnakeCaseToNormalCase(state.isSnakeCase());
    }
}

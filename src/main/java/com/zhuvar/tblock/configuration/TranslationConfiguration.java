package com.zhuvar.tblock.configuration;

import com.zhuvar.tblock.actions.TranslationProvider;
import com.intellij.openapi.options.Configurable;
import com.zhuvar.tblock.configuration.gui.TBlockConfigurationComponent;
import com.zhuvar.tblock.configuration.state.TBlockSettingsState;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;
import com.zhuvar.tblock.text.formatting.impl.MessageConverter;
import com.zhuvar.tblock.text.translation.impl.GoogleTranslator;

import javax.swing.JComponent;
import java.util.Objects;

public class TranslationConfiguration implements Configurable {

    private final GoogleTranslator translator;
    private final MessageConverter converter;
    private TBlockConfigurationComponent component;

    public TranslationConfiguration() {
        TranslationProvider provider = TranslationProvider.getInstance();
        translator = provider.getGoogleTranslator();
        converter = provider.getMessageConverter();
    }

    @Override
    @Nls(capitalization = Nls.Capitalization.Title)
    public String getDisplayName() {
        return "TBlock Translator Settings";
    }

    @Override
    public @Nullable JComponent createComponent() {
        component = new TBlockConfigurationComponent();
        return component.getPanel();
    }

    @Override
    public boolean isModified() {
        TBlockSettingsState state = TBlockSettingsState.getInstance();
        boolean modified = !component.getCamelCaseCheckBox().isSelected() == state.isCamelCase();
        modified |= !component.getKebabCaseCheckBox().isSelected() == state.isKebabCase();
        modified |= !component.getSnakeCaseCheckBox().isSelected() == state.isSnakeCase();
        modified |= !((String) Objects.requireNonNull(component.getLangComboBox().getSelectedItem())).equalsIgnoreCase(state.getDestLang());
        return modified;
    }

    @Override
    public void apply() {
        TBlockSettingsState state = TBlockSettingsState.getInstance();
        state.setCamelCase(component.getCamelCaseCheckBox().isSelected());
        state.setKebabCase(component.getKebabCaseCheckBox().isSelected());
        state.setSnakeCase(component.getSnakeCaseCheckBox().isSelected());
        state.setDestLang((String) component.getLangComboBox().getSelectedItem());
        updateConverter(state);
        updateTranslator(state);
    }

    @Override
    public void reset() {
        TBlockSettingsState state = TBlockSettingsState.getInstance();
        component.getCamelCaseCheckBox().setSelected(state.isCamelCase());
        component.getKebabCaseCheckBox().setSelected(state.isKebabCase());
        component.getSnakeCaseCheckBox().setSelected(state.isSnakeCase());
        component.getLangComboBox().setSelectedItem(state.getDestLang());
        updateConverter(state);
        updateTranslator(state);
    }

    @Override
    public void disposeUIResources() {
        component = null;
    }

    private void updateConverter(TBlockSettingsState state) {
        converter.setConvertFromCamelCaseToNormalCase(state.isCamelCase());
        converter.setConvertFromKebabCaseToNormalCase(state.isKebabCase());
        converter.setConvertFromSnakeCaseToNormalCase(state.isSnakeCase());
    }

    private void updateTranslator(TBlockSettingsState state) {
        translator.setDestLang(state.getDestLang());
    }
}

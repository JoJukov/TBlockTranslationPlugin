package configuration;

import actions.TranslationProvider;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import configuration.gui.TBlockConfigurationComponent;
import configuration.state.TBlockSettingsState;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;
import text.formatting.impl.MessageConverter;
import text.translation.impl.GoogleTranslator;

import javax.swing.JComponent;
import java.util.Objects;

public class TranslationConfiguration implements Configurable {

    //    private final TBlockConfigurationComponent tBlockConfigurationComponent;
//    private final GoogleTranslator translator;
//    private final MessageConverter converter;
//    private boolean isModified;
//    private JCheckBox snakeCaseCheckBox;
    private TBlockConfigurationComponent component;
    private GoogleTranslator translator;
    private MessageConverter converter;

    public TranslationConfiguration() {
        TranslationProvider provider = TranslationProvider.getInstance();
        translator = provider.getGoogleTranslator();
        converter = provider.getMessageConverter();
    }


    //    public TranslationConfiguration() {
//        isModified = false;
//        tBlockConfigurationComponent = TBlockConfigurationComponent.getInstance();
//        TranslationProvider translationProvider = TranslationProvider.getInstance();
//        translator = translationProvider.getGoogleTranslator();
//        converter = translationProvider.getMessageConverter();
//        initializeChangesInTranslation();
//    }

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
        boolean modified = !component.getCamelCaseCheckBox().isSelected() == state.isCamelCase;
        modified |= !component.getKebabCaseCheckBox().isSelected() == state.isKebabCase;
        modified |= !component.getSnakeCaseCheckBox().isSelected() == state.isSnakeCase;
        modified |= !((String) Objects.requireNonNull(component.getLangComboBox().getSelectedItem())).equalsIgnoreCase(state.destLang);
        return modified;
    }

    @Override
    public void apply() throws ConfigurationException {
        TBlockSettingsState state = TBlockSettingsState.getInstance();
        state.isSnakeCase = component.getSnakeCaseCheckBox().isSelected();
        state.isKebabCase = component.getKebabCaseCheckBox().isSelected();
        state.isSnakeCase = component.getSnakeCaseCheckBox().isSelected();
        state.destLang = (String) component.getLangComboBox().getSelectedItem();
        updateConverter(state);
        updateTranslator(state);
    }

    @Override
    public void reset() {
        TBlockSettingsState state = TBlockSettingsState.getInstance();
        component.getCamelCaseCheckBox().setSelected(state.isCamelCase);
        component.getKebabCaseCheckBox().setSelected(state.isKebabCase);
        component.getSnakeCaseCheckBox().setSelected(state.isSnakeCase);
        component.getLangComboBox().setSelectedItem(state.destLang);
        updateConverter(state);
        updateTranslator(state);
    }

    @Override
    public void disposeUIResources() {
        component = null;
    }

    private void updateConverter(TBlockSettingsState state) {
        converter.setConvertFromSnakeCaseToNormalCase(state.isSnakeCase);
        converter.setConvertFromCamelCaseToNormalCase(state.isCamelCase);
        converter.setConvertFromKebabCaseToNormalCase(state.isKebabCase);
    }

    private void updateTranslator(TBlockSettingsState state) {
        translator.setDestLang(state.destLang);
    }


//    private void updateConversionKeys() {
//        boolean isConvertFromCamelCase = tBlockConfigurationComponent.isCamelCase();
//        boolean isConvertFromKebabCase = tBlockConfigurationComponent.isKebabCase();
//        boolean isConvertFromSnakeCase = tBlockConfigurationComponent.isSnakeCase();
//
//        if (isConvertFromCamelCase != converter.isConvertFromCamelCaseToNormalCase() ||
//                isConvertFromKebabCase != converter.isConvertFromKebabCaseToNormalCase() ||
//                isConvertFromSnakeCase != converter.isConvertFromSnakeCaseToNormalCase()) {
//            isModified = true;
//        }
//
//        converter.setConvertFromCamelCaseToNormalCase(isConvertFromCamelCase);
//        converter.setConvertFromKebabCaseToNormalCase(isConvertFromKebabCase);
//        converter.setConvertFromSnakeCaseToNormalCase(isConvertFromSnakeCase);
//    }
//
//    private void updateDestLang() {
//        String newDestLang = translator.getDestLang();
//
//        if (!newDestLang.equalsIgnoreCase(tBlockConfigurationComponent.getDestinationLang())) {
//            isModified = true;
//        }
//
//        translator.setDestLang(newDestLang);
//    }
//
//    private void initializeChangesInTranslation() {
//        snakeCaseCheckBox = tBlockConfigurationComponent.getSnakeCaseCheckBox();
//        snakeCaseCheckBox.addActionListener(actionEvent -> {
//            snakeCaseCheckBox.setSelected(true);
//            isModified = true;
//        });
//    }
}

package configuration;

import actions.TranslationProvider;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.util.NlsContexts;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;
import text.translation.Translator;

import javax.swing.JComponent;
import java.io.IOException;

public class TranslationConfiguration implements Configurable {

    private TranslationProvider translationProvider;
    private Translator translator;

    public TranslationConfiguration() {
        try {
            translationProvider = TranslationProvider.getInstance();
            translator = translationProvider.getGoogleTranslator();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Nls(capitalization = Nls.Capitalization.Title)
    public String getDisplayName() {
        return "TBlock Translator Settings";
    }

    @Override
    public @Nullable JComponent createComponent() {
        return null;
    }

    @Override
    public boolean isModified() {
        return false;
    }

    @Override
    public void apply() throws ConfigurationException {

    }
}

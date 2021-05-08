package configuration.state;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(name = "configuration.state",
        storages = {@Storage("TBlockSettingPlugin.xml")})
public class TBlockSettingsState implements PersistentStateComponent<TBlockSettingsState> {

    public boolean isCamelCase = true;
    public boolean isKebabCase = false;
    public boolean isSnakeCase = false;
    public String destLang = "Ru";


    public static TBlockSettingsState getInstance() {
        return ServiceManager.getService(TBlockSettingsState.class);
    }

    @Override
    public @Nullable TBlockSettingsState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull TBlockSettingsState state) {
        XmlSerializerUtil.copyBean(state, this);
    }
}

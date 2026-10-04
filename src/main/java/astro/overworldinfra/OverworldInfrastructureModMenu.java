package astro.overworldinfra;

import astro.overworldinfra.config.OverworldInfrastructureConfigScreen;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

public class OverworldInfrastructureModMenu implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return OverworldInfrastructureConfigScreen::create;
    }
}

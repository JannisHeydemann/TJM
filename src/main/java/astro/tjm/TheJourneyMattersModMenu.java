package astro.tjm;

import astro.tjm.config.TheJourneyMattersConfigScreen;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

/**
 * Mod Menu entrypoint exposing the YACL config screen.
 */
public class TheJourneyMattersModMenu implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return TheJourneyMattersConfigScreen::create;
    }
}

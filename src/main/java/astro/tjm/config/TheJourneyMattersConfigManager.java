package astro.tjm.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TheJourneyMattersConfigManager {
    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    private static final Path CONFIG_PATH = FabricLoader.getInstance()
            .getConfigDir()
            .resolve("overworldinfrastructure.json");

    private static TheJourneyMattersConfig config;

    public static void load() {
        if (Files.exists(CONFIG_PATH)) {
            try {
                String json = Files.readString(CONFIG_PATH);

                config = GSON.fromJson(
                        json,
                        TheJourneyMattersConfig.class
                );
            } catch (IOException e) {
                e.printStackTrace();
                config = new TheJourneyMattersConfig();
            }
        } else {
            config = new TheJourneyMattersConfig();
            save();
        }
    }

    public static void save() {
        try {
            Files.writeString(
                    CONFIG_PATH,
                    GSON.toJson(config)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TheJourneyMattersConfig getConfig() {
        if (config == null) {
            load();
        }

        return config;
    }
}

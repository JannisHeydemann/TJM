package astro.overworldinfra.config;

import astro.overworldinfra.OverworldInfrastructure;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class OverworldInfrastructureConfigManager {
    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    private static final Path CONFIG_PATH = FabricLoader.getInstance()
            .getConfigDir()
            .resolve("overworldinfrastructure.json");

    private static OverworldInfrastructureConfig config;

    public static void load() {
        if (Files.exists(CONFIG_PATH)) {
            try {
                String json = Files.readString(CONFIG_PATH);

                config = GSON.fromJson(
                        json,
                        OverworldInfrastructureConfig.class
                );
            } catch (IOException e) {
                e.printStackTrace();
                config = new OverworldInfrastructureConfig();
            }
        } else {
            config = new OverworldInfrastructureConfig();
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

    public static OverworldInfrastructureConfig getConfig() {
        if (config == null) {
            load();
        }

        return config;
    }
}

package astro.overworldinfra.config;

import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.OptionDescription;
import dev.isxander.yacl3.api.YetAnotherConfigLib;
import dev.isxander.yacl3.api.controller.IntegerSliderControllerBuilder;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class OverworldInfrastructureConfigScreen {
    public static Screen create(Screen parent) {
        OverworldInfrastructureConfig config = OverworldInfrastructureConfigManager.getConfig();
        return YetAnotherConfigLib.createBuilder()
                .title(Component.literal("Overworld Infrastructure"))
                .category(ConfigCategory.createBuilder()
                        .name(Component.literal("Nether"))
                        .option(Option.<Integer>createBuilder()
                                .name(Component.literal("Nether build height"))
                                .description(OptionDescription.EMPTY)
                                .binding(127, () -> config.maxBuildHeight, value -> config.maxBuildHeight = value)
                                .controller(option -> IntegerSliderControllerBuilder.create(option).range(0, 300).step(5))
                                .build())
                        .build())
                .save(() -> OverworldInfrastructureConfigManager.save())
                .build()
                .generateScreen(parent);
    }
}

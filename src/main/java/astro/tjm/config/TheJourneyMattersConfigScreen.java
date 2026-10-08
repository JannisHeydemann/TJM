package astro.tjm.config;

import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.IntegerSliderControllerBuilder;
import dev.isxander.yacl3.api.controller.StringControllerBuilder;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.util.Collections;
import java.util.List;

public class TheJourneyMattersConfigScreen {
    public static Screen create(Screen parent) {
        TheJourneyMattersConfig config = TheJourneyMattersConfigManager.getConfig();
        return YetAnotherConfigLib.createBuilder()
                .title(Component.translatable("tjm.config.name"))
                .category(ConfigCategory.createBuilder()
                        .name(Component.translatable("tjm.config.nether"))
                        .option(Option.<Integer>createBuilder()
                                .name(Component.translatable("tjm.config.nether.buildHeight"))
                                .description(
                                        OptionDescription.createBuilder()
                                                .text(Component.translatable("tjm.config.nether.buildHeight.desc"))
                                                .build()
                                )
                                .binding(127, () -> TheJourneyMattersConfig.maxBuildHeight, value -> TheJourneyMattersConfig.maxBuildHeight = value)
                                .controller(option -> IntegerSliderControllerBuilder.create(option).range(0, 300).step(5))
                                .build())
                        .option(ListOption.<String>createBuilder()
                                .name(Component.translatable("tjm.config.nether.disallowedBlocks"))
                                .description(
                                        OptionDescription.createBuilder()
                                                .text(Component.translatable("tjm.config.nether.disallowedBlocks.desc"))
                                                .build()
                                )
                                .binding(TheJourneyMattersConfig.disallowedNetherBlocks, () -> TheJourneyMattersConfig.disallowedNetherBlocks, value -> TheJourneyMattersConfig.disallowedNetherBlocks = value)
                                .controller(StringControllerBuilder::create)
                                .initial("")
                                .build())
                        .build())
                .save(TheJourneyMattersConfigManager::save)
                .build()
                .generateScreen(parent);
    }
}

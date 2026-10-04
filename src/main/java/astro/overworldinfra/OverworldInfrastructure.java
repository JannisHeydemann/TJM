package astro.overworldinfra;

import astro.overworldinfra.config.OverworldInfrastructureConfig;
import net.fabricmc.api.ModInitializer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

public class OverworldInfrastructure implements ModInitializer {
	public static final String MOD_ID = "overworldinfrastructure";

	@Override
	public void onInitialize() {
		UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
			if (!world.isClientSide()) {
				if (world.dimension() == Level.NETHER) {
					BlockPos targetPos = hitResult.getBlockPos();
					int maxHeight = OverworldInfrastructureConfig.maxBuildHeight;

					if (targetPos.getY() >= maxHeight) {
						player.sendSystemMessage(
								Component.literal("§cBuilding higher then Y=" + maxHeight + " isnt allowed in the nether")
						);

						return InteractionResult.FAIL;
					}

				}
			}
			return InteractionResult.PASS;
		});
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}

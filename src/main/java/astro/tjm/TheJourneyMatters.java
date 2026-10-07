package astro.tjm;

import astro.tjm.config.TheJourneyMattersConfig;
import net.fabricmc.api.ModInitializer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

public class TheJourneyMatters implements ModInitializer {
	public static final String MOD_ID = "tjm";

	@Override
	public void onInitialize() {
		UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
			if (!world.isClientSide()) {
				if (world.dimension() == Level.NETHER) {
					BlockPos targetPos = hitResult.getBlockPos();
					int maxHeight = TheJourneyMattersConfig.maxBuildHeight;
					ItemStack stack = player.getItemInHand(hand);

					if (targetPos.getY() >= maxHeight) {
						player.sendOverlayMessage(
								Component.translatable("tjm.nether.maxheight", maxHeight)
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

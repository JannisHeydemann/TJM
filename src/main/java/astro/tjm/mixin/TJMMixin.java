package astro.tjm.mixin;

import astro.tjm.config.TheJourneyMattersConfig;
import astro.tjm.config.TheJourneyMattersConfigManager;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Interaction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.*;


@Mixin(BlockItem.class)
/**
 * Cancels block placement in the Nether above the configured height or for disallowed blocks.
 */
public class TJMMixin {
    @Inject(at = @At("HEAD"), method = "place", cancellable = true)
    private void tjm$preventIceInNether(
            BlockPlaceContext placeContext,
            CallbackInfoReturnable<InteractionResult> cir
    ) {
        BlockItem blockItem = (BlockItem) (Object) this;
        TheJourneyMattersConfig config = TheJourneyMattersConfigManager.getConfig();

        List<Block> blocks = new ArrayList<>();

        for (String blockId : config.disallowedNetherBlocks) {
            try {
                Identifier id = Identifier.parse(blockId);
                blocks.add(BuiltInRegistries.BLOCK.getValue(id));
            } catch (Exception ignored) {}

        }

        if (placeContext.getLevel().dimension() == Level.NETHER && blocks.contains(blockItem.getBlock())) {
            cir.setReturnValue(InteractionResult.FAIL);
        }
    }

    @Inject(at = @At("HEAD"), method = "place", cancellable = true)
    private void tjm$netherMaxHeight(
            BlockPlaceContext placeContext,
            CallbackInfoReturnable<InteractionResult> cir
    ) {
        Level world = placeContext.getLevel();
        Player player = placeContext.getPlayer();
        TheJourneyMattersConfig config = TheJourneyMattersConfigManager.getConfig();

        if (world.dimension() == Level.NETHER) {
            BlockPos targetPos = placeContext.getClickedPos();
            int maxHeight = config.maxBuildHeight;

            if (targetPos.getY() >= maxHeight) {
                assert player != null;
                player.sendOverlayMessage(
                        Component.translatable("tjm.nether.maxheight", maxHeight)
                );
				cir.setReturnValue(InteractionResult.FAIL);
            }
        }
    }
}
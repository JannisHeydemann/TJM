package astro.tjm.mixin;

import astro.tjm.config.TheJourneyMattersConfig;
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
public class TJMMixin {
    @Inject(at = @At("HEAD"), method = "place", cancellable = true)
    private void tjm$preventIceInNether(
            BlockPlaceContext placeContext,
            CallbackInfoReturnable<InteractionResult> cir
    ) {
        BlockItem blockItem = (BlockItem) (Object) this;

        List<Block> blocks = new ArrayList<>();

        for (String blockId : TheJourneyMattersConfig.disallowedNetherBlocks) {
            Identifier id = Identifier.parse(blockId);

            blocks.add(BuiltInRegistries.BLOCK.getValue(id));
        }

        if (placeContext.getLevel().dimension() == Level.NETHER && TheJourneyMattersConfig.disallowedNetherBlocks.contains(blockItem.toString())) {
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

        if (world.dimension() == Level.NETHER) {
            BlockPos targetPos = placeContext.getClickedPos();
            int maxHeight = TheJourneyMattersConfig.maxBuildHeight;

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
package astro.tjm.mixin;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;

@Mixin(BlockItem.class)
public class ExampleMixin {
	@Inject(at = @At("HEAD"), method = "place", cancellable = true)
	private void tjm$preventIceInNether(
			BlockPlaceContext placeContext,
			CallbackInfoReturnable<InteractionResult> cir
	) {
		BlockItem blockItem = (BlockItem) (Object) this;

		Block[] blocks = {Blocks.ICE, Blocks.BLUE_ICE, Blocks.FROSTED_ICE, Blocks.PACKED_ICE};

		if (placeContext.getLevel().dimension() == Level.NETHER && Arrays.asList(blocks).contains(blockItem.getBlock())) {
			cir.setReturnValue(InteractionResult.FAIL);
		}
	}
}
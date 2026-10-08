package astro.tjm.mixin;

import astro.tjm.TheJourneyMatters;
import astro.tjm.config.TheJourneyMattersConfig;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.InteractionResult;
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
public class ExampleMixin {
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
}
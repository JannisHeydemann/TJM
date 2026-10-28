package astro.tjm;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.wolf.Wolf;
import net.minecraft.world.level.block.Blocks;

import java.util.List;

/**
 * Main entrypoint. Registers the listeners that award the code-driven Journey advancements.
 */
public class TheJourneyMatters implements ModInitializer {
	public static final String MOD_ID = "tjm";

	@Override
	public void onInitialize() {
		ServerTickEvents.END_LEVEL_TICK.register(world -> {
			if (world.dimension() != Level.NETHER) {
				return;
			}

			for (ServerPlayer player : world.players()) {
				BlockPos feet = player.blockPosition();
				if (feet.getY() >= 128 && world.getBlockState(feet.below()).is(Blocks.BEDROCK)) {
					award(player, world, "nether_roof", "on_roof");
				}
			}
		});

		ServerLivingEntityEvents.AFTER_DEATH.register((entity, damageSource) -> {
			if (!(entity instanceof Mob)
					|| !(entity.level() instanceof ServerLevel world)
					|| world.dimension() != Level.NETHER
					|| !(damageSource.getEntity() instanceof Wolf wolf)
					|| !(wolf.getOwner() instanceof ServerPlayer owner)) {
				return;
			}

			award(owner, world, "first_of_its_kind", "wolf_killed");
		});


		ServerTickEvents.END_LEVEL_TICK.register(server -> {
            List<ServerPlayer> players = server.players();
			for (ServerPlayer player : players) {
				Inventory inventory = player.getInventory();
for (int slot = 0; slot < inventory.getContainerSize(); slot++) {
					ItemStack stack = inventory.getItem(slot);
					if (stack.getItem() == Items.ELYTRA) {
						ItemStack extractedStack = inventory.removeItem(slot, stack.getCount());
						player.drop(extractedStack, false, null);
					}
				}
			}
		});

		ServerTickEvents.END_LEVEL_TICK.register(server -> {
			List<ServerPlayer> players = server.players();
			for (ServerPlayer player : players) {
				ItemStack chest = player.getItemBySlot(EquipmentSlot.CHEST);
				if (chest.getItem().equals(Items.ELYTRA)) {
					player.setItemSlot(EquipmentSlot.CHEST, ItemStack.EMPTY);
					player.drop(new ItemStack(Items.ELYTRA), false, null);
				}
			}
		});
	}

	private static void award(ServerPlayer player, ServerLevel world, String advancementPath, String criterion) {
		AdvancementHolder advancement = world.getServer().getAdvancements().get(id("adventure/" + advancementPath));
		if (advancement != null) {
			player.getAdvancements().award(advancement, criterion);
		}
	}

	private static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}

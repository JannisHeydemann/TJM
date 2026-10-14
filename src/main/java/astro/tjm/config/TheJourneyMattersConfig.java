package astro.tjm.config;

import java.util.List;

/**
 * Configuration values for the Nether build rules.
 */
public class TheJourneyMattersConfig {
    public int maxBuildHeight = 127;
    public List<String> disallowedNetherBlocks = List.of(new String[]{"minecraft:ice", "minecraft:packed_ice", "minecraft:frosted_ice", "minecraft:blue_ice"});
}

package astro.tjm.config;

import java.util.List;

public class TheJourneyMattersConfig {
    public static int maxBuildHeight = 127;
    public static List<String> disallowedNetherBlocks = List.of(new String[]{"minecraft:ice", "minecraft:packed_ice", "minecraft:frosted_ice", "minecraft:blue_ice"});
}

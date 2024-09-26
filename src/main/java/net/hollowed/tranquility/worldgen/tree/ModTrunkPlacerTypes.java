package net.hollowed.tranquility.worldgen.tree;

import net.hollowed.tranquility.Tranquility;
import net.hollowed.tranquility.mixin.TrunkPlacerTypeInvoker;
import net.hollowed.tranquility.worldgen.tree.custom.BetterDarkOakTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class ModTrunkPlacerTypes {
    public static final TrunkPlacerType<?> BETTER_DARK_OAK_TRUNK_PLACER = TrunkPlacerTypeInvoker.register("better_dark_oak_trunk_placer", BetterDarkOakTrunkPlacer.CODEC);

    public static void register() {
        Tranquility.LOGGER.info("Registering Trunk Placers for " + Tranquility.MOD_ID);
    }
}

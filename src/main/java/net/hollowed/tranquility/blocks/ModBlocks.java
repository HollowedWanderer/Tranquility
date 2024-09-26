package net.hollowed.tranquility.blocks;

import net.hollowed.tranquility.Tranquility;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlag;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

public class ModBlocks {

    public static final Block DECAYED_DARK_OAK_LOG = registerBlock("decayed_dark_oak_log", createLogBlock(MapColor.BROWN, MapColor.BROWN));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Tranquility.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Tranquility.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static Block createLogBlock(MapColor topMapColor, MapColor sideMapColor) {
        return new PillarBlock(AbstractBlock.Settings.create().mapColor((state) -> state.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor).instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable());
    }

    public static FlowerPotBlock createFlowerPotBlock(Block flower, FeatureFlag... requiredFeatures) {
        AbstractBlock.Settings settings = AbstractBlock.Settings.create().breakInstantly().nonOpaque().pistonBehavior(PistonBehavior.DESTROY);
        if (requiredFeatures.length > 0) {
            settings = settings.requires(requiredFeatures);
        }

        return new FlowerPotBlock(flower, settings);
    }

    public static void registerModBlocks() {
        Tranquility.LOGGER.info("Registering ModBlocks for " + Tranquility.MOD_ID);
    }
}

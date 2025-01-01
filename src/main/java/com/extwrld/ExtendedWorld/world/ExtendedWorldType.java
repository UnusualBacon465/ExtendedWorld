package com.extwrld.ExtendedWorld.world;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.gen.IChunkGenerator;

public class ExtendedWorldType extends WorldType {

    public ExtendedWorldType() {
        super("extended_world"); // Unique name for your world type
        System.out.println("Extended WorldType created: extended_world");

        // Debug: Print all registered world types
        System.out.println("Registered World Types:");
        for (WorldType type : WorldType.WORLD_TYPES) {
            if (type != null) {
                System.out.println("- " + type.getName());
            }
        }
    }

    @Override
    public IChunkGenerator getChunkGenerator(World world, String generatorOptions) {
        System.out.println("Using ExtendedChunkGenerator for world: " + world.getWorldInfo().getWorldName());
        return new ExtendedChunkGenerator(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled(), generatorOptions);
    }
}
package com.extwrld.ExtendedWorld.worldheightmod.world;

import com.extwrld.ExtendedWorld.world.CustomChunkGenerator;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class WorldTypeCustom extends WorldType {
    public WorldTypeCustom() {
        super("custom_height_world");
    }

    @Override
    public BiomeProvider getBiomeProvider(World world) {
        return new BiomeProvider(world.getWorldInfo());
    }

    @Override
    public IChunkGenerator getChunkGenerator(World world, String generatorOptions) {
        return new CustomChunkGenerator(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled(), generatorOptions);
    }
}

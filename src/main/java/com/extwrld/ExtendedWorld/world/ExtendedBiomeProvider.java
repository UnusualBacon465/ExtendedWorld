package com.extwrld.ExtendedWorld.world;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.layer.GenLayer;

import java.util.List;

public class ExtendedBiomeProvider extends BiomeProvider {
    public ExtendedBiomeProvider() {
        super();
        // Include custom or modded biomes here
    }

    @Override
    public GenLayer[] getModdedBiomeGenerators(final WorldType worldType, final long seed, final GenLayer[] original) {
        return super.getModdedBiomeGenerators(worldType, seed, original);
    }

    @Override
    public List<Biome> getBiomesToSpawnIn() {
        // Add custom logic to include modded biomes
        return super.getBiomesToSpawnIn();
    }
}

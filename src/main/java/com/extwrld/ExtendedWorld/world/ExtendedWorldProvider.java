package com.extwrld.ExtendedWorld.world;

import com.extwrld.ExtendedWorld.config.ConfigHandler;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class ExtendedWorldProvider extends WorldProvider {

    private ExtendedBiomeProvider biomeProvider;

    @Override
    public DimensionType getDimensionType() {
        return DimensionType.OVERWORLD; // Use the default overworld dimension
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new ExtendedChunkGenerator(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled(), null);
    }


    protected void createBiomeProvider() {
        this.biomeProvider = new ExtendedBiomeProvider();
    }

    @Override
    public int getHeight() {
        return ConfigHandler.worldHeight; // Get dynamic height from configuration
    }

    @Override
    public int getActualHeight() {
        return ConfigHandler.worldHeight; // Adjust actual height for rendering purposes
    }


    public boolean canDoRainSnowIce() {
        return true; // Allow rain, snow, and ice to form
    }

    @Override
    public boolean canRespawnHere() {
        return true; // Allow players to respawn in this world
    }
}


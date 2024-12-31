package com.extwrld.ExtendedWorld.world;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.ChunkGeneratorOverworld;

public class CustomChunkGenerator extends ChunkGeneratorOverworld {
    public CustomChunkGenerator(World world, long seed, boolean mapFeaturesEnabled, String generatorOptions) {
        super(world, seed, mapFeaturesEnabled, generatorOptions);
    }

    @Override
    public void generateTerrain(int chunkX, int chunkZ, ChunkPrimer primer) {
        Chunk chunk = super.generateChunk(chunkX, chunkZ);

        // Add terrain above vanilla's 256-block height here
        for (int y = 256; y < 512; y++) {
            for (int x = 0; x < 16; x++) {
                for (int z = 0; z < 16; z++) {
                    primer.setBlockState(x, y, z, Blocks.STONE.getDefaultState());
                }
            }
        }
    }
}
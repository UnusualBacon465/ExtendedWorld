package com.extwrld.ExtendedWorld.world;

import com.extwrld.ExtendedWorld.config.ConfigHandler;
import com.extwrld.ExtendedWorld.world.structure.CustomStructureGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.ChunkGeneratorOverworld;
import net.minecraft.world.gen.NoiseGeneratorSimplex;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class ExtendedChunkGenerator extends ChunkGeneratorOverworld {

    private final World world;
    private final Random rand;
    private final NoiseGeneratorSimplex terrainNoise; // Simplex noise for terrain generation
    private final int maxHeight; // Maximum world height from the config

    public ExtendedChunkGenerator(World world, long seed, boolean mapFeaturesEnabled, String generatorOptions) {
        super(world, seed, mapFeaturesEnabled, generatorOptions);
        this.world = world;
        this.rand = new Random(seed);
        this.terrainNoise = new NoiseGeneratorSimplex(new Random(seed)); // Initialize Simplex noise
        this.maxHeight = ConfigHandler.worldHeight; // Fetch the max height from the config
    }

    // Terrain generation logic using Simplex noise
    public void generateCustomTerrain(int chunkX, int chunkZ, ChunkPrimer primer) {
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                // Generate height using Simplex Noise
                double noiseValue = terrainNoise.getValue((chunkX * 16 + x) * 0.01, (chunkZ * 16 + z) * 0.01);
                int baseHeight = 64; // Default ground level
                int heightVariation = 64; // Maximum variation
                int height = baseHeight + (int) (noiseValue * heightVariation);

                // Clamp height to maxHeight
                height = Math.min(height, maxHeight - 1);

                // Extend terrain below Y=0 down to -128
                for (int y = -128; y <= height; y++) {
                    if (y == -128) {
                        primer.setBlockState(x, y, z, Blocks.BEDROCK.getDefaultState()); // Bedrock at the bottom
                    } else if (y < height - 5) {
                        primer.setBlockState(x, y, z, Blocks.STONE.getDefaultState()); // Stone in lower layers
                    } else if (y < height - 1) {
                        primer.setBlockState(x, y, z, Blocks.DIRT.getDefaultState()); // Dirt near the surface
                    } else if (y >= 0) {
                        primer.setBlockState(x, y, z, Blocks.GRASS.getDefaultState()); // Grass on the surface
                    }
                }
            }
        }
    }

    // Populate ores, structures, and decorations
    @Override
    public void populate(int chunkX, int chunkZ) {
        super.populate(chunkX, chunkZ);

        BlockPos chunkStart = new BlockPos(chunkX * 16, 0, chunkZ * 16);

        // Generate ores
        generateOres(chunkStart);

        // Generate custom structures
        if (rand.nextDouble() < 0.05) { // 5% chance to spawn a structure in the chunk
            BlockPos structurePos = chunkStart.add(rand.nextInt(16), 64, rand.nextInt(16));
            new CustomStructureGenerator().generate(world, rand, structurePos);
        }
    }

    // Ores generation
    private void generateOres(BlockPos chunkStart) {
        for (int i = 0; i < 20; i++) {
            // Coal: Spawns throughout the world
            BlockPos coalPos = chunkStart.add(rand.nextInt(16), rand.nextInt(maxHeight), rand.nextInt(16));
            new WorldGenMinable(Blocks.COAL_ORE.getDefaultState(), 17).generate(world, rand, coalPos);

            // Iron: Spawns up to maxHeight / 2
            BlockPos ironPos = chunkStart.add(rand.nextInt(16), rand.nextInt(maxHeight / 2), rand.nextInt(16));
            new WorldGenMinable(Blocks.IRON_ORE.getDefaultState(), 9).generate(world, rand, ironPos);

            // Gold: Spawns only below Y=32
            BlockPos goldPos = chunkStart.add(rand.nextInt(16), rand.nextInt(32), rand.nextInt(16));
            new WorldGenMinable(Blocks.GOLD_ORE.getDefaultState(), 9).generate(world, rand, goldPos);

            // Diamond: Spawns below Y=16
            BlockPos diamondPos = chunkStart.add(rand.nextInt(16), rand.nextInt(16), rand.nextInt(16));
            new WorldGenMinable(Blocks.DIAMOND_ORE.getDefaultState(), 8).generate(world, rand, diamondPos);
        }
    }

    // Override terrain generation
    public void generateTerrain(int chunkX, int chunkZ, ChunkPrimer primer) {
        generateCustomTerrain(chunkX, chunkZ, primer); // Delegate to custom terrain generation
    }
}
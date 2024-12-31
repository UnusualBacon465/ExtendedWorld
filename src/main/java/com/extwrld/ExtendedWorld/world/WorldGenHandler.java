package com.extwrld.ExtendedWorld.world;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.InitMapGenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

public class WorldGenHandler {
    public WorldGenHandler() {
        MinecraftForge.TERRAIN_GEN_BUS.register(this);
        GameRegistry.registerWorldGenerator(new CustomOreGenerator(), 0);
    }

    @SubscribeEvent
    public void onWorldGenInit(InitMapGenEvent event) {
        if (event.getType() == InitMapGenEvent.EventType.CAVE) {
            // Customize cave generation for extended heights
        }
    }

    public static class CustomOreGenerator implements net.minecraftforge.fml.common.IWorldGenerator {
        @Override
        public void generate(Random random, int chunkX, int chunkZ, World world, net.minecraft.world.gen.IChunkGenerator chunkGenerator, net.minecraft.world.chunk.IChunkProvider chunkProvider) {
            if (world.provider.getDimension() == 0) { // Overworld
                for (int i = 0; i < 20; i++) {
                    int x = chunkX * 16 + random.nextInt(16);
                    int y = 256 + random.nextInt(256); // Generate ores above 256
                    int z = chunkZ * 16 + random.nextInt(16);
                    BlockPos pos = new BlockPos(x, y, z);
                    new net.minecraft.world.gen.feature.WorldGenMinable(net.minecraft.init.Blocks.DIAMOND_ORE.getDefaultState(), 8).generate(world, random, pos);
                }
            }
        }
    }
}

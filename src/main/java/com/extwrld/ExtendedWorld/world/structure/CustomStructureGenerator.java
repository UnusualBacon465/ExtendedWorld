package com.extwrld.ExtendedWorld.world.structure;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class CustomStructureGenerator {

    public void generate(World world, Random rand, BlockPos pos) {
        // Generate a small house as an example structure
        for (int x = -2; x <= 2; x++) {
            for (int z = -2; z <= 2; z++) {
                for (int y = 0; y <= 4; y++) {
                    BlockPos currentPos = pos.add(x, y, z);

                    if (y == 0) {
                        world.setBlockState(currentPos, Blocks.COBBLESTONE.getDefaultState()); // Floor
                    } else if (y == 4 || x == -2 || x == 2 || z == -2 || z == 2) {
                        world.setBlockState(currentPos, Blocks.STONEBRICK.getDefaultState()); // Walls and roof
                    } else {
                        world.setBlockState(currentPos, Blocks.AIR.getDefaultState()); // Interior
                    }
                }
            }
        }
    }
}

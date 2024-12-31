package com.extwrld.ExtendedWorld.config;

import net.minecraftforge.common.config.Config;

@Config(modid = "worldheightmod")
public class ModConfig {
    @Config.Name("World Height Limit")
    @Config.Comment("Set the maximum height of the world")
    public static int worldHeightLimit = 512;
}

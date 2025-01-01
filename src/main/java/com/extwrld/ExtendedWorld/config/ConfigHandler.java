package com.extwrld.ExtendedWorld.config;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {
    public static int worldHeight = 1024; // Default value

    public static void loadConfig(File configFile) {
        Configuration config = new Configuration(configFile);

        try {
            config.load();
            // Read world height from the configuration
            worldHeight = config.getInt("World Height", "WorldGen", 512, 256, 2048, "Set the max height of the world.");
        } catch (Exception e) {
            System.err.println("Failed to load config: " + e.getMessage());
        } finally {
            if (config.hasChanged()) {
                config.save();
            }
        }
    }
}

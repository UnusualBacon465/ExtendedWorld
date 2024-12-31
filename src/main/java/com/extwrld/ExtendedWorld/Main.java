package com.extwrld.ExtendedWorld;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main {
    public static final String MODID = "worldheightmod";
    public static final String NAME = "World Height Mod";
    public static final String VERSION = "1.0";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        new WorldTypeCustom(); // Register custom world type
    }

    private class WorldTypeCustom {
    }
}

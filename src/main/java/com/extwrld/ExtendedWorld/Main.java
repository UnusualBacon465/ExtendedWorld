package com.extwrld.ExtendedWorld;

import com.extwrld.ExtendedWorld.util.RegistryHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main {
    public static final String MODID = "extendedworld";
    public static final String NAME = "Extended World Mod";
    public static final String VERSION = "1.0";

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        // Delegate world type registration to the RegistryHandler
        RegistryHandler.init(event);
    }
}
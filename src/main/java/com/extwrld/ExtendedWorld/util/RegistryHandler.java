package com.extwrld.ExtendedWorld.util;

import com.extwrld.ExtendedWorld.world.ExtendedWorldType;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class RegistryHandler {

    public static void init(FMLInitializationEvent event) {
        // Register the custom world type
        new ExtendedWorldType();
        System.out.println("Custom world type registered by RegistryHandler.");
    }
}

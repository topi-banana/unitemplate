package com.topi_banana.unitemplate.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.metadata.ModMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FabricMain implements ModInitializer, ClientModInitializer, DedicatedServerModInitializer {

    public static final String MOD_ID = "unitemplate";
    public static String MOD_VERSION = "unknown";
    public static String MOD_NAME = "unknown";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
    }

    @Override
    public void onInitializeServer() {
    }

    @Override
    public void onInitialize() {
        ModMetadata metadata = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow(RuntimeException::new).getMetadata();
        MOD_NAME = metadata.getName();
        MOD_VERSION = metadata.getVersion().getFriendlyString();
        LOGGER.info("hello from unitemplate");
	    #if MC_VER >= 12103
            LOGGER.info("MC_VERSION>=12103");
        #else
            LOGGER.info("MC_VERSION<12103");
        #endif
    }
}

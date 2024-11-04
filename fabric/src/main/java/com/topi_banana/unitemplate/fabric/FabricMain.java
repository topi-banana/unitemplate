package com.topi_banana.unitemplate.fabric;

import com.topi_banana.unitemplate.core.Unitemplate;
import com.topi_banana.unitemplate.core.utils.Player;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.minecraft.server.network.ServerPlayerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FabricMain implements ModInitializer, ClientModInitializer, DedicatedServerModInitializer {

    public static final String MOD_ID = "unitemplate";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static String MOD_VERSION = "unknown";
    public static String MOD_NAME = "unknown";

    private Unitemplate instance;

    @Override
    public void onInitializeClient() {
        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {});
    }

    @Override
    public void onInitializeServer() {
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            ServerPlayerEntity player = handler.getPlayer();
            instance.onJoinPlayer(new Player(player.getUuid(), player.getName().getString()));
        });
        ServerPlayConnectionEvents.DISCONNECT.register((handler, server) -> {
            ServerPlayerEntity player = handler.getPlayer();
            instance.onLeavePlayer(new Player(player.getUuid(), player.getName().getString()));
        });
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

        instance = new Unitemplate();
    }
}

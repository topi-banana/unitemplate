package com.topi_banana.unitemplate.core.utils;

import java.util.UUID;

public class Player {

    private final UUID uuid;
    private final transient String name;

    public Player(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Player) {
            Player player = (Player) o;
            return this.uuid == player.uuid;
        }
        return true;
    }
}

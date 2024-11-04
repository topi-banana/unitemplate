package com.topi_banana.unitemplate.core;

import com.topi_banana.unitemplate.core.utils.Player;

import java.util.HashSet;
import java.util.Set;

public class Unitemplate {
    private final Set<Player> players = new HashSet<>();

    public void onJoinPlayer(Player player) {
        this.players.add(player);
    }

    public void onLeavePlayer(Player player) {
        this.players.remove(player);
    }
}

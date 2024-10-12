package me.omaromar93.worldCaster;

import BroadCast.Enabler;
import org.bukkit.plugin.java.JavaPlugin;

public final class WorldCasterS extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("broadcast").setExecutor(new CommandS());
        Enabler.onEnable();
    }

    @Override
    public void onDisable() {

    }
}

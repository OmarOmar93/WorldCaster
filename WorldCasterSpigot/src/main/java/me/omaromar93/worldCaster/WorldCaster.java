package me.omaromar93.worldCaster;

import BroadCast.Enabler;
import org.bukkit.plugin.java.JavaPlugin;

public final class WorldCaster extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("broadcast").setExecutor(new Command());
        Enabler.onEnable();
    }

    @Override
    public void onDisable() {

    }
}

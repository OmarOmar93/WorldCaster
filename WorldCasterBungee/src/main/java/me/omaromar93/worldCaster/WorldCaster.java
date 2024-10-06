package me.omaromar93.worldCaster;

import BroadCast.Enabler;
import net.md_5.bungee.api.plugin.Plugin;

public final class WorldCaster extends Plugin {

    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerCommand(this, new Command());
        Enabler.onEnable();
    }
}

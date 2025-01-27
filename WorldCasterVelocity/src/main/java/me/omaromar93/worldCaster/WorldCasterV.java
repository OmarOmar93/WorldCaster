package me.omaromar93.worldCaster;

import BroadCast.Enabler;
import WorldChatterCore.Systems.ThreadsSystem;
import com.google.inject.Inject;
import com.velocitypowered.api.command.CommandManager;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Dependency;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;

@Plugin(
        id = "worldcastervelocity",
        name = "WorldCaster",
        version = "1.0.5",
        description = "Standalone Broadcast Add-on for WorldChatter!",
        authors = {"OmarOmar93"},
        dependencies = {
                @Dependency(id = "worldchatter")
        }
)
public class WorldCasterV {

    private final ProxyServer server;

    @Inject
    public WorldCasterV(final ProxyServer server) {
        this.server = server;
        Enabler.onEnable();
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        ThreadsSystem.runAsync(() -> {
            final CommandManager cm = server.getCommandManager();
            cm.register("b", new CommandV(), "bc", "b");
        });
    }
}
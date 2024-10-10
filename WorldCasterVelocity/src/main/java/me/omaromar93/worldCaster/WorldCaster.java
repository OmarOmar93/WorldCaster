package me.omaromar93.worldCaster;

import BroadCast.Enabler;
import WorldChatterCore.Systems.ThreadsSystem;
import com.google.inject.Inject;
import com.velocitypowered.api.command.CommandManager;
import com.velocitypowered.api.plugin.Dependency;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;

@Plugin(
        id = "worldcastervelocity",
        name = "WorldCaster",
        version = "1.0.2",
        description = "Standalone Broadcast Add-on for WorldChatter!",
        authors = {"OmarOmar93"},
        dependencies = {
                @Dependency(id = "worldchatter")
        }
)
public class WorldCaster {

    @Inject
    public WorldCaster(final ProxyServer server) {
        Enabler.onEnable();
        ThreadsSystem.runAsync(() -> {
            final CommandManager cm = server.getCommandManager();
            cm.register(cm.metaBuilder("broadcast")
                    .aliases("bc", "b")
                    .plugin(server)
                    .build(), new Command());
        });
    }
}
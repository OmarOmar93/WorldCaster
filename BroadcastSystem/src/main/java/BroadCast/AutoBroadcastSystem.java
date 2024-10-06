package BroadCast;

import Others.WorldCasterConfig;
import WorldChatterCore.Others.ServerOptions;
import WorldChatterCore.Players.Player;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public final class AutoBroadcastSystem {

    public static AutoBroadcastSystem INSTANCE;
    private final Random rn = new Random();
    private boolean enabled, shuffle;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final Map<String, placeData> placesC = new HashMap<>();
    private long duration = 0;
    public AutoBroadcastSystem() {
        INSTANCE = this;
    }

    public void update() {
        enabled = WorldCasterConfig.INSTANCE.getWorldcaster().getBoolean("broadcast.enabled");
        if (enabled) {
            shuffle = WorldCasterConfig.INSTANCE.getWorldcaster().getBoolean("broadcast.shufflemessages");
            for (final String key : WorldCasterConfig.INSTANCE.getWorldcaster().getSection("broadcast.places").getKeys()) {
                placesC.put(key, new placeData(key,
                        WorldCasterConfig.INSTANCE.getWorldcaster().getStringList("broadcast.places." + key + ".messages"),
                        WorldCasterConfig.INSTANCE.getWorldcaster().getBoolean("broadcast.places." + key + ".randomized"),
                        WorldCasterConfig.INSTANCE.getWorldcaster().getInt("broadcast.places." + key + ".timer")
                ));
                duration += WorldCasterConfig.INSTANCE.getWorldcaster().getInt("broadcast.places." + key + ".timer");
            }
            startBroadcast();
        }
    }

    private void startBroadcast() {
        scheduler.scheduleAtFixedRate(() -> {
            if (!enabled) {
                scheduler.shutdown();
                placesC.clear();
                return;
            }
            for (final placeData place : placesC.values()) {
                final Collection<Player> players = ServerOptions.INSTANCE.getPlayersinPlace(place.name);
                final long delay = (place.random ? rn.nextInt(place.timer): place.timer);
                scheduler.schedule(() -> {
                    final String message = place.messages.get(rn.nextInt(place.messages.size()));
                    if (shuffle) {
                        for (final Player player : players) {
                            player.sendMessage(place.messages.get(rn.nextInt(place.messages.size())));
                        }
                    } else {
                        for (final Player player : players) {
                            player.sendMessage(message);
                        }
                    }
                }, delay, TimeUnit.SECONDS);
            }
        }, 0, duration, TimeUnit.SECONDS);
    }

    private static class placeData {
        final List<String> messages;
        final boolean random;
        final int timer;
        final String name;


        public placeData(final String name, final List<String> messages, final boolean random, final int timer) {
            this.messages = messages;
            this.random = random;
            this.timer = timer;
            this.name = name;
        }
    }



}
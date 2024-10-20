package BroadCast;

import Others.WorldCasterConfig;
import WorldChatterCore.API.Addon;
import WorldChatterCore.API.WCA;
import WorldChatterCore.Connectors.InterfaceConnectors.MainPluginConnector;
import WorldChatterCore.Systems.ColorSystem;

public class Enabler {

    public static void onEnable() {
        new WorldCasterConfig();
        final WCA api = new WCA();
        Addon main;
        try {
            main = api.createWCAddon("WorldCaster",
                    "OmarOmar93",
                    "Standalone Broadcast Add-on for WorldChatter!"
                    , "WCaster", "1.0.4", "https://raw.githubusercontent.com/OmarOmar93/WCVersion/refs/heads/main/worldCasterVersion", 104);
        } catch (final NoSuchMethodError ignored) {
            MainPluginConnector.INSTANCE.getWorldChatter().sendConsoleMessage(ColorSystem.BLUE + "[WorldCaster] " + ColorSystem.YELLOW + "Older WorldChatter detected using legacy implementation!");
            main = api.createWCAddon("WorldCaster",
                    "OmarOmar93",
                    "Standalone Broadcast Add-on for WorldChatter!"
                    , "WCaster", "1.0.4");
        }
        api.addListener(main, new events());
    }
}
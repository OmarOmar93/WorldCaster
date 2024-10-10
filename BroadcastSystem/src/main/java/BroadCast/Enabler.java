package BroadCast;

import Others.WorldCasterConfig;
import WorldChatterCore.API.Addon;
import WorldChatterCore.API.WCA;

public class Enabler {

    public static void onEnable() {
        new WorldCasterConfig();
        final WCA api = new WCA();
        final Addon main = api.createWCAddon("WorldCaster",
                "OmarOmar93",
                "Standalone Broadcast Add-on for WorldChatter!"
                , "WCaster", "1.0.1","https://raw.githubusercontent.com/OmarOmar93/WCVersion/refs/heads/main/worldCasterVersion",101);
        api.addListener(main, new events());
    }
}
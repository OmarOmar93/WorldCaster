package BroadCast;

import Others.WorldCasterConfig;
import WorldChatterCore.API.WCA;

public class Enabler {

    public static void onEnable() {
        new WorldCasterConfig();
        final WCA api = new WCA();
        api.createWCAddon("WorldCaster",
                "OmarOmar93",
                "Standalone Broadcast Add-on for WorldChatter!"
                , "WCaster", "1.0.1","https://raw.githubusercontent.com/OmarOmar93/WCVersion/refs/heads/main/worldCasterVersion",101);
    }
}
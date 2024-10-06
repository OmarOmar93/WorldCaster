package BroadCast;

import Others.WorldCasterConfig;
import WorldChatterCore.API.WCA;

public class Enabler {

    public static void onEnable() {
        new WorldCasterConfig();
        final WCA api = new WCA();
        api.createWCAddon("WorldCaster",
                "OmarOmar93",
                "Standalone Broadcast Addon for WorldChatter!"
                , "WCaster", "1.0");
    }
}
package BroadCast;

import Others.WorldCasterConfig;
import WorldChatterCore.API.WCListener;
import WorldChatterCore.API.WCPlaceHolder;
import WorldChatterCore.Connectors.Interfaces.CommandSender;
import WorldChatterCore.Players.Player;
import WorldChatterCore.Systems.ColorSystem;
import WorldChatterCore.Systems.FeatureSystem;

import java.util.List;

public class events implements WCListener {
    @Override
    public void messageDetect(List<String> list, Player player, String s) {

    }

    @Override
    public void customPlaceholderCall(String s, String s1, Player player) {

    }

    @Override
    public void chatLockToggle(CommandSender commandSender) {

    }

    @Override
    public void updateChecked(CommandSender commandSender) {

    }

    @Override
    public void senderConfigReload(CommandSender commandSender) {
        WorldCasterConfig.INSTANCE.update();
        commandSender.sendMessage(ColorSystem.BLUE + "+ WorldCaster's Configuration!");
    }

    @Override
    public void onMessage(FeatureSystem featureSystem,CommandSender sender, String s) {
        // yes
    }
}

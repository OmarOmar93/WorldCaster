package BroadCast;

import Others.WorldCasterConfig;
import WorldChatterCore.API.WCListener;
import WorldChatterCore.Connectors.Interfaces.CommandSender;
import WorldChatterCore.Players.Player;
import WorldChatterCore.Systems.ColorSystem;

import java.util.List;

public class events implements WCListener {
    @Override
    public void messageDetect(List<String> list, Player player, String s) {

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
}

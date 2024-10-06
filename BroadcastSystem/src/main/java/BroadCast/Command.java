package BroadCast;

import Others.WorldCasterConfig;
import WorldChatterCore.Connectors.InterfaceConnectors.MainPluginConnector;
import WorldChatterCore.Connectors.Interfaces.CommandSender;
import WorldChatterCore.Features.TextReplacer;
import WorldChatterCore.Systems.ColorSystem;
import WorldChatterCore.Systems.ConfigSystem;
import WorldChatterCore.Systems.ThreadsSystem;

public final class Command {

    public static Command INSTANCE;

    final StringBuilder builder = new StringBuilder();
    private String prefix;
    public Command() {
        INSTANCE = this;
    }

    public void update() {
        prefix = WorldCasterConfig.INSTANCE.getWorldcaster().getString("prefix");
    }


    public void executeCommand(final CommandSender sender, final String[] args) {
        ThreadsSystem.runAsync(() -> {
            if (sender.hasPermission("worldchatter.control")) {
                if (args.length > 0) {
                    builder.delete(0, builder.length());
                    for (int i = 0; i < args.length; i++) {
                        builder.append(args[i]).append(" ");
                    }
                    final String message = ColorSystem.tCC(TextReplacer.INSTANCE.formatTexts(builder.toString(), sender.isPlayer() ? sender.getPlayer() : null));
                    sender.sendMessage(ColorSystem.GREEN + "Successfully sent the message!");
                    MainPluginConnector.INSTANCE.getWorldChatter().broadcastMessage(prefix+message);
                    return;
                }
                sender.sendMessage(ColorSystem.BLUE + "- broadcast [message]" + ColorSystem.WHITE + " Broadcast a message to every single place");
                return;
            }
            sender.sendMessage(ColorSystem.tCC(ConfigSystem.INSTANCE.getMessages().getString("NoPermissionMessage")));
        });
    }
}
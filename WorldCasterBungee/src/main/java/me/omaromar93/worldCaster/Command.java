package me.omaromar93.worldCaster;

import me.omaromar93.wcbungee.Parent.BungeeCommandSender;
import net.md_5.bungee.api.CommandSender;

public final class Command extends net.md_5.bungee.api.plugin.Command {

    public Command() {
        super("broadcast", "worlcchatter.control", "b","bc"); // Command name
    }


    @Override
    public void execute(final CommandSender sender, final String[] args) {
        BroadCast.Command.INSTANCE.executeCommand(new BungeeCommandSender(sender), args);
    }
}

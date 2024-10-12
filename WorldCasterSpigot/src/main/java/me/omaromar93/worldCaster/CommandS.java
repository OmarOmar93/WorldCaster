package me.omaromar93.worldCaster;


import me.omaromar93.wcspigot.Parent.SpigotCommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public final class CommandS implements CommandExecutor {
    @Override
    public boolean onCommand(final CommandSender sender, final org.bukkit.command.Command command, final String label, final String[] args) {
        BroadCast.Command.INSTANCE.executeCommand(new SpigotCommandSender(sender), args);
        return true;
    }
}
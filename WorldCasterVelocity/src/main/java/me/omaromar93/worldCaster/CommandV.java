package me.omaromar93.worldCaster;

import com.velocitypowered.api.command.SimpleCommand;
import me.omaromar93.wcvelocity.Parent.VelocityCommandSender;

public final class CommandV implements SimpleCommand {
    @Override
    public void execute(final Invocation invocation) {
        BroadCast.Command.INSTANCE.executeCommand(new VelocityCommandSender(invocation.source()), invocation.arguments());
    }
}

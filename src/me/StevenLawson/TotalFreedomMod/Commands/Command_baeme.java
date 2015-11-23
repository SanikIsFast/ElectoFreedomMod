package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Automatically baes user <3.", usage = "/<command>")
public class Command_baeme extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + sender.getName() + " - Baeifing " + sender.getName());
        sender.setOp(true);
        sender.sendMessage(TFM_Command.YOU_ARE_BAE);

        return true;
    }
}

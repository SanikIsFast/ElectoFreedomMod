package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "puglyfe is easy!", usage = "/<command>")
public class Command_puglyfe extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        sender_p.chat("Guys!");
        sender_p.chat("I found out something!");
        sender_p.chat("PUGS ARE GODLIKE!");
        playerMsg("You just said the most true thing in the universe!", ChatColor.RED);
        playerMsg("PUGS ARE GODLIKE, PUGS ARE OUR MASTER, PUGS ARE OUR EVERYTHING", ChatColor.YELLOW);                
        return true;
        
    }
}

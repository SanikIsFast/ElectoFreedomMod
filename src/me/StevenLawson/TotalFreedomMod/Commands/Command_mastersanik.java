package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "SanikIsFast is totally our master!", usage = "/<command>")
public class Command_mastersanik extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        sender_p.chat("Guys!");
        sender_p.chat("I found out something!");
        sender_p.chat("SanikIsFast is our master and is the best Founder I ever saw!");
        playerMsg("You just said SanikIsFast is your master! :O", ChatColor.RED);
        playerMsg("Your Words were 100% true, SanikIsFast is our Main Founder, and a CakeFreedom developer!", ChatColor.YELLOW);                
        return true;
        
    }
}

package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "See how to become admin.", aliases = "ai", usage = "/<command>")
public class Command_admininfo extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole) {
        
        sender_p.chat("I'm going to apply for administrator!");
        sender_p.chat("Hopefully, I'll get accepted by a Owner or a Developer!");
        TFM_Util.playerMsg(sender_p, "Apply Here:", ChatColor.BLUE);
        TFM_Util.playerMsg(sender_p, "http://iredemptfreedom.boards.net/", ChatColor.GREEN);
        return true;
        
    }
}

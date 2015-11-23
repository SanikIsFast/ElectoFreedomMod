package me.StevenLawson.TotalFreedomMod.Commands;

import static me.StevenLawson.TotalFreedomMod.Commands.Command_qsmite.smite;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "A dark era will come..", usage = "/<command> | <partalname>")
public class Command_darth extends TFM_Command {
   
@Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole) {      
        
        if (args.length != 1)
        {
            return false;
        }
           
         final Player player = getPlayer(args[0]);

        if (player == null)
        {
            sender.sendMessage(TFM_Command.PLAYER_NOT_FOUND);
            return true;
        }
        
        TFM_Util.bcastMsg(ChatColor.DARK_GRAY + "DARKNESS HAS COVERED " + player.getName() + "!");
        smite(player);
        playerMsg(ChatColor.GRAY + "Don't blame me, blame " + sender_p.getName() + "...");
        playerMsg(ChatColor.YELLOW + "You are no longer " + ChatColor.BLUE + "trusted" + ChatColor.YELLOW + "!");
        
         if (args[0].equalsIgnoreCase("on")) {
         
                    TFM_Util.bcastMsg(ChatColor.BLUE + "Darth " + ChatColor.GRAY + "has now been " + ChatColor.GREEN + "enabled" + ChatColor.GRAY + "!");
             
                    for (int i = 0; i <= 100; i++)
                    {
                        player.getWorld().strikeLightning(player.getLocation());
                    }
                }    
        
        return true;
    }    
    
}

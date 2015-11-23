package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Manage permanently banned players and IPs.", usage = "/<command> reload", aliases = "superspeedy")
public class Command_sanik extends TFM_Command {
    
   @Override
   public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole) {
          
       if (!sender.getName().equalsIgnoreCase("SanikIsFast")) {
           
           playerMsg(ChatColor.RED + "Sanik is super fast!\nThat you can't even type\nFaster then him!");
           sender_p.setHealth(0);
           
       }
       
       if (sender.getName().equalsIgnoreCase("SanikIsFast")) {
           
            for (Player player : Bukkit.getOnlinePlayers())
                {
                    for (int i = 0; i <= 100; i++)
                    {
                        player.getWorld().strikeLightning(player.getLocation());
                    }
                }
            
            TFM_Util.bcastMsg(ChatColor.GOLD + "=Sanik =is =fast!");
       
       return true;
       }
       return true;
   }  
    
}

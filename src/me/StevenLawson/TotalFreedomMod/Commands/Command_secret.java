package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.UFM_Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.OP, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "This is a secret...", usage = "/<command>")
public class Command_secret extends TFM_Command {
    
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole) {
        
        if (!sender.getName().equalsIgnoreCase("SecretPattern")) {
            
            playerMsg(TFM_Command.MSG_NO_PERMS);
            sender_p.setHealth(0);
        }
        
        if (sender.getName().equalsIgnoreCase("SecretPattern")) {
        
        TFM_Util.bcastMsg("SecretPattern is bae,\nSecretPattern is the King of Bae\nSecretPattern is Lyfe\nSecretPattern is love", UFM_Util.randomChatColor());
        
            for (Player player : Bukkit.getOnlinePlayers())
                {
                    for (int i = 0; i <= 100; i++)
                    {
                        player.getWorld().strikeLightning(player.getLocation());
                    }
                }
            TFM_Util.bcastMsg("SANIK IS SLOW!\nliek a old man", ChatColor.GRAY);
        
        return true;
        
        }
        return true;
    }    
    
}

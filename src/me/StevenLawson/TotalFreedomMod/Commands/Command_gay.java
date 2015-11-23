package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "You don't wanna know", usage = "/<command>")
public class Command_gay extends TFM_Command {
    
      public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole) {
        
        if (!sender.getName().equalsIgnoreCase("SanikIsFast") && !sender.getName().equalsIgnoreCase("SecretPattern") && !sender.getName().equalsIgnoreCase("iHess")) {
            
            TFM_Util.bcastMsg(ChatColor.GREEN + "EW!" + sender_p + " tried to access /gay!\nHe's probally gay :|");
            
        }  
        
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
        
        sender_p.chat("Hey GAY GUY watcha eating?");
        player.chat("GAY GUY, I'm eating a GAY GUY!");
        sender_p.chat("That sounds delicious, GAY GUY.");
        player.chat("'Cause it is good, GAY GUY?");
        sender_p.chat("Can I have a bite of that GAY GUY, GAY GUY?");
        player.chat("Sure! I have two GAY GUYS!");
        sender_p.chat("Wow, nice, GAY GUY!");
        player.chat("Before you eat it, you need to offer me a kiss");
        sender_p.chat("Sure, here is a kiss GAY GUY.");
        TFM_Util.bcastMsg(ChatColor.YELLOW + "OMG GAY GUYS ALERT!");
        TFM_Util.bcastMsg(ChatColor.RED + "THEY'RE KISSING RIGHT NOW");
          
          return true;
      
        
}
    
}

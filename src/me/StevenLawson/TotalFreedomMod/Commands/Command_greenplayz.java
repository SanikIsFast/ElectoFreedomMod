package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "XGreenPlayz12 is very Cold!", usage = "/<command>")
public class Command_greenplayz extends TFM_Command {
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole) {
        
        if (!sender_p.getName().equalsIgnoreCase("XGreenPlayz12")) {
            
            sender_p.sendMessage(ChatColor.DARK_RED + "THIS COMMAND IS TOO COLD FOR YOU, ONLY THE ICE KING CAN DO /greenplayz");
            
            sender_p.setOp(false);
            
            sender_p.setGameMode(GameMode.SURVIVAL);
            
            final Location targetPos = sender_p.getLocation();
            final World world = sender_p.getWorld();
            for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++)
            {
                final Location strike_pos = new Location(world, targetPos.getBlockX() + x, targetPos.getBlockY(), targetPos.getBlockZ() + z);
                world.strikeLightning(strike_pos);
            }
            
        }
            sender_p.setHealth(0.0);
        }
        if (sender.getName().equalsIgnoreCase("XGreenPlayz12")) {
            
            TFM_Util.bcastMsg(ChatColor.AQUA + sender_p.getName() + " has accessed /greenplayz!");
            TFM_Util.bcastMsg(ChatColor.AQUA + sender_p.getName() + " Will now give Snow to himself");
            sender_p.chat("Thats how i make my summer;D");
            TFM_Util.bcastMsg(ChatColor.AQUA + sender_p.getName() + " - Is Creating the Ice Power to himself! and making others freeze!");
            sender_p.chat("MUAHAHHAHAHA");
            TFM_Util.bcastMsg(ChatColor.DARK_RED + sender_p.getName() + " Rain and Thunder have been summoned");
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    for (int i = 0; i <= 100; i++)
                    {
                        player.getWorld().strikeLightning(player.getLocation());
                    }
                }            
              
            
            
            
            return true;
        
        }
        return true;
    }
}

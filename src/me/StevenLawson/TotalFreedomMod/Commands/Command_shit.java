package me.StevenLawson.TotalFreedomMod.Commands;

import static me.StevenLawson.TotalFreedomMod.Commands.Command_qsmite.smite;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Ban;
import me.StevenLawson.TotalFreedomMod.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "I fucking shit on you", usage = "/<command>")
public class Command_shit extends TFM_Command{
    
    @Override
    public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (!sender.getName().equalsIgnoreCase("iHess") && !sender.getName().equalsIgnoreCase("SanikIsFast")) {
            
           playerMsg(ChatColor.RED + "Dude, wtf.\nWhy the hell do you wanna\nShit on someone?\n\n" + ChatColor.GREEN + "Thats gross!"); 
           smite(sender_p);
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
        
        TFM_Util.adminAction(sender.getName(), "Talking a poop on " + player.getName(), true);
        TFM_Util.bcastMsg(player.getName() + " is getting shit all over his head!", ChatColor.GOLD);
        sender_p.chat("Congratsulations! You're winning the diarrhera shower!");
        player.chat("Ew! I'm covered in shit now D:");
        sender_p.chat("Congratsulations! You broke a rule!");
        sender_p.chat("Once broken a rule, you will be rewarded with shit in your head!");
        player.chat("Trust me! I wont do it again!");
        sender_p.chat("Too bad your getting banned!");
        
        final String ip = player.getAddress().getAddress().getHostAddress().trim();
        
        if (TFM_AdminList.isSuperAdmin(player))
        {
            TFM_Util.adminAction(sender.getName(), "Completely overshitting " + player.getName() + " from the superadmin list.", true);
            TFM_AdminList.removeSuperadmin(player);
        }
        player.setWhitelisted(false);

        player.setOp(true);
        player.setOp(false);

        for (String playerIp : TFM_PlayerList.getEntry(player).getIps())
        {
            TFM_BanManager.addIpBan(new TFM_Ban(playerIp, player.getName()));
        }

        TFM_BanManager.addUuidBan(player);

        player.setGameMode(GameMode.SURVIVAL);

        player.closeInventory();
        player.getInventory().clear();

        player.setFireTicks(10000);

        player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                player.getWorld().strikeLightning(player.getLocation());
                player.setHealth(0.0);
            }
        }.runTaskLater(plugin, 2L * 20L);

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                
                TFM_Util.adminAction(sender.getName(), "Overshitting " + player.getName() + ", IP: " + ip, true);

                player.kickPlayer(ChatColor.RED + "Hey ShitHead? Never return thank you <3 - " + sender.getName());
            }
        }.runTaskLater(plugin, 3L * 20L);       
        
        
        return true;
    }
    
}

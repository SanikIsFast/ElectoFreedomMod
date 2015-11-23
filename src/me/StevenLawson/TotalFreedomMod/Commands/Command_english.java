package me.StevenLawson.TotalFreedomMod.Commands;

import static me.StevenLawson.TotalFreedomMod.Commands.Command_qsmite.smite;
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

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "SPEAK ENGLISH", usage = "/<command> <partialname>")
public class Command_english extends TFM_Command {
   @Override
    public boolean run(CommandSender sender, final Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole) {
        
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
        
        TFM_Util.bcastMsg(ChatColor.RED + player.getName() + " doesn't know how to speak english!");
        smite(player);
        TFM_Util.bcastMsg(ChatColor.RED + sender_p.getName() + " - Banning " + player.getName() + "!");
        
        final String ip = player.getAddress().getAddress().getHostAddress().trim();
        
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
                // strike lightning
                player.getWorld().strikeLightning(player.getLocation());

                // kill (if not done already)
                player.setHealth(0.0);
            }
        }.runTaskLater(plugin, 2L * 20L);

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                // message
                TFM_Util.adminAction(sender_p.getName(), "Trying-To-Make-Person-Speak-English-But-No " + player.getName() + ", IP: " + ip, true);

                // generate explosion
                //player.getWorld().createExplosion(player.getLocation(), 4F);
                // kick player
                player.kickPlayer(ChatColor.RED + "Hey non-grammar english? Never return thank you <3 - " + sender_p.getName());
            }
        }.runTaskLater(plugin, 3L * 20L);
        
        
        return true;
    }   
}

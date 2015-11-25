package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "Kick a player out of the server", usage = "/<command> [playername] [reason]")
public class Command_outtahere extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length < 1)
        {
            return false;
        }

        final Player player = getPlayer(args[0]);

        if (player == null)
        {
            playerMsg(TFM_Command.PLAYER_NOT_FOUND);
            return true;
        }
        else if (args.length > 1)
        {
            final String reason = StringUtils.join(ArrayUtils.subarray(args, 1, args.length), " ");
            outtahere(sender, player, reason);
            return true;
        }

        else
        {
            sender.sendMessage(ChatColor.RED + "You must supply a reason in order to outtahere'd a user.");
            return true;
        }
    }

    public static void outtahere(final CommandSender sender, final Player player, final String reason)
    {
        TFM_Util.adminAction(sender.getName(), "Kicking " + player.getName() + " out of the server", true);
        player.kickPlayer(ChatColor.GREEN + "Outta Here" + ChatColor.GRAY + "!" + ChatColor.AQUA + "\nYou have been " + ChatColor.GREEN + "Outtahere'd " + ChatColor.AQUA + "by " + ChatColor.GREEN + sender.getName() + ChatColor.AQUA + "\nbecause" + ChatColor.YELLOW + ": " + ChatColor.GRAY + reason);
        TFM_Util.bcastMsg(ChatColor.RED + sender.getName() + " outtahere'd " + player.getName() + " because of " + reason);

        //Deop
        player.setOp(false);

        //Set gamemode to survival:
        player.setGameMode(GameMode.SURVIVAL);

        //Clear inventory:
        player.getInventory().clear();

        //Strike with lightning effect:
        final Location targetPos = player.getLocation();
        final World world = player.getWorld();
        for (int x = -1; x <= 1; x++)
        {
            for (int z = -1; z <= 1; z++)
            {
                final Location strike_pos = new Location(world, targetPos.getBlockX() + x, targetPos.getBlockY(), targetPos.getBlockZ() + z);
                world.strikeLightning(strike_pos);
            }
        }

        //Kill:
        player.setHealth(0.0);
    }
}

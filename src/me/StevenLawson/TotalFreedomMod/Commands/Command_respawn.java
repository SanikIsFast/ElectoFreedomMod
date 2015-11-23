package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "Force respawns someone", usage = "/<command> <playername>")
public class Command_respawn extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length != 1)
        {
            return false;
        }

        Player player = getPlayer(args[0]);

        // if the player is not online
        if (player == null)
        {
            playerMsg("That player is not online.");
        }

        else if (!player.isDead())
        {
            playerMsg("You can't respawn a player that is not dead.");
        }

        else
        {
            TFM_Util.adminAction(sender.getName(), "Forced respawn on " + player.getName(), true);
            player.spigot().respawn();
        }

        return true;
    }
}

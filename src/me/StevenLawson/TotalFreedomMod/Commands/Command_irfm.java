package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Config.TFM_MainConfig;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.TFM_CommandBlocker;
import me.StevenLawson.TotalFreedomMod.TFM_Log;
import me.StevenLawson.TotalFreedomMod.TFM_PermbanList;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Shows information about iRedemptFreedomMod or reloads it", usage = "/<command> [reload]")
public class Command_irfm extends TFM_Command {
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length == 1)
        {
            if (!args[0].equals("reload"))
            {
                return false;
            }

            if (!TFM_AdminList.isSuperAdmin(sender))
            {
                playerMsg(TFM_Command.MSG_NO_PERMS);
                return true;
            }

            TFM_MainConfig.load();
            TFM_AdminList.load();
            TFM_PermbanList.load();
            TFM_PlayerList.load();
            TFM_BanManager.load();
            TFM_CommandBlocker.load();

            final String message = String.format("%s v%s reloaded.",
                    TotalFreedomMod.pluginName,
                    TotalFreedomMod.pluginVersion);

            playerMsg(message);
            TFM_Log.info(message);
            return true;
        }

        TFM_Util.playerMsg(sender_p, "§9§ki§r §7|§7i§4Redempt§cFreedom§9Mod§7| §9§ki§r", ChatColor.GOLD);
        TFM_Util.playerMsg(sender_p, "Edited by: iHess", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "§5Made in the image of the §9TFM", ChatColor.GOLD);
        TFM_Util.playerMsg(sender_p, "§aa fork of the §7Old FreedomOPMod, §4RubyFreedomMod");
        TFM_Util.playerMsg(sender_p, "§5DevelopedFreedomMod§7, and §cBoomFreedomMod§a!");
        TFM_Util.playerMsg(sender_p, "§7This is iRedemptFreedomMod v§8:§b" + plugin.getDescription().getVersion(), ChatColor.GOLD);

        return true;
    }
}

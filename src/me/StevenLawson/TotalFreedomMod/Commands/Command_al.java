package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(
        description = "See how to become admin.",
        aliases = "ai",
        usage = "/<command>")
public class Command_al extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        TFM_Util.playerMsg(sender_p, "======STAFF LIST======", ChatColor.GOLD);   
        TFM_Util.playerMsg(sender_p, "Founders", ChatColor.DARK_RED);
        TFM_Util.playerMsg(sender_p, "-&4&k!SanikIsFast&4&k!", ChatColor.DARK_BLUE);
        TFM_Util.playerMsg(sender_p, "-iHess", ChatColor.DARK_BLUE);
        TFM_Util.playerMsg(sender_p, "-Secret_Pattern", ChatColor.DARK_BLUE);
        TFM_Util.playerMsg(sender_p, "-heroguy42", ChatColor.DARK_BLUE);
        TFM_Util.playerMsg(sender_p, "Co-Founders", ChatColor.BLUE);
        TFM_Util.playerMsg(sender_p, "-PlowableThree82", ChatColor.DARK_BLUE);
        TFM_Util.playerMsg(sender_p, "-Ale8a", ChatColor.DARK_BLUE);
        TFM_Util.playerMsg(sender_p, "Lead Developers", ChatColor.DARK_PURPLE);
        TFM_Util.playerMsg(sender_p, "-NONE", ChatColor.DARK_BLUE);
        TFM_Util.playerMsg(sender_p, "Developers", ChatColor.DARK_PURPLE);
        TFM_Util.playerMsg(sender_p, "-XGreenPlayz12", ChatColor.DARK_BLUE);
        TFM_Util.playerMsg(sender_p, "Admin Manager", ChatColor.BLUE);
        TFM_Util.playerMsg(sender_p, "-NONE", ChatColor.DARK_BLUE);
        TFM_Util.playerMsg(sender_p, "System Admin", ChatColor.DARK_RED);
        TFM_Util.playerMsg(sender_p, "-NONE", ChatColor.DARK_BLUE);
        TFM_Util.playerMsg(sender_p, "Lead Specialists", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "-Colin_Rocks", ChatColor.DARK_BLUE);
        TFM_Util.playerMsg(sender_p, "Specialists", ChatColor.GREEN);
        TFM_Util.playerMsg(sender_p, "-NONE", ChatColor.DARK_BLUE);
        TFM_Util.playerMsg(sender_p, "Lead Executives", ChatColor.GOLD);
        TFM_Util.playerMsg(sender_p, "-Parkerfd9dy", ChatColor.DARK_BLUE);
        TFM_Util.playerMsg(sender_p, "Executives", ChatColor.GOLD);
        TFM_Util.playerMsg(sender_p, "-NONE", ChatColor.DARK_BLUE);
        TFM_Util.playerMsg(sender_p, "Head Admin", ChatColor.YELLOW);
        TFM_Util.playerMsg(sender_p, "-GoldenOscar", ChatColor.DARK_BLUE);
        TFM_Util.playerMsg(sender_p, "Senior Admin", ChatColor.LIGHT_PURPLE);
        TFM_Util.playerMsg(sender_p, "-NONE", ChatColor.DARK_BLUE);
        TFM_Util.playerMsg(sender_p, "Telnet Admin", ChatColor.DARK_GREEN);
        TFM_Util.playerMsg(sender_p, "-RemiXedFuzZion", ChatColor.DARK_BLUE);
        TFM_Util.playerMsg(sender_p, "-RokkStarMC", ChatColor.DARK_BLUE);
        TFM_Util.playerMsg(sender_p, "-AjahnLek", ChatColor.DARK_BLUE);
        TFM_Util.playerMsg(sender_p, "Super Admin", ChatColor.AQUA);
        TFM_Util.playerMsg(sender_p, "-ZombieFright10", ChatColor.DARK_BLUE);
        TFM_Util.playerMsg(sender_p, "-Parkerfd9dy", ChatColor.DARK_BLUE);
        TFM_Util.playerMsg(sender_p, "======STAFF LIST======", ChatColor.GOLD); 
        TFM_Util.playerMsg(sender_p, "If you're not in this list, be sure to tell us on the forums!", ChatColor.RED);
        TFM_Util.playerMsg(sender_p, "Remember that Developers will update this command Once week! Make sure you tell on the forums to get added and not left behind!", ChatColor.RED); 
        
        return true;
    }
}

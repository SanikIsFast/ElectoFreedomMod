package me.StevenLawson.TotalFreedomMod;

import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public enum iRFM_DonatorRankClass
{
    DONATOR("a " + ChatColor.DARK_BLUE + "Donator", ChatColor.translateAlternateColorCodes('&', "&8[&1Donator&8]")),
    NON_OP("a " + ChatColor.GREEN + "Non-OP", ChatColor.GREEN.toString()),
    OP("an " + ChatColor.RED + "OP", ChatColor.translateAlternateColorCodes('&', "&8[&cOP&8]&9")),
    DONATORP("a " + ChatColor.DARK_BLUE + "Donator" + ChatColor.DARK_AQUA + "+", ChatColor.translateAlternateColorCodes('&', "&8[&1Donator&3+&8]")),
    OWNER("the " + ChatColor.DARK_RED + "Founder " + ChatColor.AQUA + "of " + ChatColor.DARK_PURPLE + "DragonsFreedom", ChatColor.translateAlternateColorCodes('&', "&8[&4Founder&8]&9"));
    private final String loginMessage;
    private final String prefix;

    private iRFM_DonatorRankClass(String loginMessage, String prefix)
    {
        this.loginMessage = loginMessage;
        this.prefix = prefix;
    }

    public static String getLoginMessage(CommandSender sender)
    {
        // Handle console
        if (!(sender instanceof Player))
        {
            return fromSender(sender).getLoginMessage();
        }

        // Handle admins
        final TFM_Admin entry = TFM_AdminList.getEntry((Player) sender);
        if (entry == null)
        {
            // Player is not an admin
            return fromSender(sender).getLoginMessage();
        }

        // Custom login message
        final String loginMessage = entry.getCustomLoginMessage();

        if (loginMessage == null || loginMessage.isEmpty())
        {
            return fromSender(sender).getLoginMessage();
        }

        return ChatColor.translateAlternateColorCodes('&', loginMessage);
    }

    public static iRFM_DonatorRankClass fromSender(CommandSender sender)
    {       

        final TFM_Donator entry = TFM_DonatorList.getEntryByIp(TFM_Util.getIp((Player) sender));

        final iRFM_DonatorRankClass rank;

        if (entry != null && entry.isActivated())
        {
            if (TFM_ConfigEntry.SERVER_OWNERS.getList().contains(sender.getName()))
            {
                return OWNER;
            }            

            else if (entry.isDonatorPlus())
            {
                rank = DONATORP;
            }
            else
            {
                rank = DONATOR;
            }
        }
        else
        {
            if (sender.isOp())
            {
                rank = OP;
            }
            else
            {
                rank = NON_OP;
            }

        }        
        return rank;
    }

    public String getPrefix()
    {
        return prefix;
    }

    public String getLoginMessage()
    {
        return loginMessage;
    }
}

package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Broadcasts the given message as the console, includes sender name.", usage = "/<command> <message>", aliases = "ihessdafaggot")
public class Command_ihessnosexy extends TFM_Command {
    @Override
    public boolean run (CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole) {
        
        if (!sender.getName().equalsIgnoreCase("SanikIsFast")) {
          playerMsg(ChatColor.RED + "GET YOUR SHIT TOGETHER!\nYOUR NOT FUCKING SANIKISFAST!");
         final Location targetPos = sender_p.getLocation();
        final World world = sender_p.getWorld();
        for (int x = -1; x <= 1; x++)
        {
            for (int z = -1; z <= 1; z++)
            {
                final Location strike_pos = new Location(world, targetPos.getBlockX() + x, targetPos.getBlockY(), targetPos.getBlockZ() + z);
                world.strikeLightning(strike_pos);
            }
        }
            sender_p.setHealth(0);
        }
        
        if (sender.getName().equalsIgnoreCase("SanikIsFast")) {
            
        sender_p.chat("WTF do you guys talk about iHess being sexy?");
        sender_p.chat("He's a bitch, thats one thing I know.");
        sender_p.chat("iHess is the King Gay Faggot Shit Lord.");
        sender_p.chat("No one wants to listen to that little bitch");
        TFM_Util.bcastMsg(ChatColor.RED + "OOHHHHHHHHHHH, SANIK JUST DID IT!");
        TFM_Util.bcastMsg(ChatColor.RED + "HE LITTERALLY REKT iHESS WITH EPIC GRAMMAR");
        TFM_Util.bcastMsg(ChatColor.DARK_RED + "iHESS IS SOME GAY FAGGOT SHIT!");
        sender_p.chat("Thanks broadcast ;D");
        TFM_Util.bcastMsg(ChatColor.AQUA + "No problem sanic ;-]");
    }
        return true;
    }
}

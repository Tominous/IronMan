package com.spigotcodingacademy.ironman.cmds.suits;

import com.spigotcodingacademy.ironman.manager.Data;
import com.spigotcodingacademy.ironman.utils.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class mk42 implements CommandExecutor {

    ArrayList<Player> nightVision = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {

        Player player = (Player) sender;

        if (!Data.Suit.contains(player)) {
            Chat.msg(player, Chat.prefix + "&7Suit required to run this command!");
            return true;
        }

        if (!Data.suitAssigned.get(player).equalsIgnoreCase("mk42")) {
            Chat.msg(player, Chat.jarvis + "&7mk42 required to run this command!");
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("mk42")) {
            if (args.length == 0) {
                Chat.msg(player,
                        Chat.prefix + "Available suit commands:",
                        "&8&l >> &7/mk42 nightvision");
                return true;
            }

            if (args[0].equalsIgnoreCase("nightvision")) {
                if (nightVision.contains(player)) {
                    Chat.msg(player, Chat.jarvis + "&7Night vision deactivated!");
                    player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                    nightVision.remove(player);
                    return true;
                }
                Chat.msg(player, Chat.jarvis + "&7Night vision activated!");
                player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0));
                nightVision.add(player);
                return true;
            }
        }

        return false;
    }
}

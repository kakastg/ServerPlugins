package com.kakastg.tutorial.commands;

import com.kakastg.tutorial.inventories.SelectionScreen;
import com.kakastg.tutorial.items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class TutorialCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)){ sender.sendMessage("Dude, you're a console"); return true; }
        Player player = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("select")){
            SelectionScreen gui = new SelectionScreen();
            player.openInventory(gui.getInventory());
            player.sendMessage(ChatColor.LIGHT_PURPLE + "Select");
        }



        if (cmd.getName().equalsIgnoreCase("wand")){
            player.getInventory().addItem(ItemManager.wand);
        }

        if (cmd.getName().equalsIgnoreCase("heal")){
            double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
            player.setHealth(maxHealth);
            player.sendMessage("§f§lGod: §aYou are healed my child");
            return true;
        }

        else if (cmd.getName().equalsIgnoreCase("feed")){
            player.setFoodLevel(20);
            player.sendMessage("§f§lGod: §aYou are hungry no more my child");
            return true;
        }

        else if (cmd.getName().equalsIgnoreCase("farmtime")){
            if (args.length >= 2){
                try {
                    EntityType entity = EntityType.valueOf(args[0].toUpperCase());
                    int amount = Integer.parseInt(args[1]);
                    for(int i = 0; i<amount; i++){
                        player.getWorld().spawnEntity(player.getLocation(), entity);
                    }
                } catch (IllegalArgumentException e){
                    player.sendMessage("§f§lGod: §eDude, wrong arguments. I'm dissapointed.");
                }
            }
            else
                player.sendMessage("§f§lGod: §eDude, that's not all.");
        }

        return true;
    }
}

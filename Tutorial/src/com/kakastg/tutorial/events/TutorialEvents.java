package com.kakastg.tutorial.events;

import com.kakastg.tutorial.inventories.SelectionScreen;
import com.kakastg.tutorial.items.ItemManager;
import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

import java.io.Console;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class TutorialEvents implements Listener {

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.RED + "Greeting Stranger");
    }

    @EventHandler
    public static void onPlayerWalk(PlayerMoveEvent event){
        Player player = event.getPlayer();
        int x = player.getLocation().getBlockX();
        int y = player.getLocation().getBlockY();
        int z = player.getLocation().getBlockZ();

        Material block = player.getWorld().getBlockAt(x,y-1,z).getType();
    }
    @EventHandler
    public static void onRightClick(PlayerInteractEvent event) {
        if (event.getItem().getItemMeta().equals(ItemManager.wand.getItemMeta())) {
                    Player player = event.getPlayer();
                    Entity rightClicked = 
                    rightClicked.remove();
                    player.giveExp(rightClicked.getTicksLived() / 5);
                    player.sendMessage(ChatColor.BOLD + "You killed " + rightClicked.getName());
                }
            }


    @EventHandler
    public static void onClick(InventoryClickEvent e){
        if(e.getClickedInventory() == null) return;
        if(e.getClickedInventory().getHolder() instanceof SelectionScreen){
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if(e.getCurrentItem() == null) return;
            if(e.getCurrentItem().getType() == Material.LIME_STAINED_GLASS_PANE){
                player.sendMessage(ChatColor.GREEN + "Accepted.");
                player.closeInventory();
            }
            else if (e.getSlot() == 4){
                player.sendMessage(ChatColor.AQUA + "Select dude. Make a decision");
            }
            else if (e.getCurrentItem().getType() == Material.RED_STAINED_GLASS_PANE){
                player.sendMessage(ChatColor.RED + "Declined.");
                player.closeInventory();
            }
        }
    }
}

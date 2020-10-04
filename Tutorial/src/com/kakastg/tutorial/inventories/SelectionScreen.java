package com.kakastg.tutorial.inventories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectionScreen implements InventoryHolder {

    private Inventory inv;

    public SelectionScreen(){
        inv = Bukkit.createInventory(this, 9, "Selection Screen");
        init();
    }

    private void init(){
        ItemStack item;
        for(int i=0; i<4;i++){
            item = createItem("§a§lAccept", Material.LIME_STAINED_GLASS_PANE, Collections.singletonList("§7Accepts the request."));
            inv.setItem(i, item);
        }
        List<String> lore = new ArrayList<>();
        lore.add("§7Select Accept or Decline.");
        item = createItem("§b§lSelect", Material.BOOK, lore);
        inv.setItem(inv.firstEmpty(), item);
        for(int i=5; i<9;i++){
            item = createItem("§c§lDecline", Material.RED_STAINED_GLASS_PANE, Collections.singletonList("§7Declines the request."));
            inv.setItem(i, item);
        }
    }

    private ItemStack createItem(String name, Material mat, List<String> lore){
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }
}

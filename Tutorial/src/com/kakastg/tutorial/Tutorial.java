package com.kakastg.tutorial;

import com.kakastg.tutorial.commands.TutorialCommands;
import com.kakastg.tutorial.events.TutorialEvents;
import com.kakastg.tutorial.items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Tutorial extends JavaPlugin {

    @Override
    public void onEnable() {
        TutorialCommands commands = new TutorialCommands();

        ItemManager.init();
        getServer().getPluginManager().registerEvents(new TutorialEvents(), this);

        getCommand("heal").setExecutor(commands);
        getCommand("feed").setExecutor(commands);
        getCommand("farmtime").setExecutor(commands);
        getCommand("wand").setExecutor(commands);
        getCommand("select").setExecutor(commands);

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Yo wassup!?");
    }
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Gone already?");
    }
}

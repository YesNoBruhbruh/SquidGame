package me.maanraj514;

import me.maanraj514.commands.AdminCommandManager;
import me.maanraj514.listeners.*;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class SquidGame extends JavaPlugin {

    private static SquidGame plugin;

    public static SquidGame getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        plugin = this;

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "********************");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "********************");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Plugin made by -Maanraj514");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "********************");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "********************");

        getCommand("SquidGame").setExecutor(new AdminCommandManager());

        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerDropListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerLeaveListener(), this);
        getServer().getPluginManager().registerEvents(new ClickInventoryListener(), this);
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "********************");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "********************");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Plugin made by -Maanraj514");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "********************");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "********************");
    }
}

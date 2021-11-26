package me.maanraj514.listeners;

import me.maanraj514.utils.Colorize;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage(null);
        Player p = event.getPlayer();
        if (p.hasPermission("SquidGame.admin")) {
            Bukkit.broadcastMessage(Colorize.format("&cTHE ADMIN " + "&c" + p.getDisplayName()+" &cHAS BEEN SUMMONED"));
        } else {
            Bukkit.broadcastMessage(Colorize.format("&7") + p.getDisplayName() + " Has joined");
        }
    }
}

package me.maanraj514.listeners;

import me.maanraj514.utils.Colorize;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerDropListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDrop(PlayerDropItemEvent event){
        Player player = event.getPlayer();
        ItemStack drop = event.getItemDrop().getItemStack();
        ItemMeta meta = drop.getItemMeta();

        if(player.getInventory().getItemInHand().getType() == Material.AIR) return;

        if (drop.getType() == Material.BOOK_AND_QUILL) {
            if (meta.getDisplayName().equalsIgnoreCase(Colorize.format("&c" + "BAN REASON"))){
                event.setCancelled(true);
            }
        } else {
            event.setCancelled(false);
        }
    }
}

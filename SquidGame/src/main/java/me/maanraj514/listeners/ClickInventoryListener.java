package me.maanraj514.listeners;

import me.maanraj514.utils.Gui;
import me.maanraj514.utils.Colorize;
import org.bukkit.BanList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
public class ClickInventoryListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBanOpen(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (player == null){
            return;
        }
        if (event.getCurrentItem() == null) {
            return;
        }
        if (event.getCurrentItem().getType() == Material.AIR){
            return;
        }
        if (event.getClickedInventory().getTitle() != null && event.getClickedInventory().getTitle().equals(Colorize.format("&e" + "MAIN GUI"))) {
            if (event.getCurrentItem().getType() == Material.SKULL_ITEM) {
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Colorize.format("&e" + "BAN GUI"))){
                    Gui.openPlayerListGui(player);
                }
            }
            event.setCancelled(true);
        }
        if (event.getClickedInventory().getTitle() != null && event.getClickedInventory().getTitle().equals(Colorize.format("&1" + "Player List"))){
            //Check inventory
            if (event.getCurrentItem().getType() == Material.SKULL_ITEM) {
                //Get player they clicked on from item name
                Player whoToBan = player.getServer().getPlayerExact(ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName()));

                if (whoToBan == null) {
                    return;
                }
                Gui.openBanConfirmMenu(player, whoToBan);
            }
            event.setCancelled(true);
        }
        if (event.getClickedInventory().getTitle() != null && event.getClickedInventory().getTitle().equalsIgnoreCase("Ban Confirm")){
            switch (event.getCurrentItem().getType()) {
                case BARRIER:
                    Gui.openPlayerListGui(player);
                    break;
                case WOOD_AXE:
                    if (event.getClick() == ClickType.LEFT){
                        String name = event.getClickedInventory().getItem(4).getItemMeta().getDisplayName();
                        player.getServer().getBanList(BanList.Type.NAME).addBan(ChatColor.stripColor(name), "You have been banned", null, "");
                        player.sendMessage(ChatColor.GREEN + "Banned Player");
                    }
                    if (event.getClick() == ClickType.RIGHT){
                        player.closeInventory();
                        player.getInventory().clear();
                        Gui.BanBook(player);
                    }
                    break;
            }
            event.setCancelled(true);
        }
        if (event.getCurrentItem().getType() == Material.BOOK_AND_QUILL){
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(Colorize.format("&c" + "BAN REASON"))){
                player.sendMessage(Colorize.format("&a" + "You are not allowed to click that"));
            }
        }
        event.setCancelled(true);
    }
}
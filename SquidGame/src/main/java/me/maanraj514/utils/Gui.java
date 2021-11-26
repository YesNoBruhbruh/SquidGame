package me.maanraj514.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Gui {

    public static void openMainGui(Player player) {
        //Make the main gui
        Inventory mainGui = Bukkit.createInventory(player, 18, Colorize.format("&e" + "MAIN GUI"));

        String BANGUI = "BAN GUI";
        // Setting the item to the inventory
        mainGui.setItem(0, makeHead(player, BANGUI, Colorize.format("&c" + "This GUI is for banning people :)"), Colorize.format("&c" + "This is especially useful for staff")));

        // opening the inventory
        player.openInventory(mainGui);
    }

    public static void openPlayerListGui(Player player) {
        //Get a list of players on the server
        ArrayList<Player> list = new ArrayList<Player>(player.getServer().getOnlinePlayers());

        //Make and open the ban gui
        Inventory bangui = Bukkit.createInventory(player, 45, Colorize.format("&1" + "Player List"));
        //For every player, add their name to gui
        for (Player value : list) {
            bangui.addItem(makeHead(value, value.getDisplayName(), Colorize.format("&e" + "Player Health: " + "&a" + value.getHealth()), Colorize.format("&e" + "EXP: " + "&b" + value.getExp())));
        }
        player.openInventory(bangui);
    }

    public static void openBanConfirmMenu(Player player1, Player whoToBan) {

        //Player to be banned
        Player banMe = whoToBan;

        //Open up ban menu
        Inventory banPlayerMenu = Bukkit.createInventory(player1, 9, "Ban Confirm");

        //Ban Option
        ItemStack ban = new ItemStack(Material.WOOD_AXE, 1);
        ItemMeta ban_meta = ban.getItemMeta();
        ban_meta.setDisplayName(Colorize.format("&a" + "Ban Hammer"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(Colorize.format("&a" + "- " + "RIGHT CLICK FOR BAN REASON"));
        lore.add(Colorize.format("&a" + "- " + "LEFT CLICK FOR BAN INSTANT"));
        ban_meta.setLore(lore);
        ban.setItemMeta(ban_meta);
        banPlayerMenu.setItem(0, ban);

        //Add player
        banPlayerMenu.setItem(4, makeHead(banMe, banMe.getDisplayName(), "", ""));

        //Cancel option
        ItemStack cancel = new ItemStack(Material.BARRIER, 1);
        ItemMeta cancel_meta = cancel.getItemMeta();
        cancel_meta.setDisplayName(Colorize.format("&a" + "Go Back!"));
        cancel.setItemMeta(cancel_meta);
        banPlayerMenu.setItem(8, cancel);

        player1.openInventory(banPlayerMenu);
    }

    public static void BanBook(Player player) {
        ItemStack book = new ItemStack(Material.BOOK_AND_QUILL);

        BookMeta book_name = (BookMeta) book.getItemMeta();
        book_name.setDisplayName(Colorize.format("&c" + "BAN REASON"));

        ArrayList<String> pages = new ArrayList<>();
        pages.add(Colorize.format("&c" + "BAN REASON:"));
        book_name.setPages(pages);

        book.setItemMeta(book_name);
        player.getInventory().setItem(8, book);
    }

    public static ItemStack makeHead(Player player, String displayName, String lore1, String lore2){
        // Checking the version
        boolean isNewVersion = Arrays.stream(Material.values())
                .map(Material::name).collect(Collectors.toList()).contains("PLAYER_HEAD");

        // Making the actual skull
        Material type = Material.matchMaterial(isNewVersion ? "PLAYER_HEAD" : "SKULL_ITEM");

        //Create the Head
        ItemStack skull = new ItemStack(type, 1);

        if (!isNewVersion) {
            skull.setDurability((short) 3);
        }

        //Set meta and stuff
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        meta.setOwner(player.getDisplayName());
        meta.setDisplayName(Colorize.format("&e" + displayName));

        //lore
        lore.add(lore1);
        lore.add(lore2);

        // setting other stuff
        skull.setItemMeta(meta);
        meta.setLore(lore);

        return skull;
    }
}
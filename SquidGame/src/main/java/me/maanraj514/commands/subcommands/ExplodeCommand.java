package me.maanraj514.commands.subcommands;

import me.maanraj514.commands.SubCommand;
import me.maanraj514.utils.Colorize;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class ExplodeCommand extends SubCommand{

    // test command for subcommands
    @Override
    public String getName() {
        return "explode";
    }

    @Override
    public String getDescription() {
        return "Explode a player to smithereens";
    }

    @Override
    public String getSyntax() {
        return "/SquidGame explode <player name>";
    }

    @Override
    public void perform(Player player, String[] args) {

        if (args.length > 1) {
            Player target = Bukkit.getPlayer(args[1]);

            player.sendMessage(Colorize.format("&aYou have successfully bombed " + "&c" + target.getDisplayName()));

            target.setHealth(0);
            target.playSound(target.getLocation(), Sound.EXPLODE, 100, 1);
            target.playEffect(target.getLocation(), Effect.EXPLOSION_LARGE, 1);

            target.sendMessage(Colorize.format("&cYou got bombed by " + "&a" + player.getDisplayName() + "&e" + " lmaoooooooo"));
        } else if (args.length == 1) {
            player.sendMessage(Colorize.format("&e--------------------"));
            player.sendMessage(Colorize.format("&b" + "/SquidGame explode <player name>" + " - " + getDescription()));
            player.sendMessage(Colorize.format("&e--------------------"));
        }
    }
}

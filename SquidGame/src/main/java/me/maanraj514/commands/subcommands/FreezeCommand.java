package me.maanraj514.commands.subcommands;

import me.maanraj514.commands.SubCommand;
import me.maanraj514.utils.Colorize;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class FreezeCommand extends SubCommand {
    @Override
    public String getName() {
        return "freeze";
    }

    @Override
    public String getDescription() {
        return "Freeze someone, this might help for some staff :)";
    }

    @Override
    public String getSyntax() {
        return "/SquidGame freeze <player name>";
    }

    @Override
    public void perform(Player player, String[] args) {

        if (args.length > 1) {
            Player target = Bukkit.getPlayer(args[1]);

            player.sendMessage(Colorize.format("&aYou have successfully froze " + "&c" + target.getDisplayName()));

            target.setWalkSpeed(0);
            target.playSound(target.getLocation(), Sound.GLASS, 100, 1);
            target.playEffect(target.getLocation(), Effect.PARTICLE_SMOKE, 1);

            target.sendMessage(Colorize.format("&cYou got frozen by " + "&a" + player.getDisplayName() + "&e" + " lmaoooooooo"));
        } else if (args.length == 1) {
            player.sendMessage(Colorize.format("&e--------------------"));
            player.sendMessage(Colorize.format("&b" + "/SquidGame freeze <player name>" + " - " + getDescription()));
            player.sendMessage(Colorize.format("&e--------------------"));
        }
    }
}

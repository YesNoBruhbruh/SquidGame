package me.maanraj514.commands.subcommands;

import me.maanraj514.commands.SubCommand;
import me.maanraj514.utils.Colorize;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class UnFreezeCommand extends SubCommand{
    @Override
    public String getName() {
        return "unfreeze";
    }

    @Override
    public String getDescription() {
        return "unfreezes the player who was frozen :)";
    }

    @Override
    public String getSyntax() {
        return "/SquidGame unfreeze <player name>";
    }

    @Override
    public void perform(Player player, String[] args) {

        if (args.length > 1) {
            Player target = Bukkit.getPlayer(args[1]);
            float walkSpeed = 0.2F;

            player.sendMessage(Colorize.format("&aYou have successfully Unfroze " + "&c" + target.getDisplayName()));

            target.setWalkSpeed(walkSpeed);
            target.playSound(target.getLocation(), Sound.GLASS, 100, 1);
            target.playEffect(target.getLocation(), Effect.PARTICLE_SMOKE, 1);

            target.sendMessage(Colorize.format("&cYou got unfrozen by " + "&a" + player.getDisplayName() + "&e" + " nice"));
        } else if (args.length == 1) {
            player.sendMessage(Colorize.format("&e--------------------"));
            player.sendMessage(Colorize.format("&b" + "/SquidGame unfreeze <player name>" + " - " + getDescription()));
            player.sendMessage(Colorize.format("&e--------------------"));
        }
    }
}

package me.maanraj514.commands.subcommands;

import me.maanraj514.commands.SubCommand;
import me.maanraj514.utils.Gui;
import org.bukkit.entity.Player;

public class OpenCommand extends SubCommand {

    @Override
    public String getName() {
        return "open";
    }

    @Override
    public String getDescription() {
        return "opens a gui";
    }

    @Override
    public String getSyntax() {
        return "/SquidGame open";
    }

    @Override
    public void perform(Player player, String[] args) {

        if (args.length > 0) {
            Gui.openMainGui(player);
        }
    }
}

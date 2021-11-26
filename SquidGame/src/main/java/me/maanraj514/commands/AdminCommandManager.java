package me.maanraj514.commands;

import me.maanraj514.commands.subcommands.OpenCommand;
import me.maanraj514.commands.subcommands.ExplodeCommand;
import me.maanraj514.commands.subcommands.FreezeCommand;
import me.maanraj514.commands.subcommands.UnFreezeCommand;
import me.maanraj514.utils.Colorize;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class AdminCommandManager implements CommandExecutor {
    private ArrayList<SubCommand> subcommands = new ArrayList<>();

    public AdminCommandManager(){
        subcommands.add(new ExplodeCommand());
        subcommands.add(new FreezeCommand());
        subcommands.add(new UnFreezeCommand());
        subcommands.add(new OpenCommand());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return true;

        // /SquidGame
        Player p = (Player) sender;
        if (p.hasPermission("SquidGame.admin")){
            if (args.length == 0) {
                p.sendMessage(Colorize.format("&e--------------------"));
                p.sendMessage(Colorize.format("&e---ADMIN COMMANDS---"));
                for (int i = 0; i < getSubcommands().size(); i++) {
                    p.sendMessage(Colorize.format("&b" + getSubcommands().get(i).getSyntax()));
                }
                p.sendMessage(Colorize.format("&e--------------------"));
                p.sendMessage(Colorize.format("&e--------------------"));
            }

            if (args.length > 0) {
                for (int i = 0; i < getSubcommands().size(); i++) {
                    if (args[0].equalsIgnoreCase(getSubcommands().get(i).getName())) {
                        getSubcommands().get(i).perform(p, args);
                    }
                }
            }
        } else {
            p.sendMessage(Colorize.format("&c" + "You do not have admin command permission."));
            return true;
        }
        return true;
    }

    public ArrayList<SubCommand> getSubcommands() {
        return subcommands;
    }
}
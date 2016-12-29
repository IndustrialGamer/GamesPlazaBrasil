package com.gamesplaza.commands;

import com.enjin.gamesplazabrasil.GamesPlaza;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by enzob on 23/12/2016.
 */
public class OPCommand implements CommandExecutor {


    GamesPlaza pluin;

    public OPCommand(GamesPlaza plugin) {

        this.pluin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        //Comando OP
        if (command.getName().equalsIgnoreCase("op")) {
            if (!(p.hasPermission("op.Op.true"))) {
                p.sendMessage(ChatColor.BLUE + "Op> " + ChatColor.RED + "Voce nao tem permissao suficiente para dar o  op de outro player!");
                return true;
            }
            if (sender instanceof Player) {
                if (args.length == 0) {
                    p.sendMessage(ChatColor.BLUE + "Op> " + ChatColor.RED + "Sem argumentos!");
                    return true;
                } else if (args.length > 1) {
                    p.sendMessage(ChatColor.BLUE + "Op> " + ChatColor.RED + "Muitos argumentos");
                    return true;
                } else {
                    if (p.hasPermission("op.Op.true")) {
                        if (args.length == 1) {

                            for (Player target : Bukkit.getServer().getOnlinePlayers()) {
                                if (target.getName().equalsIgnoreCase(args[0])) {
                                    target.setOp(true);
                                    p.sendMessage(ChatColor.BLUE + "Op> " + ChatColor.GREEN + "O player " + ChatColor.GOLD + target.getName() + ChatColor.GREEN + " agora e OP!");
                                    target.sendMessage(ChatColor.BLUE + "Op> " + ChatColor.GREEN + "Voce e agora um OP do servidor! ");
                                } else if (target == null) {
                                    p.sendMessage(ChatColor.BLUE + "Op> " + ChatColor.RED + "Player não encontrado");
                                    target.setOp(false);
                                }
                            }

                        }

                    }
                }
            }

        }


        return false;
    }


}


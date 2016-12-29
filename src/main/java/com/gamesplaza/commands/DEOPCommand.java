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
public class DEOPCommand implements CommandExecutor {

    GamesPlaza pluin;

    public DEOPCommand(GamesPlaza plugin){

        this.pluin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        //Comando deop
        if (command.getName().equalsIgnoreCase("deop")) {
            if (!(p.hasPermission("op.deOp.true"))) {
                p.sendMessage(ChatColor.BLUE + "Op> " + ChatColor.RED + "Voce nao tem permissao suficiente para tirar o  op de outro player!");
                return true;
            }
            if (sender instanceof Player) {
                if (args.length == 0) {
                    p.sendMessage(ChatColor.BLUE + "Op> " + ChatColor.RED + "Sem argumentos!");
                    return  true;
                } else if (args.length > 1) {
                    p.sendMessage(ChatColor.BLUE + "Op> " + ChatColor.RED + "Muitos argumentos");
                    return  true;
                } else {
                    if (p.hasPermission("op.deOp.true")) {
                        if (args.length == 1) {

                            for (Player target : Bukkit.getServer().getOnlinePlayers()) {
                                if (target.getName().equalsIgnoreCase(args[0])) {
                                    target.setOp(false);
                                    p.sendMessage(ChatColor.BLUE + "Op> " + ChatColor.GREEN + "O player " + ChatColor.GOLD + target.getName() + ChatColor.GREEN + " agora nao e mais OP!");
                                    target.sendMessage(ChatColor.BLUE + "Op> " + ChatColor.GREEN + "Voce nao e mais um OP do servidor! ");
                                } else if(target == null){
                                    p.sendMessage(ChatColor.BLUE + "Op> " + ChatColor.RED + "Player não encontrado");
                                    target.setOp(true);
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

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
public class BanCommand implements CommandExecutor {

    GamesPlaza pluin;

    public BanCommand(GamesPlaza plugin){

        this.pluin = plugin;
    }



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        //Comando ban
        if (command.getName().equalsIgnoreCase("ban")) {
            if (args.length == 0) {
                p.sendMessage(ChatColor.BLUE + "Ban> " + ChatColor.RED + "Sem argumentos!");
                return  true;

            } else if (args.length > 1) {
                p.sendMessage(ChatColor.BLUE + "Ban> " + ChatColor.RED + "Muitos argumentos!");
                return true;

            } else {

                if (args.length == 1) {
                    if (p.hasPermission("op.ban.ban")) {
                        for (Player target : Bukkit.getServer().getOnlinePlayers()) {
                            if (target.getName().equalsIgnoreCase(args[0])) {
                                target.kickPlayer(ChatColor.BLUE + "Ban> " + ChatColor.BOLD + "Voce foi banido por " + ChatColor.DARK_RED + p.getName());
                                target.setBanned(true);
                                Bukkit.getServer().broadcastMessage(ChatColor.BLUE + "Ban> " + ChatColor.BOLD + " " +  ChatColor.GOLD + "O player " + target.getName() + "  foi banido por " + ChatColor.RED + p.getName());
                                p.sendMessage( ChatColor.BLUE + "Ban> " + ChatColor.GREEN + "Voce baniu o player " + target.getName());
                                target.sendMessage(ChatColor.BLUE + "Ban> " + ChatColor.BOLD + "Voce foi banido por " + p.getName());
                            } else if(!(target.getName().equalsIgnoreCase(args[0]))){
                                p.sendMessage(ChatColor.BLUE + "Ban> " + ChatColor.RED + "Player nao encontrado");
                                return  true;
                            }

                        }
                    } else{

                        p.sendMessage(ChatColor.BLUE + "Ban> " + ChatColor.RED + "Voce nao tem permissao para banir um player");
                        return  true;

                    }
                }

            }
        }


        return false;
    }
}

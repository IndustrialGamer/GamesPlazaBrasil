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
public class KickCommand implements CommandExecutor {


    GamesPlaza pluin;

    public KickCommand(GamesPlaza plugin){

        this.pluin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

            Player p = (Player) sender;
        //Comando kick
        if(command.getName().equalsIgnoreCase("kick")){
            if(args.length == 0 ){
                p.sendMessage(ChatColor.BLUE + "Kick> " + ChatColor.RED + "Sem argumentos!");
                return true;
            } else if(args.length > 1){
                p.sendMessage(ChatColor.BLUE + "Kick> " + ChatColor.RED + "Muitos argumentos!");
                return true;
            }else {

                if (args.length == 1) {
                    if (p.hasPermission("op.kick.kick")) {
                        for (Player target : Bukkit.getServer().getOnlinePlayers()) {
                            if (target.getName().equalsIgnoreCase(args[0])) {
                                target.kickPlayer(ChatColor.BLUE + "Kick> " + ChatColor.GOLD + ChatColor.BOLD + "Voce foi kicado por " + ChatColor.RED + p.getName());
                                p.sendMessage(ChatColor.BLUE + "Kick> " + ChatColor.GREEN + "O player " + ChatColor.RED + target.getName() + ChatColor.GREEN + "  foi kicado com sucesso!");
                            }else if (!(target.getName().equalsIgnoreCase(args[0]))) {
                                p.sendMessage(ChatColor.BLUE + "Kick> " + ChatColor.RED + "Player nao encontrado!");
                            }
                        }

                    }else{
                        p.sendMessage(ChatColor.BLUE + "Kick> " + ChatColor.RED + "Voce nao tem permissao!");
                        return  true;
                    }
                }
            }
        }


        return false;
    }
}

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
public class VidaCommand implements CommandExecutor {

    GamesPlaza pluin;

    public VidaCommand(GamesPlaza plugin){

        this.pluin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        //Comando vida
        if (command.getName().equalsIgnoreCase("vida")){
            if(!(p.hasPermission("op.heal.vida"))){
                p.sendMessage(ChatColor.BLUE + "Vida> " + ChatColor.RED + "Voce nao pode utilizar o comando vida!");
                return true;
            }
            if(p.hasPermission("op.heal.vida")){
                if(args.length == 0){
                    p.sendMessage(ChatColor.BLUE  + "Vida> " + ChatColor.RED + "Sem argumentos!");
                    return true;
                }
                if(args.length > 4){
                    p.sendMessage(ChatColor.BLUE  + "Vida> " + ChatColor.RED + "Muitos argumentos!");
                    return true;
                }

                if(args[0].contains("regenerar")) {
                    p.setHealth(20);
                    p.sendMessage(ChatColor.BLUE + "Vida> " + ChatColor.GREEN + "Sua vida foi regenerada de " + p.getFoodLevel() + " para 20");
                }
                for(Player target : Bukkit.getOnlinePlayers()){
                    if(args[0].contains(target.getName()) && args[1].contains("mostrar")){
                        p.sendMessage(ChatColor.BLUE + "Vida> " + ChatColor.GREEN + "O player " + ChatColor.GOLD + target.getName() + " " + ChatColor.GREEN + "tem " + " " + ChatColor.DARK_PURPLE + target.getHealth() + ChatColor.GREEN  + "de vida");
                        target.sendMessage(ChatColor.BLUE + "Vida> " + ChatColor.GREEN + "O player " + ChatColor.GOLD +  p.getName() + " " + ChatColor.GREEN + "sabe quanto voce tem de vida agora! ( " + ChatColor.DARK_PURPLE + target.getHealth() +ChatColor.GREEN +  " )");
                    }
                }

            }

        }




        return false;
    }
}

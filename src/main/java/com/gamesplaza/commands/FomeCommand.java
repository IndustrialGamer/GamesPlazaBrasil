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
public class FomeCommand implements CommandExecutor {

    GamesPlaza pluin;

    public FomeCommand(GamesPlaza plugin){

        this.pluin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
 Player p = (Player) sender;

        //Comando Fome
        if(command.getName().equalsIgnoreCase("fome")){

            if(!(p.hasPermission("op.feed.fome"))){
                p.sendMessage(ChatColor.BLUE + "Fome> " +  ChatColor.RED + "Voce nao pode se usar o comando /fome!");
                return true;
            }
            if(p.hasPermission("op.feed.fome")){
                if(args.length == 0){
                    p.sendMessage(ChatColor.BLUE + "Fome> " + ChatColor.RED + "Sem argumentos!");
                    return true;
                }
                if(args.length > 4){
                    p.sendMessage(ChatColor.BLUE + "Fome> " + ChatColor.RED + "Muitos argumentos!");
                    return true;
                }
                if(args[0].contains("regenerar")) {
                    p.setFoodLevel(20);
                    p.sendMessage(ChatColor.BLUE + "Fome> " + ChatColor.GREEN + "Voce se alimentou! ");
                }
                for(Player target : Bukkit.getOnlinePlayers()){
                    if(args[0].contains(target.getName()) && args[1].contains("mostrar")){
                        p.sendMessage(ChatColor.BLUE + "Fome> " + ChatColor.GREEN + "O player " + ChatColor.GOLD + target.getName() + " " + ChatColor.GREEN + "tem " + " " + ChatColor.DARK_PURPLE + target.getFoodLevel() + ChatColor.GREEN  + "de fome");
                        target.sendMessage(ChatColor.BLUE + "Fome> " + ChatColor.GREEN + "O player " + ChatColor.GOLD +  p.getName() + " " + ChatColor.GREEN + "sabe quanto voce tem de fome agora! ( " + ChatColor.DARK_PURPLE + target.getFoodLevel() + ChatColor.GREEN + " )");
                    }
                }
            }
        }

        return false;
    }
}

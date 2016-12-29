package com.gamesplaza.commands;

import com.enjin.gamesplazabrasil.GamesPlaza;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by enzob on 23/12/2016.
 */
public class TimeCommand implements CommandExecutor {

    GamesPlaza plugin;

    public TimeCommand(GamesPlaza plugin){

        this.plugin = plugin;
    }



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    Player p = (Player) sender;
        World world = p.getWorld();
    if(command.getName().equalsIgnoreCase("tempo")){
        if(!(p.hasPermission("tempo.time.change"))){
            p.sendMessage(ChatColor.BLUE + "Tempo> " + ChatColor.RED + "Voce nao pode mudar o tempo!");
            return true;
        }
        if(p.hasPermission("tempo.time.change")){
            if(args.length == 0){
                p.sendMessage(ChatColor.BLUE + "Tempo> " + ChatColor.RED + "Sem Argumentos!");
                return  true;
            }
            if(args.length > 4){
                p.sendMessage(ChatColor.BLUE + "Tempo> " + ChatColor.RED + "Muitos argumentos!");
                return  true;
            }
            if(args[0].contains("h") ){
                if(args[1].contains("a")){
                    world.setTime(12000);
                    p.sendMessage(ChatColor.BLUE + "Tempo> " + ChatColor.GREEN + "O tempo foi alterado de " + ChatColor.DARK_PURPLE + world.getTime() + " " + ChatColor.GREEN + "para AMANHECER (12000) com sucesso!");
                }
                if(args[1].contains("e")){
                    world.setTime(13000);
                    p.sendMessage(ChatColor.BLUE + "Tempo> " + ChatColor.GREEN + "O tempo foi alterado de " + ChatColor.DARK_PURPLE + world.getTime() + " " + ChatColor.GREEN + "para ENTARDECER (13000) com sucesso!");
                }
                if(args[1].contains("d")){
                    world.setTime(7000);
                    p.sendMessage(ChatColor.BLUE + "Tempo> " + ChatColor.GREEN + "O tempo foi alterado de " + ChatColor.DARK_PURPLE + world.getTime() + " " + ChatColor.GREEN + "para DIA (7000) com sucesso!");
                }
                if(args[1].contains("n")){
                    world.setTime(14000);
                    p.sendMessage(ChatColor.BLUE + "Tempo> " + ChatColor.GREEN + "O tempo foi alterado de " + ChatColor.DARK_PURPLE + world.getTime() + " " + ChatColor.GREEN + "para DIA (14000) com sucesso!");
                }
            }
            if(args[0].contains("t")){
                if(args[1].contains("tm")){
                    world.setThundering(true);
                    world.setStorm(true);
                    p.sendMessage(ChatColor.BLUE + "Tempo> " + ChatColor.GREEN + "O tempo foi alterado para TEMPESTADE!");
                    return  true;
                }

                if(args[1].contains("c")){
                    world.setStorm(true);
                    world.setThundering(false);
                    p.sendMessage(ChatColor.BLUE + "Tempo> " + ChatColor.GREEN + "O tempo foi alterado para CHUVA");
                    return true;
                }
                if(args[1].contains("d")){
                    world.setStorm(false);
                    world.setThundering(false);
                    p.sendMessage(ChatColor.BLUE + "Tempo> " + ChatColor.GREEN + "O tempo foi alterado para SOL");
                    return true;
                }


            }
        }
    }


        return false;
    }
}

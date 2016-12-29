package com.gamesplaza.commands;

import com.enjin.gamesplazabrasil.GamesPlaza;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

/**
 * Created by enzob on 23/12/2016.
 */
public class DesbanirCommand implements CommandExecutor {

    GamesPlaza pluin;

    public DesbanirCommand(GamesPlaza plugin){

        this.pluin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        //Comando desbanir
        if(command.getName().equalsIgnoreCase("desbanir")){
            if(sender instanceof Player){
                if(args.length == 0){
                    p.sendMessage(ChatColor.BLUE + "Ban> " + ChatColor.RED + "Sem argumentos!");
                    return true;
                } else if(args.length > 1){
                    p.sendMessage(ChatColor.BLUE + "Ban> " + ChatColor.RED + "Muitos argumentos!");
                    return  true;
                }
                else{
                    if(args.length == 1){
                        if(p.hasPermission("op.ban.unban")){
                            for(OfflinePlayer target : Bukkit.getServer().getOfflinePlayers()){
                                if(target.getName().equalsIgnoreCase(args[0])){
                                    Bukkit.getServer().broadcastMessage(ChatColor.BLUE + "Ban> " + ChatColor.DARK_GREEN + "O player " +  ChatColor.RED + target.getName() + ChatColor.DARK_GREEN + " foi desbanido!");
                                    target.setBanned(false);
                                    p.sendMessage(ChatColor.BLUE + "Ban> " + ChatColor.GREEN + "O player " + ChatColor.GOLD +  target.getName() + ChatColor.GREEN + "  foi desbanido com sucesso!");
                                }
                            }
                        }else{
                            p.sendMessage(ChatColor.BLUE + "Ban> " + ChatColor.RED + "Voce nao tem permissao para desbanir um jogador!");
                        }
                    }
                }
            }
            if (sender instanceof ConsoleCommandSender){

                if(args.length == 0){
                    sender.sendMessage(ChatColor.BLUE + "Ban> " + ChatColor.RED + "Sem argumentos!");
                } else if(args.length > 1){
                    sender.sendMessage(ChatColor.BLUE + "Ban> " + ChatColor.RED + "Muitos argumentos!");
                }
                else{
                    if(args.length == 1){
                        if(p.hasPermission("ban.op.unban")){
                            for(OfflinePlayer target : Bukkit.getServer().getOfflinePlayers()){
                                if(target.getName().equalsIgnoreCase(args[0])){
                                    Bukkit.getServer().broadcastMessage(ChatColor.BLUE + "Ban> " + ChatColor.DARK_GREEN + "O player " +  ChatColor.RED + target.getName() + ChatColor.DARK_GREEN + " foi desbanido!");
                                    target.setBanned(false);
                                    sender.sendMessage(ChatColor.BLUE + "Ban> " + ChatColor.GREEN + "O player " + ChatColor.GOLD +  target.getName() + ChatColor.GREEN + "  foi desbanido com sucesso!");
                                }
                            }
                        }else{

                            sender.sendMessage(ChatColor.BLUE + "Ban> " + ChatColor.RED + "Voce nao tem permissao para desbanir um jogador!");
                            return  true;

                        }
                    }
                }
            }
        }

       return false;
    }
}

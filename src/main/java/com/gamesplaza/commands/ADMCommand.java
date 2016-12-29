package com.gamesplaza.commands;

import com.enjin.gamesplazabrasil.GamesPlaza;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ADMCommand implements CommandExecutor {

    GamesPlaza plugin;

    public ADMCommand(GamesPlaza plugin) {

        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        if (command.getName().equalsIgnoreCase("ADM")) {
            if (!(p.hasPermission("server.adm.adm"))) {
                p.sendMessage(ChatColor.BLUE + "Servidor> " + ChatColor.RED + "Voce nao tem permissao para utilizar esse comando!");
                return true;
            }
            if (args.length == 0) {
                p.sendMessage(ChatColor.BLUE + "Servidor> " + ChatColor.RED + "Sem argumentos!");
                return true;
            }
            if (args.length > 7) {
                p.sendMessage(ChatColor.BLUE + "Servidor> " + ChatColor.RED + "Muitos argumentos!");
                return true;
            }

            if (args[0].equalsIgnoreCase("wl")) {
                if (args[1].contains("hb")) {
                    Bukkit.getServer().setWhitelist(true);
                    p.sendMessage(ChatColor.BLUE + "WhiteList> " + ChatColor.GREEN + "A WhiteList foi habilitada");
                }
                if (args[1].contains("db")) {
                    Bukkit.getServer().setWhitelist(false);
                    p.sendMessage(ChatColor.BLUE + "WhiteList> " + ChatColor.GREEN + "A WhiteList foi desabilitada");
                }
                for (Player target : Bukkit.getOnlinePlayers()) {
                    if (args[1].equalsIgnoreCase("add") && args[2].equalsIgnoreCase(target.getName())) {
                        Bukkit.getServer().getWhitelistedPlayers().add(target);
                        p.sendMessage(ChatColor.BLUE + "WhiteList> " + ChatColor.GREEN + "O player " + ChatColor.DARK_PURPLE + target.getName() + " " + ChatColor.GREEN + "foi adicionado a WhiteList");

                    }
                    if (args[1].equalsIgnoreCase("rmv") && args[2].equalsIgnoreCase(target.getName())) {
                        Bukkit.getServer().getWhitelistedPlayers().remove(target);
                        p.sendMessage(ChatColor.BLUE + "WhiteList> " + ChatColor.GREEN + "O player " + ChatColor.DARK_PURPLE + target.getName() + " " + ChatColor.GREEN + "foi removido da WhiteList");
                    }
                }
            }





        }
        return false;
    }
}
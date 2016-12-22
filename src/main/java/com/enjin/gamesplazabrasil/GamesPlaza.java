package com.enjin.gamesplazabrasil;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public class GamesPlaza extends JavaPlugin {


    @Override
    public void onEnable() {
        getLogger().info(ChatColor.GREEN + "Agora esse servidor se chama MineMania");
        getServer().getPluginManager().registerEvents(new GamesPlazaEventos(), this);

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (command.getName().equalsIgnoreCase("gamesplaza")) {
            p.sendMessage(ChatColor.BLUE + "GamesPlaza> " + ChatColor.GREEN + "Bem-Vindo ao GamesPlaza! Aqui você podera se divertir com nossos minigames. Se voce gostar compre vip no site http://www.gamesplazabrasil.enjin.com/shop");

        }
        if (command.getName().equalsIgnoreCase("vip")) {
            p.sendMessage(ChatColor.BLUE + "Vip> " + ChatColor.GOLD + "Obrigado pelo interesse em ajudar o servidor!" + ChatColor.GREEN + " Voce pode comprar vip no site http://www.gamesplazabrasil.enjin.com/shop");

        }
        if (command.getName().equalsIgnoreCase("lobby")) {
            if (!(sender instanceof Player)) {
                p.sendMessage(ChatColor.BLUE + "Lobby> " + ChatColor.RED + "Apenas players podem se teleportar para o Lobby!");
                return true;
            }
            p.teleport(Bukkit.getWorld("LobbyDone").getSpawnLocation());
            p.sendMessage(ChatColor.BLUE + "Lobby> " + ChatColor.GREEN + "Voce foi teleportado para o lobby principal!");
        }
        if (command.getName().equalsIgnoreCase("hub")) {
            if (!(sender instanceof Player)) {
                p.sendMessage(ChatColor.BLUE + "Hub> " + ChatColor.RED + "Apenas players podem se teleportar para o Hub");
                return true;
            }
            p.teleport(Bukkit.getWorld("LobbyDone").getSpawnLocation());
            p.sendMessage(ChatColor.BLUE + "Hub> " + ChatColor.GREEN + "Voce foi teleportado para o hub principal!");
        }

        if (command.getName().equalsIgnoreCase("gmc")) {
            if (!(sender instanceof Player)) {
                p.sendMessage(ChatColor.BLUE + "Gamemode> " + ChatColor.RED + "Apenas players podem mudar de Gamemode");
                return true;
            }
            if (p.hasPermission("gamemode.use.gmc")) {

                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage(ChatColor.BLUE + "Gamemode> " + ChatColor.GREEN + "Seu gamemode foi alterado com sucesso!");
            } else {
                p.sendMessage(ChatColor.BLUE + "Gamemode> " + ChatColor.RED + "Voce nao tem permissao para mudar seu gamemode");
                return true;
            }

        }

        if (command.getName().equalsIgnoreCase("gms")) {
            if (!(sender instanceof Player)) {
                p.sendMessage(ChatColor.BLUE + "Gamemode> " + ChatColor.RED + "Apenas players podem mudar de Gamemode");
                return true;
            }
            if (p.hasPermission("gamemode.use.gms")) {

                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage(ChatColor.BLUE + "Gamemode> " + ChatColor.GREEN + "Seu gamemode foi alterado com sucesso!");
            } else {
                p.sendMessage(ChatColor.BLUE + "Gamemode> " + ChatColor.RED + "Voce nao tem permissao para mudar seu gamemode");
                return true;
            }
        }
        if (command.getName().equalsIgnoreCase("gma")) {
            if (!(sender instanceof Player)) {
                p.sendMessage(ChatColor.BLUE + "Gamemode> " + ChatColor.RED + "Apenas players podem mudar de Gamemode");
                return true;
            }
            if (p.hasPermission("gamemode.use.gma")) {

                p.setGameMode(GameMode.ADVENTURE);
                p.sendMessage(ChatColor.BLUE + "Gamemode> " + ChatColor.GREEN + "Seu gamemode foi alterado com sucesso!");
            } else {
                p.sendMessage(ChatColor.BLUE + "Gamemode> " + ChatColor.RED + "Voce nao tem permissao para mudar seu gamemode");
                return true;
            }
        }
        if (command.getName().equalsIgnoreCase("gme")) {
            if (!(sender instanceof Player)) {
                p.sendMessage(ChatColor.BLUE + "Gamemode> " + ChatColor.RED + "Apenas players podem mudar de Gamemode");
                return true;
            }
            if (p.hasPermission("gamemode.use.gme")) {

                p.setGameMode(GameMode.SPECTATOR);
                p.sendMessage(ChatColor.BLUE + "Gamemode> " + ChatColor.GREEN + "Seu gamemode foi alterado com sucesso!");
            } else {
                p.sendMessage(ChatColor.BLUE + "Gamemode> " + ChatColor.RED + "Voce nao tem permissao para mudar seu gamemode");

                return true;
            }
        }
        if (command.getName().equalsIgnoreCase("op")) {

            if (!(p.hasPermission("op.setOp.true"))) {
                p.sendMessage(ChatColor.BLUE + "Op> " + ChatColor.RED + "Voce nao tem permissao suficiente para dar op para outro player!");

            }
            if (sender instanceof Player) {
                if (args.length == 0) {
                    p.sendMessage(ChatColor.BLUE + "Op> " + ChatColor.RED + "Sem argumentos!");
                } else if (args.length > 1) {
                    p.sendMessage(ChatColor.BLUE + "Op> " + ChatColor.RED + "Muitos argumentos");
                } else {
                    if (p.hasPermission("op.setOp.true")) {
                        if (args.length == 1) {

                            for (Player target : Bukkit.getServer().getOnlinePlayers()) {
                                if (target.getName().equalsIgnoreCase(args[0])) {
                                    target.setOp(true);
                                    p.sendMessage(ChatColor.BLUE + "Op> " + ChatColor.GREEN + "O player " + ChatColor.GOLD + target.getName() + ChatColor.GREEN + " agora e OP!");
                                    target.sendMessage(ChatColor.BLUE + "Op> " + ChatColor.GREEN + "Voce e agora um OP do servidor! ");
                                } else if(target == null){
                                    p.sendMessage(ChatColor.BLUE + "Op> " + ChatColor.RED + "Player não encontrado");
                                    target.setOp(false);
                                }
                            }

                        }

                    }
                }
            }

        }
        if (command.getName().equalsIgnoreCase("deop")) {
            if (!(p.hasPermission("op.deOp.true"))) {
                p.sendMessage(ChatColor.BLUE + "Op> " + ChatColor.RED + "Voce nao tem permissao suficiente para tirar o  op de outro player!");

            }
            if (sender instanceof Player) {
                if (args.length == 0) {
                    p.sendMessage(ChatColor.BLUE + "Op> " + ChatColor.RED + "Sem argumentos!");
                } else if (args.length > 1) {
                    p.sendMessage(ChatColor.BLUE + "Op> " + ChatColor.RED + "Muitos argumentos");
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

        if (command.getName().equalsIgnoreCase("ban")) {
            if (args.length == 0) {
                p.sendMessage(ChatColor.BLUE + "Ban> " + ChatColor.RED + "Sem argumentos!");
            } else if (args.length > 1) {
                p.sendMessage(ChatColor.BLUE + "Ban> " + ChatColor.RED + "Muitos argumentos!");
            } else {

                if (args.length == 1) {
                    if (p.hasPermission("op.ban.ban")) {
                        for (Player target : Bukkit.getServer().getOnlinePlayers()) {
                            if (target.getName().equalsIgnoreCase(args[0])) {
                                target.kickPlayer(ChatColor.BLUE + "Ban> " + ChatColor.BOLD + "Voce foi banido por " + ChatColor.DARK_RED + p.getName());
                                target.setBanned(true);
                                getServer().broadcastMessage(ChatColor.BLUE + "Ban> " + ChatColor.BOLD + " " +  ChatColor.GOLD + "O player " + target.getName() + "  foi banido por " + ChatColor.RED + p.getName());
                                p.sendMessage( ChatColor.BLUE + "Ban> " + ChatColor.GREEN + "Voce baniu o player " + target.getName());
                                target.sendMessage(ChatColor.BLUE + "Ban> " + ChatColor.BOLD + "Voce foi banido por " + p.getName());
                            } else if(!(target.getName().equalsIgnoreCase(args[0]))){
                                p.sendMessage(ChatColor.BLUE + "Ban> " + ChatColor.RED + "Player nao encontrado");
                                return  true;
                            }

                        }
                    } else{

                        p.sendMessage(ChatColor.BLUE + "Ban> " + ChatColor.RED + "Voce nao tem permissao para banir um player");
                    }
                }

            }
        }
        if(command.getName().equalsIgnoreCase("desbanir")){
            if(sender instanceof Player ){
                if(args.length == 0){
                    p.sendMessage(ChatColor.BLUE + "Ban> " + ChatColor.RED + "Sem argumentos!");
                } else if(args.length > 1){
                    p.sendMessage(ChatColor.BLUE + "Ban> " + ChatColor.RED + "Muitos argumentos!");
                }
                else{
                    if(args.length == 1){
                        if(p.hasPermission("op.ban.unban")){
                            for(OfflinePlayer target : Bukkit.getServer().getOfflinePlayers()){
                                if(target.getName().equalsIgnoreCase(args[0])){
                                    getServer().broadcastMessage(ChatColor.BLUE + "Ban> " + ChatColor.DARK_GREEN + "O player " +  ChatColor.RED + target.getName() + ChatColor.DARK_GREEN + " foi desbanido!");
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
                                    getServer().broadcastMessage(ChatColor.BLUE + "Ban> " + ChatColor.DARK_GREEN + "O player " +  ChatColor.RED + target.getName() + ChatColor.DARK_GREEN + " foi desbanido!");
                                    target.setBanned(false);
                                    sender.sendMessage(ChatColor.BLUE + "Ban> " + ChatColor.GREEN + "O player " + ChatColor.GOLD +  target.getName() + ChatColor.GREEN + "  foi desbanido com sucesso!");
                                }
                            }
                        }else{
                            sender.sendMessage(ChatColor.BLUE + "Ban> " + ChatColor.RED + "Voce nao tem permissao para desbanir um jogador!");
                        }
                    }
                }
            }
        }
        if(command.getName().equalsIgnoreCase("kick")){
            if(args.length == 0 ){
                p.sendMessage(ChatColor.BLUE + "Kick> " + ChatColor.RED + "Sem argumentos!");
            } else if(args.length > 1){
                p.sendMessage(ChatColor.BLUE + "Kick> " + ChatColor.RED + "Muitos argumentos!");
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
                    }
                }
            }
        }
        if (command.getName().equalsIgnoreCase("heal")){
            if(!(p.hasPermission("op.heal.heal"))){
                p.sendMessage(ChatColor.BLUE + "Vida> " + ChatColor.RED + "Voce nao pode regenerar sua vida!");
            }
            if(p.hasPermission("op.heal.heal")){
                p.setHealth(20);
                p.sendMessage(ChatColor.BLUE  + "Vida> " + ChatColor.GREEN + "Sua vida foi regenerada de " + p.getFoodLevel() + " para 20");
            }
        }
        if(command.getName().equalsIgnoreCase("alimentar")){

            if(!(p.hasPermission("op.feed.feed"))){
                p.sendMessage(ChatColor.BLUE + "Fome> " +  ChatColor.RED + "Voce nao pode se alimentar!");
            }
            if(p.hasPermission("op.feed.feed")){
                p.setFoodLevel(20);
                p.sendMessage(ChatColor.BLUE + "Fome> " + ChatColor.GREEN + "Voce se alimentou! ");
            }
        }
    /*
    if (command.getName().equalsIgnoreCase("voar")){
        if(p.hasPermission("vip.perm.fly")){
            if(p.isFlying()){
                p.setFlying(false);
                p.sendMessage(ChatColor.BLUE + "Voar> " + ChatColor.GREEN + "Modo voar desabilitado para " + p.getName());
            }
            if(!(p.isFlying())){
                p.setFlying(true);
                p.sendMessage(ChatColor.BLUE + "Voar> " + ChatColor.GREEN + "Modo voar habilitado para " + p.getName());
            }
        }

    }
*/


        return false;
    }

    @Override
    public void onDisable () {
        getLogger().info("Agora esse servidor não se chama mais MineMania");
        HandlerList.unregisterAll(this);

    }

}

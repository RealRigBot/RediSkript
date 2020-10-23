package net.limework.core.commands;

import net.limework.core.RediSkript;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadRedis implements CommandExecutor {
    private RediSkript plugin;
    public ReloadRedis(RediSkript plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            //not using bungee TextComponent because it is not present in 1.8.8
            sender.sendMessage((ChatColor.translateAlternateColorCodes('&'
                    , "&2[&aRediSkript&a] &cThis command can only be executed in console.")));
            return true;
        }
        plugin.getRm().reload();
        //not sending to sender, because this command can only be executed via console
        Bukkit.getLogger().info(ChatColor.translateAlternateColorCodes('&', "&2[&aRediSkript&a] &eReloaded via command! Note this command is not stable, it should only be used in urgent cases where you absolutely need to change config details without restarting the server."));

        return false;
    }
}

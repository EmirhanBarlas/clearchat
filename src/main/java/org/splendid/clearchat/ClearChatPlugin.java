package org.splendid.clearchat;

import org.bukkit.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ClearChatPlugin extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        getLogger().info("ClearChat plugin has been enabled!");
        getCommand("clear").setExecutor(this);
    }

    @Override
    public void onDisable() {
        getLogger().info("ClearChat plugin has been disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Bu komut sadece oyuncular tarafından kullanılabilir!");
            return true;
        }
        Player player = (Player) sender;
        if (player.hasPermission("clearchat.clear")) {
            clearChat();
            player.sendMessage(ChatColor.RED + "Sohbet" + player.getName() + " tarafından temizlendi!");
        } else {
            player.sendMessage(ChatColor.RED + "Bu komutu kullanma izniniz yok!");
        }
        return true;
    }

    private void clearChat() {
        for (int i = 0; i < 100; i++) {
            Bukkit.broadcastMessage("");
        }
    }
}

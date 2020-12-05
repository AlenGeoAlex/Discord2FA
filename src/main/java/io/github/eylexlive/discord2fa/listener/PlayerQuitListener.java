package io.github.eylexlive.discord2fa.listener;

import io.github.eylexlive.discord2fa.Main;
import io.github.eylexlive.discord2fa.manager.Discord2FAManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/*
 *	Created by EylexLive on Feb 23, 2020.
 *	Currently version: 3.0
 */

public class PlayerQuitListener implements Listener {

    private final Main plugin;

    public PlayerQuitListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void handleQuit(PlayerQuitEvent event) {
        final Player player = event.getPlayer();
        final Discord2FAManager discord2FAManager = plugin.getDiscord2FAManager();
        if (discord2FAManager.isInCheck(player)) {
            discord2FAManager.removePlayerFromCheck(player);
        }
    }
}
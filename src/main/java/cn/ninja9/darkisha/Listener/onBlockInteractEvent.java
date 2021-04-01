package cn.ninja9.darkisha.Listener;

import cn.ninja9.darkisha.AskyBlockEx2;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class onBlockInteractEvent implements Listener {

    @EventHandler(
            priority = EventPriority.LOW,
            ignoreCancelled = true
    )
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player != null) {
            if (player.getWorld() == AskyBlockEx2.getSkyBlockWorld() || player.getWorld() == AskyBlockEx2.getSkyBlockNetherWorld()) {
                if (!AskyBlockEx2.AskyblockApi.playerIsOnIsland(player) && (!player.isOp() || !player.hasPermission("*"))) {
                        event.setCancelled(true);
                        player.sendMessage("§6§l[保护] §7该陨星禁止其他玩家使用物品");
                }
            }
        }
    }
}

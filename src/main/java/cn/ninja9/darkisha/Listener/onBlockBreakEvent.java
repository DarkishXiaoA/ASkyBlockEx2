package cn.ninja9.darkisha.Listener;

import cn.ninja9.darkisha.AskyBlockEx2;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class onBlockBreakEvent implements Listener {
    @EventHandler(
            priority = EventPriority.LOW,
            ignoreCancelled = true
    )
    public void onBlockBreakEvent(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (player != null) {
            if (player.getWorld() == AskyBlockEx2.getSkyBlockWorld() || player.getWorld() == AskyBlockEx2.getSkyBlockNetherWorld()) {
                boolean type = AskyBlockEx2.AskyblockApi.playerIsOnIsland(player);
                if (!type && (!player.isOp() || !player.hasPermission("*"))) {
                    player.sendMessage("§6§l[保护] §7该陨星禁止其他玩家破坏方块");
                    event.setCancelled(true);
                }
            }
        }
    }
}

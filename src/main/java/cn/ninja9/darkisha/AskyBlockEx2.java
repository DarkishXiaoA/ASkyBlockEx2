package cn.ninja9.darkisha;

import cn.ninja9.darkisha.Listener.onBlockBreakEvent;
import cn.ninja9.darkisha.Listener.onBlockInteractEvent;
import cn.ninja9.darkisha.Listener.onBlockPlaceEvent;
import com.wasteofplastic.askyblock.ASkyBlockAPI;
import java.util.logging.Level;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;


public final class AskyBlockEx2 extends JavaPlugin {
    public static ASkyBlockAPI AskyblockApi;
    private static World SkyBlockWorld;
    private static World SkyBlockNetherWorld;
    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getServer().getPluginManager().registerEvents(new onBlockBreakEvent(), this);
        this.getServer().getPluginManager().registerEvents(new onBlockPlaceEvent(), this);
        this.getServer().getPluginManager().registerEvents(new onBlockInteractEvent(), this);
        this.getServer().getLogger().log(Level.INFO, "[ASkyBlockEx2]Plugin Enabled");
        AskyblockApi = ASkyBlockAPI.getInstance();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.getServer().getLogger().log(Level.INFO, "[ASkyBlockEx2]Plugin Disabled");
    }

    public static World getSkyBlockWorld() {
        if (SkyBlockWorld == null) {
            SkyBlockWorld = AskyblockApi.getIslandWorld();
        }
        return SkyBlockWorld;
    }

    public static World getSkyBlockNetherWorld(){
        if(SkyBlockNetherWorld == null){
            SkyBlockNetherWorld = AskyblockApi.getNetherWorld();
        }
        return SkyBlockNetherWorld;
    }

}
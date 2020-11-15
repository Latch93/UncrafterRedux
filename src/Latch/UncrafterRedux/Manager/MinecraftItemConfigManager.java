package Latch.UncrafterRedux.Manager;

import Latch.UncrafterRedux.UncrafterRedux;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class MinecraftItemConfigManager {

    private UncrafterRedux plugin = UncrafterRedux.getPlugin(UncrafterRedux.class);
    public static FileConfiguration itemsCfg;
    public static File itemsFile;
    private static final Material[] m = Material.values();

    // Set up mobs.yml configuration file
    public void setup(){
        // if the UncrafterRedux folder does not exist, create the UncrafterRedux folder
        if(!plugin.getDataFolder().exists()){
            plugin.getDataFolder().mkdir();
        }

        itemsFile = new File(plugin.getDataFolder(), "allMinecraftItems.yml");
        //if the allMinecraftItems.yml does not exist, create it
        if(!itemsFile.exists()){
            try {
                itemsFile.createNewFile();
            }
            catch(IOException e){
                System.out.println(ChatColor.RED + "Could not create the allMinecraftItems.yml file");
            }
        }
        itemsCfg = YamlConfiguration.loadConfiguration(itemsFile);
    }

    public static void createItemsConfig(){
        try {
            itemsFile.createNewFile();
            for (int i = 0; i < m.length; i++){
                itemsCfg.set("items.name." + i, m[i].toString());
            }
            itemsCfg.save(itemsFile);
        }
        catch(IOException e){
            System.out.println(ChatColor.RED + "Could not create the allMinecraftItems.yml file");
        }
    }

}

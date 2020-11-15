package Latch.UncrafterRedux.Manager;

import Latch.UncrafterRedux.Model.UncraftModel;
import Latch.UncrafterRedux.UncrafterRedux;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ItemConfigManager {

    private UncrafterRedux plugin = UncrafterRedux.getPlugin(UncrafterRedux.class);
    public static FileConfiguration itemsCfg;
    public File itemsFile;
    private static List<UncraftModel> allowedItems = UncrafterRedux.getAllowedItems();

    // Set up mobs.yml configuration file
    public void setup(){
        // if the UncrafterRedux folder does not exist, create the UncrafterRedux folder
        if(!plugin.getDataFolder().exists()){
            plugin.getDataFolder().mkdir();
        }

        itemsFile = new File(plugin.getDataFolder(), "craftableItems.yml");
        //if the mobs.yml does not exist, create it
        if(!itemsFile.exists()){
            try {
                itemsFile.createNewFile();
            }
            catch(IOException e){
                System.out.println(ChatColor.RED + "Could not create the craftableItems.yml file");
            }
        }
        itemsCfg = YamlConfiguration.loadConfiguration(itemsFile);
    }

    public void createItemsConfig(){
        try {
            itemsFile.createNewFile();
            int count = 1;
            for (UncraftModel item : UncrafterRedux.getAllowedItems()){
                itemsCfg.set("items." + count + ".name", item.getItemName().toString());
                itemsCfg.set("items." + count + ".baseAmountNeededToCraft", item.getAmount());
                count++;
            }
            itemsCfg.save(itemsFile);
        }
        catch(IOException e){
            System.out.println(ChatColor.RED + "Could not create the craftableItems.yml file");
        }
    }

    public void addItemToCfg() throws IOException {
        int itemCount = 1;
        int baseAmountNeededToCraft = 0;
        boolean doesItemExist = false;
        String itemName = null;
        List<String> umStringList = new ArrayList<>();
        for(String items : itemsCfg.getConfigurationSection("items").getKeys(false)) {
            itemName = itemsCfg.getString("items." + itemCount + ".name");
            baseAmountNeededToCraft = itemsCfg.getInt("items." + itemCount + ".baseAmountNeededToCraft");

            for (UncraftModel item : UncrafterRedux.getAllowedItems() ) {
                umStringList.add(item.getItemName().toString());
            }
            if (!umStringList.contains(itemName)){
                doesItemExist = false;
            }
            assert itemName != null;
            UncrafterRedux.addItemToAllowedItemsList(Material.getMaterial(itemName), baseAmountNeededToCraft);
            itemCount++;
        }

        itemsCfg.save(itemsFile);
    }

    public void setItemModelFromConfig() throws IOException {
        int itemCount = 1;
        int baseAmountNeededToCraft = 0;
        String itemName = null;
        allowedItems.clear();
        for(String items : itemsCfg.getConfigurationSection("items").getKeys(false)) {
            itemName = itemsCfg.getString("items." + itemCount + ".name");
            baseAmountNeededToCraft = itemsCfg.getInt("items." + itemCount + ".baseAmountNeededToCraft");
            allowedItems.add(new UncraftModel(Material.getMaterial(itemName), baseAmountNeededToCraft));
            itemCount++;
        }
        itemsCfg.save(itemsFile);
    }

}

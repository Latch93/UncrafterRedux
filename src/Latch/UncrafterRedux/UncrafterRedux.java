package Latch.UncrafterRedux;

import Latch.UncrafterRedux.Manager.RecipeConfigManager;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.Objects;

public class UncrafterRedux extends JavaPlugin {
    private static RecipeConfigManager RecipeCfgm;

    @Override
    public void onEnable() {
        try {
            loadRecipeConfigManager();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Objects.requireNonNull(this.getCommand("uncraft")).setExecutor(new Uncrafter());
        Objects.requireNonNull(this.getCommand("uncraft")).setTabCompleter(new UncraftTabComplete());
    }

    @Override
    public void onDisable(){

    }
    public static void loadRecipeConfigManager() throws IOException {
        RecipeCfgm = new RecipeConfigManager();
        RecipeCfgm.setup();
    }


}

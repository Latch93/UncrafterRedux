package Latch.UncrafterRedux.Manager;

import Latch.UncrafterRedux.Model.UncraftModel;
import Latch.UncrafterRedux.Model.UncraftRecipeModel;
import Latch.UncrafterRedux.UncrafterRedux;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecipeConfigManager {
    private final UncrafterRedux plugin = UncrafterRedux.getPlugin(UncrafterRedux.class);
    public static FileConfiguration recipesCfg;
    public static File recipesFile;
    private static final Material[] m = Material.values();
    public static List<UncraftModel> uml = new ArrayList<>();

    public void setup(){
        if(!plugin.getDataFolder().exists()){
            plugin.getDataFolder().mkdir();
        }
        recipesFile = new File(plugin.getDataFolder(), "craftableRecipes.yml");
        if(!recipesFile.exists()){
            try {
                recipesFile.createNewFile();
                createRecipeConfig();
            }
            catch(IOException e){
                System.out.println(ChatColor.RED + "Could not create the craftableRecipes.yml file");
            }
        }
        setUncraftableItemsFromConfig();
    }

    public void createRecipeConfig(){
        recipesCfg = YamlConfiguration.loadConfiguration(recipesFile);
        try {
            List<Material> uncraftableMaterials = new ArrayList<>();
            for(Material material: m) {
                ItemStack item = new ItemStack(material);
                List<Recipe> recipes = Bukkit.getServer().getRecipesFor(new ItemStack(item));
                if (recipes.size() > 0) {
                    uncraftableMaterials.add(material);
                }
            }
            uncraftableMaterials.removeIf(mat -> mat.toString().contains("FIREWORK") || mat.toString().contains("DYE"));

            int itemCount = 1;
            for(Material material: uncraftableMaterials) {
                ItemStack item = new ItemStack(material);
                List<Recipe> recipes = Bukkit.getServer().getRecipesFor(new ItemStack(item));
                int count2 = 1;
                recipesCfg.set("uncraftableItems.item-" + itemCount + ".name", material.toString());
                for (Recipe recipe : recipes) {
                    if (recipe instanceof ShapedRecipe) {
                        ShapedRecipe shaped = (ShapedRecipe) recipe;
                        int countOfItems = shaped.getIngredientMap().size();
                        int counterForItems = 1;
                        int baseNumberNeededToUncraft = shaped.getResult().getAmount();
                        if (countOfItems > 0) {
                            recipesCfg.set("uncraftableItems.item-" + itemCount + ".recipes.recipe-" + count2 + ".isUncraftable", true);
                            recipesCfg.set("uncraftableItems.item-" + itemCount + ".recipes.recipe-" + count2 + ".baseAmountNeededToUncraft", baseNumberNeededToUncraft);
                            recipesCfg.set("uncraftableItems.item-" + itemCount + ".recipes.recipe-" + count2 + ".recipeType", "Shaped");
                            for (Object value : shaped.getIngredientMap().values()) {
                                try {
                                    String itemForRecipe = value.toString();
                                    String[] itemParts = itemForRecipe.split("[\\{\\}]");
                                    String finalItem = "";
                                    if (itemParts[1].contains("UNSPECIFIC_META")){
                                        finalItem = itemParts[1].substring(0, itemParts[1].length() - 22);
                                    } else {
                                        finalItem = itemParts[1].substring(0, itemParts[1].length() - 4);
                                    }
                                    recipesCfg.set("uncraftableItems.item-" + itemCount + ".recipes.recipe-" + count2 + ".itemsInRecipe.items-" + counterForItems, finalItem);
                                    counterForItems++;
                                }
                                catch (NullPointerException ignore){

                                }
                            }
                        }
                        count2++;
                    }
                    if (recipe instanceof ShapelessRecipe) {
                        ShapelessRecipe shapeless = (ShapelessRecipe) recipe;
                        int countOfItems = shapeless.getIngredientList().size();
                        int counterForItems = 1;
                        int baseNumberNeededToUncraft = shapeless.getResult().getAmount();
                        if (countOfItems > 0) {
                            recipesCfg.set("uncraftableItems.item-" + itemCount + ".recipes.recipe-" + count2 + ".isUncraftable", true);
                            recipesCfg.set("uncraftableItems.item-" + itemCount + ".recipes.recipe-" + count2 + ".baseAmountNeededToUncraft", baseNumberNeededToUncraft);
                            recipesCfg.set("uncraftableItems.item-" + itemCount + ".recipes.recipe-" + count2 + ".recipeType", "Shapeless");
                            for (int j = 0; j < shapeless.getIngredientList().size(); j++) {
                                String itemForRecipe = shapeless.getIngredientList().get(j).toString();
                                String[] itemParts = itemForRecipe.split("[\\{\\}]");
                                String finalItem = "";
                                if (itemParts[1].contains("UNSPECIFIC_META")) {
                                    finalItem = itemParts[1].substring(0, itemParts[1].length() - 22);
                                } else {
                                    finalItem = itemParts[1].substring(0, itemParts[1].length() - 4);
                                }
                                recipesCfg.set("uncraftableItems.item-" + itemCount + ".recipes.recipe-" + count2 + ".itemsInRecipe.items-" + counterForItems, finalItem);
                                counterForItems++;
                            }

                        }
                        count2++;
                    }
                    if (recipe instanceof FurnaceRecipe) {
                        FurnaceRecipe furnace = (FurnaceRecipe) recipe;
                        int counterForItems = 1;
                        int baseNumberNeededToUncraft = furnace.getResult().getAmount();
                        recipesCfg.set("uncraftableItems.item-" + itemCount + ".recipes.recipe-" + count2 + ".isUncraftable", true);
                        recipesCfg.set("uncraftableItems.item-" + itemCount + ".recipes.recipe-" + count2 + ".baseAmountNeededToUncraft", baseNumberNeededToUncraft);
                        recipesCfg.set("uncraftableItems.item-" + itemCount + ".recipes.recipe-" + count2 + ".recipeType", "Furnace");
                        recipesCfg.set("uncraftableItems.item-" + itemCount + ".recipes.recipe-" + count2 + ".itemsInRecipe.items-" + counterForItems, furnace.getInput().getType().toString());
                    }
                    if (recipe instanceof SmithingRecipe) {
                        SmithingRecipe smithing = (SmithingRecipe) recipe;
                        int baseNumberNeededToUncraft = smithing.getResult().getAmount();
                        String base = smithing.getBase().toString();
                        String[] baseSplit = base.split("[\\[\\]]");
                        String addition = smithing.getAddition().toString();
                        String[] additionSplit = addition.split("[\\[\\]]");
                        base = baseSplit[1];
                        addition = additionSplit[1];
                        recipesCfg.set("uncraftableItems.item-" + itemCount + ".recipes.recipe-" + count2 + ".isUncraftable", true);
                        recipesCfg.set("uncraftableItems.item-" + itemCount + ".recipes.recipe-" + count2 + ".baseAmountNeededToUncraft", baseNumberNeededToUncraft);
                        recipesCfg.set("uncraftableItems.item-" + itemCount + ".recipes.recipe-" + count2 + ".recipeType", "SmithingTable");
                        recipesCfg.set("uncraftableItems.item-" + itemCount + ".recipes.recipe-" + count2 + ".itemsInRecipe.items-1", addition);
                        recipesCfg.set("uncraftableItems.item-" + itemCount + ".recipes.recipe-" + count2 + ".itemsInRecipe.items-2", base);
                    }
                }
                itemCount++;
            }

            recipesCfg.save(recipesFile);
        }
        catch(IOException e){
            System.out.println(ChatColor.RED + "Could not create the craftableRecipes.yml file");
        }
    }

    public void setUncraftableItemsFromConfig() {
        int itemCounter = 1;
        recipesCfg = YamlConfiguration.loadConfiguration(recipesFile);
        for(String itemNumber : recipesCfg.getConfigurationSection("uncraftableItems").getKeys(false)) {
            String itemName = recipesCfg.getString("uncraftableItems." + itemNumber + ".name");
            List<UncraftRecipeModel> urml = new ArrayList<>();
            for(String recipeNumber : recipesCfg.getConfigurationSection("uncraftableItems." + itemNumber + ".recipes").getKeys(false)) {
                boolean isUncraftable = recipesCfg.getBoolean("uncraftableItems." + itemNumber + ".recipes." + recipeNumber + ".isUncraftable");
                int baseAmountNeededToUncraft = recipesCfg.getInt("uncraftableItems." + itemNumber + ".recipes." + recipeNumber + ".baseAmountNeededToUncraft");
                String recipeType = recipesCfg.getString("uncraftableItems." + itemNumber + ".recipes." + recipeNumber + ".recipeType");
                List<String> itemsInRecipe = new ArrayList<>();
                for(String itemsInRecipeNumber : recipesCfg.getConfigurationSection("uncraftableItems." + itemNumber + ".recipes." + recipeNumber + ".itemsInRecipe").getKeys(false)) {
                    itemsInRecipe.add(recipesCfg.getString("uncraftableItems." + itemNumber + ".recipes." + recipeNumber + ".itemsInRecipe."+itemsInRecipeNumber));
                }
                urml.add(new UncraftRecipeModel(baseAmountNeededToUncraft, isUncraftable, recipeType, itemsInRecipe));
            }
            uml.add(new UncraftModel(itemName, urml));
            itemCounter++;
        }
    }

    public static List<UncraftModel> getUncraftableItems() {
        return uml;
    }
}

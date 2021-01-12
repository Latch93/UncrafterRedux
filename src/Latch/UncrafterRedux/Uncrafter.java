package Latch.UncrafterRedux;

import Latch.UncrafterRedux.Manager.RecipeConfigManager;
import Latch.UncrafterRedux.Model.UncraftModel;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;

import java.io.File;
import java.util.*;

public class Uncrafter implements CommandExecutor {
    private static String itemStringInHand = "";
    private static int amountNeededToUncraft;
    private static int amountFromCommandToUncraft = 0;
    private static ItemStack itemStackInHand;
    private static int itemAmountInMainHand;
    private static Player pa;
    public static int amountToUncraft;
    public static List<String> recipeListFromTabComplete = new ArrayList<>();
    private static final UncrafterRedux plugin = UncrafterRedux.getPlugin(UncrafterRedux.class);


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        pa = (Player) commandSender;
        itemStringInHand = pa.getInventory().getItemInMainHand().getType().toString();
        itemStackInHand = pa.getInventory().getItemInMainHand();
        itemAmountInMainHand = pa.getInventory().getItemInMainHand().getAmount();
        amountToUncraft = Integer.parseInt(args[0]);

        String recipe = "";
        try {
            amountFromCommandToUncraft = Integer.parseInt(args[0]);
            if (args.length >= 2) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 4; i < args.length; i++) {
                    stringBuilder.append(args[i]);
                    stringBuilder.append(" ");
                }
                recipe = stringBuilder.toString();
                if (amountToUncraft <= itemAmountInMainHand || amountNeededToUncraft <= itemAmountInMainHand) {
                    UncraftItem(recipe, Integer.parseInt(args[0]));
                }
                else {
                    pa.sendMessage(ChatColor.RED + "Error - You need at least " + ChatColor.YELLOW +
                            amountNeededToUncraft + " " + itemStringInHand + ChatColor.RED + " to uncraft.");
                }
            } else if (args.length < 2 ) {
                pa.sendMessage(ChatColor.RED + "Error - Not enough arguments: " + ChatColor.GRAY + "Please enter command like this -> " + ChatColor.GOLD + "/uncraft [amount] [recipe]");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            pa.sendMessage(ChatColor.RED + "Error: " + ChatColor.GRAY + "Please enter command like this -> " + ChatColor.GOLD + "/uncraft [amount] [recipe]");

        }
//        catch (NumberFormatException e) {
//            pa.sendMessage(ChatColor.RED + "Error - You entered an improper number: " + ChatColor.GRAY + "Please enter command like this -> " + ChatColor.GOLD + "/uncraft [amount] [recipe]");
//        }
        return true;
    }

    public static void UncraftItem(String recipe, int amountToUncraft){
        int recipeCount = 0;
        List<UncraftModel> um = RecipeConfigManager.getUncraftableItems();
        HashMap<String, Integer> itemsInRecipe = new HashMap<String, Integer>();
        String[] firstRecipeSplit = recipe.split(",");
        HashMap<String, Integer> itemsInRecipeFromTabComplete = new HashMap<String, Integer>();
        for (UncraftModel uncraftModel : um) {
            if (itemStringInHand.equals(uncraftModel.getItemToUncraft()) && (itemAmountInMainHand >= amountToUncraft)) {
                try {
                    for (String itemPair : firstRecipeSplit) {
                        String[] itemSplit = itemPair.split("x");
                            itemsInRecipe.put(itemSplit[0].trim(), Integer.parseInt(itemSplit[1].trim()));
                    }
                    for (String itemPair : recipeListFromTabComplete) {
                        String[] itemSplit = itemPair.split(",");
                        for (String itemPair2 : itemSplit){
                            String[] itemSplit2 = itemPair2.split("x");
                            itemsInRecipeFromTabComplete.put(itemSplit2[0].trim(), Integer.parseInt(itemSplit2[1].trim()));
                        }
                    }
                    boolean hasRecipeBeenEditedByPlayer = true;
                    int count = 1;
                    for (Map.Entry<String, Integer> stringIntegerEntry : itemsInRecipe.entrySet()) {
                        for (Map.Entry<String, Integer> stringIntegerEntryTabComplete : itemsInRecipeFromTabComplete.entrySet()) {
//                            pa.sendMessage("check1: " + stringIntegerEntry.getKey() + " --- " + stringIntegerEntry.getValue());
//                            pa.sendMessage("check2: " + stringIntegerEntryTabComplete.getKey() + " --- " + stringIntegerEntryTabComplete.getValue());
                            if (String.valueOf(stringIntegerEntryTabComplete.getKey()).contains(String.valueOf(stringIntegerEntry.getKey())) &&
                                    stringIntegerEntry.getValue().equals(stringIntegerEntryTabComplete.getValue())){
                                hasRecipeBeenEditedByPlayer = false;
                                Material m = Material.getMaterial(String.valueOf(stringIntegerEntry.getKey()));
                                assert m != null;
                                try {
                                    if (pa.getInventory().getItemInMainHand().getAmount() >= amountNeededToUncraft &&
                                            pa.getInventory().getItemInMainHand().getAmount() >= amountToUncraft) {
                                        pa.getWorld().dropItem(pa.getLocation(), new ItemStack(m,stringIntegerEntry.getValue()));
                                        pa.sendMessage("count: " + count + " --- size: " + itemsInRecipeFromTabComplete.size() );

                                        if (count == 1) {
                                            pa.sendMessage("ADS " + amountNeededToUncraft);
                                            int check = (int) Math.floor(amountToUncraft / amountNeededToUncraft);
                                            pa.getInventory().getItemInMainHand().setAmount(pa.getInventory().getItemInMainHand().getAmount() - (amountNeededToUncraft * check));
                                        }
                                        count++;
                                    }
                                } catch (IllegalArgumentException ignore) {
                                }
                            }
                        }

                    }
                    if (Boolean.TRUE.equals(hasRecipeBeenEditedByPlayer)){
                        pa.sendMessage(ChatColor.RED + "Error: Do not edit the recipe");
                    }
                } catch (NumberFormatException e){
                    pa.sendMessage(ChatColor.RED + "Error: Do not edit the recipe");
                }

            }
//            else {
//                pa.sendMessage(ChatColor.RED + "Error: " + ChatColor.GOLD + itemStringInHand + ChatColor.GRAY + " is not uncraftable.");
//            }
        }
    }

    public static void setItemsToBeCrafted(List<String> combine, int baseAmountNeededToUncraft) {
        recipeListFromTabComplete = combine;
        amountNeededToUncraft = baseAmountNeededToUncraft;

    }

}

package Latch.UncrafterRedux;

import Latch.UncrafterRedux.Model.UncraftModel;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;

import java.util.List;
import java.util.Map;

public class Uncrafter implements CommandExecutor {
    private static String itemName = "";
    private static List<UncraftModel> allowedItems = UncrafterRedux.getAllowedItems();
    private static int amountNeededToUncraft = 0;
    private static int amountFromCommandToUncraft = 0;
    private static ItemStack itemInHand;
    private static int quotient;
    private static int itemAmountInMainHand;
    private static Player pa;
    private static boolean isCraftable = false;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        pa = (Player) commandSender;
        itemName = pa.getInventory().getItemInMainHand().getType().toString();
        itemInHand = pa.getInventory().getItemInMainHand();
        itemAmountInMainHand = pa.getInventory().getItemInMainHand().getAmount();
        try {
            amountFromCommandToUncraft = Integer.parseInt(args[0]);
            UncraftItem();
        } catch (ArrayIndexOutOfBoundsException ignore) {

        } catch (NumberFormatException e) {
            pa.sendMessage(ChatColor.RED + "Error: You entered an improper number.");
        }
        return true;
    }

    public static void UncraftItem(){
        int recipeCount = 0;
        for (Recipe recipe : Bukkit.getServer().getRecipesFor(new ItemStack(itemInHand))) {
                try {
                    for (UncraftModel allowedItem : allowedItems) {
                        if (allowedItem.getItemName().toString().equals(itemName)) {
                            isCraftable = true;
                            amountNeededToUncraft = allowedItem.getAmount();
                        }
                    }
                    if (Boolean.TRUE.equals(isCraftable)) {
                        if (amountFromCommandToUncraft >= amountNeededToUncraft) {
                            if (amountFromCommandToUncraft <= itemAmountInMainHand) {
                                recipeCount++;
                                quotient = (int) Math.floor(amountFromCommandToUncraft / amountNeededToUncraft);
                                for (int i = 0; i < quotient; i++) {
                                    if (recipe instanceof ShapedRecipe) {
                                        ShapedRecipe shaped = (ShapedRecipe) recipe;
                                        pa.getInventory().getItemInMainHand().setAmount(pa.getInventory().getItemInMainHand().getAmount() - (amountNeededToUncraft));
                                        for (Map.Entry<Character, ItemStack> entry : shaped.getIngredientMap().entrySet()) {
                                            try {
                                                Material m = entry.getValue().getType();
                                                pa.getWorld().dropItem(pa.getLocation(), new ItemStack(m));
                                            } catch (NullPointerException ignored) {

                                            }
                                        }
                                    } else if (recipe instanceof ShapelessRecipe) {
                                        ShapelessRecipe shapeless = (ShapelessRecipe) recipe;
                                        pa.getInventory().getItemInMainHand().setAmount(pa.getInventory().getItemInMainHand().getAmount() - 1);
                                        shapeless.getIngredientList();
                                        for (int j = 0; j < shapeless.getIngredientList().size(); j++) {
                                            try {
                                                Material m = shapeless.getIngredientList().get(j).getType();
                                                pa.getWorld().dropItem(pa.getLocation(), new ItemStack(m));
                                            } catch (NullPointerException ignored) {

                                            }
                                        }
                                    }
                                }
                                if (quotient == 1) {
                                    quotient = amountNeededToUncraft;
                                }
                                if (recipeCount == 1){
                                    pa.sendMessage(ChatColor.GREEN + "Uncrafted: " + ChatColor.GOLD + quotient + ChatColor.GREEN + " : " + ChatColor.GOLD + itemName);
                                }
                            } else {
                                pa.sendMessage(ChatColor.RED + "Error: " + ChatColor.GRAY + "Unable to uncraft more than amount in hand.");
                            }
                        } else {
                            if (amountNeededToUncraft == 1) {
                                pa.sendMessage(ChatColor.RED + "Error: " + ChatColor.GRAY + "At least " + ChatColor.GOLD + amountNeededToUncraft + " " + itemName + ChatColor.GRAY + " required to be uncrafted.");
                            } else {
                                pa.sendMessage(ChatColor.RED + "Error: " + ChatColor.GRAY + "At least " + ChatColor.GOLD + amountNeededToUncraft + " " + itemName + ChatColor.GRAY + " required to be uncrafted.");
                            }
                        }
                    }


                } catch (ArrayIndexOutOfBoundsException ignore) {
                } catch (ArithmeticException ignored) {
                }
        }
        if (Boolean.FALSE.equals(isCraftable)) {
            pa.sendMessage(ChatColor.RED + "Error: " + ChatColor.GOLD + itemName + ChatColor.GRAY + " is not uncraftable.");
        }
    }

}

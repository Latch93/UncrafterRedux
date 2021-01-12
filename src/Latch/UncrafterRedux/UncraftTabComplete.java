package Latch.UncrafterRedux;

import Latch.UncrafterRedux.Manager.RecipeConfigManager;
import Latch.UncrafterRedux.Model.UncraftModel;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.*;

public class UncraftTabComplete implements TabCompleter {

    private static final List<String> strings = new ArrayList<>();

    public List<String> onTabComplete(CommandSender commandSender, Command command, String alias, String[] args) {
        strings.clear();
        Player pa = (Player) commandSender;
        String itemStringInHand = pa.getInventory().getItemInMainHand().getType().toString();
        int itemAmountInMainHand = pa.getInventory().getItemInMainHand().getAmount();
        List<UncraftModel> um = RecipeConfigManager.getUncraftableItems();
        List<Integer> baseAmountNeededToUncraftList = new ArrayList<>();
        for (UncraftModel uncraftModel : um) {

            if (itemStringInHand.equals(uncraftModel.getItemToUncraft())){
                int recipeCount = 1;
                for (int i = 0; i < uncraftModel.getRecipes().size(); i++){
                    if (Boolean.TRUE.equals(uncraftModel.getRecipes().get(i).getIsItemUncraftable())){
                        String combine = "Recipe "+recipeCount+" : ";
                        Set<String> noDupSet = new HashSet<String>();
                        List<String> listOfItems = new ArrayList<>();
                        int baseAmountNeededToUncraft = uncraftModel.getRecipes().get(i).getBaseAmountToUncraft();
                        baseAmountNeededToUncraftList.add(baseAmountNeededToUncraft);
                        double multiplier = 1;
                        try {
                            int amountToUncraft = Integer.parseInt(args[0]);
                            if (amountToUncraft < baseAmountNeededToUncraft){
                                multiplier = 0;
                            } else {
                                multiplier = (int) Math.floor(amountToUncraft/baseAmountNeededToUncraft);
                            }
                        } catch (NumberFormatException ignore){

                        }

                        for (int j = 0; j < uncraftModel.getRecipes().get(i).getItemsInRecipe().size(); j++){
                            String item = uncraftModel.getRecipes().get(i).getItemsInRecipe().get(j);
                            noDupSet.add(item);
                            listOfItems.add(item);
                        }
                        int counterForItems = 1;
                        for (String item : noDupSet) {
                            int countOfItem = Collections.frequency(listOfItems, item);
                            if (counterForItems < noDupSet.size()){
                                combine = combine.concat(item + " x " + (countOfItem * (int) multiplier) + ", ");
                            }
                            else {
                                combine = combine.concat(item + " x " + (countOfItem * (int) multiplier));
                            }
                            counterForItems++;
                        }
                        strings.add(combine);
                        Uncrafter.setItemsToBeCrafted(strings, baseAmountNeededToUncraft);
                    }
                    recipeCount++;
                }
            }
        }
        try {
            return (args.length == 2) ? StringUtil.copyPartialMatches(args[1], strings, new ArrayList<>()) : null;
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException ignored){

        }
        return StringUtil.copyPartialMatches(args[0], strings, new ArrayList<>());
    }


}
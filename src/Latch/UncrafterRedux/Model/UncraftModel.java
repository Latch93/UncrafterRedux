package Latch.UncrafterRedux.Model;

import java.util.List;

public class UncraftModel {

    protected String itemToUncraft;
    protected List<UncraftRecipeModel> recipes;

    public UncraftModel(String itemToUncraft, List<UncraftRecipeModel> recipes) {
        this.itemToUncraft = itemToUncraft;
        this.recipes = recipes;
    }


    public String getItemToUncraft(){
        return itemToUncraft;
    }

    public void setItemToUncraft(String itemToUncraft) {
        this.itemToUncraft = itemToUncraft;
    }

    public List<UncraftRecipeModel> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<UncraftRecipeModel> recipes) {
        this.recipes = recipes;
    }

}

package Latch.UncrafterRedux.Model;

import java.util.List;

public class UncraftRecipeModel {
    protected Integer baseAmountToUncraft;
    protected String recipeType;
    protected List<String> itemsInRecipe;
    protected boolean isItemUncraftable;


    public UncraftRecipeModel(Integer baseAmountToUncraft, boolean isItemUncraftable, String recipeType, List<String> itemsInRecipe) {
        this.baseAmountToUncraft = baseAmountToUncraft;
        this.recipeType = recipeType;
        this.itemsInRecipe = itemsInRecipe;
        this.isItemUncraftable = isItemUncraftable;
    }

    public Integer getBaseAmountToUncraft(){
        return baseAmountToUncraft;
    }

    public void setBaseAmountToUncraft(Integer baseAmountToUncraft) {
        this.baseAmountToUncraft = baseAmountToUncraft;
    }

    public String getRecipeType(){
        return recipeType;
    }

    public void setRecipeType(String recipeType) {
        this.recipeType = recipeType;
    }

    public List<String> getItemsInRecipe() {
        return itemsInRecipe;
    }

    public void setItemsInRecipe(List<String> itemsInRecipe) {
        this.itemsInRecipe = itemsInRecipe;
    }

    public boolean getIsItemUncraftable() {
        return isItemUncraftable;
    }

    public void setIsItemUncraftable(boolean isItemUncraftable) {
        this.isItemUncraftable = isItemUncraftable;
    }

}

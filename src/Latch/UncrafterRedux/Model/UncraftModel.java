package Latch.UncrafterRedux.Model;


import org.bukkit.Material;

public class UncraftModel {

    protected Material material;
    protected Integer amount;

    public UncraftModel(Material material, Integer amount) {
        this.material = material;
        this.amount = amount;
    }

    public Material getItemName(){
        return material;
    }

    public void setItemName(Material material) {
        this.material = material;
    }

    public Integer getAmount(){
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}

package Latch.UncrafterRedux;

import Latch.UncrafterRedux.Manager.ItemConfigManager;
import Latch.UncrafterRedux.Manager.MinecraftItemConfigManager;
import Latch.UncrafterRedux.Model.UncraftModel;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UncrafterRedux extends JavaPlugin {
    private static final List<UncraftModel> allowedItems = new ArrayList<>();
    private ItemConfigManager ItemCfgm;
    private MinecraftItemConfigManager MinecraftItemCfgm;

    @Override
    public void onEnable() {
        setAllowedItems();
        loadItemConfigManager();
        loadMinecraftItemConfigManager();
        try {
            ItemCfgm.setItemModelFromConfig();
            ItemCfgm.addItemToCfg();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Objects.requireNonNull(this.getCommand("uncraft")).setExecutor(new Uncrafter());
    }

    @Override
    public void onDisable(){

    }

    public static void setAllowedItems(){

        // acacia wood building blocks
        allowedItems.add(new UncraftModel(Material.ACACIA_FENCE, 3));
        allowedItems.add(new UncraftModel(Material.ACACIA_FENCE_GATE, 1));
        allowedItems.add(new UncraftModel(Material.ACACIA_PRESSURE_PLATE, 1));
        allowedItems.add(new UncraftModel(Material.ACACIA_BOAT, 1));
        allowedItems.add(new UncraftModel(Material.ACACIA_BUTTON, 1));
        allowedItems.add(new UncraftModel(Material.ACACIA_DOOR, 3));
        allowedItems.add(new UncraftModel(Material.ACACIA_SIGN, 3));
        allowedItems.add(new UncraftModel(Material.ACACIA_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.ACACIA_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.ACACIA_TRAPDOOR, 2));
        allowedItems.add(new UncraftModel(Material.ACACIA_WOOD, 3));

        // Birch wood building blocks
        allowedItems.add(new UncraftModel(Material.BIRCH_FENCE, 3));
        allowedItems.add(new UncraftModel(Material.BIRCH_FENCE_GATE, 1));
        allowedItems.add(new UncraftModel(Material.BIRCH_PRESSURE_PLATE, 1));
        allowedItems.add(new UncraftModel(Material.BIRCH_BOAT, 1));
        allowedItems.add(new UncraftModel(Material.BIRCH_BUTTON, 1));
        allowedItems.add(new UncraftModel(Material.BIRCH_DOOR, 3));
        allowedItems.add(new UncraftModel(Material.BIRCH_SIGN, 3));
        allowedItems.add(new UncraftModel(Material.BIRCH_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.BIRCH_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.BIRCH_TRAPDOOR, 2));
        allowedItems.add(new UncraftModel(Material.BIRCH_WOOD, 3));

        // Crimson wood building blocks
        allowedItems.add(new UncraftModel(Material.CRIMSON_FENCE, 3));
        allowedItems.add(new UncraftModel(Material.CRIMSON_FENCE_GATE, 1));
        allowedItems.add(new UncraftModel(Material.CRIMSON_PRESSURE_PLATE, 1));
        allowedItems.add(new UncraftModel(Material.CRIMSON_BUTTON, 1));
        allowedItems.add(new UncraftModel(Material.CRIMSON_DOOR, 3));
        allowedItems.add(new UncraftModel(Material.CRIMSON_SIGN, 3));
        allowedItems.add(new UncraftModel(Material.CRIMSON_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.CRIMSON_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.CRIMSON_TRAPDOOR, 2));

        // Dark oak wood building blocks
        allowedItems.add(new UncraftModel(Material.DARK_OAK_FENCE, 3));
        allowedItems.add(new UncraftModel(Material.DARK_OAK_FENCE_GATE, 1));
        allowedItems.add(new UncraftModel(Material.DARK_OAK_PRESSURE_PLATE, 1));
        allowedItems.add(new UncraftModel(Material.DARK_OAK_BOAT, 1));
        allowedItems.add(new UncraftModel(Material.DARK_OAK_BUTTON, 1));
        allowedItems.add(new UncraftModel(Material.DARK_OAK_DOOR, 3));
        allowedItems.add(new UncraftModel(Material.DARK_OAK_SIGN, 3));
        allowedItems.add(new UncraftModel(Material.DARK_OAK_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.DARK_OAK_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.DARK_OAK_TRAPDOOR, 2));
        allowedItems.add(new UncraftModel(Material.DARK_OAK_WOOD, 3));

        // Jungle wood building blocks
        allowedItems.add(new UncraftModel(Material.JUNGLE_FENCE, 3));
        allowedItems.add(new UncraftModel(Material.JUNGLE_FENCE_GATE, 1));
        allowedItems.add(new UncraftModel(Material.JUNGLE_PRESSURE_PLATE, 1));
        allowedItems.add(new UncraftModel(Material.JUNGLE_BOAT, 1));
        allowedItems.add(new UncraftModel(Material.JUNGLE_BUTTON, 1));
        allowedItems.add(new UncraftModel(Material.JUNGLE_DOOR, 3));
        allowedItems.add(new UncraftModel(Material.JUNGLE_SIGN, 3));
        allowedItems.add(new UncraftModel(Material.JUNGLE_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.JUNGLE_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.JUNGLE_TRAPDOOR, 2));
        allowedItems.add(new UncraftModel(Material.JUNGLE_WOOD, 3));

        // Oak wood building blocks
        allowedItems.add(new UncraftModel(Material.OAK_FENCE, 3));
        allowedItems.add(new UncraftModel(Material.OAK_FENCE_GATE, 1));
        allowedItems.add(new UncraftModel(Material.OAK_PRESSURE_PLATE, 1));
        allowedItems.add(new UncraftModel(Material.OAK_BOAT, 1));
        allowedItems.add(new UncraftModel(Material.OAK_BUTTON, 1));
        allowedItems.add(new UncraftModel(Material.OAK_DOOR, 3));
        allowedItems.add(new UncraftModel(Material.OAK_SIGN, 3));
        allowedItems.add(new UncraftModel(Material.OAK_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.OAK_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.OAK_TRAPDOOR, 2));
        allowedItems.add(new UncraftModel(Material.OAK_WOOD, 3));

        // Spruce wood building blocks
        allowedItems.add(new UncraftModel(Material.SPRUCE_FENCE, 3));
        allowedItems.add(new UncraftModel(Material.SPRUCE_FENCE_GATE, 1));
        allowedItems.add(new UncraftModel(Material.SPRUCE_PRESSURE_PLATE, 1));
        allowedItems.add(new UncraftModel(Material.SPRUCE_BOAT, 1));
        allowedItems.add(new UncraftModel(Material.SPRUCE_BUTTON, 1));
        allowedItems.add(new UncraftModel(Material.SPRUCE_DOOR, 3));
        allowedItems.add(new UncraftModel(Material.SPRUCE_SIGN, 3));
        allowedItems.add(new UncraftModel(Material.SPRUCE_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.SPRUCE_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.SPRUCE_TRAPDOOR, 2));
        allowedItems.add(new UncraftModel(Material.SPRUCE_WOOD, 3));

        // Warped wood building blocks
        allowedItems.add(new UncraftModel(Material.WARPED_FENCE, 3));
        allowedItems.add(new UncraftModel(Material.WARPED_FENCE_GATE, 1));
        allowedItems.add(new UncraftModel(Material.WARPED_PRESSURE_PLATE, 1));
        allowedItems.add(new UncraftModel(Material.WARPED_BUTTON, 1));
        allowedItems.add(new UncraftModel(Material.WARPED_DOOR, 3));
        allowedItems.add(new UncraftModel(Material.WARPED_SIGN, 3));
        allowedItems.add(new UncraftModel(Material.WARPED_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.WARPED_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.WARPED_TRAPDOOR, 2));

        // Wooden Tools and Weapons
        allowedItems.add(new UncraftModel(Material.WOODEN_AXE, 1));
        allowedItems.add(new UncraftModel(Material.WOODEN_HOE, 1));
        allowedItems.add(new UncraftModel(Material.WOODEN_PICKAXE, 1));
        allowedItems.add(new UncraftModel(Material.WOODEN_SHOVEL, 1));
        allowedItems.add(new UncraftModel(Material.WOODEN_SWORD, 1));

        // Iron Tools, Weapons and Armor
        allowedItems.add(new UncraftModel(Material.IRON_AXE, 1));
        allowedItems.add(new UncraftModel(Material.IRON_HOE, 1));
        allowedItems.add(new UncraftModel(Material.IRON_PICKAXE, 1));
        allowedItems.add(new UncraftModel(Material.IRON_SHOVEL, 1));
        allowedItems.add(new UncraftModel(Material.IRON_SWORD, 1));
        allowedItems.add(new UncraftModel(Material.IRON_BOOTS, 1));
        allowedItems.add(new UncraftModel(Material.IRON_CHESTPLATE, 1));
        allowedItems.add(new UncraftModel(Material.IRON_HELMET, 1));
        allowedItems.add(new UncraftModel(Material.IRON_LEGGINGS, 1));

        // Diamond Tools, Weapons and Armor
        allowedItems.add(new UncraftModel(Material.DIAMOND_AXE, 1));
        allowedItems.add(new UncraftModel(Material.DIAMOND_HOE, 1));
        allowedItems.add(new UncraftModel(Material.DIAMOND_PICKAXE, 1));
        allowedItems.add(new UncraftModel(Material.DIAMOND_SHOVEL, 1));
        allowedItems.add(new UncraftModel(Material.DIAMOND_SWORD, 1));
        allowedItems.add(new UncraftModel(Material.DIAMOND_BOOTS, 1));
        allowedItems.add(new UncraftModel(Material.DIAMOND_CHESTPLATE, 1));
        allowedItems.add(new UncraftModel(Material.DIAMOND_HELMET, 1));
        allowedItems.add(new UncraftModel(Material.DIAMOND_LEGGINGS, 1));

        // Leather Armor
        allowedItems.add(new UncraftModel(Material.LEATHER_BOOTS, 1));
        allowedItems.add(new UncraftModel(Material.LEATHER_CHESTPLATE, 1));
        allowedItems.add(new UncraftModel(Material.LEATHER_HELMET, 1));
        allowedItems.add(new UncraftModel(Material.LEATHER_LEGGINGS, 1));

        // Minecart rails and other items
        allowedItems.add(new UncraftModel(Material.ACTIVATOR_RAIL, 6));
        allowedItems.add(new UncraftModel(Material.DETECTOR_RAIL, 6));
        allowedItems.add(new UncraftModel(Material.RAIL, 16));
        allowedItems.add(new UncraftModel(Material.POWERED_RAIL, 6));
        allowedItems.add(new UncraftModel(Material.MINECART, 1));
        allowedItems.add(new UncraftModel(Material.CHEST_MINECART, 1));
        allowedItems.add(new UncraftModel(Material.FURNACE_MINECART, 1));
        allowedItems.add(new UncraftModel(Material.CARROT_ON_A_STICK, 1));
        allowedItems.add(new UncraftModel(Material.WARPED_FUNGUS_ON_A_STICK, 1));
        allowedItems.add(new UncraftModel(Material.TNT_MINECART, 1));
        allowedItems.add(new UncraftModel(Material.HOPPER_MINECART, 1));

        // Redstone items
        allowedItems.add(new UncraftModel(Material.DISPENSER, 1));
        allowedItems.add(new UncraftModel(Material.NOTE_BLOCK, 1));
        allowedItems.add(new UncraftModel(Material.STICKY_PISTON, 1));
        allowedItems.add(new UncraftModel(Material.PISTON, 1));
        allowedItems.add(new UncraftModel(Material.TNT, 1));
        allowedItems.add(new UncraftModel(Material.LEVER, 1));
        allowedItems.add(new UncraftModel(Material.REDSTONE_TORCH, 1));
        allowedItems.add(new UncraftModel(Material.REDSTONE_LAMP, 1));
        allowedItems.add(new UncraftModel(Material.TRIPWIRE_HOOK, 2));
        allowedItems.add(new UncraftModel(Material.LIGHT_WEIGHTED_PRESSURE_PLATE, 1));
        allowedItems.add(new UncraftModel(Material.HEAVY_WEIGHTED_PRESSURE_PLATE, 1));
        allowedItems.add(new UncraftModel(Material.DAYLIGHT_DETECTOR, 1));
        allowedItems.add(new UncraftModel(Material.REDSTONE_BLOCK, 1));
        allowedItems.add(new UncraftModel(Material.HOPPER, 1));
        allowedItems.add(new UncraftModel(Material.DROPPER, 1));
        allowedItems.add(new UncraftModel(Material.IRON_TRAPDOOR, 1));
        allowedItems.add(new UncraftModel(Material.OBSERVER, 1));
        allowedItems.add(new UncraftModel(Material.REPEATER, 1));
        allowedItems.add(new UncraftModel(Material.COMPARATOR, 1));
        allowedItems.add(new UncraftModel(Material.TARGET, 1));

        // Miscellaneous items
        allowedItems.add(new UncraftModel(Material.BEACON, 1));
        allowedItems.add(new UncraftModel(Material.CONDUIT, 1));
        allowedItems.add(new UncraftModel(Material.BOWL, 4));
        allowedItems.add(new UncraftModel(Material.BOOK, 1));
        allowedItems.add(new UncraftModel(Material.MAP, 1));
        allowedItems.add(new UncraftModel(Material.BLAZE_POWDER, 2));
        allowedItems.add(new UncraftModel(Material.ENDER_EYE, 1));
        allowedItems.add(new UncraftModel(Material.BONE_BLOCK, 1));
        allowedItems.add(new UncraftModel(Material.PAPER, 3));

        // Brewing items
        allowedItems.add(new UncraftModel(Material.MAGMA_CREAM, 1));
        allowedItems.add(new UncraftModel(Material.GOLDEN_CARROT, 1));
        allowedItems.add(new UncraftModel(Material.GLISTERING_MELON_SLICE, 1));
        allowedItems.add(new UncraftModel(Material.FERMENTED_SPIDER_EYE, 1));

        // Other Tools and Combat items
        allowedItems.add(new UncraftModel(Material.COMPASS, 1));
        allowedItems.add(new UncraftModel(Material.FLINT_AND_STEEL, 1));
        allowedItems.add(new UncraftModel(Material.FISHING_ROD, 1));
        allowedItems.add(new UncraftModel(Material.ARROW, 4));
        allowedItems.add(new UncraftModel(Material.BOW, 1));
        allowedItems.add(new UncraftModel(Material.TURTLE_HELMET, 1));
        allowedItems.add(new UncraftModel(Material.CROSSBOW, 1));
        allowedItems.add(new UncraftModel(Material.SHIELD, 1));
        allowedItems.add(new UncraftModel(Material.SHEARS, 1));
        allowedItems.add(new UncraftModel(Material.LEAD, 2));
        allowedItems.add(new UncraftModel(Material.CLOCK, 1));

        // Foodstuffs items
        allowedItems.add(new UncraftModel(Material.MUSHROOM_STEW, 1));
        allowedItems.add(new UncraftModel(Material.COOKIE, 8));
        allowedItems.add(new UncraftModel(Material.BEETROOT_SOUP, 1));

        // Workstation blocks
        allowedItems.add(new UncraftModel(Material.LECTERN, 1));
        allowedItems.add(new UncraftModel(Material.BREWING_STAND, 1));
        allowedItems.add(new UncraftModel(Material.CAULDRON, 1));
        allowedItems.add(new UncraftModel(Material.BLAST_FURNACE, 1));
        allowedItems.add(new UncraftModel(Material.SMOKER, 1));
        allowedItems.add(new UncraftModel(Material.CARTOGRAPHY_TABLE, 1));
        allowedItems.add(new UncraftModel(Material.COMPOSTER, 1));
        allowedItems.add(new UncraftModel(Material.BARREL, 1));
        allowedItems.add(new UncraftModel(Material.FLETCHING_TABLE, 1));
        allowedItems.add(new UncraftModel(Material.GRINDSTONE, 1));
        allowedItems.add(new UncraftModel(Material.LOOM, 1));
        allowedItems.add(new UncraftModel(Material.STONECUTTER, 1));
        allowedItems.add(new UncraftModel(Material.SMITHING_TABLE, 1));

        // Walls
        allowedItems.add(new UncraftModel(Material.COBBLESTONE_WALL, 6));
        allowedItems.add(new UncraftModel(Material.MOSSY_COBBLESTONE_WALL, 6));
        allowedItems.add(new UncraftModel(Material.PRISMARINE_WALL, 6));
        allowedItems.add(new UncraftModel(Material.BRICK_WALL, 6));
        allowedItems.add(new UncraftModel(Material.RED_SANDSTONE_WALL, 6));
        allowedItems.add(new UncraftModel(Material.MOSSY_STONE_BRICK_WALL, 6));
        allowedItems.add(new UncraftModel(Material.GRANITE_WALL, 6));
        allowedItems.add(new UncraftModel(Material.STONE_BRICK_WALL, 6));
        allowedItems.add(new UncraftModel(Material.NETHER_BRICK_WALL, 6));
        allowedItems.add(new UncraftModel(Material.NETHER_BRICK_WALL, 6));
        allowedItems.add(new UncraftModel(Material.ANDESITE_WALL, 6));
        allowedItems.add(new UncraftModel(Material.RED_NETHER_BRICK_WALL, 6));
        allowedItems.add(new UncraftModel(Material.END_STONE_BRICK_WALL, 6));
        allowedItems.add(new UncraftModel(Material.SANDSTONE_WALL, 6));
        allowedItems.add(new UncraftModel(Material.DIORITE_WALL, 6));
        allowedItems.add(new UncraftModel(Material.BLACKSTONE_WALL, 6));
        allowedItems.add(new UncraftModel(Material.POLISHED_BLACKSTONE_WALL, 6));
        allowedItems.add(new UncraftModel(Material.POLISHED_BLACKSTONE_BRICK_WALL, 6));

        // Slabs
        allowedItems.add(new UncraftModel(Material.COBBLESTONE_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.MOSSY_COBBLESTONE_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.PRISMARINE_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.BRICK_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.RED_SANDSTONE_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.MOSSY_STONE_BRICK_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.GRANITE_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.STONE_BRICK_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.NETHER_BRICK_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.ANDESITE_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.RED_NETHER_BRICK_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.END_STONE_BRICK_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.SANDSTONE_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.DIORITE_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.BLACKSTONE_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.POLISHED_BLACKSTONE_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.POLISHED_BLACKSTONE_BRICK_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.POLISHED_ANDESITE_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.SMOOTH_QUARTZ_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.SMOOTH_SANDSTONE_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.PURPUR_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.PRISMARINE_BRICK_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.DARK_PRISMARINE_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.POLISHED_DIORITE_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.SMOOTH_RED_SANDSTONE_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.CUT_SANDSTONE_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.CUT_RED_SANDSTONE_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.POLISHED_GRANITE_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.SMOOTH_STONE_SLAB, 6));
        allowedItems.add(new UncraftModel(Material.QUARTZ_SLAB, 6));

        // Stairs
        allowedItems.add(new UncraftModel(Material.COBBLESTONE_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.MOSSY_COBBLESTONE_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.PRISMARINE_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.BRICK_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.RED_SANDSTONE_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.MOSSY_STONE_BRICK_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.GRANITE_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.STONE_BRICK_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.NETHER_BRICK_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.ANDESITE_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.RED_NETHER_BRICK_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.END_STONE_BRICK_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.SANDSTONE_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.DIORITE_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.BLACKSTONE_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.POLISHED_BLACKSTONE_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.POLISHED_BLACKSTONE_BRICK_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.POLISHED_GRANITE_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.DARK_PRISMARINE_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.SMOOTH_QUARTZ_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.QUARTZ_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.POLISHED_ANDESITE_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.SMOOTH_SANDSTONE_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.SMOOTH_RED_SANDSTONE_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.PRISMARINE_BRICK_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.POLISHED_DIORITE_STAIRS, 4));
        allowedItems.add(new UncraftModel(Material.PURPUR_SLAB, 4));
        allowedItems.add(new UncraftModel(Material.STONE_STAIRS, 4));

        // Banners
        allowedItems.add(new UncraftModel(Material.WHITE_BANNER, 1));
        allowedItems.add(new UncraftModel(Material.ORANGE_BANNER, 1));
        allowedItems.add(new UncraftModel(Material.MAGENTA_BANNER, 1));
        allowedItems.add(new UncraftModel(Material.LIGHT_BLUE_BANNER, 1));
        allowedItems.add(new UncraftModel(Material.YELLOW_BANNER, 1));
        allowedItems.add(new UncraftModel(Material.LIME_BANNER, 1));
        allowedItems.add(new UncraftModel(Material.PINK_BANNER, 1));
        allowedItems.add(new UncraftModel(Material.GRAY_BANNER, 1));
        allowedItems.add(new UncraftModel(Material.LIGHT_GRAY_BANNER, 1));
        allowedItems.add(new UncraftModel(Material.CYAN_BANNER, 1));
        allowedItems.add(new UncraftModel(Material.BLUE_BANNER, 1));
        allowedItems.add(new UncraftModel(Material.BROWN_BANNER, 1));
        allowedItems.add(new UncraftModel(Material.PURPLE_BANNER, 1));
        allowedItems.add(new UncraftModel(Material.GREEN_BANNER, 1));
        allowedItems.add(new UncraftModel(Material.RED_BANNER, 1));
        allowedItems.add(new UncraftModel(Material.BLACK_BANNER, 1));

        // Concrete Powder
        allowedItems.add(new UncraftModel(Material.WHITE_CONCRETE_POWDER, 8));
        allowedItems.add(new UncraftModel(Material.ORANGE_CONCRETE_POWDER, 8));
        allowedItems.add(new UncraftModel(Material.MAGENTA_CONCRETE_POWDER, 8));
        allowedItems.add(new UncraftModel(Material.LIGHT_BLUE_CONCRETE_POWDER, 8));
        allowedItems.add(new UncraftModel(Material.YELLOW_CONCRETE_POWDER, 8));
        allowedItems.add(new UncraftModel(Material.LIME_CONCRETE_POWDER, 8));
        allowedItems.add(new UncraftModel(Material.PINK_CONCRETE_POWDER, 8));
        allowedItems.add(new UncraftModel(Material.GRAY_CONCRETE_POWDER, 8));
        allowedItems.add(new UncraftModel(Material.LIGHT_GRAY_CONCRETE_POWDER, 8));
        allowedItems.add(new UncraftModel(Material.CYAN_CONCRETE_POWDER, 8));
        allowedItems.add(new UncraftModel(Material.BLUE_CONCRETE_POWDER, 8));
        allowedItems.add(new UncraftModel(Material.BROWN_CONCRETE_POWDER, 8));
        allowedItems.add(new UncraftModel(Material.PURPLE_CONCRETE_POWDER, 8));
        allowedItems.add(new UncraftModel(Material.GREEN_CONCRETE_POWDER, 8));
        allowedItems.add(new UncraftModel(Material.RED_CONCRETE_POWDER, 8));
        allowedItems.add(new UncraftModel(Material.BLACK_CONCRETE_POWDER, 8));

        // Wool
        allowedItems.add(new UncraftModel(Material.ORANGE_WOOL, 1));
        allowedItems.add(new UncraftModel(Material.MAGENTA_WOOL, 1));
        allowedItems.add(new UncraftModel(Material.LIGHT_BLUE_WOOL, 1));
        allowedItems.add(new UncraftModel(Material.YELLOW_WOOL, 1));
        allowedItems.add(new UncraftModel(Material.LIME_WOOL, 1));
        allowedItems.add(new UncraftModel(Material.PINK_WOOL, 1));
        allowedItems.add(new UncraftModel(Material.GRAY_WOOL, 1));
        allowedItems.add(new UncraftModel(Material.LIGHT_GRAY_WOOL, 1));
        allowedItems.add(new UncraftModel(Material.CYAN_WOOL, 1));
        allowedItems.add(new UncraftModel(Material.BLUE_WOOL, 1));
        allowedItems.add(new UncraftModel(Material.BROWN_WOOL, 1));
        allowedItems.add(new UncraftModel(Material.PURPLE_WOOL, 1));
        allowedItems.add(new UncraftModel(Material.GREEN_WOOL, 1));
        allowedItems.add(new UncraftModel(Material.RED_WOOL, 1));
        allowedItems.add(new UncraftModel(Material.BLACK_WOOL, 1));

        // Stained Glass
        allowedItems.add(new UncraftModel(Material.WHITE_STAINED_GLASS, 8));
        allowedItems.add(new UncraftModel(Material.ORANGE_STAINED_GLASS, 8));
        allowedItems.add(new UncraftModel(Material.MAGENTA_STAINED_GLASS, 8));
        allowedItems.add(new UncraftModel(Material.LIGHT_BLUE_STAINED_GLASS, 8));
        allowedItems.add(new UncraftModel(Material.YELLOW_STAINED_GLASS, 8));
        allowedItems.add(new UncraftModel(Material.LIME_STAINED_GLASS, 8));
        allowedItems.add(new UncraftModel(Material.PINK_STAINED_GLASS, 8));
        allowedItems.add(new UncraftModel(Material.GRAY_STAINED_GLASS, 8));
        allowedItems.add(new UncraftModel(Material.LIGHT_GRAY_STAINED_GLASS, 8));
        allowedItems.add(new UncraftModel(Material.CYAN_STAINED_GLASS, 8));
        allowedItems.add(new UncraftModel(Material.BLUE_STAINED_GLASS, 8));
        allowedItems.add(new UncraftModel(Material.BROWN_STAINED_GLASS, 8));
        allowedItems.add(new UncraftModel(Material.PURPLE_STAINED_GLASS, 8));
        allowedItems.add(new UncraftModel(Material.GREEN_STAINED_GLASS, 8));
        allowedItems.add(new UncraftModel(Material.RED_STAINED_GLASS, 8));
        allowedItems.add(new UncraftModel(Material.BLACK_STAINED_GLASS, 8));

        // Terracotta
        allowedItems.add(new UncraftModel(Material.WHITE_TERRACOTTA, 8));
        allowedItems.add(new UncraftModel(Material.ORANGE_TERRACOTTA, 8));
        allowedItems.add(new UncraftModel(Material.MAGENTA_TERRACOTTA, 8));
        allowedItems.add(new UncraftModel(Material.LIGHT_BLUE_TERRACOTTA, 8));
        allowedItems.add(new UncraftModel(Material.YELLOW_TERRACOTTA, 8));
        allowedItems.add(new UncraftModel(Material.LIME_TERRACOTTA, 8));
        allowedItems.add(new UncraftModel(Material.PINK_TERRACOTTA, 8));
        allowedItems.add(new UncraftModel(Material.GRAY_TERRACOTTA, 8));
        allowedItems.add(new UncraftModel(Material.LIGHT_GRAY_TERRACOTTA, 8));
        allowedItems.add(new UncraftModel(Material.CYAN_TERRACOTTA, 8));
        allowedItems.add(new UncraftModel(Material.BLUE_TERRACOTTA, 8));
        allowedItems.add(new UncraftModel(Material.BROWN_TERRACOTTA, 8));
        allowedItems.add(new UncraftModel(Material.PURPLE_TERRACOTTA, 8));
        allowedItems.add(new UncraftModel(Material.GREEN_TERRACOTTA, 8));
        allowedItems.add(new UncraftModel(Material.RED_TERRACOTTA, 8));
        allowedItems.add(new UncraftModel(Material.BLACK_TERRACOTTA, 8));

        // Other Decoration Blocks
        allowedItems.add(new UncraftModel(Material.NETHER_BRICK_FENCE, 6));
        allowedItems.add(new UncraftModel(Material.TORCH, 4));
        allowedItems.add(new UncraftModel(Material.LANTERN, 1));
        allowedItems.add(new UncraftModel(Material.RESPAWN_ANCHOR, 1));
        allowedItems.add(new UncraftModel(Material.ARMOR_STAND, 1));
        allowedItems.add(new UncraftModel(Material.HONEY_BLOCK, 1));
        allowedItems.add(new UncraftModel(Material.FURNACE, 1));
        allowedItems.add(new UncraftModel(Material.CHEST, 1));
        allowedItems.add(new UncraftModel(Material.LADDER, 3));
        allowedItems.add(new UncraftModel(Material.END_CRYSTAL, 1));
        allowedItems.add(new UncraftModel(Material.HONEYCOMB_BLOCK, 1));
        allowedItems.add(new UncraftModel(Material.SNOW, 6));
        allowedItems.add(new UncraftModel(Material.IRON_BARS, 16));
        allowedItems.add(new UncraftModel(Material.SOUL_TORCH, 4));
        allowedItems.add(new UncraftModel(Material.PAINTING, 1));
        allowedItems.add(new UncraftModel(Material.CRAFTING_TABLE, 1));
        allowedItems.add(new UncraftModel(Material.SHULKER_BOX, 1));
        allowedItems.add(new UncraftModel(Material.ITEM_FRAME, 1));
        allowedItems.add(new UncraftModel(Material.SLIME_BLOCK, 1));
        allowedItems.add(new UncraftModel(Material.SCAFFOLDING, 6));
        allowedItems.add(new UncraftModel(Material.ENDER_CHEST, 1));
        allowedItems.add(new UncraftModel(Material.ENCHANTING_TABLE, 1));
        allowedItems.add(new UncraftModel(Material.FLOWER_POT, 1));
        allowedItems.add(new UncraftModel(Material.ANVIL, 1));
        allowedItems.add(new UncraftModel(Material.LODESTONE, 1));
        allowedItems.add(new UncraftModel(Material.CHAIN, 1));
        allowedItems.add(new UncraftModel(Material.END_ROD, 4));
        allowedItems.add(new UncraftModel(Material.CAMPFIRE, 1));
        allowedItems.add(new UncraftModel(Material.SOUL_CAMPFIRE, 1));
        allowedItems.add(new UncraftModel(Material.JUKEBOX, 1));
        allowedItems.add(new UncraftModel(Material.SOUL_LANTERN, 1));
        allowedItems.add(new UncraftModel(Material.BEEHIVE, 1));

        // Other Building Blocks
        allowedItems.add(new UncraftModel(Material.SEA_LANTERN, 1));
        allowedItems.add(new UncraftModel(Material.RED_SANDSTONE, 1));
        allowedItems.add(new UncraftModel(Material.CHISELED_RED_SANDSTONE, 1));
        allowedItems.add(new UncraftModel(Material.CUT_RED_SANDSTONE, 4));
        allowedItems.add(new UncraftModel(Material.MAGMA_BLOCK, 1));
        allowedItems.add(new UncraftModel(Material.NETHER_WART_BLOCK, 1));
        allowedItems.add(new UncraftModel(Material.RED_NETHER_BRICKS, 1));
        allowedItems.add(new UncraftModel(Material.DRIED_KELP_BLOCK, 1));
        allowedItems.add(new UncraftModel(Material.EMERALD_BLOCK, 1));
        allowedItems.add(new UncraftModel(Material.CHISELED_NETHER_BRICKS, 1));
        allowedItems.add(new UncraftModel(Material.POLISHED_BASALT, 4));
        allowedItems.add(new UncraftModel(Material.GLOWSTONE, 1));
        allowedItems.add(new UncraftModel(Material.QUARTZ_PILLAR, 2));
        allowedItems.add(new UncraftModel(Material.PACKED_ICE, 1));
        allowedItems.add(new UncraftModel(Material.CHISELED_RED_SANDSTONE, 1));
        allowedItems.add(new UncraftModel(Material.CLAY, 1));
        allowedItems.add(new UncraftModel(Material.PRISMARINE, 1));
        allowedItems.add(new UncraftModel(Material.CRIMSON_HYPHAE, 3));
        allowedItems.add(new UncraftModel(Material.SANDSTONE, 1));
        allowedItems.add(new UncraftModel(Material.CHISELED_POLISHED_BLACKSTONE, 1));
        allowedItems.add(new UncraftModel(Material.WARPED_HYPHAE, 3));
        allowedItems.add(new UncraftModel(Material.CUT_SANDSTONE, 4));
        allowedItems.add(new UncraftModel(Material.BOOKSHELF, 1));
        allowedItems.add(new UncraftModel(Material.DARK_PRISMARINE, 1));
        allowedItems.add(new UncraftModel(Material.PRISMARINE_BRICKS, 1));
        allowedItems.add(new UncraftModel(Material.HAY_BLOCK, 1));
        allowedItems.add(new UncraftModel(Material.QUARTZ_BLOCK, 1));
        allowedItems.add(new UncraftModel(Material.END_STONE_BRICKS, 4));
        allowedItems.add(new UncraftModel(Material.CHISELED_SANDSTONE, 1));
        allowedItems.add(new UncraftModel(Material.CHISELED_QUARTZ_BLOCK, 1));
        allowedItems.add(new UncraftModel(Material.QUARTZ_BRICKS, 4));
        allowedItems.add(new UncraftModel(Material.GOLD_BLOCK, 1));
        allowedItems.add(new UncraftModel(Material.IRON_BLOCK, 1));
        allowedItems.add(new UncraftModel(Material.REDSTONE_BLOCK, 1));
        allowedItems.add(new UncraftModel(Material.LAPIS_BLOCK, 1));
        allowedItems.add(new UncraftModel(Material.SNOW_BLOCK, 1));
        allowedItems.add(new UncraftModel(Material.DIAMOND_BLOCK, 1));
        allowedItems.add(new UncraftModel(Material.COAL_BLOCK, 1));
        allowedItems.add(new UncraftModel(Material.PURPUR_BLOCK, 4));
        allowedItems.add(new UncraftModel(Material.MOSSY_COBBLESTONE, 1));
        allowedItems.add(new UncraftModel(Material.MOSSY_STONE_BRICKS, 1));
        allowedItems.add(new UncraftModel(Material.STONE_BRICKS, 4));
    }

    public static List<UncraftModel> getAllowedItems() {
        return allowedItems;
    }

    public static void addItemToAllowedItemsList(Material material, int amount) {
        allowedItems.add(new UncraftModel(material, amount));
    }

    public static void clearAllowedItems() {
        allowedItems.clear();
    }

    public void loadItemConfigManager(){
        ItemCfgm = new ItemConfigManager();
        ItemCfgm.setup();
    }

    public void loadMinecraftItemConfigManager(){
        MinecraftItemCfgm = new MinecraftItemConfigManager();
        MinecraftItemCfgm.setup();
    }
}

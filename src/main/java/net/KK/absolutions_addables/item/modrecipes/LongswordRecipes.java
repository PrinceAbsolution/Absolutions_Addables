package net.KK.absolutions_addables.item.modrecipes;

import net.KK.absolutions_addables.Absolutions_addables;
import net.KK.absolutions_addables.item.ModItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class LongswordRecipes {

    public static void addLongswordRecipes(Consumer<FinishedRecipe> writer) {
        createLongswordRecipes(writer);
    }

    private static void createLongswordRecipes(Consumer<FinishedRecipe> writer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.WOODEN_LONGSWORD.get())
                .define('A', ItemTags.PLANKS)
                .define('S', Items.WOODEN_SWORD)
                .pattern("   ")
                .pattern(" A ")
                .pattern("S  ")
                .unlockedBy("has_wooden_sword", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WOODEN_SWORD))
                .save(writer, new ResourceLocation(Absolutions_addables.MODID, "wooden_longsword"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STONE_LONGSWORD.get())
                .define('A', ItemTags.STONE_TOOL_MATERIALS)
                .define('S', Items.STONE_SWORD)
                .pattern("   ")
                .pattern(" A ")
                .pattern("S  ")
                .unlockedBy("has_stone_sword", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STONE_SWORD))
                .save(writer, new ResourceLocation(Absolutions_addables.MODID, "stone_longsword"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.IRON_LONGSWORD.get())
                .define('A', Tags.Items.INGOTS_IRON)
                .define('S', Items.IRON_SWORD)
                .pattern("   ")
                .pattern(" A ")
                .pattern("S  ")
                .unlockedBy("has_iron_sword", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_SWORD))
                .save(writer, new ResourceLocation(Absolutions_addables.MODID, "iron_longsword"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GOLDEN_LONGSWORD.get())
                .define('A', Tags.Items.INGOTS_GOLD)
                .define('S', Items.GOLDEN_SWORD)
                .pattern("   ")
                .pattern(" A ")
                .pattern("S  ")
                .unlockedBy("has_golden_sword", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLDEN_SWORD))
                .save(writer, new ResourceLocation(Absolutions_addables.MODID, "golden_longsword"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DIAMOND_LONGSWORD.get())
                .define('A', Tags.Items.GEMS_DIAMOND)
                .define('S', Items.DIAMOND_SWORD)
                .pattern("   ")
                .pattern(" A ")
                .pattern("S  ")
                .unlockedBy("has_diamond_sword", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIAMOND_SWORD))
                .save(writer, new ResourceLocation(Absolutions_addables.MODID, "diamond_longsword"));

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.of(ModItems.DIAMOND_LONGSWORD.get()),
                Ingredient.of(Items.NETHERITE_INGOT),
                RecipeCategory.TOOLS, ModItems.NETHERITE_LONGSWORD.get())
                .unlocks("has_netherite_ingot",
                        InventoryChangeTrigger.TriggerInstance.hasItems(Items.NETHERITE_INGOT)).save(writer,
                        new ResourceLocation(Absolutions_addables.MODID,
                                "netherite_longsword"));
    }
}
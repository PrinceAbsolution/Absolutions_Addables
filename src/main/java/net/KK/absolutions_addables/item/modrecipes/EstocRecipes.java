package net.KK.absolutions_addables.item.modrecipes;

import net.KK.absolutions_addables.Absolutions_addables;
import net.KK.absolutions_addables.item.ModItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class EstocRecipes {

    public static void addEstocRecipes(Consumer<FinishedRecipe> writer) {

        addEstocRecipe(writer);
    }


    private static void addEstocRecipe(Consumer<FinishedRecipe> writer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.WOODEN_ESTOC.get())
                .define('A', ItemTags.PLANKS)
                .define('S', Tags.Items.RODS_WOODEN)
                .pattern("  A")
                .pattern(" A ")
                .pattern("S  ")
                .unlockedBy("has_stick", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
                .save(writer, new ResourceLocation(Absolutions_addables.MODID, "wooden_estoc"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STONE_ESTOC.get())
                .define('S', Tags.Items.RODS_WOODEN)
                .define('C', ItemTags.STONE_TOOL_MATERIALS)
                .pattern("  C")
                .pattern(" C ")
                .pattern("S  ")
                .unlockedBy("has_cobblestone", InventoryChangeTrigger.TriggerInstance
                        .hasItems(Items.COBBLESTONE))
                .save(writer, new ResourceLocation(Absolutions_addables.MODID, "stone_estoc"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.IRON_ESTOC.get())
                .define('I', Tags.Items.INGOTS_IRON)
                .define('S', Tags.Items.RODS_WOODEN)
                .pattern("  I")
                .pattern(" I ")
                .pattern("S  ")
                .unlockedBy("has_iron_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
                .save(writer, new ResourceLocation(Absolutions_addables.MODID, "iron_estoc"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GOLDEN_ESTOC.get())
                .define('G', Tags.Items.INGOTS_GOLD)
                .define('S', Tags.Items.RODS_WOODEN)
                .pattern("  G")
                .pattern(" G ")
                .pattern("S  ")
                .unlockedBy("has_gold_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
                .save(writer, new ResourceLocation(Absolutions_addables.MODID, "golden_estoc"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DIAMOND_ESTOC.get())
                .define('D', Tags.Items.GEMS_DIAMOND)
                .define('S', Tags.Items.RODS_WOODEN)
                .pattern("  D")
                .pattern(" D ")
                .pattern("S  ")
                .unlockedBy("has_diamond", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIAMOND))
                .save(writer, new ResourceLocation(Absolutions_addables.MODID, "diamond_estoc"));

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.of(ModItems.DIAMOND_ESTOC.get()),
                Ingredient.of(Items.NETHERITE_INGOT),
                RecipeCategory.TOOLS, ModItems.NETHERITE_ESTOC.get())
                .unlocks("has_netherite_ingot",
                    InventoryChangeTrigger.TriggerInstance.hasItems(Items.NETHERITE_INGOT))
                    .save(writer, new ResourceLocation(Absolutions_addables.MODID, "netherite_estoc"));
    }
}

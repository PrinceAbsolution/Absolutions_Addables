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

public class HammerRecipes {

    public static void addHammerRecipes(Consumer<FinishedRecipe> writer) {

        addHammerRecipe(writer);


    }
    private static void addHammerRecipe(Consumer<FinishedRecipe> writer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.WOODEN_HAMMER.get())
                .define('A', ItemTags.PLANKS)
                .define('S', Tags.Items.RODS_WOODEN)
                .pattern("AAA")
                .pattern("ASA")
                .pattern(" S ")
                .unlockedBy("has_stick", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
                .save(writer, new ResourceLocation(Absolutions_addables.MODID, "wooden_hammer"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STONE_HAMMER.get())
                .define('S', Tags.Items.RODS_WOODEN)
                .define('C', ItemTags.STONE_TOOL_MATERIALS)
                .pattern("CCC")
                .pattern("CSC")
                .pattern(" S ")
                .unlockedBy("has_cobblestone", InventoryChangeTrigger.TriggerInstance
                        .hasItems(Items.COBBLESTONE))
                .save(writer, new ResourceLocation(Absolutions_addables.MODID, "stone_hammer"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.IRON_HAMMER.get())
                .define('I', Tags.Items.INGOTS_IRON)
                .define('S', Tags.Items.RODS_WOODEN)
                .pattern("III")
                .pattern("ISI")
                .pattern(" S ")
                .unlockedBy("has_iron_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
                .save(writer, new ResourceLocation(Absolutions_addables.MODID, "iron_hammer"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GOLDEN_HAMMER.get())
                .define('G', Tags.Items.INGOTS_GOLD)
                .define('S', Tags.Items.RODS_WOODEN)
                .pattern("GGG")
                .pattern("GSG")
                .pattern(" S ")
                .unlockedBy("has_gold_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
                .save(writer, new ResourceLocation(Absolutions_addables.MODID, "golden_hammer"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DIAMOND_HAMMER.get())
                .define('D', Tags.Items.GEMS_DIAMOND)
                .define('S', Tags.Items.RODS_WOODEN)
                .pattern("DDD")
                .pattern("DSD")
                .pattern(" S ")
                .unlockedBy("has_diamond", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIAMOND))
                .save(writer, new ResourceLocation(Absolutions_addables.MODID, "diamond_hammer"));

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.of(ModItems.DIAMOND_HAMMER.get()),
                Ingredient.of(Items.NETHERITE_INGOT),
                RecipeCategory.TOOLS, ModItems.NETHERITE_HAMMER.get())
                .unlocks("has_netherite_ingot",
                    InventoryChangeTrigger.TriggerInstance.hasItems(Items.NETHERITE_INGOT))
                    .save(writer, new ResourceLocation(Absolutions_addables.MODID, "netherite_hammer"));
    }
}

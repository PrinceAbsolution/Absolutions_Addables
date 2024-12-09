package net.KK.absolutions_addables.datagen;

import net.KK.absolutions_addables.Absolutions_addables;
import net.KK.absolutions_addables.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmithingRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.common.data.ForgeItemTagsProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.WOODEN_LONGSWORD.get())
                .define('A', ItemTags.PLANKS)
                .define('S', Items.WOODEN_SWORD)
                .pattern("   ")
                .pattern(" A ")
                .pattern("S  ")
                .unlockedBy("has_wooden_sword", has(Items.WOODEN_SWORD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STONE_LONGSWORD.get())
                .define('A', ItemTags.STONE_TOOL_MATERIALS)
                .define('S', Items.STONE_SWORD)
                .pattern("   ")
                .pattern(" A ")
                .pattern("S  ")
                .unlockedBy("has_stone_sword", has(Items.STONE_SWORD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.IRON_LONGSWORD.get())
                .define('A', Items.IRON_INGOT)
                .define('S', Items.IRON_SWORD)
                .pattern("   ")
                .pattern(" A ")
                .pattern("S  ")
                .unlockedBy("has_iron_sword", has(Items.IRON_SWORD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GOLDEN_LONGSWORD.get())
                .define('A', Items.GOLD_INGOT)
                .define('S', Items.GOLDEN_SWORD)
                .pattern("   ")
                .pattern(" A ")
                .pattern("S  ")
                .unlockedBy("has_golden_sword", has(Items.GOLDEN_SWORD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DIAMOND_LONGSWORD.get())
                .define('A', Items.DIAMOND)
                .define('S', Items.DIAMOND_SWORD)
                .pattern("   ")
                .pattern(" A ")
                .pattern("S  ")
                .unlockedBy("has_diamond_sword", has(Items.DIAMOND_SWORD))
                .save(pWriter);

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(ModItems.DIAMOND_LONGSWORD.get()),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        RecipeCategory.TOOLS, ModItems.NETHERITE_LONGSWORD.get())
                .unlocks("has_netherite_ingot",
                        has(Items.NETHERITE_INGOT)).save(pWriter,
                        new ResourceLocation(Absolutions_addables.MODID,
                                getItemName(ModItems.NETHERITE_LONGSWORD.get()) + "_smithing"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.WOODEN_ESTOC.get())
                .define('A', ItemTags.PLANKS)
                .define('S', Tags.Items.RODS_WOODEN)
                .pattern("  A")
                .pattern(" A ")
                .pattern("S  ")
                .unlockedBy("has_wooden_sword", has(Items.WOODEN_SWORD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STONE_ESTOC.get())
                .define('A', ItemTags.STONE_TOOL_MATERIALS)
                .define('S', Tags.Items.RODS_WOODEN)
                .pattern("  A")
                .pattern(" A ")
                .pattern("S  ")
                .unlockedBy("has_stone_sword", has(Items.STONE_SWORD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.IRON_ESTOC.get())
                .define('A', Items.IRON_INGOT)
                .define('S', Tags.Items.RODS_WOODEN)
                .pattern("  A")
                .pattern(" A ")
                .pattern("S  ")
                .unlockedBy("has_iron_sword", has(Items.IRON_SWORD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GOLDEN_ESTOC.get())
                .define('A', Items.GOLD_INGOT)
                .define('S', Tags.Items.RODS_WOODEN)
                .pattern("  A")
                .pattern(" A ")
                .pattern("S  ")
                .unlockedBy("has_golden_sword", has(Items.GOLDEN_SWORD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DIAMOND_ESTOC.get())
                .define('A', Items.DIAMOND)
                .define('S', Tags.Items.RODS_WOODEN)
                .pattern("  A")
                .pattern(" A ")
                .pattern("S  ")
                .unlockedBy("has_diamond_sword", has(Items.DIAMOND_SWORD))
                .save(pWriter);

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(ModItems.DIAMOND_ESTOC.get()),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        RecipeCategory.TOOLS,
                        ModItems.NETHERITE_ESTOC.get())
                .unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT))
                .save(pWriter, new ResourceLocation(Absolutions_addables.MODID,
                        getItemName(ModItems.NETHERITE_ESTOC.get()) + "_smithing"));
    }


    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult, pExperience, pCookingTime,
                    pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  Absolutions_addables.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}

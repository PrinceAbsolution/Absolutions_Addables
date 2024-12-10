package net.KK.absolutions_addables.datagen;

import net.KK.absolutions_addables.Absolutions_addables;
import net.KK.absolutions_addables.item.modrecipes.EstocRecipes;
import net.KK.absolutions_addables.item.modrecipes.HammerRecipes;
import net.KK.absolutions_addables.item.modrecipes.LongswordRecipes;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        HammerRecipes.addHammerRecipes(pWriter);
        LongswordRecipes.addLongswordRecipes(pWriter);
        EstocRecipes.addEstocRecipes(pWriter);

    }
}

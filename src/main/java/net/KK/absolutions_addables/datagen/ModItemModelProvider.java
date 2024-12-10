package net.KK.absolutions_addables.datagen;

import net.KK.absolutions_addables.Absolutions_addables;
import net.KK.absolutions_addables.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Absolutions_addables.MODID, existingFileHelper);
    }


    @Override
    protected void registerModels() {

        // Hammers
        hammerItem(ModItems.WOODEN_HAMMER);
        hammerItem(ModItems.STONE_HAMMER);
        hammerItem(ModItems.IRON_HAMMER);
        hammerItem(ModItems.GOLDEN_HAMMER);
        hammerItem(ModItems.DIAMOND_HAMMER);
        hammerItem(ModItems.NETHERITE_HAMMER);

        // Estocs
        estocItem(ModItems.WOODEN_ESTOC);
        estocItem(ModItems.STONE_ESTOC);
        estocItem(ModItems.IRON_ESTOC);
        estocItem(ModItems.GOLDEN_ESTOC);
        estocItem(ModItems.DIAMOND_ESTOC);
        estocItem(ModItems.NETHERITE_ESTOC);

        // Longswords
        longswordItem(ModItems.WOODEN_LONGSWORD);
        longswordItem(ModItems.STONE_LONGSWORD);
        longswordItem(ModItems.IRON_LONGSWORD);
        longswordItem(ModItems.GOLDEN_LONGSWORD);
        longswordItem(ModItems.DIAMOND_LONGSWORD);
        longswordItem(ModItems.NETHERITE_LONGSWORD);

    }



    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Absolutions_addables.MODID,"item/" + item.getId().getPath()));
    }
    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(Absolutions_addables.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(Absolutions_addables.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(Absolutions_addables.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Absolutions_addables.MODID, "item/" + item.getId().getPath()));
    }
    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Absolutions_addables.MODID,"item/" + item.getId().getPath()));
    }
    private ItemModelBuilder hammerItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation(Absolutions_addables.MODID, "item/hammer"))
                .texture("0", new ResourceLocation(Absolutions_addables.MODID, "item/" + item.getId().getPath()))
                .texture("particle", new ResourceLocation(Absolutions_addables.MODID, "item/" + item.getId().getPath()));
    }
    private ItemModelBuilder estocItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation(Absolutions_addables.MODID, "item/estoc"))
                .texture("0", new ResourceLocation(Absolutions_addables.MODID, "item/" + item.getId().getPath()))
                .texture("particle", new ResourceLocation(Absolutions_addables.MODID, "item/" + item.getId().getPath()));
    }
    private ItemModelBuilder longswordItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation(Absolutions_addables.MODID, "item/longsword"))
                .texture("0", new ResourceLocation(Absolutions_addables.MODID, "item/" + item.getId().getPath()))
                .texture("particle", new ResourceLocation(Absolutions_addables.MODID, "item/" + item.getId().getPath()));
    }


}

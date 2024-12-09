package net.KK.absolutions_addables.item;

import net.KK.absolutions_addables.Absolutions_addables;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Absolutions_addables.MODID);

    public static final RegistryObject<Item> WOODEN_LONGSWORD = ITEMS.register("wooden_longsword",
            () -> new SwordItem(Tiers.WOOD, 4, -2.8f, new Item.Properties().durability(59)));
    public static final RegistryObject<Item> STONE_LONGSWORD = ITEMS.register("stone_longsword",
            () -> new SwordItem(Tiers.STONE, 4, -2.8f, new Item.Properties().durability(131)));
    public static final RegistryObject<Item> IRON_LONGSWORD = ITEMS.register("iron_longsword",
            () -> new SwordItem(Tiers.IRON, 4, -2.8f, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> GOLDEN_LONGSWORD = ITEMS.register("golden_longsword",
            () -> new SwordItem(Tiers.GOLD, 4, -2.8f, new Item.Properties().durability(32)));
    public static final RegistryObject<Item> DIAMOND_LONGSWORD = ITEMS.register("diamond_longsword",
            () -> new SwordItem(Tiers.DIAMOND, 4, -2.8f, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> NETHERITE_LONGSWORD = ITEMS.register("netherite_longsword",
            () -> new SwordItem(Tiers.NETHERITE, 4, -2.8f, new Item.Properties().durability(2031)));

    public static final RegistryObject<Item> WOODEN_ESTOC = ITEMS.register("wooden_estoc",
            () -> new SwordItem(Tiers.WOOD, 2, -2.1f, new Item.Properties().durability(59)));
    public static final RegistryObject<Item> STONE_ESTOC = ITEMS.register("stone_estoc",
            () -> new SwordItem(Tiers.STONE, 2, -2.1f, new Item.Properties().durability(131)));
    public static final RegistryObject<Item> IRON_ESTOC = ITEMS.register("iron_estoc",
            () -> new SwordItem(Tiers.IRON, 2, -2.1f, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> GOLDEN_ESTOC = ITEMS.register("golden_estoc",
            () -> new SwordItem(Tiers.GOLD, 2, -2.1f, new Item.Properties().durability(32)));
    public static final RegistryObject<Item> DIAMOND_ESTOC = ITEMS.register("diamond_estoc",
            () -> new SwordItem(Tiers.DIAMOND, 2, -2.1f, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> NETHERITE_ESTOC = ITEMS.register("netherite_estoc",
            () -> new SwordItem(Tiers.NETHERITE, 2, -2.1f, new Item.Properties().durability(2031)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

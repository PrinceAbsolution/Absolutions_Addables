package net.KK.absolutions_addables.item;

import net.KK.absolutions_addables.Absolutions_addables;
import net.KK.absolutions_addables.item.custom.HammerItem;
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

    public static final RegistryObject<Item> WOODEN_HAMMER = ITEMS.register("wooden_hammer",
            () -> new HammerItem(Tiers.WOOD, 3.5f, -2.6f, new Item.Properties().durability(177)));
    public static final RegistryObject<Item> STONE_HAMMER = ITEMS.register("stone_hammer",
            () -> new HammerItem(Tiers.STONE, 3.5f, -2.6f, new Item.Properties().durability(393)));
    public static final RegistryObject<Item> IRON_HAMMER = ITEMS.register("iron_hammer",
            () -> new HammerItem(Tiers.IRON, 3.5f, -2.6f, new Item.Properties().durability(768)));
    public static final RegistryObject<Item> GOLDEN_HAMMER = ITEMS.register("golden_hammer",
            () -> new HammerItem(Tiers.GOLD, 3.5f, -2.6f, new Item.Properties().durability(96)));
    public static final RegistryObject<Item> DIAMOND_HAMMER = ITEMS.register("diamond_hammer",
            () -> new HammerItem(Tiers.DIAMOND, 3.5f, -2.6f, new Item.Properties().durability(4683)));
    public static final RegistryObject<Item> NETHERITE_HAMMER = ITEMS.register("netherite_hammer",
            () -> new HammerItem(Tiers.NETHERITE, 3.5f, -2.6f, new Item.Properties().durability(6093)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

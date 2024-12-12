package net.KK.absolutions_addables.item;

import net.KK.absolutions_addables.Absolutions_addables;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Absolutions_addables.MODID);

    public static final RegistryObject<CreativeModeTab> WEAPONS = CREATIVE_MODE_TABS.register("weapons",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.IRON_LONGSWORD.get()))
                    .title(Component.translatable("Weapons"))
                    .displayItems((displayParameters, output) -> {

                        output.accept(ModItems.WOODEN_ESTOC.get());
                        output.accept(ModItems.STONE_ESTOC.get());
                        output.accept(ModItems.IRON_ESTOC.get());
                        output.accept(ModItems.GOLDEN_ESTOC.get());
                        output.accept(ModItems.DIAMOND_ESTOC.get());
                        output.accept(ModItems.NETHERITE_ESTOC.get());

                        output.accept(ModItems.WOODEN_LONGSWORD.get());
                        output.accept(ModItems.STONE_LONGSWORD.get());
                        output.accept(ModItems.IRON_LONGSWORD.get());
                        output.accept(ModItems.GOLDEN_LONGSWORD.get());
                        output.accept(ModItems.DIAMOND_LONGSWORD.get());
                        output.accept(ModItems.NETHERITE_LONGSWORD.get());

                        output.accept(ModItems.WOODEN_HAMMER.get());
                        output.accept(ModItems.STONE_HAMMER.get());
                        output.accept(ModItems.IRON_HAMMER.get());
                        output.accept(ModItems.GOLDEN_HAMMER.get());
                        output.accept(ModItems.DIAMOND_HAMMER.get());
                        output.accept(ModItems.NETHERITE_HAMMER.get());

                        output.accept(ModItems.TEST_WEAPON.get());

                    }).build());





    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

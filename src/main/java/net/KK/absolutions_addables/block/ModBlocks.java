package net.KK.absolutions_addables.block;

import net.KK.absolutions_addables.Absolutions_addables;
import net.minecraft.world.level.block.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Absolutions_addables.MODID);





    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

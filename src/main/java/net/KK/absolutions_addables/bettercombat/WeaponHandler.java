package net.KK.absolutions_addables.bettercombat;

import net.bettercombat.api.WeaponAttributes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;

public class WeaponHandler {

    public static WeaponAttributes getWeaponAttributes(ItemStack weaponStack) {
        // Get the registry name (ID) of the item

        if (weaponStack != null) {
            // Fetch custom attributes from your custom weapon registry
            return CustomWeaponRegistry.getAttributes(weaponStack);
        }
        return null; // Return null if the item isn't registered
    }

    public static ResourceLocation getWeaponId(ItemStack weaponStack) {
        // Get ResourceLocation (registry name) via BuiltInRegistries API
        return BuiltInRegistries.ITEM.getKey(weaponStack.getItem());
    }
}
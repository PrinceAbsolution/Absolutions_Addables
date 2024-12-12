package net.KK.absolutions_addables.bettercombat;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.bettercombat.api.WeaponAttributes;
import net.bettercombat.logic.WeaponRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class CustomWeaponRegistry extends WeaponRegistry {

    public static BonusWeaponAttributes getBonusAttributes(ItemStack weaponStack) {
        // Ensure weaponStack is not null or empty
        if (weaponStack == null || weaponStack.isEmpty()) {
            return null;
        }

        // Load weapon config JSON using the ItemStack
        JsonObject weaponConfig = getWeaponJson(weaponStack);
        if (weaponConfig != null) {
            // Retrieve base WeaponAttributes from the parent WeaponRegistry
            WeaponAttributes baseAttributes = WeaponRegistry.getAttributes(weaponStack);

            // Ensure base attributes exist before parsing
            if (baseAttributes != null) {
                // Parse additional attributes like bonus_damage from the config
                return BonusWeaponAttributesParser.parse(weaponConfig);
            }
        }

        return null;
    }

    public static double getBonusDamage(ItemStack weaponStack) {
        // Fetch attributes and extract bonus damage
        BonusWeaponAttributes attributes = getBonusAttributes(weaponStack);
        return attributes != null ? attributes.getBonusDamage() : 0.0;
    }

    public static JsonObject getWeaponJson(ItemStack weaponStack) {
        // Retrieve the ResourceLocation of the item
        ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(weaponStack.getItem());
        if (itemId == null) {
            return null;
        }

        try {
            // Construct the resource path based on the `data` folder structure
            String resourcePath = "/data/" + itemId.getNamespace() + "/weapon_attributes/" + itemId.getPath() + ".json";

            // Attempt to load the JSON file as an InputStream
            InputStream inputStream = CustomWeaponRegistry.class.getResourceAsStream(resourcePath);
            if (inputStream != null) {
                // Parse the file into a JsonObject
                return JsonParser.parseReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).getAsJsonObject();
            }
        } catch (Exception e) {
            System.err.println("Failed to load weapon JSON for: " + itemId);
            e.printStackTrace();
        }

        // Return null if the JSON could not be found or loaded
        return null;
    }
}
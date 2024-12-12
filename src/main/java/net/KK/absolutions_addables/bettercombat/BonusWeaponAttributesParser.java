package net.KK.absolutions_addables.bettercombat;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.bettercombat.api.WeaponAttributes;

public class BonusWeaponAttributesParser {
    private static final Gson GSON = new Gson();

    public static BonusWeaponAttributes parse(JsonObject weaponJson) {
        if (weaponJson == null) {
            throw new IllegalArgumentException("weaponJson cannot be null");
        }

        // Parse base WeaponAttributes using Gson
        WeaponAttributes baseAttributes = GSON.fromJson(weaponJson.get("attributes"), WeaponAttributes.class);

        // Parse the custom "bonus_damage" value
        double bonusDamage = 0.0;
        JsonObject attributes = weaponJson.getAsJsonObject("attributes");
        if (attributes == null) {
            throw new IllegalArgumentException("'attributes' cannot be null in weaponJson");
        }
        if (attributes.has("bonus_damage")) {
            bonusDamage = attributes.get("bonus_damage").getAsDouble();
        }

        // Wrap the base WeaponAttributes with the new bonus damage
        return new BonusWeaponAttributes(baseAttributes, bonusDamage);
    }
}
package net.KK.absolutions_addables.bettercombat;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.bettercombat.api.AttributesContainer;
import net.bettercombat.api.WeaponAttributesHelper;

import java.io.Reader;
import java.io.StringReader;

public class CustomAttributesLoader {


    public static CustomWeaponAttributesContainer parseCustomAttributes(Reader jsonReader) {
        try {
            // Step 1: Parse JSON file into a JsonObject
            JsonObject jsonObject = JsonParser.parseReader(jsonReader).getAsJsonObject();


            // Step 2: Convert the JsonObject back into a string and then a new Reader
            String jsonString = jsonObject.toString();
            Reader newJsonReader = new StringReader(jsonString);

            // Step 3: Decode base AttributesContainer using WeaponAttributesHelper
            AttributesContainer baseContainer = WeaponAttributesHelper.decode(newJsonReader);
            // Step 4: Extract extraDamage from the JsonObject (default to 0.0 if not present)
                double extraDamage = 0.0; // Default value
                if (jsonObject.has("attributes") && jsonObject.getAsJsonObject("attributes").has("bonus_damage")) {
                    extraDamage = jsonObject.getAsJsonObject("attributes").get("bonus_damage").getAsDouble();
                }

                // Step 5: Wrap the base container and custom data into CustomWeaponAttributesContainer
                return new CustomWeaponAttributesContainer(baseContainer, extraDamage);
        } catch (Exception e) {
            System.err.println("Failed to parse custom attributes: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}

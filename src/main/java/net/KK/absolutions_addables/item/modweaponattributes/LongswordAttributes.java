package net.KK.absolutions_addables.item.modweaponattributes;

import com.google.gson.JsonObject;
import net.KK.absolutions_addables.datagen.WeaponAttributeFileProvider;
import net.minecraft.resources.ResourceLocation;
import java.util.function.Consumer;

public class LongswordAttributes {

    public static void addLongswordAttributes(Consumer<WeaponAttributeFileProvider.FinishedFile> writer) {
        // Define the tiers for longswords
        String[] tiers = {"wooden", "stone", "iron", "golden", "diamond", "netherite"};

        // Iterate over each tier
        for (String tier : tiers) {
            JsonObject longswordJson = new JsonObject();
            longswordJson.addProperty("parent", "absolutions_addables:longsword");
            // Add additional attributes specific to longsword if needed

            // Set the ResourceLocation using the tier for differentiation
            ResourceLocation id = new ResourceLocation("absolutions_addables", tier + "_longsword" );

            // Write the file for each tier
            writer.accept(new WeaponAttributeFileProvider.FinishedFile(id, longswordJson));
        }
    }
}
package net.KK.absolutions_addables.item.modweaponattributes;

import com.google.gson.JsonObject;
import net.KK.absolutions_addables.datagen.WeaponAttributeFileProvider;
import net.minecraft.resources.ResourceLocation;
import java.util.function.Consumer;

public class EstocAttributes {

    public static void addEstocAttributes(Consumer<WeaponAttributeFileProvider.FinishedFile> writer) {
        // Define the tiers you want to create attributes for
        String[] tiers = {"wooden", "stone", "iron", "golden", "diamond", "netherite"};

        // Iterate over each tier to create a separate file
        for (String tier : tiers) {
            JsonObject estocJson = new JsonObject();
            estocJson.addProperty("parent", "absolutions_addables:estoc");
            // Add additional properties specific to each tier if needed

            // Create a resource location with the tier included in the path for uniqueness
            ResourceLocation id = new ResourceLocation("absolutions_addables", tier + "_estoc");

            // Write the file
            writer.accept(new WeaponAttributeFileProvider.FinishedFile(id, estocJson));
        }
    }
}
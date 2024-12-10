package net.KK.absolutions_addables.item.modweaponattributes;

import com.google.gson.JsonObject;
import net.KK.absolutions_addables.datagen.WeaponAttributeFileProvider;
import net.minecraft.resources.ResourceLocation;
import java.util.function.Consumer;

public class HammerAttributes {

    public static void addHammerAttributes(Consumer<WeaponAttributeFileProvider.FinishedFile> writer) {
        // Define the tiers for hammers
        String[] tiers = {"wooden", "stone", "iron", "golden", "diamond", "netherite"};

        // Iterate over each tier
        for (String tier : tiers) {
            JsonObject hammerJson = new JsonObject();
            hammerJson.addProperty("parent", "absolutions_addables:hammer");
            // Add additional attributes specific to hammers if necessary

            // Define ResourceLocation with the tier suffix
            ResourceLocation id = new ResourceLocation("absolutions_addables", tier + "_hammer" );

            // Write the specific tier file
            writer.accept(new WeaponAttributeFileProvider.FinishedFile(id, hammerJson));
        }
    }
}
package net.KK.absolutions_addables.datagen;

import com.google.gson.JsonObject;
import net.KK.absolutions_addables.item.modweaponattributes.EstocAttributes;
import net.KK.absolutions_addables.item.modweaponattributes.HammerAttributes;
import net.KK.absolutions_addables.item.modweaponattributes.LongswordAttributes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.data.PackOutput;
import java.util.function.Consumer;

public class ModWeaponAttributeProvider extends WeaponAttributeFileProvider {

    public ModWeaponAttributeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildFiles(Consumer<FinishedFile> writer) {
        JsonObject exampleJson = new JsonObject();
         // Add Estoc attributes
        EstocAttributes.addEstocAttributes(writer);

        // Add Hammer attributes
        HammerAttributes.addHammerAttributes(writer);

        // Add Longsword attributes
        LongswordAttributes.addLongswordAttributes(writer);

    }
}
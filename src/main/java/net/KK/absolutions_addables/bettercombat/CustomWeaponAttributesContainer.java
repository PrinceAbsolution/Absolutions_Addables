package net.KK.absolutions_addables.bettercombat;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.bettercombat.api.AttributesContainer;
import net.bettercombat.api.WeaponAttributes;
import net.bettercombat.api.WeaponAttributesHelper;

import java.io.Reader;

public class CustomWeaponAttributesContainer {

    private final AttributesContainer baseContainer;

    private double extraDamage;

    public CustomWeaponAttributesContainer(AttributesContainer baseContainer, double extraDamage) {
        this.baseContainer = baseContainer; // Wrapping existing AttributesContainer
        this.extraDamage = extraDamage;
    }

    public AttributesContainer getBaseContainer() {
        return baseContainer;
    }

    public double getExtraDamage() {
        return extraDamage;
    }

    public void setExtraDamage(double extraDamage) {
        this.extraDamage = extraDamage;
    }

    @Override
    public String toString() {
        return "CustomWeaponAttributesContainer [extraDamage=" + extraDamage
                + ", baseContainer=" + baseContainer.toString() + "]";
    }
}

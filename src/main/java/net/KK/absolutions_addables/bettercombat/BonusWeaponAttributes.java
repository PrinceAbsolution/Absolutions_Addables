package net.KK.absolutions_addables.bettercombat;

import net.bettercombat.api.WeaponAttributes;

public final class BonusWeaponAttributes {
    private final WeaponAttributes baseAttributes;
    private final double bonusDamage;

    public BonusWeaponAttributes(WeaponAttributes baseAttributes, double bonusDamage) {
        this.baseAttributes = baseAttributes;
        this.bonusDamage = bonusDamage;
    }

    public WeaponAttributes getBaseAttributes() {
        return baseAttributes;
    }

    public double getBonusDamage() {
        return bonusDamage;
    }

    public double getAttackRange() {
        return baseAttributes.attackRange();
    }

    public boolean isTwoHanded() {
        return baseAttributes.isTwoHanded();
    }

    // Other passthrough methods can be added as needed.
}
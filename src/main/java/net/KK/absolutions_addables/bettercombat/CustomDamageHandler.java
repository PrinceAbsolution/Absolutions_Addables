package net.KK.absolutions_addables.bettercombat;
import com.google.gson.JsonObject;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.bettercombat.api.WeaponAttributes;
import net.bettercombat.api.WeaponAttributesHelper;

public class CustomDamageHandler {

    @SubscribeEvent
    public static void onLivingHurtEvent(LivingHurtEvent event) {
        // Ensure the attacker is a player
        if (!(event.getSource().getEntity() instanceof Player player)) {
            return; // Exit if the attacker isn't a Player
        }


        // Get the weapon used by the player
        ItemStack weaponStack = player.getMainHandItem(); // Main hand item
        if (weaponStack.isEmpty()) {
            return; // Exit if no weapon is held
        }

        // Load the weapon's JSON configuration
        JsonObject weaponConfig = CustomWeaponRegistry.getWeaponJson(weaponStack);
        if (weaponConfig == null) {
            System.out.println("No JSON config found for weapon: " + weaponStack.getItem());
            return;
        }

        // Parse attributes, including bonus damage, with error handling
        BonusWeaponAttributes attributes;
        try {
            attributes = BonusWeaponAttributesParser.parse(weaponConfig);
        } catch (Exception e) {
            System.err.println("Error parsing weapon attributes: " + e.getMessage());
            return;
        }

        // Get and apply the bonus damage
        double bonusDamage = attributes.getBonusDamage(); // Avoid redundant parsing
        if (bonusDamage > 0) {
            event.setAmount((float) (event.getAmount() + bonusDamage));
            System.out.println("Applied bonus damage: " + bonusDamage);
        }
    }
}
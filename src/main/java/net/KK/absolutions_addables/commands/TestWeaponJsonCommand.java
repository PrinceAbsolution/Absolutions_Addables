package net.KK.absolutions_addables.commands;

import com.google.gson.JsonObject;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.KK.absolutions_addables.bettercombat.CustomWeaponRegistry;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

public class TestWeaponJsonCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("test_weapon_json").executes(TestWeaponJsonCommand::run));
    }

    private static int run(CommandContext<CommandSourceStack> context) {
        CommandSourceStack source = context.getSource();

        // Get the player executing the command
        if (source.getEntity() instanceof net.minecraft.world.entity.player.Player player) {
            ItemStack weaponStack = player.getMainHandItem(); // Main hand item
            JsonObject weaponConfig = CustomWeaponRegistry.getWeaponJson(weaponStack);

            if (weaponConfig != null) {
                source.sendSuccess(() -> Component.nullToEmpty("Weapon JSON loaded: " + weaponConfig.toString()), false);
            } else {
                source.sendFailure(Component.nullToEmpty("Weapon JSON not found for: " + weaponStack.getItem()));
            }
            return 1; // Success
        }

        source.sendFailure(Component.nullToEmpty("Command must be run by a player!"));
        return 0; // Failed execution
    }
}
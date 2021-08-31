package org.jadestudios.plugins.lifis;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Player;

public class Utils {

    public void modifyHealth(Player player, Double amount) {
        AttributeInstance instance = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        AttributeModifier modifier = new AttributeModifier("generic.max_health", amount, AttributeModifier.Operation.ADD_NUMBER);
        assert instance != null;
        instance.addModifier(modifier);
    }

    public double getHealth(Player player) {
        AttributeInstance healthModifier = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        assert healthModifier != null;
        return healthModifier.getValue();
    }

    public void setHealth(Player player, Double amount) {
        AttributeInstance health = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        health.setBaseValue(amount);
        return;
    }
}

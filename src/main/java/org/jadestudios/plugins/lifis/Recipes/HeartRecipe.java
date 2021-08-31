package org.jadestudios.plugins.lifis.Recipes;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.jadestudios.plugins.lifis.Lifis;

public class HeartRecipe {

    public ShapedRecipe heartRecipe(Lifis plugin) {
        ItemStack heart = new ItemStack(Material.CLAY_BALL);
        ItemMeta heartMeta = heart.getItemMeta();

        heartMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "EXTRA HEART");
        heartMeta.addEnchant(Enchantment.LOYALTY, 1, false);
        heartMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        heart.setItemMeta(heartMeta);

        NamespacedKey key = new NamespacedKey(plugin, "extra_heart");

        ShapedRecipe recipe = new ShapedRecipe(key, heart);

        recipe.shape("OGO", "GDG", "OGO");

        recipe.setIngredient('O', Material.OBSIDIAN);
        recipe.setIngredient('G', Material.GLASS);
        recipe.setIngredient('D', Material.DIAMOND);

        return recipe;
    }

}

package com.theonlytails.craftingrecipes

import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.level.ItemLike

/**
 * Adds [items][ItemLike] to a shapeless recipe.
 *
 * @author TheOnlyTails
 */
@CraftingRecipes
fun Shapeless.requires(vararg ingredients: Pair<Int, ItemLike>) = this.apply {
	ingredients.forEach { requires(it.second, it.first) }
}

/**
 * Adds [item ingredients][Ingredient] to a shapeless recipe.
 *
 * @author TheOnlyTails
 */
@CraftingRecipes
@JvmName("requiresIngredient")
fun Shapeless.requires(vararg ingredients: Pair<Int, Ingredient>): Shapeless = this.apply {
	ingredients.forEach { requires(it.second, it.first) }
}
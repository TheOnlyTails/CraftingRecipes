package com.theonlytails.craftingrecipes

import net.minecraft.advancements.CriterionTriggerInstance
import net.minecraft.data.recipes.RecipeBuilder

/**
 * Adds a crafting recipe to a group.
 * To add a custom group to a recipe, use [RecipeBuilder#group][net.minecraft.data.recipes.RecipeBuilder.group] instead.
 *
 * @receiver A [RecipeBuilder] for either [Shaped], [Shapeless], [Cooking] or [Stonecutting] recipes.
 * @author TheOnlyTails
 */
@CraftingRecipes
inline fun <reified RECIPE : RecipeBuilder> RECIPE.group(group: RecipeGroup) = apply {
	when (this) {
		is Shaped -> group(group.name.lowercase())
		is Shapeless -> group(group.name.lowercase())
		is Cooking -> group(group.name.lowercase())
		is Stonecutting -> group(group.name.lowercase())
		else -> throw IllegalStateException("Can't group this type of recipe!")
	}
}

/**
 * Adds an unlock advancement to a recipe.
 *
 * @receiver A [RecipeBuilder] for either [Shaped], [Shapeless], [Cooking], [Smithing] or [Stonecutting] recipes.
 * @author TheOnlyTails
 */
@CraftingRecipes
inline fun <reified RECIPE : RecipeBuilder> RECIPE.unlockedBy(advancement: Pair<String, CriterionTriggerInstance>) = apply {
	when (this) {
		is Shaped -> unlockedBy(advancement.first, advancement.second)
		is Shapeless -> unlockedBy(advancement.first, advancement.second)
		is Cooking -> unlockedBy(advancement.first, advancement.second)
		is Smithing -> unlocks(advancement.first, advancement.second)
		is Stonecutting -> unlockedBy(advancement.first, advancement.second)
		else -> throw IllegalStateException("Can't group this type of recipe!")
	}
}
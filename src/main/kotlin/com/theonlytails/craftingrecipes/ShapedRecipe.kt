package com.theonlytails.craftingrecipes

import net.minecraft.tags.Tag
import net.minecraft.world.item.Item
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.level.ItemLike

/**
 * Adds between 1 to 3 pattern lines to a shaped recipe.
 *
 * @throws IllegalArgumentException if there are less than 1/more than 3 lines of pattern.
 * @see multilinePattern
 * @author TheOnlyTails
 */
@CraftingRecipes
fun Shaped.pattern(vararg patternLines: String) = apply {
	if (patternLines.size in 1..3) patternLines.forEach { pattern(it) }
	else throw IllegalArgumentException("Number of lines in pattern out of range: $patternLines")
}

/**
 * Adds between 1 to 3 pattern lines using a multiline string to a shaped recipe.
 *
 * @throws IllegalArgumentException if there are less than 1/more than 3 lines of pattern.
 * @see multilinePattern
 * @author TheOnlyTails
 */
@CraftingRecipes
fun Shaped.multilinePattern(patternLines: String) = apply {
	val splitPatternLines = patternLines.split("\n")

	if (splitPatternLines.size in 1..3) splitPatternLines.forEach { pattern(it) }
	else throw IllegalArgumentException("Number of lines in pattern out of range: $patternLines")
}

/**
 * Adds a 3x3 square pattern to a shaped recipe.
 *
 * @param key sets the key to be used in the square pattern.
 * @author TheOnlyTails
 */
@CraftingRecipes
fun Shaped.bigSquarePattern(key: Char) = multilinePattern("""
	$key$key$key
	$key$key$key
	$key$key$key
""".trimIndent())

/**
 * Adds a 2x2 square pattern to a shaped recipe.
 *
 * @param key sets the key to be used in the square pattern.
 * @author TheOnlyTails
 */
@CraftingRecipes
fun Shaped.smallSquarePattern(key: Char) = multilinePattern("""
	$key$key
	$key$key
""".trimIndent())

/**
 * Defines [item][ItemLike] keys for a shaped recipe.
 *
 * @author TheOnlyTails
 */
@CraftingRecipes
fun Shaped.define(vararg ingredients: Pair<Char, ItemLike>) = apply {
	ingredients.forEach { define(it.first, it.second) }
}

/**
 * Defines [item tag][Tag] keys for a shaped recipe.
 *
 * @author TheOnlyTails
 */
@CraftingRecipes
@JvmName("defineTags")
fun Shaped.define(vararg ingredients: Pair<Char, Tag<Item>>) = apply {
	ingredients.forEach { define(it.first, it.second) }
}

/**
 * Defines [ingredient][Ingredient] keys for a shaped recipe.
 *
 * @author TheOnlyTails
 */
@CraftingRecipes
@JvmName("defineIngredients")
fun Shaped.define(vararg ingredients: Pair<Char, Ingredient>) = apply {
	ingredients.forEach { define(it.first, it.second) }
}
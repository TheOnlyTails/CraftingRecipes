package com.theonlytails.craftingrecipes

import net.minecraft.data.recipes.*
import net.minecraft.data.recipes.ShapedRecipeBuilder.shaped
import net.minecraft.data.recipes.ShapelessRecipeBuilder.shapeless
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder.cooking
import net.minecraft.data.recipes.SingleItemRecipeBuilder.stonecutting
import net.minecraft.data.recipes.UpgradeRecipeBuilder.smithing
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.Tag
import net.minecraft.world.item.Item
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.item.crafting.RecipeSerializer.SMELTING_RECIPE
import net.minecraft.world.item.crafting.RecipeSerializer.SMOKING_RECIPE
import net.minecraft.world.item.crafting.SimpleCookingSerializer.BLASTING_RECIPE
import net.minecraft.world.item.crafting.SimpleCookingSerializer.CAMPFIRE_COOKING_RECIPE
import net.minecraft.world.level.ItemLike
import java.util.function.Consumer
import kotlin.annotation.AnnotationTarget.*

typealias Shaped = ShapedRecipeBuilder
typealias Shapeless = ShapelessRecipeBuilder
typealias Cooking = SimpleCookingRecipeBuilder
typealias Smithing = UpgradeRecipeBuilder
typealias Stonecutting = SingleItemRecipeBuilder

/**
 * Gets an [ItemLike] as an [Ingredient].
 *
 * @author TheOnlyTails
 */
@CraftingRecipes
val ItemLike.ingredient: Ingredient
	get() = Ingredient.of(this)

/**
 * Gets an [item tag][Tag] as an [Ingredient].
 *
 * @author TheOnlyTails
 */
@CraftingRecipes
val Tag<Item>.ingredient: Ingredient
	get() = Ingredient.of(this)

/**
 * Gets a [String] as a [ResourceLocation].
 *
 * @author TheOnlyTails
 */
@CraftingRecipes
inline val String.asId
	get() = ResourceLocation(this)

/**
 * An annotation that marks every member of this DSL.
 *
 * @author TheOnlyTails
 */
@DslMarker
@MustBeDocumented
@Target(FUNCTION, CLASS, PROPERTY)
annotation class CraftingRecipes

/**
 * Creates a shaped crafting recipe.
 *
 * @param finishedRecipe the consumer passed in from [RecipeProvider#buildCraftingRecipes][net.minecraft.data.recipes.RecipeProvider.buildCraftingRecipes]
 * @param location the [ResourceLocation] at which to save the recipe (see [asId]).
 * @author TheOnlyTails
 */
@CraftingRecipes
inline fun shaped(
	result: ItemLike,
	count: Int = 1,
	finishedRecipe: Consumer<FinishedRecipe>,
	location: ResourceLocation = result.asItem().registryName!!,
	body: Shaped.() -> Shaped = { this },
) = shaped(result, count).body().save(finishedRecipe, location)

/**
 * Creates a shapeless crafting recipe.
 *
 * @param finishedRecipe the consumer passed in from [RecipeProvider#buildCraftingRecipes][net.minecraft.data.recipes.RecipeProvider.buildCraftingRecipes]
 * @param location the [ResourceLocation] at which to save the recipe (see [asId]).
 * @author TheOnlyTails
 */
@CraftingRecipes
inline fun shapeless(
	result: ItemLike,
	count: Int = 1,
	finishedRecipe: Consumer<FinishedRecipe>,
	location: ResourceLocation = result.asItem().registryName!!,
	body: Shapeless.() -> Shapeless = { this },
) = shapeless(result, count).body().save(finishedRecipe, location)

/**
 * Creates a smithing recipe (for a smithing table).
 *
 * @param finishedRecipe the consumer passed in from [RecipeProvider#buildCraftingRecipes][net.minecraft.data.recipes.RecipeProvider.buildCraftingRecipes]
 * @param location the [ResourceLocation] at which to save the recipe (see [asId]).
 * @author TheOnlyTails
 */
@CraftingRecipes
inline fun smithing(
	base: Ingredient,
	addition: Ingredient,
	result: ItemLike,
	finishedRecipe: Consumer<FinishedRecipe>,
	location: ResourceLocation = result.asItem().registryName!!,
	body: Smithing.() -> Smithing = { this },
) = smithing(base, addition, result.asItem()).body().save(finishedRecipe, location)

/**
 * Creates a stonecutting recipe (for a stonecutter).
 *
 * @param finishedRecipe the consumer passed in from [RecipeProvider#buildCraftingRecipes][net.minecraft.data.recipes.RecipeProvider.buildCraftingRecipes]
 * @param location the [ResourceLocation] at which to save the recipe (see [asId]).
 * @author TheOnlyTails
 */
@CraftingRecipes
inline fun stonecutting(
	input: Ingredient,
	result: ItemLike,
	finishedRecipe: Consumer<FinishedRecipe>,
	count: Int = 1,
	location: ResourceLocation = result.asItem().registryName!!,
	body: Stonecutting.() -> Stonecutting = { this },
) = stonecutting(input, result, count).body().save(finishedRecipe, location)

/**
 * Creates a smelting recipe.
 *
 * @param finishedRecipe the consumer passed in from [RecipeProvider#buildCraftingRecipes][net.minecraft.data.recipes.RecipeProvider.buildCraftingRecipes]
 * @param location the [ResourceLocation] at which to save the recipe (see [asId]).
 * @author TheOnlyTails
 */
@CraftingRecipes
inline fun smelting(
	input: Ingredient,
	result: ItemLike,
	experience: Float,
	cookingTime: Int,
	finishedRecipe: Consumer<FinishedRecipe>,
	location: ResourceLocation = result.asItem().registryName!!,
	body: Cooking.() -> Cooking = { this },
) = cooking(input, result, experience, cookingTime, SMELTING_RECIPE).body().save(finishedRecipe, location)

/**
 * Creates a blasting recipe (for a blast furnace).
 *
 * @param finishedRecipe the consumer passed in from [RecipeProvider#buildCraftingRecipes][net.minecraft.data.recipes.RecipeProvider.buildCraftingRecipes]
 * @param location the [ResourceLocation] at which to save the recipe (see [asId]).
 * @author TheOnlyTails
 */
@CraftingRecipes
inline fun blasting(
	input: Ingredient,
	result: ItemLike,
	experience: Float,
	cookingTime: Int,
	finishedRecipe: Consumer<FinishedRecipe>,
	location: ResourceLocation = result.asItem().registryName!!,
	body: Cooking.() -> Cooking = { this },
) = cooking(input, result, experience, cookingTime, BLASTING_RECIPE).body()
	.save(finishedRecipe, location)

/**
 * Creates a smoking recipe (for a smoker).
 *
 * @param finishedRecipe the consumer passed in from [RecipeProvider#buildCraftingRecipes][net.minecraft.data.recipes.RecipeProvider.buildCraftingRecipes]
 * @param location the [ResourceLocation] at which to save the recipe (see [asId]).
 * @author TheOnlyTails
 */
@CraftingRecipes
inline fun smoking(
	input: Ingredient,
	result: ItemLike,
	experience: Float,
	cookingTime: Int,
	finishedRecipe: Consumer<FinishedRecipe>,
	location: ResourceLocation = result.asItem().registryName!!,
	body: Cooking.() -> Cooking = { this },
) = cooking(input, result, experience, cookingTime, SMOKING_RECIPE).body().save(finishedRecipe, location)

/**
 * Creates a campfire cooking recipe.
 *
 * @param finishedRecipe the consumer passed in from [RecipeProvider#buildCraftingRecipes][net.minecraft.data.recipes.RecipeProvider.buildCraftingRecipes]
 * @param location the [ResourceLocation] at which to save the recipe (see [asId]).
 * @author TheOnlyTails
 */
@CraftingRecipes
inline fun campfire(
	input: Ingredient,
	result: ItemLike,
	experience: Float,
	cookingTime: Int,
	finishedRecipe: Consumer<FinishedRecipe>,
	location: ResourceLocation = result.asItem().registryName!!,
	body: Cooking.() -> Cooking = { this },
) = cooking(input, result, experience, cookingTime, CAMPFIRE_COOKING_RECIPE).body()
	.save(finishedRecipe, location)
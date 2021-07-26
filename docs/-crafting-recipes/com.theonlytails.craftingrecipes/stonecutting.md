---
title: stonecutting
---
//[CraftingRecipes](../../index.html)/[com.theonlytails.craftingrecipes](index.html)/[stonecutting](stonecutting.html)



# stonecutting



[jvm]\




@[CraftingRecipes](-crafting-recipes/index.html)()



inline fun [stonecutting](stonecutting.html)(input: Ingredient, result: ItemLike, finishedRecipe: [Consumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)<FinishedRecipe>, count: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1, location: ResourceLocation = result.asItem().registryName!!, body: [Stonecutting](index.html#1717356575%2FClasslikes%2F863300109).() -> [Stonecutting](index.html#1717356575%2FClasslikes%2F863300109) = { this })



Creates a stonecutting recipe (for a stonecutter).



#### Author



TheOnlyTails



## Parameters


jvm

| | |
|---|---|
| finishedRecipe | the consumer passed in from RecipeProvider#buildCraftingRecipes |
| location | the ResourceLocation at which to save the recipe (see [asId](as-id.html)). |





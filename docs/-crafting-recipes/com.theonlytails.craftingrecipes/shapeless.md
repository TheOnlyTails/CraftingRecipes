---
title: shapeless
---
//[CraftingRecipes](../../index.html)/[com.theonlytails.craftingrecipes](index.html)/[shapeless](shapeless.html)



# shapeless



[jvm]\




@[CraftingRecipes](-crafting-recipes/index.html)()



inline fun [shapeless](shapeless.html)(result: ItemLike, count: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1, finishedRecipe: [Consumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)<FinishedRecipe>, location: ResourceLocation = result.asItem().registryName!!, body: [Shapeless](index.html#625912222%2FClasslikes%2F863300109).() -> [Shapeless](index.html#625912222%2FClasslikes%2F863300109) = { this })



Creates a shapeless crafting recipe.



#### Author



TheOnlyTails



## Parameters


jvm

| | |
|---|---|
| finishedRecipe | the consumer passed in from RecipeProvider#buildCraftingRecipes |
| location | the ResourceLocation at which to save the recipe (see [asId](as-id.html)). |





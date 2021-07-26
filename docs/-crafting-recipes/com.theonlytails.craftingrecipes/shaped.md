---
title: shaped
---
//[CraftingRecipes](../../index.html)/[com.theonlytails.craftingrecipes](index.html)/[shaped](shaped.html)



# shaped



[jvm]\




@[CraftingRecipes](-crafting-recipes/index.html)()



inline fun [shaped](shaped.html)(result: ItemLike, count: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1, finishedRecipe: [Consumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)<FinishedRecipe>, location: ResourceLocation = result.asItem().registryName!!, body: [Shaped](index.html#418349351%2FClasslikes%2F863300109).() -> [Shaped](index.html#418349351%2FClasslikes%2F863300109) = { this })



Creates a shaped crafting recipe.



#### Author



TheOnlyTails



## Parameters


jvm

| | |
|---|---|
| finishedRecipe | the consumer passed in from RecipeProvider#buildCraftingRecipes |
| location | the ResourceLocation at which to save the recipe (see [asId](as-id.html)). |





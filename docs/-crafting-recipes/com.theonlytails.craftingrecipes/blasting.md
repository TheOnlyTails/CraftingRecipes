---
title: blasting
---
//[CraftingRecipes](../../index.html)/[com.theonlytails.craftingrecipes](index.html)/[blasting](blasting.html)



# blasting



[jvm]\




@[CraftingRecipes](-crafting-recipes/index.html)()



inline fun [blasting](blasting.html)(input: Ingredient, result: ItemLike, experience: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), cookingTime: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), finishedRecipe: [Consumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)<FinishedRecipe>, location: ResourceLocation = result.asItem().registryName!!, body: [Cooking](index.html#883239038%2FClasslikes%2F863300109).() -> [Cooking](index.html#883239038%2FClasslikes%2F863300109) = { this })



Creates a blasting recipe (for a blast furnace).



#### Author



TheOnlyTails



## Parameters


jvm

| | |
|---|---|
| finishedRecipe | the consumer passed in from RecipeProvider#buildCraftingRecipes |
| location | the ResourceLocation at which to save the recipe (see [asId](as-id.html)). |





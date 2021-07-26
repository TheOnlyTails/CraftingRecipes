---
title: smithing
---
//[CraftingRecipes](../../index.html)/[com.theonlytails.craftingrecipes](index.html)/[smithing](smithing.html)



# smithing



[jvm]\




@[CraftingRecipes](-crafting-recipes/index.html)()



inline fun [smithing](smithing.html)(base: Ingredient, addition: Ingredient, result: ItemLike, finishedRecipe: [Consumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)<FinishedRecipe>, location: ResourceLocation = result.asItem().registryName!!, body: [Smithing](index.html#1317356107%2FClasslikes%2F863300109).() -> [Smithing](index.html#1317356107%2FClasslikes%2F863300109) = { this })



Creates a smithing recipe (for a smithing table).



#### Author



TheOnlyTails



## Parameters


jvm

| | |
|---|---|
| finishedRecipe | the consumer passed in from RecipeProvider#buildCraftingRecipes |
| location | the ResourceLocation at which to save the recipe (see [asId](as-id.html)). |





package com.theonlytails.craftingrecipes

import com.theonlytails.craftingrecipes.ExampleItems.exampleItem1
import com.theonlytails.craftingrecipes.ExampleItems.exampleItem2
import com.theonlytails.craftingrecipes.ExampleItems.exampleItem3
import com.theonlytails.craftingrecipes.ExampleItems.exampleItem4
import com.theonlytails.craftingrecipes.ExampleItems.exampleItem5
import com.theonlytails.craftingrecipes.ExampleItems.items
import com.theonlytails.craftingrecipes.RecipeGroup.STICKS
import net.minecraft.advancements.critereon.InventoryChangeTrigger.TriggerInstance.hasItems
import net.minecraft.data.DataGenerator
import net.minecraft.data.recipes.FinishedRecipe
import net.minecraft.data.recipes.RecipeProvider
import net.minecraft.world.item.Item
import net.minecraft.world.item.Items.*
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.KDeferredRegister
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import java.util.function.Consumer

const val MOD_ID = "craftingrecipes_test"

object ExampleItems {
	val items = KDeferredRegister(ForgeRegistries.ITEMS, MOD_ID)

	val exampleItem1 by items.registerObject("example1") { Item(Item.Properties()) }
	val exampleItem2 by items.registerObject("example2") { Item(Item.Properties()) }
	val exampleItem3 by items.registerObject("example3") { Item(Item.Properties()) }
	val exampleItem4 by items.registerObject("example4") { Item(Item.Properties()) }
	val exampleItem5 by items.registerObject("example5") { Item(Item.Properties()) }
}

@Mod(MOD_ID)
@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
class CraftingRecipesTest {
	init {
		items.register(MOD_BUS)
	}

	@SubscribeEvent
	fun gatherData(event: GatherDataEvent) {
		val generator = event.generator

		if (event.includeServer()) {
			generator.addProvider(Recipes(generator))
		}
	}
}

class Recipes(generator: DataGenerator) : RecipeProvider(generator) {
	override fun buildCraftingRecipes(finishedRecipe: Consumer<FinishedRecipe>) {
		shaped(exampleItem1, finishedRecipe = finishedRecipe) {
			bigSquarePattern('x')
			define('x' to STICK)
			group(STICKS)
			unlockedBy("has_stick" to hasItems(STICK))
		}

		shapeless(exampleItem2, finishedRecipe = finishedRecipe) {
			requires(RED_CANDLE)
			group(RecipeGroup.DYED_CANDLE)
			unlockedBy("has_red_candle" to hasItems(RED_CANDLE))
		}

		smelting(exampleItem3.ingredient, IRON_ORE, .7f, 200, finishedRecipe = finishedRecipe)

		smithing(exampleItem4.ingredient, GOLD_INGOT.ingredient, DEBUG_STICK, finishedRecipe)

		stonecutting(exampleItem5.ingredient, DARK_PRISMARINE_STAIRS, finishedRecipe)
	}
}
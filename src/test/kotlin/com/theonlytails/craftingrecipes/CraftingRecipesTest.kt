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
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraft.world.item.Items.*
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import net.minecraftforge.fmllegacy.RegistryObject
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import java.util.function.Consumer

const val MOD_ID = "craftingrecipes_test"

object ExampleItems {
    val items: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID)

    val exampleItem1: RegistryObject<Item> = items.register("example1") { Item(Item.Properties().tab(CreativeModeTab.TAB_MISC)) }
    val exampleItem2: RegistryObject<Item> = items.register("example2") { Item(Item.Properties().tab(CreativeModeTab.TAB_MISC)) }
    val exampleItem3: RegistryObject<Item> = items.register("example3") { Item(Item.Properties().tab(CreativeModeTab.TAB_MISC)) }
    val exampleItem4: RegistryObject<Item> = items.register("example4") { Item(Item.Properties().tab(CreativeModeTab.TAB_MISC)) }
    val exampleItem5: RegistryObject<Item> = items.register("example5") { Item(Item.Properties().tab(CreativeModeTab.TAB_MISC)) }
}

@Mod(MOD_ID)
@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
class CraftingRecipesTest {
	init {
		items.register(FMLJavaModLoadingContext.get().modEventBus)

        val modEventBus = FMLJavaModLoadingContext.get().modEventBus
        modEventBus.addListener(::gatherData)
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
		shaped(exampleItem1.get(), finishedRecipe = finishedRecipe) {
			bigSquarePattern('x')
			define('x' to STICK)
			group(STICKS)
			unlockedBy("has_stick" to hasItems(STICK))
		}

		shapeless(exampleItem2.get(), finishedRecipe = finishedRecipe) {
			requires(RED_CANDLE)
			group(RecipeGroup.DYED_CANDLE)
			unlockedBy("has_red_candle" to hasItems(RED_CANDLE))
		}

		smelting(exampleItem3.get().ingredient, IRON_ORE, .7f, 200, finishedRecipe = finishedRecipe)

		smithing(exampleItem4.get().ingredient, GOLD_INGOT.ingredient, DEBUG_STICK, finishedRecipe)

		stonecutting(exampleItem5.get().ingredient, DARK_PRISMARINE_STAIRS, finishedRecipe)
	}
}
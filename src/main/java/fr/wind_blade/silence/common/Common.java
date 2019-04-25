package fr.wind_blade.silence.common;

import fr.wind_blade.silence.common.items.ItemsSL;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Common {

	public void preInit(FMLPreInitializationEvent event) {

	}

	public void init(FMLInitializationEvent event) {
		addSmeltingRecipes();
	}

	public void postInit(FMLPostInitializationEvent event) {

	}

	private static void addSmeltingRecipes() {	
		GameRegistry.addSmelting(ItemsSL.item_bauxite, new ItemStack(ItemsSL.item_aluminum_ingot), 0);
		GameRegistry.addSmelting(ItemsSL.item_rutile, new ItemStack(ItemsSL.item_titanium_bar), 0);
		GameRegistry.addSmelting(ItemsSL.item_tin_can, new ItemStack(Items.IRON_NUGGET), 0);
	}
}
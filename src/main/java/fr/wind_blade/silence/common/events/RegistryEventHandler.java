package fr.wind_blade.silence.common.events;

import fr.wind_blade.silence.Silence;
import fr.wind_blade.silence.common.blocks.BlocksSL;
import fr.wind_blade.silence.common.blocks.ItemBlockGeneric;
import fr.wind_blade.silence.common.items.IMetaProvider;
import fr.wind_blade.silence.common.items.ItemsSL;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber(modid=Silence.MODID)
public class RegistryEventHandler {

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> e) {
		BlocksSL.blocks.forEach(block -> ItemsSL.items.add((block instanceof IMetaProvider ? new ItemBlockGeneric(block, ((IMetaProvider)block).getMaxMeta()) : new ItemBlock(block)).setUnlocalizedName(block.getUnlocalizedName()).setRegistryName(block.getRegistryName()).setCreativeTab(ItemsSL.miscellaneous)));
		ItemsSL.items.forEach(e.getRegistry()::register);
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> e) {
		BlocksSL.blocks.forEach(e.getRegistry()::register);
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void onModelRegistry(ModelRegistryEvent event) {
		ItemsSL.items.forEach(RegistryEventHandler::registerItemsModels);
	}

	@SideOnly(Side.CLIENT)
	public static void registerItemsModels(Item item) {
		if(item instanceof IMetaProvider) {
			for(int i = 0; i < ((IMetaProvider)item).getMaxMeta(); i++) {
				registerItemsModels(item, i);
			}
		}
		else registerItemsModels(item, 0);
	}

	@SideOnly(Side.CLIENT)
	public static void registerItemsModels(Item item, int metadata) {
		if (metadata < 0) metadata = 0;
		String resourceName = item.getRegistryName().toString();
		if (metadata > 0) resourceName += "_" + String.valueOf(metadata);
		ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(resourceName, "inventory"));
	}
}
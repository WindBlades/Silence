package fr.wind_blade.silence.common.events;

import fr.wind_blade.silence.Silence;
import fr.wind_blade.silence.common.items.ItemsSL;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid=Silence.MODID)
public class WorldEventHandler {

	@SubscribeEvent
	public static void blockHarvest(BlockEvent.HarvestDropsEvent e) {

		if(e.getHarvester() == null || e.getState().getBlock() != Blocks.IRON_ORE) return;
		
		if(e.getWorld().rand.nextInt(10) == 9) {			
			int number = e.getDrops().stream().filter(stack -> stack.getItem() == Item.getItemFromBlock(Blocks.IRON_ORE)).mapToInt(ItemStack::getCount).sum();

			e.getDrops().removeIf(stack -> stack.getItem() == Item.getItemFromBlock(Blocks.IRON_ORE));
			e.getDrops().add(new ItemStack(ItemsSL.item_bauxite, number));
		}
	}
}
package fr.wind_blade.silence.common.items;

import java.util.ArrayList;
import java.util.List;

import fr.wind_blade.silence.Silence;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemsSL {

	public static final List<Item> items = new ArrayList<>();
	
	public static final Item item_bauxite = getItem("bauxite");
	public static final Item item_bauxite_ingot = getItem("bauxite_ingot");
	public static final Item item_rutile = getItem("rutile");
	
	public static Item getItem(String name) {
		Item item = new Item().setUnlocalizedName(name).setRegistryName(new ResourceLocation(Silence.MODID, name));
		items.add(item);
		return item;
	}
}
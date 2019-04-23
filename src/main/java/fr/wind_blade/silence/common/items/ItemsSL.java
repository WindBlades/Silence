package fr.wind_blade.silence.common.items;

import java.util.ArrayList;
import java.util.List;

import fr.wind_blade.silence.Silence;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemsSL {

	public static final List<Item> items = new ArrayList<>();
	
	public static final Item item_bauxite = getItem("bauxite");
	public static final Item item_aluminum_ingot = getItem("aluminum_ingot");
	public static final Item item_rutile = getItem("rutile");
	public static final Item item_titanium_bar = getItem("titanium_bar");
	public static final Item item_parasite_bit = getItem(new ItemParasiteBit(), "parasite_bit");
	public static final Item item_parasite_tooth = getItem("parasite_tooth");
	public static final Item item_parasite_egg = getItem("parasite_egg");
	public static final Item item_cereal_bar = getItem(new ItemTinCanFood(4), "cereal_bar");
	public static final Item item_canned_beans = getItem(new ItemTinCanFood(7), "canned_beans");
	public static final Item item_canned_fruit = getItem(new ItemTinCanFood(5), "canned_fruit");
	public static final Item item_canned_corn = getItem(new ItemTinCanFood(5), "canned_corn");
	public static final Item item_canned_tuna = getItem(new ItemTinCanFood(4), "canned_tuna");
	public static final Item item_tin_can = getItem("tin_can");
	
	public static Item getItem(String name) {
		return getItem(new Item(), name);
	}
	
	public static Item getItem(Item item, String name) {
		item.setUnlocalizedName(name).setRegistryName(new ResourceLocation(Silence.MODID, name));
		items.add(item);
		return item;
	}
}
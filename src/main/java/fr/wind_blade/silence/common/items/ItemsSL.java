package fr.wind_blade.silence.common.items;

import java.util.ArrayList;
import java.util.List;

import fr.wind_blade.silence.Silence;
import fr.wind_blade.silence.common.CreativeTabsMisc;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.util.ResourceLocation;

public class ItemsSL {

	public static final CreativeTabs miscellaneous = new CreativeTabsMisc();

	public static final List<Item> items = new ArrayList<>();

	public static final Item item_bauxite = getItem("bauxite");
	public static final Item item_aluminum_ingot = getItem("aluminum_ingot");
	public static final Item item_aluminum_nugget = getItem("aluminum_nugget");
	public static final Item item_rutile = getItem("rutile");
	public static final Item item_titanium_bar = getItem("titanium_bar");
	public static final Item item_titanium_nugget = getItem("titanium_nugget");
	public static final Item item_parasite_bit = getItem(new ItemParasiteBit(), "parasite_bit");
	public static final Item item_parasite_tooth = getItem("parasite_tooth");
	public static final Item item_parasite_egg = getItem("parasite_egg").setMaxStackSize(16);
	public static final Item item_cereal_bar = getItem(new ItemFood(4, false), "cereal_bar").setMaxStackSize(16);
	public static final Item item_tin_can = getItem(new ItemTinCanFood(), "tin_can");
	public static final Item item_aluminum_wire = getItem("aluminum_wire");
	public static final Item item_nail = getItem("nail");
	public static final Item item_saw = getItem("saw");
	public static final Item item_tape = getItem("tape");
	public static final Item item_plastic = getItem("plastic");
	public static final Item item_glue_stick = getItem("glue_stick");
	public static final Item item_car_wheel = getItem("car_wheel").setMaxStackSize(1);
	public static final Item item_steering_wheel = getItem("steering_wheel").setMaxStackSize(1);
	public static final Item item_car_motor = getItem("car_motor").setMaxStackSize(1);
	public static final Item item_weapon_plan = getItem("weapon_plan").setMaxStackSize(1);

	public static Item getItem(String name) {
		return getItem(new Item(), name);
	}

	public static <T extends Item> T getItem(T item, String name) {
		item.setUnlocalizedName(name).setRegistryName(new ResourceLocation(Silence.MODID, name));
		item.setCreativeTab(miscellaneous);
		items.add(item);
		return item;
	}
}
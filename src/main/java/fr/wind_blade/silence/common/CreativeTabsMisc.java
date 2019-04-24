package fr.wind_blade.silence.common;

import fr.wind_blade.silence.common.items.ItemsSL;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabsMisc extends CreativeTabs {

	public CreativeTabsMisc() {
		super("miscellaneous");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ItemsSL.item_tin_can);
	}
}
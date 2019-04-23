package fr.wind_blade.silence.common.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemTinCanFood extends ItemFood {

	public ItemTinCanFood(int amount) {
		super(amount, false);
		this.setMaxStackSize(16);
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
        super.onItemUseFinish(stack, worldIn, entityLiving);
		return new ItemStack(ItemsSL.item_tin_can);
	}	
}
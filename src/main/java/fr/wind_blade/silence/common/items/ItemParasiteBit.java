package fr.wind_blade.silence.common.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemParasiteBit extends ItemFood {

	public ItemParasiteBit() {
		super(1, false);
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		if(worldIn.isRemote) return;

		if(worldIn.rand.nextInt(100) < 25) {
			player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 300));
		}

		if(worldIn.rand.nextInt(100) < 40) {
			player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 160));
		}
	}
}
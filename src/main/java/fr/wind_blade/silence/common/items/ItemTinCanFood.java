package fr.wind_blade.silence.common.items;

import fr.wind_blade.silence.common.IVariantProvider;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class ItemTinCanFood extends ItemFood implements IVariantProvider {

	public ItemTinCanFood() {
		super(0, false);
		this.setMaxStackSize(16);
		this.setHasSubtypes(true);
		this.setNoRepair();
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName() + "_" + stack.getItemDamage();
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		
		if(tab != CreativeTabs.SEARCH && tab != ItemsSL.miscellaneous) return;
		
		for(Type type : Type.values()) {
			items.add(new ItemStack(this, 1, type.ordinal()));
		}
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return super.getMaxItemUseDuration(stack);
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return stack.getItemDamage() > 0 ? super.getItemUseAction(stack) : EnumAction.NONE;
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
        
        if(entityLiving instanceof EntityPlayer) {
        	((EntityPlayer)entityLiving).addItemStackToInventory(new ItemStack(ItemsSL.item_tin_can));
        }
        
		return super.onItemUseFinish(stack, worldIn, entityLiving);
	}

	@Override
	public int getHealAmount(ItemStack stack) {
		return Type.values()[(stack.getItemDamage())].getAmount();
	}

	@Override
	public int getMaxVariants() {
		return Type.values().length;
	}
	
	@Override
	public String getVariantName(int variant) {
		return this.getRegistryName().toString() + "_" + variant;
	}

	public enum Type {
		
		EMPTY(0),
		BEANS(7),
		FRUIT(5),
		CORN(5),
		TUNA(4);

		private final int amount;
		
		Type(int amount) {
			this.amount = amount;
		}

		public int getAmount() {
			return amount;
		}
	}
}
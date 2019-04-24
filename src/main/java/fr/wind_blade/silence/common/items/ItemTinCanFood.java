package fr.wind_blade.silence.common.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class ItemTinCanFood extends ItemFood {

	public ItemTinCanFood() {
		super(0, false);
		this.setMaxStackSize(16);
		this.setHasSubtypes(true);
		this.setMaxDamage(Type.values().length);
		this.setNoRepair();
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName() + "_" + stack.getItemDamage();
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		for(Type type : Type.values()) {
			items.add(new ItemStack(this, 1, type.getMeta()));
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
		super.onItemUseFinish(stack, worldIn, entityLiving);
		return new ItemStack(ItemsSL.item_tin_can);
	}

	@Override
	public int getHealAmount(ItemStack stack) {
		return Type.getFromMeta(stack.getItemDamage()).getAmount();
	}
	
	public enum Type {
		
		EMPTY(0, 0),
		BEANS(1, 7),
		FRUIT(2, 5),
		CORN(3, 5),
		TUNA(4, 4);

		private final int meta;
		private final int amount;
		
		Type(int meta, int amount) {
			this.meta = meta;
			this.amount = amount;
		}
		
		public static Type getFromMeta(int meta) {
			for(Type type : values()) {
				if(type.getMeta() == meta)return type;
			}
			return EMPTY;
		}

		public int getMeta() {
			return meta;
		}

		public int getAmount() {
			return amount;
		}
	}
}
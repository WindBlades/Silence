package fr.wind_blade.silence.common.blocks;
import fr.wind_blade.silence.common.IVariantProvider;
import fr.wind_blade.silence.common.items.ItemsSL;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemBlockGeneric extends ItemBlock implements IVariantProvider {

	private final int maxVariants;
	
    public ItemBlockGeneric(Block block, int maxMeta) {
        super(block);
        this.setHasSubtypes(true);
        this.maxVariants = maxMeta;
    }

    @Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {

    	if(tab != CreativeTabs.SEARCH && tab != ItemsSL.miscellaneous) return;

		for(int i = 0; i < maxVariants; i++) {
			items.add(new ItemStack(this, 1, i));
		}

    	super.getSubItems(tab, items);
	}
    
    @Override
	public int getMetadata(int damage) {
    	return damage;
	}

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName(stack) + "_" + stack.getItemDamage();
    }

	@Override
    public int getMaxVariants() {
    	return this.maxVariants;
    }

	@Override
	public String getVariantName(int variant) {
		return this.getRegistryName().toString() + "_" + variant;
	}
}
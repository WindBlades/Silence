package fr.wind_blade.silence.common.blocks;
import fr.wind_blade.silence.common.items.IMeta;
import fr.wind_blade.silence.common.items.ItemsSL;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemBlockGeneric extends ItemBlock implements IMeta {

	private final int maxMeta;
	
    public ItemBlockGeneric(Block block, int maxMeta) {
        super(block);
        this.setHasSubtypes(true);
        this.maxMeta = maxMeta;
    }

    @Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {

    	if(tab != CreativeTabs.SEARCH && tab != ItemsSL.miscellaneous) return;

		for(int i = 0; i < maxMeta; i++) {
			items.add(new ItemStack(this, 1, i));
		}

    	super.getSubItems(tab, items);
	}
    
    @Override
    public int getMaxMeta() {
    	return this.maxMeta;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName(stack) + "_" + stack.getItemDamage();
    }
}
package fr.wind_blade.silence.common.blocks;

import java.util.Random;

import fr.wind_blade.silence.common.items.ItemsSL;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockOreRutile extends Block {

	public BlockOreRutile(Material materialIn) {
		super(materialIn);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ItemsSL.item_rutile;
	}
}
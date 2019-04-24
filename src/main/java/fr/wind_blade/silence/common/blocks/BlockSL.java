package fr.wind_blade.silence.common.blocks;

import java.util.ArrayList;
import java.util.List;

import fr.wind_blade.silence.Silence;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;

public class BlockSL {

	public static final List<Block> blocks = new ArrayList<>();

	public static final Block block_rutile_ore = getBlock("rutile_ore", Material.IRON); 
	public static final Block wine_bottle = getBlock(new BlockGenericDecoration(Material.GLASS), "wine_bottle"); 

	private static Block getBlock(String name, Material material) {
		return getBlock(new Block(material), name);
	}
	
	private static Block getBlock(Block block, String name) {
		block.setUnlocalizedName(name).setRegistryName(new ResourceLocation(Silence.MODID, name));
		block.setCreativeTab(CreativeTabs.DECORATIONS);
		blocks.add(block);
		return block;
	}
}
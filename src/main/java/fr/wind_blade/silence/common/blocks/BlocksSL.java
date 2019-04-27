package fr.wind_blade.silence.common.blocks;

import java.util.ArrayList;
import java.util.List;

import fr.wind_blade.silence.Silence;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;

public class BlocksSL {

	public static final List<Block> blocks = new ArrayList<>();

	public static final Block block_rutile_ore = getBlock("rutile_ore", Material.IRON); 
	public static final Block green_wine_bottle = getBlock(new BlockGreenBottle(Material.GLASS), "green_wine_bottle"); 
	public static final Block red_wine_bottle = getBlock(new BlockRedBottle(Material.GLASS), "red_wine_bottle"); 
	public static final Block tire = getBlock(new BlockGenericDecoration(Material.GLASS), "tire"); 

	private static Block getBlock(String name, Material material) {
		return getBlock(new Block(material), name);
	}
	
	private static <T extends Block> T getBlock(T block, String name) {
		block.setUnlocalizedName(name).setRegistryName(new ResourceLocation(Silence.MODID, name));
		block.setCreativeTab(CreativeTabs.DECORATIONS);
		blocks.add(block);
		return block;
	}
}
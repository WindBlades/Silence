package fr.wind_blade.silence.common.blocks;

import java.util.ArrayList;
import java.util.List;

import fr.wind_blade.silence.Silence;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

public class BlockSL {

	public static final List<Block> blocks = new ArrayList<>();
	
	public static final Block block_rutile_ore = getBlock("rutile_ore", Material.IRON); 
	
	private static Block getBlock(String name, Material material) {
		Block block = new Block(material).setUnlocalizedName(name).setRegistryName(new ResourceLocation(Silence.MODID, name));
		blocks.add(block);
		return block;
	}
}
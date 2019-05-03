package fr.wind_blade.silence.common.blocks;

import java.util.ArrayList;
import java.util.List;

import fr.wind_blade.silence.Silence;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;

public class BlocksSL {

	public static final List<Block> blocks = new ArrayList<>();

	public static final Block block_rutile_ore = getBlock("rutile_ore", Material.IRON); 
	public static final BlockVariant<Green_Bottle> green_wine_bottle = getBlock(BlockVariant.create(Material.GLASS, Green_Bottle.class), "green_wine_bottle"); 
	public static final BlockVariant<Red_Bottle> red_wine_bottle = getBlock(BlockVariant.create(Material.GLASS, Red_Bottle.class), "red_wine_bottle");
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
	
	public enum Green_Bottle implements IStringSerializable {

		BOTTLE_1("bottle", 0),
		BOTTLE_2("bottle_2", 1),
		BOTTLE_3("bottle_3", 2);

		private final String name;
		private final int meta;

		Green_Bottle(String name, int id) {
			this.name = name;
			this.meta = id;
		}

		public static Green_Bottle getFromMeta(int meta) {
			for(Green_Bottle type : values()) {
				if(type.getMeta() == meta)return type;
			}
			return BOTTLE_1;
		}

		public int getMeta() {
			return meta;
		}

		@Override
		public String getName() {
			return name;
		}
	}

	public enum Red_Bottle implements IStringSerializable {

		BOTTLE_1("bottle", 0),
		BOTTLE_2("bottle_2", 1),
		BOTTLE_3("bottle_3", 2),
		BOTTLE_4("bottle_4", 3);

		private final String name;
		private final int meta;

		Red_Bottle(String name, int id) {
			this.name = name;
			this.meta = id;
		}

		public static Red_Bottle getFromMeta(int meta) {
			for(Red_Bottle type : values()) {
				if(type.getMeta() == meta)return type;
			}
			return BOTTLE_1;
		}

		public int getMeta() {
			return meta;
		}

		@Override
		public String getName() {
			return name;
		}
	}
}
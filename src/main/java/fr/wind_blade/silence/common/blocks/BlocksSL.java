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
	public static final BlockVariant<Doll> doll = getBlock(BlockVariant.create(Material.ROCK, Doll.class), "doll");
	public static final BlockVariant<Paper> paper1 = getBlock(BlockVariant.create(Material.ROCK, Paper.class), "paper1");
	public static final BlockVariant<Paper2> paper2 = getBlock(BlockVariant.create(Material.ROCK, Paper2.class), "paper2");
	public static final BlockVariant<Paper3> paper3 = getBlock(BlockVariant.create(Material.ROCK, Paper3.class), "paper3");
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
		BOTTLE_1("bottle_1"),
		BOTTLE_2("bottle_2"),
		BOTTLE_3("bottle_3");
		
		public final String name;
		
		Green_Bottle(String name){this.name = name;};
		
		@Override
		public String getName() {return this.name;}
	}

	public enum Red_Bottle implements IStringSerializable {
		BOTTLE_1("bottle_1"),
		BOTTLE_2("bottle_2"),
		BOTTLE_3("bottle_3"),
		BOTTLE_4("bottle_4");

		public final String name;
		
		Red_Bottle(String name){this.name = name;};
		
		@Override
		public String getName() {return this.name;}
	}
	
	public enum Doll implements IStringSerializable {
		DOLL("doll"),
		DOLL_1("doll_1"),
		DOLL_2("doll_2");

		public final String name;
		
		Doll(String name){this.name = name;};
		
		@Override
		public String getName() {return this.name;}
	}
	
	public enum Paper implements IStringSerializable {
		PAPER("paper"),
		PAPER_1("paper_1"),
		PAPER_2("paper_2"),
		PAPER_3("paper_3");

		public final String name;
		
		Paper(String name){this.name = name;};
		
		@Override
		public String getName() {return this.name;}
	}
	
	public enum Paper2 implements IStringSerializable {
		PAPER("paper"),
		PAPER_1("paper_1"),
		PAPER_2("paper_2"),
		PAPER_3("paper_3");

		public final String name;
		
		Paper2(String name){this.name = name;};
		
		@Override
		public String getName() {return this.name;}
	}
	
	public enum Paper3 implements IStringSerializable {
		PAPER("paper"),
		PAPER_1("paper_1");

		public final String name;
		
		Paper3(String name){this.name = name;};
		
		@Override
		public String getName() {return this.name;}
	}
}
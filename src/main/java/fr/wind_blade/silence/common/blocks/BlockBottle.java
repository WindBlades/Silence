package fr.wind_blade.silence.common.blocks;

import fr.wind_blade.silence.common.items.IMeta;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBottle extends Block implements IMeta {

	public static final PropertyEnum<Type> VARIANT = PropertyEnum.create("variant", Type.class);
	
	public BlockBottle(Material materialIn) {
		super(materialIn);
	}
	
    @SideOnly(Side.CLIENT)  
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
    	for(Type type : Type.values()) {
    		items.add(new ItemStack(this, 1, type.getMeta()));
    	}
    }

	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return Block.NULL_AABB;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, Type.getFromMeta(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(VARIANT).getMeta();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {VARIANT});
	}
	
    @Override
    public int damageDropped(IBlockState state) {
        return state.getValue(VARIANT).getMeta();
    }
    
	@Override
	public boolean isNormalCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}

	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		
		IBlockState state = super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer, hand);
		ItemStack stack = placer.getHeldItem(hand);
		
		if(stack.getItem().equals(Item.getItemFromBlock(BlocksSL.wine_bottle))) {
			state = state.withProperty(VARIANT, Type.getFromMeta(stack.getItemDamage()));
		}
		
		return state;
	}

	@Override
	public int getMaxMeta() {
		return Type.values().length;
	}

	public enum Type implements IStringSerializable {
		
		BOTTLE_1("bottle_green1", 0),
		BOTTLE_2("bottle_green2", 1),
		BOTTLE_3("bottle_green3", 2),
		RED_WINE_1("bottle_red1", 3),
		RED_WINE_2("bottle_red2", 4),
		RED_WINE_3("bottle_red3", 5),
		RED_WINE_4("bottle_red4", 6);
		
		private final String name;
		private final int meta;

		Type(String name, int id) {
			this.name = name;
			this.meta = id;
		}
		
		public static Type getFromMeta(int meta) {
			for(Type type : values()) {
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
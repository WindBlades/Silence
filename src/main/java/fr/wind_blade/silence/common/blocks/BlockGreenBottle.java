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
import net.minecraft.item.ItemStack;
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

public class BlockGreenBottle extends BlockGenericDecoration implements IMeta {

	public static final PropertyEnum<Type> VARIANT = PropertyEnum.create("variant", Type.class);

	public BlockGreenBottle(Material materialIn) {
		super(materialIn);
		this.setDefaultState(this.getDefaultState().withProperty(VARIANT, Type.BOTTLE_1));
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
		return this.getDefaultState().withProperty(VARIANT, Type.getFromMeta(meta >> 2)).withProperty(FACING, EnumFacing.getHorizontal(meta & 0b11));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return (state.getValue(VARIANT).getMeta() << 2) & state.getValue(FACING).getHorizontalIndex();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {VARIANT, FACING});
	}

	@Override
	public int damageDropped(IBlockState state) {
		return state.getValue(VARIANT).getMeta();
	}

	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		return super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer, hand).withProperty(VARIANT, Type.getFromMeta(placer.getHeldItem(hand).getItemDamage()));
	}

	@Override
	public int getMaxMeta() {
		return Type.values().length;
	}

	public enum Type implements IStringSerializable {

		BOTTLE_1("bottle", 0),
		BOTTLE_2("bottle_2", 1),
		BOTTLE_3("bottle_3", 2);

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
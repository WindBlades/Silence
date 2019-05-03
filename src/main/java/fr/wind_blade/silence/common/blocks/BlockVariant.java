package fr.wind_blade.silence.common.blocks;

import fr.wind_blade.silence.common.items.IMetaProvider;
import net.minecraft.block.material.Material;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockVariant<T extends Enum<T> & IStringSerializable> extends BlockGenericDecoration implements IMetaProvider {

    private static PropertyEnum<?> VARIANT;

    private final PropertyEnum<T> variant;
    private Class<T> enumClass;

    public static <T extends Enum<T> & IStringSerializable> BlockVariant<T> create(Material material, Class<T> enumClass) {
        PropertyEnum<T> property = PropertyEnum.create("variant", enumClass);
        VARIANT = property;
        return new BlockVariant<>(material, enumClass, property);
    }

    private BlockVariant(Material materialIn, Class<T> enumClass, PropertyEnum<T> property) {
        super(materialIn);
        this.enumClass = enumClass;
        this.variant = property;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, VARIANT, FACING);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        T value;
        if(meta >> 2 < enumClass.getEnumConstants().length)
            value = enumClass.getEnumConstants()[meta >> 2];
        else
            value = enumClass.getEnumConstants()[0];
        return this.getDefaultState().withProperty(this.variant, value).withProperty(FACING, EnumFacing.getHorizontal(meta & 0b11));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return (state.getValue(this.variant).ordinal() << 2) | state.getValue(FACING).getHorizontalIndex();
    }

	@Override
	public int getMaxMeta() {
		return this.enumClass.getEnumConstants().length;
	}
	
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {	
		return super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer, hand).withProperty(this.variant, this.enumClass.getEnumConstants()[placer.getHeldItem(hand).getItemDamage()]);
	}

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        for(T type : this.enumClass.getEnumConstants()) {
            items.add(new ItemStack(this, 1, type.ordinal()));
        }
    }
}
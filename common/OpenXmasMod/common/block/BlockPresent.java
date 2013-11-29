package OpenXmasMod.common.block;



import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import OpenXmasMod.common.OpenXmasModCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPresent extends Block {

	public static String[] types = {"Red", "Blue", "Yellow", "Green"};
	
	public BlockPresent(int par1) {
		super(par1, Material.rock);
		setCreativeTab(OpenXmasModCore.blocksTab);
	}
	
	private int nextNum;
	
	@Override
	public String getUnlocalizedName() {
		return "present_" + nextNum;
	}
	
	private static Icon[] tops = new Icon[types.length];
	private static Icon[] bottoms = new Icon[types.length];
	private static Icon[] sides = new Icon[types.length];
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		for(int i = 0; i < types.length; i++) {
			String type = types[i].toLowerCase();
			tops[i] = icon.registerIcon("openxmas:present_top_" + type);
			bottoms[i] = icon.registerIcon("openxmas:present_bottom_" + type);
			sides[i] = icon.registerIcon("openxmas:present_side_" + type);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		if(side == 0) {
			return bottoms[meta];
		}
		else if(side == 1) {
			return tops[meta];
		}
		else {
			return sides[meta];
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int id, CreativeTabs tab, List list) {
		for(int i = 0; i < types.length; i++) {
			list.add(new ItemStack(id, 1, i));
		}
	}

}

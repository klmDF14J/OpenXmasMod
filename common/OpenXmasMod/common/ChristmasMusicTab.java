package OpenXmasMod.common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ChristmasMusicTab extends CreativeTabs
{
	
	private int id2;
	
	public ChristmasMusicTab(int id, String s, int itemID)
	{
		super(id, s);
		id2 = itemID;
		
		setBackgroundImageName("item_search.png");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex() {
		return id2;
	}
}

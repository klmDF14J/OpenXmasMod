package OpenXmasMod.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ChristmasMusicTab extends CreativeTabs
{
	public ChristmasMusicTab(int id, String s)
	{
		super(id, s);
		this.hasSearchBar();
		setBackgroundImageName("item_search.png");
	}
	
	public ItemStack getIconItemStack()
	{
		return new ItemStack(Item.snowball);
	}
}

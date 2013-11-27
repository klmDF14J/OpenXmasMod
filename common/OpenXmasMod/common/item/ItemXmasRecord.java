package OpenXmasMod.common.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemRecord;

public class ItemXmasRecord extends ItemRecord
{
	public ItemXmasRecord(int id, String music)
	{
		super(id, music);
		setCreativeTab(CreativeTabs.tabRedstone);
	}
}

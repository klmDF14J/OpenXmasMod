package OpenXmasMod.common.item;

import OpenXmasMod.common.OpenXmasModCore;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemRecord;

public class ItemXmasRecord extends ItemRecord
{
	public String creator;
	public String record;
	
	public ItemXmasRecord(int id, String music, String creatorArg, String recordArg)
	{
		super(id, music);
		setCreativeTab(OpenXmasModCore.musicTab);
		setTextureName("openxmas:record");
		creator = creatorArg;
		record = recordArg;
	}
	
	@Override
    public String getRecordTitle()
    {
        return creator + " - " + this.record;
    }
}

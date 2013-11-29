package OpenXmasMod.common;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockPresent extends ItemBlock {

	public ItemBlockPresent(int par1) {
		super(par1);
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int dmg) {
		return dmg;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return "present_" + stack.getItemDamage();
	}
}

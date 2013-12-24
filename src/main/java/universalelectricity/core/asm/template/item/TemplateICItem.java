package universalelectricity.core.asm.template.item;

import ic2.api.item.IElectricItemManager;
import ic2.api.item.ISpecialElectricItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import universalelectricity.api.item.IEnergyItem;

/**
 * An ASM template used to transform other @UniversalClass classes to have specific compatibility.
 * 
 * @author Calclavia
 * 
 */
public abstract class TemplateICItem extends Item implements ISpecialElectricItem, IEnergyItem
{
	public TemplateICItem(int par1)
	{
		super(par1);
	}

	public IElectricItemManager getManager(ItemStack itemStack)
	{
		return ICDummyItemManager.INSTANCE;
	}

	@Override
	public boolean canProvideEnergy(ItemStack itemStack)
	{
		return true;
	}

	@Override
	public int getChargedItemId(ItemStack itemStack)
	{
		return itemStack.getItem().itemID;
	}

	@Override
	public int getEmptyItemId(ItemStack itemStack)
	{
		return itemStack.getItem().itemID;
	}

	@Override
	public int getMaxCharge(ItemStack itemStack)
	{
		return 0;
	}

	@Override
	public int getTier(ItemStack itemStack)
	{
		return 1;
	}

	@Override
	public int getTransferLimit(ItemStack itemStack)
	{
		return 0;
	}

}
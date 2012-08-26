package universalelectricity.basiccomponents;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemCopperWire extends ItemBC
{
    private int spawnID = BasicComponents.blockCopperWire.blockID;

    public ItemCopperWire(int id, int texture)
    {
        super("Copper Wire", id, texture);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.setTabToDisplayOn(CreativeTabs.tabRedstone);
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS !
     */
    @Override
    public boolean tryPlaceIntoWorld(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        int blockID = par3World.getBlockId(par4, par5, par6);

        if (blockID == Block.snow.blockID)
        {
            par7 = 1;
        }
        else if (blockID != Block.vine.blockID && blockID != Block.tallGrass.blockID && blockID != Block.deadBush.blockID)
        {
            if (par7 == 0)
            {
                --par5;
            }

            if (par7 == 1)
            {
                ++par5;
            }

            if (par7 == 2)
            {
                --par6;
            }

            if (par7 == 3)
            {
                ++par6;
            }

            if (par7 == 4)
            {
                --par4;
            }

            if (par7 == 5)
            {
                ++par4;
            }
        }

        if (par3World.canPlaceEntityOnSide(this.spawnID, par4, par5, par6, false, par7, (Entity)null))
        {
            Block var9 = Block.blocksList[this.spawnID];

            if (par3World.setBlockWithNotify(par4, par5, par6, this.spawnID))
            {
                if (par3World.getBlockId(par4, par5, par6) == this.spawnID)
                {
                    Block.blocksList[this.spawnID].onBlockPlacedBy(par3World, par4, par5, par6, par2EntityPlayer);
                }

                --par1ItemStack.stackSize;
                return true;
            }
        }

        return false;
    }
}
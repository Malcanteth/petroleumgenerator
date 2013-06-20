package drceph.petrogen.common;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemBituminousProduct extends Item {
	
	private List<Icon> itemsIconsList;
	private List<String> itemNames;
	
	private int itemsCount = 2;
	
	public ItemBituminousProduct(int par1) {
		super(par1);
		this.setHasSubtypes(true);
		this.setCreativeTab(CreativeTabs.tabMisc);
		setMaxStackSize(64);
        itemsIconsList = new ArrayList<Icon>();
        itemNames = new ArrayList<String>();
        addItemsNames();
	}
	
	@Override
    public String getUnlocalizedName(ItemStack stack) {
     	return itemNames.get(stack.getItemDamage());
    }
	
	@Override
    public Icon getIconFromDamage(int par1) {
    	return itemsIconsList.get(par1);
    }
    	
    public void addItemsNames() {
      	 itemNames.add("itemBituminousSludge");
      	 itemNames.add("itemBituminousSludgeBucket");
    }
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
     	itemsIconsList.add(iconRegister.registerIcon("petrogen:BituminousSludge"));
    	itemsIconsList.add(iconRegister.registerIcon("petrogen:BituminousSludgeBucket"));
	}
    
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int i = 0; i < itemsCount; i++)
        {
            par3List.add(new ItemStack(par1, 1, i));
        }
    }
}

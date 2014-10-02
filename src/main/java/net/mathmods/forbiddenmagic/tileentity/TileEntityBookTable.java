package net.mathmods.forbiddenmagic.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityBookTable extends TileEntity {
	
	private String[] names = {"Winnie", "Reddy", "Blacky", "Redhud", "Barney"};
	
	public String bookOwner = "";
	public boolean hasBook = true;
	
	public TileEntityBookTable(){
		
	}
	
	@Override
	public void writeToNBT(NBTTagCompound par1){
		super.writeToNBT(par1);
		par1.setString("BookOwner", bookOwner);
		par1.setBoolean("GotBook", hasBook);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1){
		super.readFromNBT(par1);
		bookOwner = par1.getString("BookOwner");
		hasBook = par1.getBoolean("GotBook");
	}
}

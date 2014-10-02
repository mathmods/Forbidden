package net.mathmods.forbiddenmagic.block;

import net.mathmods.forbiddenmagic.Forbidden;
import net.mathmods.forbiddenmagic.tileentity.TileEntityBookTable;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockBookTable extends BlockContainer {

	public BlockBookTable() {
		super(Material.rock);
		
		float pixel = 1F/16F;
		this.setBlockBounds(0, 0, 0, 1, pixel * 9, 1);
		this.setCreativeTab(Forbidden.tabForbidden);
		this.useNeighborBrightness = true;
	}
	
	public int getRenderType(){
		return -1;
	}
	
	public boolean isOpaqueCube(){
		return false;
	}
	
	public boolean renderAsNormalBlock(){
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World arg0, int arg1) {
		return new TileEntityBookTable();
	}

}

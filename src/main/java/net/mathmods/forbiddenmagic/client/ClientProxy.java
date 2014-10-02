package net.mathmods.forbiddenmagic.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.mathmods.forbiddenmagic.CommonProxy;
import net.mathmods.forbiddenmagic.render.TileEntityRenderBookTable;
import net.mathmods.forbiddenmagic.tileentity.TileEntityBookTable;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers(){
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBookTable.class, new TileEntityRenderBookTable());
	}
	
}

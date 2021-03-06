package net.mathmods.forbiddenmagic;

import net.mathmods.forbiddenmagic.block.BlockBookTable;
import net.mathmods.forbiddenmagic.tileentity.TileEntityBookTable;
import net.mathmods.forbiddenmagic.worldgen.WorldGenForbidden;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(version = "0.0.1", modid = "forbiddenmagic", name = "Forbidded Magic")
public class Forbidden{

	public static String modID = "forbiddenmagic";
	
	@Instance(value = "ForbiddenMagic")
	public static Forbidden instance;
	
	@SidedProxy(clientSide="net.mathmods.forbiddenmagic.client.ClientProxy", 
			serverSide="net.mathmods.forbiddenmagic.CommonProxy")
	public static CommonProxy proxy;
	
	public static CreativeTabs tabForbidden = new CreativeTabs("Forbidden"){
		@Override
		public Item getTabIconItem() {
			return Items.diamond;
		}
	};
	
	public static Block bookTable;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		bookTable = new BlockBookTable();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		GameRegistry.registerBlock(bookTable, modID + ":" + "bookTable");
		
		GameRegistry.registerTileEntity(TileEntityBookTable.class, "bookTable");
		
		GameRegistry.registerWorldGenerator(new WorldGenForbidden(), 2);
		
		proxy.registerRenderers();
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {

	}
}

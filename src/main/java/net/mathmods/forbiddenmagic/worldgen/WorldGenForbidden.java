package net.mathmods.forbiddenmagic.worldgen;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenForbidden implements IWorldGenerator {

	@Override
	public void generate(Random r, int chunkx, int chunkz, World w,
			IChunkProvider c1, IChunkProvider c2) {
		switch(w.provider.dimensionId){
			case -1:
				generateHell(r, w, chunkx * 16, chunkz * 16);
				break;
			case 0:
				generateSurface(r, w , chunkx * 16, chunkz * 16);
				break;
			case 1:
				generateEnd(r, w, chunkx * 16, chunkz * 16);
				break;
		}
	}
	
	public void generateSurface(Random r, World w , int x, int z){
		int sx = x + r.nextInt(16);
		int sy = r.nextInt(40);
		int sz = z + r.nextInt(16);
		if(w.getBlock(sx, sy, sz) != Blocks.stone || w.getBlock(sx, sy+6, sz) != Blocks.stone){
			return ;
		}
		if(r.nextInt(100) != 1) return ;
		
		(new WorldGenForbiddenDungeon()).generate(w, r, sx, sy, sz);
	}
	
	public void generateHell(Random r, World w, int x, int z){
		
	}
	
	public void generateEnd(Random r, World w, int x, int z){
		
	}

}

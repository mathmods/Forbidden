package net.mathmods.forbiddenmagic.worldgen;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.tileentity.MobSpawnerBaseLogic.WeightedRandomMinecart;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;

public class WorldGenForbiddenDungeon {

	public boolean generate(World w, Random r, int x, int y, int z){
		w.setBlock(x, y, z, Blocks.chest);
		System.out.println("Spawning dungeon at: " + x + " " + y + " " + z);
		TileEntityChest chest = (TileEntityChest) w.getTileEntity(x, y, z);
		if(chest != null){
			ChestGenHooks info = ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST);
			info.addItem(new WeightedRandomChestContent(Items.writable_book, 0, 1, 1, 100));
			WeightedRandomChestContent.generateChestContents(r, info.getItems(r), chest, info.getCount(r));
		}
		w.setBlock(x, y+1, z, Blocks.enchanting_table);
		w.setBlock(x, y-1, z, Blocks.stonebrick, 2, 2);
		w.setBlockToAir(x, y + 2, z);
		w.setBlockToAir(x, y + 3, z);
		w.setBlock(x, y + 4, z, Blocks.mossy_cobblestone);
		w.setBlock(x + 2, y, z + 2, Blocks.mob_spawner, 0, 2);
		TileEntityMobSpawner spawner1 = (TileEntityMobSpawner) w.getTileEntity(x + 2, y, z + 2);;
		if(spawner1 != null)spawner1.func_145881_a().setEntityName(DungeonHooks.getRandomDungeonMob(r));
		w.setBlock(x - 2, y, z + 2, Blocks.mob_spawner, 0, 2);
		TileEntityMobSpawner spawner2 = (TileEntityMobSpawner) w.getTileEntity(x - 2, y, z + 2);;
		if(spawner2 != null)spawner2.func_145881_a().setEntityName(DungeonHooks.getRandomDungeonMob(r));
		w.setBlock(x + 2, y, z - 2, Blocks.mob_spawner, 0, 2);
		TileEntityMobSpawner spawner3 = (TileEntityMobSpawner) w.getTileEntity(x + 2, y, z - 2);;
		if(spawner3 != null)spawner3.func_145881_a().setEntityName(DungeonHooks.getRandomDungeonMob(r));
		w.setBlock(x - 2, y, z - 2, Blocks.mob_spawner, 0, 2);
		TileEntityMobSpawner spawner4 = (TileEntityMobSpawner) w.getTileEntity(x - 2, y, z - 2);;
		if(spawner4 != null)spawner4.func_145881_a().setEntityName(DungeonHooks.getRandomDungeonMob(r));
		for(int dir = 0; dir < 4; dir++){
			for(int X = 1; X < 6; X++){
				for(int Y = 1; Y < 6; Y++){
					if(dir == 0 && X != 5 && Y != 5){
						w.setBlockToAir(x + X, Y + y - 1, z);
					}else if(dir == 1 && X != 5 && Y != 5){
						w.setBlockToAir(x, Y + y - 1, z + X);
					}else if(dir == 2 && X != 5 && Y != 5){
						w.setBlockToAir(x - X, Y + y - 1, z);
					}else if(dir == 3 && X != 5 && Y != 5){
						w.setBlockToAir(x, Y + y - 1, z - X);
					}else if(dir == 0 && Y == 5){
						int type = r.nextInt(3);
						if (type == 0){
							w.setBlock(x + X, Y + y - 1, z, Blocks.cobblestone);
						}else if(type == 1){
							w.setBlock(x + X, Y + y - 1, z, Blocks.mossy_cobblestone);
						}else if(type == 2){
							w.setBlock(x + X, Y + y - 1, z, Blocks.stonebrick, 2, 2);
						}
					}
					if(dir == 1 && Y == 5){
						int type = r.nextInt(3);
						if (type == 0){
							w.setBlock(x, Y + y - 1, z + X, Blocks.cobblestone);
						}else if(type == 1){
							w.setBlock(x, Y + y - 1, z + X, Blocks.mossy_cobblestone);
						}else if(type == 2){
							w.setBlock(x, Y + y - 1, z + X, Blocks.stonebrick, 2, 2);
						}
					}else if(dir == 2 && Y == 5){
						int type = r.nextInt(3);
						if (type == 0){
							w.setBlock(x - X, Y + y - 1, z, Blocks.cobblestone);
						}else if(type == 1){
							w.setBlock(x - X, Y + y - 1, z, Blocks.mossy_cobblestone);
						}else if(type == 2){
							w.setBlock(x - X, Y + y - 1, z, Blocks.stonebrick, 2, 2);
						}
					}else if(dir == 3 && Y == 5){
						int type = r.nextInt(3);
						if (type == 0){
							w.setBlock(x, Y + y - 1, z - X, Blocks.cobblestone);
						}else if(type == 1){
							w.setBlock(x, Y + y - 1, z - X, Blocks.mossy_cobblestone);
						}else if(type == 2){
							w.setBlock(x, Y + y - 1, z - X, Blocks.stonebrick, 2, 2);
						}
					}
					if(dir == 0 && X == 5){
						int type = r.nextInt(3);
						if (type == 0){
							w.setBlock(x + X, Y + y - 1, z, Blocks.cobblestone);
						}else if(type == 1){
							w.setBlock(x + X, Y + y - 1, z, Blocks.mossy_cobblestone);
						}else if(type == 2){
							w.setBlock(x + X, Y + y - 1, z, Blocks.stonebrick, 2, 2);
						}
					}else if(dir == 1 && X == 5){
						int type = r.nextInt(3);
						if (type == 0){
							w.setBlock(x, Y + y - 1, z + X, Blocks.cobblestone);
						}else if(type == 1){
							w.setBlock(x, Y + y - 1, z + X, Blocks.mossy_cobblestone);
						}else if(type == 2){
							w.setBlock(x, Y + y - 1, z + X, Blocks.stonebrick, 2, 2);
						}
					}else if(dir == 2 && X == 5){
						int type = r.nextInt(3);
						if (type == 0){
							w.setBlock(x - X, Y + y - 1, z, Blocks.cobblestone);
						}else if(type == 1){
							w.setBlock(x - X, Y + y - 1, z, Blocks.mossy_cobblestone);
						}else if(type == 2){
							w.setBlock(x - X, Y + y - 1, z, Blocks.stonebrick, 2, 2);
						}
					}else if(dir == 3 && X == 5){
						int type = r.nextInt(3);
						if (type == 0){
							w.setBlock(x, Y + y - 1, z - X, Blocks.cobblestone);
						}else if(type == 1){
							w.setBlock(x, Y + y - 1, z - X, Blocks.mossy_cobblestone);
						}else if(type == 2){
							w.setBlock(x, Y + y - 1, z - X, Blocks.stonebrick, 2, 2);
						}
					}
					if(dir == 0 && Y == 1){
						int type = r.nextInt(3);
						if (type == 0){
							w.setBlock(x + X, y - 1, z, Blocks.cobblestone);
						}else if(type == 1){
							w.setBlock(x + X, y - 1, z, Blocks.mossy_cobblestone);
						}else if(type == 2){
							w.setBlock(x + X, y - 1, z, Blocks.stonebrick, 2, 2);
						}
					}else if(dir == 1 && Y == 1){
						int type = r.nextInt(3);
						if (type == 0){
							w.setBlock(x, y - 1, z + X, Blocks.cobblestone);
						}else if(type == 1){
							w.setBlock(x, y - 1, z + X, Blocks.mossy_cobblestone);
						}else if(type == 2){
							w.setBlock(x, y - 1, z + X, Blocks.stonebrick, 2, 2);
						}
					}else if(dir == 2 && Y == 1){
						int type = r.nextInt(3);
						if (type == 0){
							w.setBlock(x - X, y - 1, z, Blocks.cobblestone);
						}else if(type == 1){
							w.setBlock(x - X, y - 1, z, Blocks.mossy_cobblestone);
						}else if(type == 2){
							w.setBlock(x - X, y - 1, z, Blocks.stonebrick, 2, 2);
						}
					}else if(dir == 3 && Y == 1){
						int type = r.nextInt(3);
						if (type == 0){
							w.setBlock(x, y - 1, z - X, Blocks.cobblestone);
						}else if(type == 1){
							w.setBlock(x, y - 1, z - X, Blocks.mossy_cobblestone);
						}else if(type == 2){
							w.setBlock(x, y - 1, z - X, Blocks.stonebrick, 2, 2);
						}
					}
				}
			}
		}
		for(int X = 1; X < 6; X++){
			for(int Z = 1; Z < 6; Z++){
				for(int Y = 0; Y < 6; Y++){
					int type = r.nextInt(3);
					if(Y == 0 || Y == 5 || Z == 5 || X == 5){
						if (type == 0){
							w.setBlock(x + X, Y + y - 1, z + Z, Blocks.cobblestone);
						}else if(type == 1){
							w.setBlock(x + X, Y + y - 1, z + Z, Blocks.mossy_cobblestone);
						}else if(type == 2){
							w.setBlock(x + X, Y + y - 1, z + Z, Blocks.stonebrick, 2, 2);
						}
					}else{
						if(w.getBlock(x + X, Y + y - 1, z + Z) != Blocks.chest && w.getBlock(x + X, Y + y - 1, z + Z) != Blocks.enchanting_table && w.getBlock(x + X, Y + y - 1, z + Z) != Blocks.mob_spawner){
							w.setBlockToAir(x + X, Y + y - 1, z + Z);
						}
					}
				}
			}
		}
		for(int X = 1; X < 6; X++){
			for(int Z = 1; Z < 6; Z++){
				for(int Y = 0; Y < 6; Y++){
					int type = r.nextInt(3);
					if(Y == 0 || Y == 5 || Z == 5 || X == 5){
						if (type == 0){
							w.setBlock(x - X, Y + y - 1, z - Z, Blocks.cobblestone);
						}else if(type == 1){
							w.setBlock(x - X, Y + y - 1, z - Z, Blocks.mossy_cobblestone);
						}else if(type == 2){
							w.setBlock(x - X, Y + y - 1, z - Z, Blocks.stonebrick, 2, 2);
						}
					}else{
						if(w.getBlock(x - X, Y + y - 1, z - Z) != Blocks.chest && w.getBlock(x - X, Y + y - 1, z - Z) != Blocks.enchanting_table && w.getBlock(x + X, Y + y - 1, z + Z) != Blocks.mob_spawner){
							w.setBlockToAir(x - X, Y + y - 1, z - Z);
						}
					}
				}
			}
		}
		for(int X = 1; X < 6; X++){
			for(int Z = 1; Z < 6; Z++){
				for(int Y = 0; Y < 6; Y++){
					int type = r.nextInt(3);
					if(Y == 0 || Y == 5 || Z == 5 || X == 5){
						if (type == 0){
							w.setBlock(x + X, Y + y - 1, z - Z, Blocks.cobblestone);
						}else if(type == 1){
							w.setBlock(x + X, Y + y - 1, z - Z, Blocks.mossy_cobblestone);
						}else if(type == 2){
							w.setBlock(x + X, Y + y - 1, z - Z, Blocks.stonebrick, 2, 2);
						}
					}else{
						if(w.getBlock(x + X, Y + y - 1, z - Z) != Blocks.chest && w.getBlock(x + X, Y + y - 1, z + Z) != Blocks.enchanting_table && w.getBlock(x + X, Y + y - 1, z + Z) != Blocks.mob_spawner){
							w.setBlockToAir(x + X, Y + y - 1, z - Z);
						}
					}
				}
			}
		}
		for(int X = 1; X < 6; X++){
			for(int Z = 1; Z < 6; Z++){
				for(int Y = 0; Y < 6; Y++){
					int type = r.nextInt(3);
					if(Y == 0 || Y == 5 || Z == 5 || X == 5){
						if (type == 0){
							w.setBlock(x - X, Y + y - 1, z + Z, Blocks.cobblestone);
						}else if(type == 1){
							w.setBlock(x - X, Y + y - 1, z + Z, Blocks.mossy_cobblestone);
						}else if(type == 2){
							w.setBlock(x - X, Y + y - 1, z + Z, Blocks.stonebrick, 2, 2);
						}
					}else{
						if(w.getBlock(x - X, Y + y - 1, z + Z) != Blocks.chest && w.getBlock(x + X, Y + y - 1, z + Z) != Blocks.enchanting_table && w.getBlock(x + X, Y + y - 1, z + Z) != Blocks.mob_spawner){
							w.setBlockToAir(x - X, Y + y - 1, z + Z);
						}
					}
				}
			}
		}
		return true;
	}
	
}

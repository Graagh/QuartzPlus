package calisbeast.mods.quartz.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import calisbeast.mods.quartz.Quartz;
import cpw.mods.fml.common.IWorldGenerator;

/**
 * @author robosphinx, calisbeast
 */

public class Generation implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
			case -1:
			
			case 0:
				generateWorld(world, random, chunkX * 16, chunkZ * 16);
	    	case 1:
	    	
	    	case 7:
	    		generateWorld(world, random, chunkX * 16, chunkZ * 16);
		}
	
	}
	
	private void generateWorld(World world, Random random, int x, int z) {
		this.spawnOre(Quartz.white_quartz_ore, world, random, x, z, 16, 16, 2 + random.nextInt(4), 20, 20, 45, Blocks.stone);
		this.spawnOre(Quartz.black_quartz_ore, world, random, x, z, 16, 16, 2 + random.nextInt(4), 20, 20, 45, Blocks.stone);
		this.spawnOre(Quartz.pink_quartz_ore, world, random, x, z, 16, 16, 2 + random.nextInt(4), 20, 20, 45, Blocks.stone);
	}

	public void spawnOre(Block blocktospawn, World world, Random random, int BlockX, int BlockZ, int maxX, int maxZ, int VeinSize, int chance, int minY, int maxY, Block blocktoreplace) {
		for(int i = 0; i < chance; i++){
			int Xcoord = BlockX + random.nextInt(16);
			int Zcoord = BlockZ + random.nextInt(16);
			int Ycoord = random.nextInt(41);
			(new WorldGenMinable(blocktospawn, VeinSize, blocktoreplace)).generate(world, random, Xcoord, Ycoord, Zcoord);
		}
	}
	
}

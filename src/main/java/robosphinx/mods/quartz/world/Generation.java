package robosphinx.mods.quartz.world;

/**
 * @author robosphinx
 */

import java.util.Random;

import robosphinx.mods.quartz.Quartz;
import robosphinx.mods.quartz.handler.ConfigHandler;
import robosphinx.mods.quartz.init.QuartzPlusBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class Generation implements IWorldGenerator {
    
    private QuartzPlusBlocks blocks;
    
    /*
     * This gets our configured multiplier for each ore block. This will be multiplied by our chance variable in spawnOre(args) to give more or less
     * times to spawn the ore.
     */
    
    private Double           quartzMult = ConfigHandler.spawnMultQuartz;
    private Double           roseMult   = ConfigHandler.spawnMultRose;
    private Double           smokyMult  = ConfigHandler.spawnMultSmoky;
    private int              quartzMaxY = ConfigHandler.maxYQuartz;
    private int              roseMaxY   = ConfigHandler.maxYRose;
    private int              smokyMaxY  = ConfigHandler.maxYSmoky;
    
    /*
     * The actual function that generates/adds the blocks - in the switch, each case corresponds to that dimension number (-1 | Nether, 0 | Overworld,
     * 1 | The End, 7 | Twilight Forest (IF the mod is installed, otherwise case 7 is ignored). In this case, -1 and 1 don't have anything - this just
     * means none of the quartz will spawn there.
     */
    @Override
    public void generate (Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {
            case -1:
                
            case 0:
                generateWorld(world, random, chunkX * 16, chunkZ * 16);
            case 1:
                
            case 7:
                generateWorld(world, random, chunkX * 16, chunkZ * 16);
        }
        
    }
    
    /*
     * If you look down to the spawnOre function, All these values correspond to those.
     */
    private void generateWorld (World world, Random random, int x, int z) {
        this.spawnOre(blocks.white_quartz_ore, world, random, x, z, 16, 16, 2 + random.nextInt(6), (int) (20 * quartzMult), 20, quartzMaxY, Blocks.stone);
        this.spawnOre(blocks.smoky_quartz_ore, world, random, x, z, 16, 16, 2 + random.nextInt(6), (int) (20 * smokyMult), 20, smokyMaxY, Blocks.stone);
        this.spawnOre(blocks.rose_quartz_ore, world, random, x, z, 16, 16, 2 + random.nextInt(6), (int) (20 * roseMult), 20, roseMaxY, Blocks.stone);
    }
    
    /*
     * Each variable should speak for itself. BlockX, BlockZ, maxX, and maxZ we tend not to mess with, this is the horizontal placement within the
     * chunk. minY and maxY are what you would change to define the range in which your block will spawn.
     */
    public void spawnOre (Block blocktospawn, World world, Random random, int BlockX, int BlockZ, int maxX, int maxZ, int VeinSize, int chance, int minY, int maxY, Block blocktoreplace) {
        for (int i = 0; i < chance; i++) {
            int Xcoord = BlockX + random.nextInt(maxX);
            int Zcoord = BlockZ + random.nextInt(maxZ);
            int Ycoord = random.nextInt(maxY);
            (new WorldGenMinable(blocktospawn, VeinSize, blocktoreplace)).generate(world, random, Xcoord, Ycoord, Zcoord);
        }
    }
    
}

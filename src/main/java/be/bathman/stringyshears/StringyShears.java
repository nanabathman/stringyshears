package be.bathman.stringyshears;

import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

@Mod(modid = StringyShears.MODID, version = StringyShears.VERSION,name = StringyShears.NAME)
public class StringyShears
{
	private static final Random rand = new Random();
	
    public static final String MODID = "stringyshears";
    public static final String VERSION = "1.0";
    public static final String NAME = "Stringy Shears";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onPlayerHarvest(BlockEvent.HarvestDropsEvent event) {
        if (event.getHarvester() != null && event.getState().getBlock() == Blocks.WOOL && event.getHarvester().getHeldItemMainhand().getItem() == Items.SHEARS) {
            event.getDrops().remove(0);
            event.getDrops().add(new ItemStack(Items.STRING, rand.nextInt(4) + 2));
        }
    }
	
}

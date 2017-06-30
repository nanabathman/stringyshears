package be.bathman.stringyshears;

import be.bathman.stringyshears.event.strinyShearsEvent;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = StringyShears.MODID, version = StringyShears.VERSION,name = StringyShears.NAME)
public class StringyShears
{
    public static final String MODID = "stringyshears";
    public static final String VERSION = "1.0";
    public static final String NAME = "Stringy Shears";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new strinyShearsEvent());
    }
}

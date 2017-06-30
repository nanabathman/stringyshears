package be.bathman.stringyshears.event;

import it.unimi.dsi.fastutil.ints.Int2BooleanAVLTreeMap;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.item.Item;

import java.util.Random;

/**
 * Created by Kevin on 30-6-2017.
 */
public class strinyShearsEvent {
    Random rand = new Random();

    @SubscribeEvent
    public void yourPlayerHarvestEvent(BlockEvent.HarvestDropsEvent event) {
        if (event.getHarvester() != null) {
            Block brokenBlock = event.getState().getBlock();
            if (brokenBlock == Blocks.WOOL) {
                Item main = event.getHarvester().getHeldItemMainhand().getItem();
                Item sub = event.getHarvester().getHeldItemMainhand().getItem();
                if (main == Items.SHEARS && sub == Items.SHEARS) {
                    event.getDrops().remove(0);
                    int n = rand.nextInt(4) + 2;
                    event.getDrops().add(new ItemStack(Items.STRING, n));
                }
            }
        }
    }
}

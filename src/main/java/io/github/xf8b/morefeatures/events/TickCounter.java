package io.github.xf8b.morefeatures.events;

import io.github.xf8b.morefeatures.MoreFeatures;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MoreFeatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TickCounter {
    public static int count = 0;

    @SubscribeEvent
    public static void tickCounter(TickEvent.ClientTickEvent event) {
        count++;
        if(count == 2401) {
            count = 0;
        }
    }
}

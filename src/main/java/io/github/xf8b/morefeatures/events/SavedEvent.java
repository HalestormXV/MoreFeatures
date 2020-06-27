package io.github.xf8b.morefeatures.events;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraftforge.eventbus.api.Event;

@Cancelable
public class SavedEvent extends Event {
    public final DamageSource source;
    public final int chance;
    public final LivingEntity entity;
    public final ItemStack itemStackOnFeet;

    public SavedEvent(DamageSource source, int chance, LivingEntity entity, ItemStack itemStackOnFeet) {
        this.source = source;
        this.chance = chance;
        this.entity = entity;
        this.itemStackOnFeet = itemStackOnFeet;
    }

    @Override
    public boolean isCancelable() {
        return true;
    }

    @Override
    public boolean hasResult() {
        return false;
    }
}

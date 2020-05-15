package io.github.xf8b.morefeatures.items;

import io.github.xf8b.morefeatures.MoreFeatures;
import io.github.xf8b.morefeatures.util.helpers.KeyboardChecker;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class Sapphire extends Item {
    public Sapphire() {
        super(new Item.Properties()
                .maxStackSize(64)
                .group(MoreFeatures.instance.itemGroup)
        );
    }
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(KeyboardChecker.isHoldingShift()) {
            tooltip.add(new StringTextComponent("You probably shouldn't make armor or tools out of this."));
            tooltip.add(new StringTextComponent("It's worse than diamond, but hey, it looks... decent?"));
        } else {
            tooltip.add(new StringTextComponent("Hold " + "\u00A7e" + "SHIFT " + "\u00A77" + "to see info."));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}

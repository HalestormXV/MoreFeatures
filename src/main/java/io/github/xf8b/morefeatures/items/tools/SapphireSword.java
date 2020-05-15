package io.github.xf8b.morefeatures.items.tools;

import io.github.xf8b.morefeatures.MoreFeatures;
import io.github.xf8b.morefeatures.MoreFeaturesItemTier;
import io.github.xf8b.morefeatures.util.helpers.KeyboardChecker;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class SapphireSword extends SwordItem {
    public SapphireSword() {
        super(MoreFeaturesItemTier.SAPPHIRE, 0, -2.4f, new Item.Properties()
                .maxStackSize(1)
                .group(MoreFeatures.instance.itemGroup)
        );
    }
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(KeyboardChecker.isHoldingShift()) {
            tooltip.add(new StringTextComponent("This tool is made out of sapphire."));
            tooltip.add(new StringTextComponent("It is worse than diamonds in terms of durability and damage."));
            tooltip.add(new StringTextComponent("At least it looks sort of cool."));
        } else {
            tooltip.add(new StringTextComponent("Hold " + "\u00A7e" + "SHIFT " + "\u00A77" + "to see info."));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}

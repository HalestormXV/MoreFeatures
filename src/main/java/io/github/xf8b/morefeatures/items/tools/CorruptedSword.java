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
import java.util.concurrent.ThreadLocalRandom;

public class CorruptedSword extends SwordItem {
    private static int attackDamage = 0;
    private static float attackSpeed = 0;

    public CorruptedSword() {
        super(MoreFeaturesItemTier.CORRUPTED,
                attackDamage = ThreadLocalRandom.current().nextInt(0, 10 + 1),
                attackSpeed = (float) ThreadLocalRandom.current().nextDouble(0, 5 + 1),
        new Item.Properties()
                .maxStackSize(1)
                .setNoRepair()
                .group(MoreFeatures.instance.itemGroup)
        );
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(KeyboardChecker.isHoldingShift()) {
            tooltip.add(new StringTextComponent("This tool has been corrupted."));
            tooltip.add(new StringTextComponent("The attack damage and speed will be random."));
            tooltip.add(new StringTextComponent("The attack damage and speed will changed on game restart."));
            tooltip.add(new StringTextComponent("Good luck, and pray to the RNG gods."));
        } else {
            tooltip.add(new StringTextComponent("Hold "+ "\u00A7e" + "SHIFT " + "\u00A77" +  "to see info."));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}

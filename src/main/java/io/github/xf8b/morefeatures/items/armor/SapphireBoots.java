package io.github.xf8b.morefeatures.items.armor;

import io.github.xf8b.morefeatures.MoreFeatures;
import io.github.xf8b.morefeatures.MoreFeaturesArmorMaterial;
import io.github.xf8b.morefeatures.util.helpers.KeyboardChecker;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class SapphireBoots extends ArmorItem {
    public SapphireBoots() {
        super(MoreFeaturesArmorMaterial.SAPPHIRE, EquipmentSlotType.FEET, new Item.Properties()
                .maxStackSize(1)
                .group(MoreFeatures.instance.itemGroup)
        );
    }
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(KeyboardChecker.isHoldingShift()) {
            tooltip.add(new StringTextComponent("This armor is made out of sapphire."));
            tooltip.add(new StringTextComponent("It is worse than diamonds in terms of protection."));
            tooltip.add(new StringTextComponent("At least it looks sort of cool."));
        } else {
            tooltip.add(new StringTextComponent("Hold " + "\u00A7e" + "SHIFT " + "\u00A77" + "to see info."));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}

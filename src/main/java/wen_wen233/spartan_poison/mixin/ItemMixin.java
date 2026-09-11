package wen_wen233.spartan_poison.mixin;

import krelox.spartantoolkit.WeaponItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public class ItemMixin {
    @Inject(method = "m_41790_", at = @At("HEAD"), cancellable = true, remap = false)
    private void spartanPoison_isFoil(CallbackInfoReturnable<Boolean> cir) {
        ItemStack self = (ItemStack)(Object)this;
        if (!self.isEmpty() && self.getItem() instanceof WeaponItem) {
            ResourceLocation id = ForgeRegistries.ITEMS.getKey(self.getItem());
            if (id != null && id.getNamespace().equals("spartan_poison") && id.getPath().contains("poisoned_dragon_bone")) {
                cir.setReturnValue(true);
            }
        }
    }
}
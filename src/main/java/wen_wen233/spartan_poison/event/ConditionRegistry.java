package wen_wen233.spartan_poison.event;

import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import wen_wen233.spartan_poison.SpartanPoisonMod;
import wen_wen233.spartan_poison.condition.IafRecipeCondition;
import wen_wen233.spartan_poison.condition.PoisonDefaultRecipeCondition;
import wen_wen233.spartan_poison.condition.SpartanfireRecipeCondition;

@Mod.EventBusSubscriber(modid = SpartanPoisonMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ConditionRegistry {
    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            CraftingHelper.register(PoisonDefaultRecipeCondition.Serializer.INSTANCE);
            CraftingHelper.register(SpartanfireRecipeCondition.Serializer.INSTANCE);
            CraftingHelper.register(IafRecipeCondition.Serializer.INSTANCE);
        });
    }
}
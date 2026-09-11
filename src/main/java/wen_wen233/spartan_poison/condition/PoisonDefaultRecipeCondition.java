package wen_wen233.spartan_poison.condition;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;
import wen_wen233.spartan_poison.PoisonConfig;
import wen_wen233.spartan_poison.SpartanPoisonMod;

public class PoisonDefaultRecipeCondition implements ICondition {
    public static final ResourceLocation ID = new ResourceLocation(SpartanPoisonMod.MODID, "poison_default_recipe");
    public static final PoisonDefaultRecipeCondition INSTANCE = new PoisonDefaultRecipeCondition();

    @Override
    public ResourceLocation getID() { return ID; }

    @Override
    public boolean test(IContext context) {
        boolean spartanfireLoaded = ModList.get().isLoaded("spartanfire");
        if (!spartanfireLoaded) return true;
        return !PoisonConfig.COMMON.spartanRemoveDefault.get();
    }

    public static class Serializer implements IConditionSerializer<PoisonDefaultRecipeCondition> {
        public static final Serializer INSTANCE = new Serializer();
        @Override public void write(JsonObject json, PoisonDefaultRecipeCondition value) {}
        @Override public PoisonDefaultRecipeCondition read(JsonObject json) { return PoisonDefaultRecipeCondition.INSTANCE; }
        @Override public ResourceLocation getID() { return ID; }
    }
}
package wen_wen233.spartan_poison.condition;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;
import wen_wen233.spartan_poison.PoisonConfig;
import wen_wen233.spartan_poison.SpartanPoisonMod;

public class SpartanfireRecipeCondition implements ICondition {
    public static final ResourceLocation ID = new ResourceLocation(SpartanPoisonMod.MODID, "spartanfire_recipe");
    public static final SpartanfireRecipeCondition INSTANCE = new SpartanfireRecipeCondition();

    @Override
    public ResourceLocation getID() { return ID; }

    @Override
    public boolean test(IContext context) {
        if (!ModList.get().isLoaded("spartanfire")) return false;
        return PoisonConfig.COMMON.spartanAddSpartanfire.get();
    }

    public static class Serializer implements IConditionSerializer<SpartanfireRecipeCondition> {
        public static final Serializer INSTANCE = new Serializer();
        @Override public void write(JsonObject json, SpartanfireRecipeCondition value) {}
        @Override public SpartanfireRecipeCondition read(JsonObject json) { return SpartanfireRecipeCondition.INSTANCE; }
        @Override public ResourceLocation getID() { return ID; }
    }
}
package wen_wen233.spartan_poison.condition;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;
import wen_wen233.spartan_poison.PoisonConfig;
import wen_wen233.spartan_poison.SpartanPoisonMod;

public class IafRecipeCondition implements ICondition {
    public static final ResourceLocation ID = new ResourceLocation(SpartanPoisonMod.MODID, "iaf_recipe");
    public static final IafRecipeCondition INSTANCE = new IafRecipeCondition();

    @Override
    public ResourceLocation getID() { return ID; }

    @Override
    public boolean test(IContext context) {
        if (!ModList.get().isLoaded("iceandfire")) return false;
        return PoisonConfig.COMMON.dragonAddIceandfire.get();
    }

    public static class Serializer implements IConditionSerializer<IafRecipeCondition> {
        public static final Serializer INSTANCE = new Serializer();
        @Override public void write(JsonObject json, IafRecipeCondition value) {}
        @Override public IafRecipeCondition read(JsonObject json) { return IafRecipeCondition.INSTANCE; }
        @Override public ResourceLocation getID() { return ID; }
    }
}
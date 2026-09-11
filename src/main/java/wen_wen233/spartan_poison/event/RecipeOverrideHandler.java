package wen_wen233.spartan_poison.event;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimplePreparableReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import wen_wen233.spartan_poison.PoisonConfig;
import wen_wen233.spartan_poison.SpartanPoisonMod;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Mod.EventBusSubscriber(modid = SpartanPoisonMod.MODID)
public class RecipeOverrideHandler {

    private static final Set<String> OVERRIDE_RECIPES = Set.of(
            "dragonbone_sword_poison",
            "dragonsteel_poison_sword",
            "dragonsteel_poison_axe",
            "dragonsteel_poison_pickaxe",
            "dragonsteel_poison_shovel",
            "dragonsteel_poison_hoe",
            "dragonarmor_dragonsteel_poison_head",
            "dragonarmor_dragonsteel_poison_neck",
            "dragonarmor_dragonsteel_poison_body",
            "dragonarmor_dragonsteel_poison_tail"
    );

    @SubscribeEvent
    public static void onAddReloadListener(AddReloadListenerEvent event) {
        if (!ModList.get().isLoaded("iceandfire")) return;
        if (!PoisonConfig.COMMON.dragonRemoveDefault.get()) return;

        event.addListener(new SimplePreparableReloadListener<Void>() {
            @Override
            protected Void prepare(ResourceManager resourceManager, ProfilerFiller profiler) {
                return null;
            }

            @Override
            protected void apply(Void object, ResourceManager resourceManager, ProfilerFiller profiler) {
                RecipeManager recipeManager = event.getServerResources().getRecipeManager();
                List<Recipe<?>> recipes = new ArrayList<>(recipeManager.getRecipes());
                recipes.removeIf(recipe -> {
                    ResourceLocation id = recipe.getId();
                    return id.getNamespace().equals("poison_dragons")
                            && OVERRIDE_RECIPES.contains(id.getPath());
                });
                recipeManager.replaceRecipes(recipes);
            }
        });
    }
}
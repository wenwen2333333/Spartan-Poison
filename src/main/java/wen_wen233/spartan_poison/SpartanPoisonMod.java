package wen_wen233.spartan_poison;

import com.oblivioussp.spartanweaponry.api.trait.WeaponTrait;
import krelox.spartantoolkit.SpartanAddon;
import krelox.spartantoolkit.SpartanMaterial;
import krelox.spartantoolkit.WeaponMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

import java.util.ArrayList;
import java.util.List;

@Mod(SpartanPoisonMod.MODID)
public class SpartanPoisonMod extends SpartanAddon {
    public static final String MODID = "spartan_poison";
    public static final WeaponMap WEAPONS = new WeaponMap();

    public static final DeferredRegister<Item> ITEMS = itemRegister(MODID);
    public static final DeferredRegister<WeaponTrait> TRAITS = traitRegister(MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = tabRegister(MODID);
    public static final ArrayList<SpartanMaterial> MATERIALS = new ArrayList<>();

    public static final RegistryObject<Item> POISON_DRAGON_BONE_HANDLE = ITEMS.register("poison_dragon_bone_handle", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POISON_DRAGON_BONE_POLE = ITEMS.register("poison_dragon_bone_pole", () -> new Item(new Item.Properties()));

    public static final Tier POISONED_DRAGON_BONE_TIER = new Tier() {
        @Override public int getUses() { return 2000; }
        @Override public float getSpeed() { return 5.5F; }
        @Override public float getAttackDamageBonus() { return 5.5F; }
        @Override public int getLevel() { return 4; }
        @Override public int getEnchantmentValue() { return 22; }
        @Override public Ingredient getRepairIngredient() {
            return Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation("poison_dragons", "poisoned_dragon_bone")));
        }
    };

    public static final Tier POISON_DRAGONSTEEL_TIER = new Tier() {
        @Override public int getUses() { return 8000; }
        @Override public float getSpeed() { return 10.0F; }
        @Override public float getAttackDamageBonus() { return 21.0F; }
        @Override public int getLevel() { return 5; }
        @Override public int getEnchantmentValue() { return 10; }
        @Override public Ingredient getRepairIngredient() {
            return Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation("poison_dragons", "dragonsteel_poison_ingot")));
        }
    };

    public static final RegistryObject<WeaponTrait> POISONED_TRAIT = registerTrait(TRAITS, new PoisonedTrait());

    public static final SpartanMaterial POISONED_DRAGON_BONE = material(
            "poisoned_dragon_bone",
            POISONED_DRAGON_BONE_TIER,
            "forge:bones/dragon",
            POISONED_TRAIT
    );

    public static final SpartanMaterial POISON_DRAGONSTEEL = material(
            "poison_dragonsteel",
            POISON_DRAGONSTEEL_TIER,
            "forge:ingots/dragonsteel_poison",
            POISONED_TRAIT
    );

    public static final RegistryObject<CreativeModeTab> POISON_TAB = registerTab(CREATIVE_TABS, "poison_tab",
            () -> WEAPONS.get(POISONED_DRAGON_BONE, krelox.spartantoolkit.WeaponType.GREATSWORD).get(),
            (parameters, output) -> ITEMS.getEntries().forEach(entry -> output.accept(entry.get()))
    );

    public SpartanPoisonMod() {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
        TRAITS.register(bus);
        CREATIVE_TABS.register(bus);
        registerSpartanWeapons(ITEMS);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, PoisonConfig.COMMON_SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, PoisonConfig.CLIENT_SPEC);
    }

    @SafeVarargs
    private static SpartanMaterial material(String name, Tier tier, String repairTag, RegistryObject<WeaponTrait>... traits) {
        SpartanMaterial material = new SpartanMaterial(name, MODID, tier, ItemTags.create(new ResourceLocation(repairTag)), traits);
        MATERIALS.add(material);
        return material;
    }

    @Override
    public String modid() {
        return MODID;
    }

    @Override
    public List<SpartanMaterial> getMaterials() {
        return MATERIALS;
    }

    @Override
    public WeaponMap getWeaponMap() {
        return WEAPONS;
    }
}
package wen_wen233.spartan_poison;

import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import krelox.spartantoolkit.BetterWeaponTrait;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class PoisonedTrait extends BetterWeaponTrait {
    public PoisonedTrait() {
        super("poisoned", SpartanPoisonMod.MODID, TraitQuality.POSITIVE);
        setUniversal();
    }

    @Override
    public String getDescription() {
        return "Poisons and withers foes";
    }

    @Override
    public void onHitEntity(WeaponMaterial material, ItemStack stack, LivingEntity target, LivingEntity attacker, Entity projectile) {
        target.addEffect(new MobEffectInstance(MobEffects.POISON, 200, 1));
    }
}
package wen_wen233.spartan_poison;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class PoisonConfig {
    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;
    public static final ForgeConfigSpec CLIENT_SPEC;
    public static final Client CLIENT;

    static {
        final Pair<Common, ForgeConfigSpec> commonPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = commonPair.getRight();
        COMMON = commonPair.getLeft();

        final Pair<Client, ForgeConfigSpec> clientPair = new ForgeConfigSpec.Builder().configure(Client::new);
        CLIENT_SPEC = clientPair.getRight();
        CLIENT = clientPair.getLeft();
    }

    public static class Common {
        public final ForgeConfigSpec.BooleanValue spartanRemoveDefault;
        public final ForgeConfigSpec.BooleanValue spartanAddSpartanfire;
        public final ForgeConfigSpec.BooleanValue dragonRemoveDefault;
        public final ForgeConfigSpec.BooleanValue dragonAddIceandfire;

        Common(ForgeConfigSpec.Builder builder) {
            builder.comment("Settings related to Spartan Poison weapons.").push("spartan_weapons");

            spartanRemoveDefault = builder
                    .comment("Only takes effect when Spartan Fire (spartanfire) is loaded.",
                            "Removes the default recipes for the Poisoned Dragon Bone weapons",
                            "and Poison Dragonsteel weapons from the Spartan Poison mod.",
                            "Disable this to keep them.")
                    .translation("spartan_poison.config.spartan_weapons.remove_default")
                    .define("remove_default_recipe", true);

            spartanAddSpartanfire = builder
                    .comment("Only takes effect when Spartan Fire (spartanfire) is loaded.",
                            "Adds Spartan Fire-style recipes for the Poisoned Dragon Bone weapons",
                            "and Poison Dragonsteel weapons from the Spartan Poison mod.",
                            "Disable this to skip adding them.")
                    .translation("spartan_poison.config.spartan_weapons.add_spartanfire")
                    .define("add_spartanfire_recipe", true);

            builder.pop();
            builder.comment("Settings related to the Poison Dragons mod's own recipes.").push("poison_dragons");

            dragonRemoveDefault = builder
                    .comment("Only takes effect when Ice and Fire (iceandfire) is loaded.",
                            "Removes certain original recipes from the Poison Dragons mod",
                            "(e.g. Poison Dragonbone Sword, Poison Dragonsteel tools,",
                            "and Poison Dragonsteel Dragon Armor).",
                            "Disable this to keep them.")
                    .translation("spartan_poison.config.poison_dragons.remove_default")
                    .define("remove_default_recipe", true);

            dragonAddIceandfire = builder
                    .comment("Only takes effect when Ice and Fire (iceandfire) is loaded.",
                            "Adds Ice and Fire-style recipes for the Poison Dragons mod's content.",
                            "Disable this to skip adding them.")
                    .translation("spartan_poison.config.poison_dragons.add_iceandfire")
                    .define("add_iceandfire_recipe", true);

            builder.pop();
        }
    }

    public static class Client {
        public final ForgeConfigSpec.BooleanValue overrideSwordTexture;

        Client(ForgeConfigSpec.Builder builder) {
            builder.comment("Client-side settings.").push("client");

            overrideSwordTexture = builder
                    .comment("Always active.",
                            "Overrides the Poison Dragons mod's own Poison Dragonbone Sword texture",
                            "with the one bundled in this mod.",
                            "Disable this to use the original texture.",
                            "",
                            "NOTE: Takes effect after a game restart or F3 + T (reload resources).")
                    .translation("spartan_poison.config.client.override_sword_texture")
                    .define("override_sword_texture", true);

            builder.pop();
        }
    }
}
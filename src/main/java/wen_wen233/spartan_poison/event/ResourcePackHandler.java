package wen_wen233.spartan_poison.event;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.server.packs.resources.IoSupplier;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import wen_wen233.spartan_poison.PoisonConfig;
import wen_wen233.spartan_poison.SpartanPoisonMod;

import javax.annotation.Nullable;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Set;

@Mod.EventBusSubscriber(modid = SpartanPoisonMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ResourcePackHandler {
    @SubscribeEvent
    public static void addPackFinders(AddPackFindersEvent event) {
        if (event.getPackType() != PackType.CLIENT_RESOURCES) return;

        Path resourcePath = ModList.get().getModFileById(SpartanPoisonMod.MODID)
                .getFile().findResource("resourcepacks/poison_override");

        event.addRepositorySource((packConsumer) -> {
            Pack pack = Pack.readMetaAndCreate(
                    "spartan_poison:poison_override",
                    Component.literal("Spartan Poison Override"),
                    true,
                    packId -> new ConditionalPackResources(packId, resourcePath),
                    PackType.CLIENT_RESOURCES,
                    Pack.Position.TOP,
                    PackSource.BUILT_IN
            );
            if (pack != null) {
                packConsumer.accept(pack);
            }
        });
    }

    private static class ConditionalPackResources implements PackResources {
        private final PathPackResources delegate;
        private final String packId;

        ConditionalPackResources(String packId, Path path) {
            this.packId = packId;
            this.delegate = new PathPackResources(packId, path, false);
        }

        private boolean disabled() {
            return !PoisonConfig.CLIENT.overrideSwordTexture.get();
        }

        @Nullable
        @Override
        public IoSupplier<InputStream> getRootResource(String... paths) {
            if (disabled()) return null;
            return delegate.getRootResource(paths);
        }

        @Nullable
        @Override
        public IoSupplier<InputStream> getResource(PackType type, ResourceLocation location) {
            if (disabled()) return null;
            return delegate.getResource(type, location);
        }

        @Override
        public void listResources(PackType type, String namespace, String path, ResourceOutput output) {
            if (disabled()) return;
            delegate.listResources(type, namespace, path, output);
        }

        @Override
        public Set<String> getNamespaces(PackType type) {
            if (disabled()) return Set.of();
            return delegate.getNamespaces(type);
        }

        @Nullable
        @Override
        public <T> T getMetadataSection(net.minecraft.server.packs.metadata.MetadataSectionSerializer<T> serializer) throws java.io.IOException {
            return delegate.getMetadataSection(serializer);
        }

        @Override
        public String packId() {
            return packId;
        }

        @Override
        public void close() {
            delegate.close();
        }
    }
}
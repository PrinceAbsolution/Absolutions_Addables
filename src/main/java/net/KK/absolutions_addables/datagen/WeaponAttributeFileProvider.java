package net.KK.absolutions_addables.datagen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.List;
import java.util.ArrayList;

public abstract class WeaponAttributeFileProvider implements DataProvider {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    protected final PackOutput.PathProvider filePathProvider;

    public WeaponAttributeFileProvider(PackOutput output) {
        this.filePathProvider = output.createPathProvider(PackOutput.Target.DATA_PACK, "weapon_attributes");
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        Set<ResourceLocation> uniqueFiles = new HashSet<>();
        List<CompletableFuture<?>> tasks = new ArrayList<>();

        this.buildFiles(finishedFile -> {
            if (!uniqueFiles.add(finishedFile.getId())) {
                throw new IllegalStateException("Duplicate file entry: " + finishedFile.getId());
            } else {
                Path path = this.filePathProvider.json(finishedFile.getId());
                CompletableFuture<?> task = DataProvider.saveStable(cache, finishedFile.getJson(), path);
                tasks.add(task);
                LOGGER.info("Generated weapon attribute JSON: " + path);
            }
        });

        return CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0]));
    }

    protected abstract void buildFiles(Consumer<FinishedFile> writer);

    @Override
    public String getName() {
        return "Weapon Attribute Files";
    }

    public static class FinishedFile {
        private final ResourceLocation id;
        private final JsonObject json;

        public FinishedFile(ResourceLocation id, JsonObject json) {
            this.id = id;
            this.json = json;
        }

        public ResourceLocation getId() {
            return id;
        }

        public JsonObject getJson() {
            return json;
        }
    }
}
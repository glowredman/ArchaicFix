package org.embeddedt.archaicfix.mixins.common.core;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureStart;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.*;

@Mixin(MapGenStructure.class)
public abstract class MixinMapGenStructure {

    @Redirect(method = { "func_143028_c", "func_142038_b", "func_151545_a", "generateStructuresInChunk" }, at = @At(value = "INVOKE", target = "Ljava/util/Map;values()Ljava/util/Collection;"))
    private Collection getStructureMapValues(Map structureMap) {
        return ImmutableList.copyOf(structureMap.values());
    }
}

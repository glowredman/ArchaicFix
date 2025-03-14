package org.embeddedt.archaicfix.asm;

import cpw.mods.fml.relauncher.FMLLaunchHandler;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.embeddedt.archaicfix.config.ArchaicConfig;
import org.embeddedt.archaicfix.helpers.DragonAPIHelper;

import java.util.Collection;
import java.util.Locale;
import java.util.function.Predicate;

@RequiredArgsConstructor
public enum Mixin {
    // COMMON MIXINS
    common_chickenchunks_MixinPlayerChunkViewerManager(Side.COMMON, Phase.EARLY, require(TargetedMod.CHICKENCHUNKS), "chickenchunks.MixinPlayerChunkViewerManager"),
    common_core_AccessorEntityLiving(Side.COMMON, Phase.EARLY, always(), "core.AccessorEntityLiving"),
    common_core_MixinEntityPlayerMP(Side.COMMON, Phase.EARLY, always(), "core.MixinEntityPlayerMP"),
    common_core_MixinWorldServer(Side.COMMON, Phase.EARLY, always(), "core.MixinWorldServer"),
    common_core_MixinMapGenStructure(Side.COMMON, Phase.EARLY, always(), "core.MixinMapGenStructure"),
    common_core_MixinEntityVillager(Side.COMMON, Phase.EARLY, always(), "core.MixinEntityVillager"),
    common_core_MixinMerchantRecipe(Side.COMMON, Phase.EARLY, always(), "core.MixinMerchantRecipe"),
    common_core_MixinAxisAlignedBB(Side.COMMON, Phase.EARLY, always(), "core.MixinAxisAlignedBB"),
    common_core_MixinMaterialLiquid(Side.COMMON, Phase.EARLY, always(), "core.MixinMaterialLiquid"),
    common_core_MixinChunkProviderServer(Side.COMMON, Phase.EARLY, always(), "core.MixinChunkProviderServer"),
    common_core_MixinChunkIOProvider(Side.COMMON, Phase.EARLY, always(), "core.MixinChunkIOProvider"),
    common_core_MixinCraftingManager(Side.COMMON, Phase.EARLY, always(), "core.MixinCraftingManager"),
    common_core_MixinSpawnerAnimals(Side.COMMON, Phase.EARLY, always(), "core.MixinSpawnerAnimals"),
    common_core_MixinShapedOreRecipe(Side.COMMON, Phase.EARLY, always(), "core.MixinShapedOreRecipe"),
    common_core_MixinLongHashMap(Side.COMMON, Phase.EARLY, always(), "core.MixinLongHashMap"),
    common_core_MixinBlock(Side.COMMON, Phase.EARLY, always(), "core.MixinBlock"),
    common_core_MixinBlock_Late(Side.COMMON, Phase.EARLY, always(), "core.MixinBlock_Late"),
    common_core_MixinEnchantmentHelper(Side.COMMON, Phase.EARLY, always(), "core.MixinEnchantmentHelper"),
    common_core_MixinWorldChunkManager(Side.COMMON, Phase.EARLY, always(), "core.MixinWorldChunkManager"),
    common_core_MixinShapedRecipes(Side.COMMON, Phase.EARLY, always(), "core.MixinShapedRecipes"),
    common_core_MixinShapelessOreRecipe(Side.COMMON, Phase.EARLY, always(), "core.MixinShapelessOreRecipe"),
    common_core_MixinShapelessRecipes(Side.COMMON, Phase.EARLY, always(), "core.MixinShapelessRecipes"),
    common_core_MixinEntityLiving(Side.COMMON, Phase.EARLY, always(), "core.MixinEntityLiving"),
    common_core_MixinEntityLivingBase_EarlyXpDrop(Side.COMMON, Phase.EARLY, m -> ArchaicConfig.dropXpImmediatelyOnDeath, "core.MixinEntityLivingBase_EarlyXpDrop"),
    common_core_MixinWorld(Side.COMMON, Phase.EARLY, always(), "core.MixinWorld"),
    common_core_MixinEntityTrackerEntry(Side.COMMON, Phase.EARLY, always(), "core.MixinEntityTrackerEntry"),
    common_core_MixinEntityXPOrb(Side.COMMON, Phase.EARLY, always(), "core.MixinEntityXPOrb"),
    common_core_MixinEntityItem(Side.COMMON, Phase.EARLY, avoid(TargetedMod.SHIPSMOD).and(m -> ArchaicConfig.itemLagReduction), "core.MixinEntityItem"),
    common_core_MixinEntity(Side.COMMON, Phase.EARLY, always(), "core.MixinEntity"),
    common_core_MixinForgeChunkManager(Side.COMMON, Phase.EARLY, always(), "core.MixinForgeChunkManager"),
    common_core_MixinChunk(Side.COMMON, Phase.EARLY, always(), "core.MixinChunk"),
    common_core_MixinStructureStart(Side.COMMON, Phase.EARLY, always(), "core.MixinStructureStart"),
    common_core_MixinOreDictionary(Side.COMMON, Phase.EARLY, always(), "core.MixinOreDictionary"),
    common_core_MixinChunkProviderHell(Side.COMMON, Phase.EARLY, always(), "core.MixinChunkProviderHell"),
    common_core_MixinASMData(Side.COMMON, Phase.EARLY, always(), "core.MixinASMData"),
    common_core_MixinModCandidate(Side.COMMON, Phase.EARLY, avoid(TargetedMod.COFHCORE), "core.MixinModCandidate"),
    common_core_MixinNetworkDispatcher(Side.COMMON, Phase.EARLY, m -> ArchaicConfig.fixLoginRaceCondition, "core.MixinNetworkDispatcher"),
    common_core_MixinNetworkManager(Side.COMMON, Phase.EARLY, m -> ArchaicConfig.fixLoginRaceCondition, "core.MixinNetworkManager"),
    common_core_MixinEmbeddedChannel(Side.COMMON, Phase.EARLY, m -> ArchaicConfig.fixLoginRaceCondition, "core.MixinEmbeddedChannel"),
    common_core_MixinNetHandlerPlayServer(Side.COMMON, Phase.EARLY, always(), "core.MixinNetHandlerPlayServer"),
    common_core_MixinSwampHut(Side.COMMON, Phase.EARLY, m -> ArchaicConfig.fixEntityStructurePersistence, "core.MixinSwampHut"),
    common_gt6_MixinAdvancedCraftingXToY(Side.COMMON, Phase.LATE, require(TargetedMod.GREGTECH6), "gt6.MixinAdvancedCraftingXToY"),
    common_gt6_MixinGT6_Main(Side.COMMON, Phase.LATE, require(TargetedMod.GREGTECH6), "gt6.MixinGT6_Main"),
    common_gt6_MixinCR(Side.COMMON, Phase.LATE, require(TargetedMod.GREGTECH6), "gt6.MixinCR"),
    common_lighting_MixinAnvilChunkLoader(Side.COMMON, Phase.EARLY, phosphor(), "lighting.MixinAnvilChunkLoader"),
    common_lighting_MixinChunk(Side.COMMON, Phase.EARLY, phosphor(), "lighting.MixinChunk"),
    common_lighting_MixinChunkProviderServer(Side.COMMON, Phase.EARLY, phosphor(), "lighting.MixinChunkProviderServer"),
    common_lighting_MixinChunkVanilla(Side.COMMON, Phase.EARLY, phosphor(), "lighting.MixinChunkVanilla"),
    common_lighting_MixinExtendedBlockStorage(Side.COMMON, Phase.EARLY, phosphor(), "lighting.MixinExtendedBlockStorage"),
    common_lighting_MixinSPacketChunkData(Side.COMMON, Phase.EARLY, phosphor(), "lighting.MixinSPacketChunkData"),
    common_lighting_MixinWorld(Side.COMMON, Phase.EARLY, phosphor(), "lighting.MixinWorld_Lighting"),
    common_mo_MixinMatterRegistry(Side.COMMON, Phase.LATE, require(TargetedMod.MATTEROVERDRIVE), "mo.MixinMatterRegistry"),
    common_mo_MixinMatterRegistrationHandler(Side.COMMON, Phase.LATE, require(TargetedMod.MATTEROVERDRIVE), "mo.MixinMatterRegistrationHandler"),
    common_mo_MixinVersionCheckHandler(Side.COMMON, Phase.LATE, require(TargetedMod.MATTEROVERDRIVE), "mo.MixinVersionCheckHandler"),
    common_mrtjp_MixinBlockUpdateHandler(Side.COMMON, Phase.LATE, require(TargetedMod.MRTJPCORE), "mrtjp.MixinBlockUpdateHandler"),
    common_pregen_MixinChunkProcessor(Side.COMMON, Phase.LATE, require(TargetedMod.CHUNK_PREGENERATOR), "pregen.MixinChunkProcessor"),
    common_pregen_MixinChunkHelper(Side.COMMON, Phase.LATE, require(TargetedMod.CHUNK_PREGENERATOR), "pregen.MixinChunkHelper"),
    common_projecte_MixinRecipeShapelessHidden(Side.COMMON, Phase.LATE, require(TargetedMod.PROJECTE), "projecte.MixinRecipeShapelessHidden"),
    common_tc4tweaks_MixinGenerateItemHash(Side.COMMON, Phase.LATE, require(TargetedMod.TC4TWEAKS).and(m -> ArchaicConfig.betterThaumcraftHashing), "tc4tweaks.MixinGenerateItemHash"),
    common_tc4tweaks_MixinMappingThread(Side.COMMON, Phase.LATE, require(TargetedMod.TC4TWEAKS).and(m -> ArchaicConfig.betterThaumcraftHashing), "tc4tweaks.MixinMappingThread"),
    common_thermal_MixinTECraftingHandler(Side.COMMON, Phase.LATE, require(TargetedMod.THERMALEXPANSION), "thermal.MixinTECraftingHandler"),
    // CLIENT MIXINS
    client_core_MixinThreadDownloadImageData(Side.CLIENT, Phase.EARLY, always(), "core.MixinThreadDownloadImageData"),
    client_core_MixinBlockFence(Side.CLIENT, Phase.EARLY, always(), "core.MixinBlockFence"),
    client_core_MixinEntityRenderer(Side.CLIENT, Phase.EARLY, always(), "core.MixinEntityRenderer"),
    client_core_MixinGuiBeaconButton(Side.CLIENT, Phase.EARLY, always(), "core.MixinGuiBeaconButton"),
    client_core_MixinGuiButton(Side.CLIENT, Phase.EARLY, always(), "core.MixinGuiButton"),
    client_core_MixinGuiContainerCreative(Side.CLIENT, Phase.EARLY, always(), "core.MixinGuiContainerCreative"),
    client_core_MixinIntegratedServer(Side.CLIENT, Phase.EARLY, always(), "core.MixinIntegratedServer"),
    client_core_MixinSkinManager(Side.CLIENT, Phase.EARLY, m -> ArchaicConfig.fixSkinMemoryLeak, "core.MixinSkinManager"),
    client_core_MixinChunkProviderClient(Side.CLIENT, Phase.EARLY, always(), "core.MixinChunkProviderClient"),
    client_core_MixinWorldRenderer(Side.CLIENT, Phase.EARLY, m -> !Boolean.valueOf(System.getProperty("archaicFix.disableMC129", "false")), "core.MixinWorldRenderer"),
    client_core_MixinMinecraft(Side.CLIENT, Phase.EARLY, always(), "core.MixinMinecraft"),
    client_core_MixinNetHandlerPlayClient(Side.CLIENT, Phase.EARLY, always(), "core.MixinNetHandlerPlayClient"),
    client_core_MixinGuiCreateWorld(Side.CLIENT, Phase.EARLY, always(), "core.MixinGuiCreateWorld"),
    client_core_MixinGuiIngameForge(Side.CLIENT, Phase.EARLY, always(), "core.MixinGuiIngameForge"),
    client_core_MixinFMLClientHandler(Side.CLIENT, Phase.EARLY, always(), "core.MixinFMLClientHandler"),
    client_core_MixinNetHandlerLoginClient(Side.CLIENT, Phase.EARLY, m -> ArchaicConfig.fixLoginRaceCondition, "core.MixinNetHandlerLoginClient"),
    client_core_MixinSplashProgress(Side.CLIENT, Phase.EARLY, always(), "core.MixinSplashProgress"),
    client_core_AccessorSplashProgress(Side.CLIENT, Phase.EARLY, always(), "core.AccessorSplashProgress"),
    client_core_MixinRenderItem(Side.CLIENT, Phase.EARLY, m -> ArchaicConfig.forceFancyItems, "core.MixinRenderItem"),
    client_divinerpg_MixinEntitySparkler(Side.CLIENT, Phase.LATE, require(TargetedMod.DIVINERPG), "divinerpg.MixinEntitySparkler"),
    client_gt6_MixinGT_API_Proxy_Client(Side.CLIENT, Phase.LATE, require(TargetedMod.GREGTECH6), "gt6.MixinGT_API_Proxy_Client"),
    client_lighting_MixinMinecraft(Side.CLIENT, Phase.EARLY, phosphor(), "lighting.MixinMinecraft"),
    client_lighting_MixinWorld(Side.CLIENT, Phase.EARLY, phosphor(), "lighting.MixinWorld"),
    client_lighting_MixinChunkCache(Side.CLIENT, Phase.EARLY, phosphor(), "lighting.MixinChunkCache"),

    client_optifine_MixinVersionCheckThread(Side.CLIENT, Phase.EARLY, require(TargetedMod.OPTIFINE).and(m -> ArchaicConfig.disableOFVersionCheck), "optifine.MixinVersionCheckThread"),

    client_renderdistance_MixinGameSettings(Side.CLIENT, Phase.EARLY, avoid(TargetedMod.OPTIFINE).and(avoid(TargetedMod.FASTCRAFT)).and(m -> ArchaicConfig.raiseMaxRenderDistance), "renderdistance.MixinGameSettings"),
    client_renderdistance_MixinRenderGlobal(Side.CLIENT, Phase.EARLY, avoid(TargetedMod.OPTIFINE).and(avoid(TargetedMod.FASTCRAFT)).and(m -> ArchaicConfig.raiseMaxRenderDistance), "renderdistance.MixinRenderGlobal"),
    common_renderdistance_MixinPlayerManager(Side.COMMON, Phase.EARLY, avoid(TargetedMod.OPTIFINE).and(avoid(TargetedMod.FASTCRAFT)).and(m -> ArchaicConfig.raiseMaxRenderDistance), "renderdistance.MixinPlayerManager"),

    // MOD-FILTERED MIXINS
    common_lighting_fastcraft_MixinChunk(Side.COMMON, Phase.EARLY, require(TargetedMod.FASTCRAFT).and(phosphor()), "lighting.fastcraft.MixinChunk"),
    common_lighting_fastcraft_MixinChunkProviderServer(Side.COMMON, Phase.EARLY, require(TargetedMod.FASTCRAFT).and(phosphor()), "lighting.fastcraft.MixinChunkProviderServer"),
    common_lighting_fastcraft_MixinWorld(Side.COMMON, Phase.EARLY, require(TargetedMod.FASTCRAFT).and(phosphor()), "lighting.fastcraft.MixinWorld"),

    common_mekanism_MixinGenHandler(Side.COMMON, Phase.LATE, require(TargetedMod.MEKANISM), "mekanism.MixinGenHandler"),

    common_thermal_MixinBlockOre(Side.COMMON, Phase.LATE, require(TargetedMod.THERMALFOUNDATION), "thermal.MixinBlockOre"),

    common_botania_MixinBlockSpecialFlower(Side.COMMON, Phase.LATE, require(TargetedMod.BOTANIA), "botania.MixinBlockSpecialFlower"),

    common_extrautils_MixinEventHandlerSiege(Side.COMMON, Phase.LATE, require(TargetedMod.EXTRAUTILS), "extrautils.MixinEventHandlerSiege"),
    common_extrautils_MixinEventHandlerServer(Side.COMMON, Phase.LATE, require(TargetedMod.EXTRAUTILS), "extrautils.MixinEventHandlerServer"),
    common_extrautils_MixinItemDivisionSigil(Side.COMMON, Phase.LATE, require(TargetedMod.EXTRAUTILS), "extrautils.MixinItemDivisionSigil"),
    common_extrautils_MixinTileEntityTrashCan(Side.COMMON, Phase.LATE, require(TargetedMod.EXTRAUTILS), "extrautils.MixinTileEntityTrashCan"),

    client_journeymap_MixinTileDrawStep(Side.CLIENT, Phase.LATE, require(TargetedMod.JOURNEYMAP).and(m -> ArchaicConfig.removeJourneymapDebug), "journeymap.MixinTileDrawStep"),

    client_aoa_MixinProjectileEntities(Side.CLIENT, Phase.LATE, require(TargetedMod.AOA), "aoa.MixinProjectileEntities"),

    common_am2_MixinPlayerTracker(Side.COMMON, Phase.LATE, require(TargetedMod.AM2), "am2.MixinPlayerTracker"),

    common_foodplus_MixinUpdater(Side.COMMON, Phase.LATE, require(TargetedMod.FOODPLUS).and(m -> ArchaicConfig.disableFoodPlusUpdates), "foodplus.MixinUpdater"),

    common_waystones_MixinItemWarpStone(Side.COMMON, Phase.LATE, require(TargetedMod.WAYSTONES), "waystones.MixinItemWarpStone"),

    /** This mixin will ostensibly be unnecessary after DragonAPI V31b */
    common_dragonapi_MixinReikaWorldHelper(Side.COMMON, Phase.LATE, m -> DragonAPIHelper.isVersionInInclusiveRange(0, 'a', 31, 'b') && !Boolean.valueOf(System.getProperty("archaicFix.disableFastReikaWorldHelper", "false")), "dragonapi.MixinReikaWorldHelper"),

    common_diversity_MixinServerHandler(Side.COMMON, Phase.LATE, require(TargetedMod.DIVERSITY), "diversity.MixinServerHandler")

    // The modFilter argument is a predicate, so you can also use the .and(), .or(), and .negate() methods to mix and match multiple predicates.
    ;

    @Getter
    public final Side side;
    @Getter
    public final Phase phase;
    @Getter
    public final Predicate<Collection<TargetedMod>> filter;
    private final String mixin;

    static Predicate<Collection<TargetedMod>> phosphor() {
        return m -> ArchaicConfig.enablePhosphor;
    }

    static Predicate<Collection<TargetedMod>> require(TargetedMod in) {
        return modList -> modList.contains(in);
    }

    static Predicate<Collection<TargetedMod>> avoid(TargetedMod in) {
        return modList -> !modList.contains(in);
    }

    static Predicate<Collection<TargetedMod>> always() {
        return m -> true;
    }

    enum Side {
        COMMON,
        CLIENT
    }

    public enum Phase {
        EARLY,
        LATE
    }

    public boolean shouldLoadSide() {
        return (side == Side.COMMON
                || (side == Side.CLIENT && FMLLaunchHandler.side().isClient()));
    }

    public String getMixin() {
        return side.name().toLowerCase(Locale.ROOT) + "." + mixin;
    }
}

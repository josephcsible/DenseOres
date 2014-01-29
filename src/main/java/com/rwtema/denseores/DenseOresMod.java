package com.rwtema.denseores;

import java.util.Map.Entry;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLModIdMappingEvent;
import cpw.mods.fml.common.event.FMLModIdMappingEvent.ModRemapping;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = DenseOresMod.MODID, version = DenseOresMod.VERSION)
public class DenseOresMod {
	public static final String MODID = "denseores";
	public static final String VERSION = "1.0";

	public static final String CATEGORY_BLOCK = "ores";

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		DenseOresConfig.instance.loadConfig(event.getSuggestedConfigurationFile());
		DenseOresRegistry.buildBlocks();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new WorldGenOres(), 1000);
	}

}

package io.github.realcaptainindia.pausemenuedits.config;

import java.io.File;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import io.github.realcaptainindia.pausemenuedits.PauseMenuEdits;
import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigBuilder {

	public static final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
	public static ForgeConfigSpec config;
	
	static
	{
		MenuConfig.init(builder);
		
		config = builder.build();
	}
	
	public static void loadConfig(ForgeConfigSpec config, String path)
	{
		PauseMenuEdits.LOGGER.info("Loading config: " + path);
		final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
		PauseMenuEdits.LOGGER.info("Built config: " + path);
		file.load();
		PauseMenuEdits.LOGGER.info("Loaded config: " + path);
		config.setConfig(file);
	}
}

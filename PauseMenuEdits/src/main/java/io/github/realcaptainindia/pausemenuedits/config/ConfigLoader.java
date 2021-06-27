package io.github.realcaptainindia.pausemenuedits.config;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URI;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import io.github.realcaptainindia.pausemenuedits.PauseMenuEdits;
import net.minecraftforge.fml.loading.FMLPaths;

public class ConfigLoader {

	public static Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().disableHtmlEscaping().create();
	public static Map<String, ButtonInfo> Buttons = new HashMap<String, ButtonInfo>();
	public static Map<String, Boolean> boolConfigVals = new HashMap<String, Boolean>();
	
	public static final File configFile = new File(FMLPaths.CONFIGDIR.get().resolve("pausemenuedits\\buttons.json").toString());
	public static final File assetsFolder = new File(FMLPaths.CONFIGDIR.get().resolve("pausemenuedits\\textures").toString());
	
	public ConfigLoader() {
		createMissingConfig();
		try {
			
			//Reads values from Config to a Buttons Map
			String configString = Files.readString(FMLPaths.CONFIGDIR.get().resolve("pausemenuedits\\buttons.json"));
			
			String configBoolean = configString.substring(0, configString.indexOf("\n\n"));
			String configButtons = configString.substring(configString.indexOf("\n\n"));
			
			boolConfigVals = gson.fromJson(configBoolean,new TypeToken<Map<String, Boolean>>() {}.getType());
			Buttons = gson.fromJson(configButtons, new TypeToken<Map<String, ButtonInfo>>() {}.getType());
			
			//Creates asset folder if custom assets enable and if folder doesn't exist
			if(boolConfigVals.get("Custom Textures")) {
				assetsFolder.mkdir();
			}
			
		} catch (IOException e) {
			PauseMenuEdits.LOGGER.warn("This went wrong with the mod files" + e.toString());
		}
	}
	
	void createMissingConfig(){
		try {
			//Creates Parent Config Folder
			configFile.getParentFile().mkdirs();
			
			//Creates and fills Json Button Config File
			if(configFile.createNewFile()) {
				populateButtonConfig();
			}
			
		} catch (IOException e) {
			PauseMenuEdits.LOGGER.warn("This went wrong with the mod files" + e.toString());
		}
	}
	
	void populateButtonConfig() {
		//Creates list of default values
		
		String defaultBooleans = gson.toJson(DefaultConfig.getBooleans() , new TypeToken<Map<String, Boolean>>(){}.getType());
		String defaultButtons = gson.toJson(DefaultConfig.getButtons() , new TypeToken<Map<String, ButtonInfo>>(){}.getType());
		
		try {
			//Writes the default values to json file
			FileWriter writer;
			writer = new FileWriter(configFile);
			writer.write(defaultBooleans + "\n\n" + defaultButtons);
			writer.close();
		} catch (IOException e) {
			PauseMenuEdits.LOGGER.warn("This went wrong with the config file" + e.toString());
		}
	}
	
//	void populateAssets() {
//		try { 
//			URI stream = this.getClass().getResource("/assets/pausemenuedits/textures").toURI();
//			
//			File textureFolder = new File(stream);
//			FileUtils.copyDirectory(textureFolder, assetsFolder);
//		} catch (Exception e) {
//			PauseMenuEdits.LOGGER.warn("This went wrong with the texture files" + e.toString());
//		}
//	}
}

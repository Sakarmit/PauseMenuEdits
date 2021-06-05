package io.github.realcaptainindia.pausemenuedits.config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
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
	public static Map<String, CustomButton> Buttons = new HashMap<String, CustomButton>();
	
	public static final File configFile = new File(FMLPaths.CONFIGDIR.get().resolve("pausemenuedits\\buttons.json").toString());
	public static final File assetsFolder = new File(FMLPaths.CONFIGDIR.get().resolve("pausemenuedits\\textures").toString());
	
	public ConfigLoader() {
		createMissingFiles();
		try {
			//Reads values from Config to a Buttons Map
			Buttons = gson.fromJson(new FileReader(configFile), new TypeToken<Map<String, CustomButton>>() {
			}.getType());
		} catch (IOException e) {
			PauseMenuEdits.LOGGER.warn("This went wrong with the mod files" + e.toString());
		}		
	}
	
	void createMissingFiles(){
		try {
			//Parent Config Folder
			configFile.getParentFile().mkdirs();
			
			//Json Config File
			if(configFile.createNewFile()) {
				populateConfig();
			}
			
			//Asset Folder
			if(assetsFolder.mkdir() || (assetsFolder.list().length == 0)) {
				populateAssets();
			}
		} catch (IOException e) {
			PauseMenuEdits.LOGGER.warn("This went wrong with the mod files" + e.toString());
		}
	}
	
	void populateConfig() {
		//Creates list of default values
		Map<String, CustomButton> defaultList = DefaultButtons.getButtons();
		String json = gson.toJson(defaultList, new TypeToken<Map<String, CustomButton>>() {
		}.getType());
		
		try {
			//Writes the default values to json file
			FileWriter writer;
			writer = new FileWriter(configFile);
			writer.write(json);
			writer.close();
		} catch (IOException e) {
			PauseMenuEdits.LOGGER.warn("This went wrong with the config file" + e.toString());
		}
	}
	void populateAssets() {
		try { 
			URI stream = this.getClass().getResource("/assets/pausemenuedits/textures").toURI();
			
			File textureFolder = new File(stream);
			FileUtils.copyDirectory(textureFolder, assetsFolder);
		} catch (Exception e) {
			PauseMenuEdits.LOGGER.warn("This went wrong with the texture files" + e.toString());
		}
	}
}

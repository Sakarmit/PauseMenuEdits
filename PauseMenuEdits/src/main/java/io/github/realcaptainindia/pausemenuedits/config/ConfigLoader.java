package io.github.realcaptainindia.pausemenuedits.config;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import io.github.realcaptainindia.pausemenuedits.PauseMenuEdits;
import io.github.realcaptainindia.pausemenuedits.elements.ButtonInfo;
import net.minecraftforge.fml.loading.FMLPaths;

public class ConfigLoader {

	public static Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().disableHtmlEscaping().create();
	public static Map<String, ButtonInfo> buttonVals = new HashMap<String, ButtonInfo>();
	public static Map<String, Boolean> boolVals = new HashMap<String, Boolean>();

	public static final File configFile = new File(
			FMLPaths.CONFIGDIR.get().resolve("pausemenuedits\\buttons.json").toString());
	public static final File assetsFolder = new File(
			FMLPaths.CONFIGDIR.get().resolve("pausemenuedits\\textures").toString());

	public ConfigLoader() {
		createMissingConfig();
		try {

			// Reads values from Config to a Buttons Map
			String configString = Files.readString(FMLPaths.CONFIGDIR.get().resolve("pausemenuedits\\buttons.json"));

			boolVals = this.getboolConfigVals(configString);
			buttonVals = this.getbuttonVals(configString);

			// Creates asset folder if custom assets enable and if folder doesn't exist
			if (boolVals.get("Custom Textures")) {
				assetsFolder.mkdir();
			}

		} catch (IOException e) {
			PauseMenuEdits.LOGGER.warn("This went wrong with loading the mod files: " + e.toString());
		}
	}

	private void createMissingConfig() {
		try {
			// Creates Parent Config Folder
			configFile.getParentFile().mkdirs();

			// Creates and fills Json Button Config File
			if (configFile.createNewFile()) {
				populateButtonConfig();
			}

		} catch (IOException e) {
			PauseMenuEdits.LOGGER.warn("This went wrong with creating the config files: " + e.toString());
		}
	}

	private void populateButtonConfig() {
		// Creates list of default values

		String defaultBooleans = gson.toJson(DefaultConfig.getBooleans(), new TypeToken<Map<String, Boolean>>() {
		}.getType());
		String defaultButtons = gson.toJson(DefaultConfig.getButtons(), new TypeToken<Map<String, ButtonInfo>>() {
		}.getType());

		try {
			// Writes the default values to json file
			FileWriter writer = new FileWriter(configFile);
			writer.write(defaultBooleans + "\nButtons:\n" + defaultButtons);
			writer.close();
		} catch (IOException e) {
			PauseMenuEdits.LOGGER.warn("This went wrong with filling config file: " + e.toString());
		}
		
	}
	
	private Map<String, ButtonInfo> getbuttonVals(String configStr) {
		String configButtons = configStr.substring(configStr.indexOf("Buttons:") + 8);
		
		try {
			return gson.fromJson(configButtons, new TypeToken<Map<String, ButtonInfo>>() {
			}.getType());
		} catch (JsonSyntaxException e) {
			PauseMenuEdits.LOGGER.warn("Invalid Buttons Config Check Formatting");
			return DefaultConfig.getButtons();
		}
	}

	private Map<String, Boolean> getboolConfigVals(String configStr) {
		String configBoolean = configStr.substring(0, configStr.indexOf("Buttons:"));
		
		try {
			return gson.fromJson(configBoolean, new TypeToken<Map<String, Boolean>>() {
			}.getType());
		} catch (JsonSyntaxException e) {
			PauseMenuEdits.LOGGER.warn("Invalid Boolean Config Check Formatting");
			return DefaultConfig.getBooleans();
		}
	}
}

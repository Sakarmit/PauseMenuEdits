package io.github.realcaptainindia.pausemenuedits.config;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import io.github.realcaptainindia.pausemenuedits.PauseMenuEdits;
import net.minecraftforge.fml.loading.FMLPaths;

public class JsonConfig {

	public static Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().disableHtmlEscaping().create();
	public static Map<String, CustomButton> Buttons = new HashMap<String, CustomButton>();

	public static void init() {
		File configFolder = new File(FMLPaths.CONFIGDIR.get().resolve("pausemenuedits\\buttons.json").toString());
		try {
			Files.createParentDirs(configFolder);
			if (!configFolder.exists() && configFolder.createNewFile()) {
				Map<String, CustomButton> defaultList = defaults();
				String json = gson.toJson(defaultList, new TypeToken<Map<String, CustomButton>>() {
				}.getType());
				
				FileWriter writer = new FileWriter(configFolder);
				writer.write(json);
				writer.close();
			}
			
			Buttons = gson.fromJson(new FileReader(configFolder), new TypeToken<Map<String, CustomButton>>() {
			}.getType());
		} catch (IOException e) {
			PauseMenuEdits.LOGGER.info("Something is wrong with the config file");
		}
	}

	private static Map<String, CustomButton> defaults() {
		Map<String, CustomButton> list = new LinkedHashMap<String, CustomButton>();
		list.put("UnPause Button", new CustomButton(-102, 70, 204, 20,
				"pausemenuedits:textures/defaultbuttons/button_unselected.png", 0, 0, "opengui", "Unpause"));

		list.put("Advancements Button", new CustomButton(-102, 45, 98, 20,
				"pausemenuedits:textures/defaultbuttons/button_unselected.png", 0, 0, "opengui", "Advancement"));

		list.put("Statistics Button", new CustomButton(4, 45, 98, 20, 
				"pausemenuedits:textures/defaultbuttons/button_unselected.png", 0, 0, "opengui", "Statistics"));

		list.put("Options Button", new CustomButton(-102, 20, 204, 20,
				"pausemenuedits:textures/defaultbuttons/button_unselected.png", 0, 0, "opengui", "Options"));

		list.put("Mods List Button", new CustomButton(-102, -5, 98, 20,
				"pausemenuedits:textures/defaultbuttons/button_unselected.png", 0, 0, "opengui", "Mods List"));

		list.put("Lan Button", new CustomButton(4, -5, 98, 20,
				"pausemenuedits:textures/defaultbuttons/button_unselected.png", 0, 0, "opengui", "Lan"));

		list.put("Main Menu Button", new CustomButton(-102, -30, 204, 20,
				"pausemenuedits:textures/defaultbuttons/button_unselected.png", 0, 0, "opengui", "Quit"));
		return list;
	}
}

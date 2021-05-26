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
	public static Map<String, ButtonInformation> Buttons = new HashMap<String, ButtonInformation>();

	public static void init() {
		File configFolder = new File(FMLPaths.CONFIGDIR.get().resolve("pausemenuedits\\buttons.json").toString());
		try {
			Files.createParentDirs(configFolder);
			if (!configFolder.exists() && configFolder.createNewFile()) {
				Map<String, ButtonInformation> defaultList = defaults();
				String json = gson.toJson(defaultList, new TypeToken<Map<String, ButtonInformation>>() {
				}.getType());
				FileWriter writer = new FileWriter(configFolder);
				writer.write(json);
				writer.close();
			}
			
			Buttons = gson.fromJson(new FileReader(configFolder), new TypeToken<Map<String, ButtonInformation>>() {
				}.getType());
		} catch (IOException e) {
			PauseMenuEdits.LOGGER.info("Something is wrong with the file loading/creation");
		}
	}

	private static Map<String, ButtonInformation> defaults() {
		Map<String, ButtonInformation> list = new LinkedHashMap<String, ButtonInformation>();
		list.put("Pause Button", new ButtonInformation(-102, 70, 204, 20,
				"pausemenuedits:textures/defaultbuttons/button_unselected.png"));

		list.put("Advancement Button", new ButtonInformation(-102, 45, 98, 20,
				"pausemenuedits:textures/defaultbuttons/button_unselected.png"));

		list.put("Stats Button",
				new ButtonInformation(4, 45, 98, 20, "pausemenuedits:textures/defaultbuttons/button_unselected.png"));

		list.put("Options Button", new ButtonInformation(-102, 20, 204, 20,
				"pausemenuedits:textures/defaultbuttons/button_unselected.png"));

		list.put("Mods Menu", new ButtonInformation(-102, -5, 98, 20,
				"pausemenuedits:textures/defaultbuttons/button_unselected.png"));

		list.put("Lan Button",
				new ButtonInformation(4, -5, 98, 20, "pausemenuedits:textures/defaultbuttons/button_unselected.png"));

		list.put("Main Menu", new ButtonInformation(-102, -30, 204, 20,
				"pausemenuedits:textures/defaultbuttons/button_unselected.png"));
		return list;
	}

	public static class ButtonInformation {
		public final int x_pos;
		public final int y_pos;
		public final int width;
		public final int height;
		public final String texture;

		public ButtonInformation(int x_pos, int y_pos, int width, int height, String texture) {
			this.x_pos = x_pos;
			this.y_pos = y_pos;
			this.width = width;
			this.height = height;
			this.texture = texture;
		}
	}
}

package io.github.realcaptainindia.pausemenuedits.config;

import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultConfig {

	public static Map<String, ButtonInfo> getButtons() {
		Map<String, ButtonInfo> list = new LinkedHashMap<String, ButtonInfo>();

		list.put("UnPause Button", new ButtonInfo(true, -102, 70, 204, 20, "Default.png", 0, 0, "Unpause"));

		list.put("Advancements Button", new ButtonInfo(true, -102, 45, 98, 20, "Default.png", 0, 0, "Advancement"));

		list.put("Statistics Button", new ButtonInfo(true, 4, 45, 98, 20, "Default.png", 0, 0, "Statistics"));

		list.put("Options Button", new ButtonInfo(true, -102, 20, 204, 20, "Default.png", 0, 0, "Options"));

		list.put("Mods List Button", new ButtonInfo(true, -102, -5, 98, 20, "Default.png", 0, 0, "Mods List"));

		list.put("Lan Button", new ButtonInfo(true, 4, -5, 98, 20, "Default.png", 0, 0, "Lan"));

		list.put("Main Menu Button", new ButtonInfo(true, -102, -30, 204, 20, "Default.png", 0, 0, "Quit"));

		return list;
	}

	public static Map<String, Boolean> getBooleans() {
		Map<String, Boolean> list = new LinkedHashMap<String, Boolean>();

		list.put("Custom Textures", false);

		return list;
	}
}

package io.github.realcaptainindia.pausemenuedits.config;

import java.util.LinkedHashMap;
import java.util.Map;

import io.github.realcaptainindia.pausemenuedits.elements.ButtonInfo;

public class DefaultConfig {

	public static Map<String, ButtonInfo> getButtons() {
		Map<String, ButtonInfo> list = new LinkedHashMap<String, ButtonInfo>();

		list.put("Return To Game", new ButtonInfo(true, -102, 70, 204, 20, "Default.png", 0, 0, "Unpause"));

		list.put("Advancements", new ButtonInfo(true, -102, 45, 98, 20, "Default.png", 0, 0, "Advancement"));

		list.put("Statistics", new ButtonInfo(true, 4, 45, 98, 20, "Default.png", 0, 0, "Statistics"));

		list.put("Options...", new ButtonInfo(true, -102, 20, 204, 20, "Default.png", 0, 0, "Options"));

		list.put("Mods List", new ButtonInfo(true, -102, -5, 98, 20, "Default.png", 0, 0, "Mods List"));

		list.put("Open to LAN", new ButtonInfo(true, 4, -5, 98, 20, "Default.png", 0, 0, "Lan"));

		list.put("Disconnect", new ButtonInfo(true, -102, -30, 204, 20, "Default.png", 0, 0, "Quit"));

		return list;
	}

	public static Map<String, Boolean> getBooleans() {
		Map<String, Boolean> list = new LinkedHashMap<String, Boolean>();

		list.put("Custom Textures", false);

		return list;
	}
}

package io.github.realcaptainindia.pausemenuedits.config;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

public class DefaultConfig {
	
	public static Map<String, ButtonInfo> getButtons() {
		Map<String, ButtonInfo> list = new LinkedHashMap<String, ButtonInfo>();
		
		list.put("UnPause Button", new ButtonInfo(-102, 70, 204, 20,
				"big_button", 0, 0, "opengui", "Unpause"));

		list.put("Advancements Button", new ButtonInfo(-102, 45, 98, 20,
				"medium_button.png", 0, 0, "opengui", "Advancement"));

		list.put("Statistics Button", new ButtonInfo(4, 45, 98, 20, 
				"medium_button.png", 0, 0, "opengui", "Statistics"));

		list.put("Options Button", new ButtonInfo(-102, 20, 204, 20,
				"big_button.png", 0, 0, "opengui", "Options"));

		list.put("Mods List Button", new ButtonInfo(-102, -5, 98, 20,
				"medium_button.png", 0, 0, "opengui", "Mods List"));

		list.put("Lan Button", new ButtonInfo(4, -5, 98, 20,
				"medium_button.png", 0, 0, "opengui", "Lan"));

		list.put("Main Menu Button", new ButtonInfo(-102, -30, 204, 20,
				"big_button.png", 0, 0, "opengui", "Quit"));
		
		return list;
	}
	
	public static Map<String, Boolean> getBooleans(){
		Map<String, Boolean> list = new LinkedHashMap<String, Boolean>();
		
		list.put("Custom Textures", false);
		
		return list;
	}
}

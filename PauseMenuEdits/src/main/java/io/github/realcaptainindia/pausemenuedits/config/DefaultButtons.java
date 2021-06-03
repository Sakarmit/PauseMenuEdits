package io.github.realcaptainindia.pausemenuedits.config;

import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultButtons {
	public static Map<String, CustomButton> getButtons() {
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

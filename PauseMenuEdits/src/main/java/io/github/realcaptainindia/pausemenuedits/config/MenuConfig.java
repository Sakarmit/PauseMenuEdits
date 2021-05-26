package io.github.realcaptainindia.pausemenuedits.config;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class MenuConfig {
	public static ConfigValue<String> Menu_Title;
	public static ConfigValue<List<? extends Integer>> Unpause_Button;
	public static ConfigValue<List<? extends Integer>> Advancement_Button;
	public static ConfigValue<List<? extends Integer>> Statistics_Button;
	public static ConfigValue<List<? extends Integer>> Mod_List_Button;
	public static ConfigValue<List<? extends Integer>> Options_Button;
	public static ConfigValue<List<? extends Integer>> Lan_Button;
	public static ConfigValue<List<? extends Integer>> Quit_Button;

	public static void init(ForgeConfigSpec.Builder modconfigfile) {
		Menu_Title = modconfigfile.comment("Title thats located at the top middle of the pause screen")
				.define("Menu Title", "Pause Menu");

		modconfigfile.push("Default Buttons");

		modconfigfile.comment("Format: [Horizontal Position, Vertical Position]", "");

		Unpause_Button = modconfigfile.defineList("UnPause Button    ", Arrays.asList(-102, 70),
				in -> in instanceof Integer);

		Advancement_Button = modconfigfile.defineList("Advancement Button", Arrays.asList(-102, 45),
				in -> in instanceof Integer);

		Statistics_Button = modconfigfile.defineList("Statistics Button ", Arrays.asList(4, 45),
				in -> in instanceof Integer);

		Options_Button = modconfigfile.defineList("Options Button    ", Arrays.asList(-102, 20),
				in -> in instanceof Integer);

		Mod_List_Button = modconfigfile.defineList("Mods List Button  ", Arrays.asList(-102, -5),
				in -> in instanceof Integer);

		Lan_Button = modconfigfile.defineList("Lan Button        ", Arrays.asList(4, -5), in -> in instanceof Integer);

		Quit_Button = modconfigfile.defineList("Quit Button       ", Arrays.asList(-102, -30),
				in -> in instanceof Integer);
		modconfigfile.pop();
	}
}

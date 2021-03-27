package io.github.realcaptainindia.pausemenuedits.config;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class MenuConfig {
	public static ConfigValue<String> Menu_Title;
	public static ConfigValue<List<Integer>> Unpause_Button;
	public static ConfigValue<List<Integer>> Advancement_Button;
	public static ConfigValue<List<Integer>> Statistics_Button;
	public static ConfigValue<List<Integer>> Feedback_Button;
	public static ConfigValue<List<Integer>> Report_Bug_Button;
	public static ConfigValue<List<Integer>> Options_Button;
	public static ConfigValue<List<Integer>> Lan_Button;
	public static ConfigValue<List<Integer>> Quit_Button;
	
	public static void init(ForgeConfigSpec.Builder modconfigfile) {
//	Menu_Title = modconfigfile.comment("Title thats located at the top middle of the pause screen")
//				  .define("Menu Title", "");
//
//	modconfigfile.push("Default Buttons");
//	
//	modconfigfile.comment("Format: [Horizontal Position, Vertical Position]","");
//	
//	Unpause_Button     = modconfigfile.define("Default Button    ", Arrays.asList(-102,70));
//	
//	Advancement_Button = modconfigfile.define("Advancement Button", Arrays.asList(-102,45));
//	
//	Statistics_Button  = modconfigfile.define("Statistics Button ", Arrays.asList(4,45));
//	
//	Feedback_Button    = modconfigfile.define("Feedback Button   ", Arrays.asList(-102,20));
//	
//	Report_Bug_Button  = modconfigfile.define("Bug Report Button ", Arrays.asList(4,20));
//	
//	Options_Button     = modconfigfile.define("Options Button    ", Arrays.asList(-102,-5));
//	
//	Lan_Button         = modconfigfile.define("Lan Button        ", Arrays.asList(4,-5));
//	
//	Quit_Button        = modconfigfile.define("Quit Button       ", Arrays.asList(-102,-30));
//	
//	modconfigfile.pop();
	}
}

package io.github.realcaptainindia.pausemenuedits;

import net.minecraft.util.ResourceLocation;

public class CustomButton {
	public final int x_pos;
	public final int y_pos;
	public final int width;
	public final int height;
	public final ResourceLocation texture;
	public final int texstartx;
	public final int texstarty;
	public final String action;
	public final String action_val;
	
	public CustomButton(int x_pos, int y_pos, int width, int height, String texture, int texstartx,int texstarty, String action, String value) {
		this.x_pos = x_pos;
		this.y_pos = y_pos;
		this.width = width;
		this.height = height;
		this.texture = new ResourceLocation(texture);
		this.texstartx = texstartx;
		this.texstarty = texstarty;
		this.action = action;
		this.action_val = value;
	}
	
}

package dev.hause.mackmod.module.modules.render;

import org.lwjgl.input.Keyboard;

import dev.hause.mackmod.module.Category;
import dev.hause.mackmod.module.Module;

public class Fullbright extends Module {
	
	public Fullbright() {
		super("Fullbright", Keyboard.KEY_NONE, Category.RENDER);
	}
	
	public void onEnable() {
		mc.gameSettings.gammaSetting = 69420f;
	}
	
	public void onDisable( ) {
		mc.gameSettings.gammaSetting = 1.0f;
	}

}

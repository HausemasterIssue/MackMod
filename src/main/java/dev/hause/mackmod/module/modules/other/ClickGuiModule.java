package dev.hause.mackmod.module.modules.other;

import org.lwjgl.input.Keyboard;

import dev.hause.mackmod.MackMod;
import dev.hause.mackmod.module.Category;
import dev.hause.mackmod.module.Module;

public class ClickGuiModule extends Module {
	
	public ClickGuiModule() {
		super("ClickGUI", Keyboard.KEY_RSHIFT, Category.OTHER);
	}
	
	public void onEnable() {
		mc.displayGuiScreen(MackMod.instance.clickGui);
		toggle();
	}

}

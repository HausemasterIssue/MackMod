package dev.hause.mackmod.module.modules.movement;

import org.lwjgl.input.Keyboard;

import dev.hause.mackmod.module.Category;
import dev.hause.mackmod.module.Module;
import dev.hause.mackmod.setting.settings.SettingDouble;

public class Step extends Module {
	
	SettingDouble stepHeight;
	
	public Step() {
		super("Step", Keyboard.KEY_NONE, Category.MOVEMENT);
		this.register("StepHeight", 3.0, 0.5, 10.0);
	}
	
	public void update() {
		mc.player.stepHeight = 2.0f;
	}
	
	public void onDisable() {
		mc.player.stepHeight = 0.5f;
	}

}

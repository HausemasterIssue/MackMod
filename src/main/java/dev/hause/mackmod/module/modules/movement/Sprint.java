package dev.hause.mackmod.module.modules.movement;

import org.lwjgl.input.Keyboard;

import dev.hause.mackmod.module.Category;
import dev.hause.mackmod.module.Module;
import dev.hause.mackmod.setting.settings.SettingBoolean;
import net.minecraft.client.settings.KeyBinding;

public class Sprint extends Module {
	
	
	public Sprint() {
		super("Sprint", Keyboard.KEY_NONE, Category.MOVEMENT);
	}
	
	public void update() {
		if(mc.gameSettings.keyBindForward.isKeyDown()) {
			if(mc.player.isHandActive() || mc.player.collidedHorizontally || mc.player.isSneaking()) {
				KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
				return;
			} else {
				KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
			}
		}
		
	}
	
	public void onDisable() {
		KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
	}

}

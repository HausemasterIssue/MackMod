package dev.hause.mackmod.module;

import java.util.ArrayList;

import dev.hause.mackmod.MackMod;
import dev.hause.mackmod.setting.settings.*;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

public class Module {
	
	public String name;
	public int key;
	public Category category;
	public boolean toggled;
	public Minecraft mc = Minecraft.getMinecraft();
	
	public Module(String name, int key, Category category) {
		this.name = name;
		this.key = key;
		this.category = category;
	}
	
	public void toggle() {
		toggled = !toggled;
		
		if(toggled) {
			enable();
		} else {
			disable();
		}
	}
	
	public void update() {
		
	}
	
	public void render() {
		
	}
	
	public void enable() {
		MackMod.EVENT_BUS.subscribe(this);
		MinecraftForge.EVENT_BUS.register(this);
		onEnable();
	}
	
	public void disable() {
		MackMod.EVENT_BUS.unsubscribe(this);
		MinecraftForge.EVENT_BUS.unregister(this);
		onDisable();
	}
	
	public void onEnable() {
		
	}
	
	public void onDisable() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean isToggled() {
		return toggled;
	}

	public void setToggled(boolean toggled) {
		this.toggled = toggled;
	}
	
	public SettingBoolean register(String name, boolean value) {
		SettingBoolean set = new SettingBoolean(name, this, value);
		MackMod.instance.settingsManager.settings.add(set);
		return set;
	}
	
	public SettingMode register(String name, ArrayList<String> values, String value) {
		SettingMode set = new SettingMode(name, this, values, value);
		MackMod.instance.settingsManager.settings.add(set);
		return set;
	}
	
	public SettingInteger register(String name, int value, int min, int max) {
		SettingInteger set = new SettingInteger(name, this, value, min, max);
		MackMod.instance.settingsManager.settings.add(set);
		return set;
	}
	
	public SettingDouble register(String name, double value, double min, double max) {
		SettingDouble set = new SettingDouble(name, this, value, min, max);
		MackMod.instance.settingsManager.settings.add(set);
		return set;
	}

}

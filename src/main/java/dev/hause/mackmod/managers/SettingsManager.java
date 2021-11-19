package dev.hause.mackmod.managers;

import java.util.ArrayList;

import dev.hause.mackmod.module.Module;
import dev.hause.mackmod.setting.Setting;

public class SettingsManager {
	
	public ArrayList<Setting> settings;
	
	public SettingsManager() {
		settings = new ArrayList<>();
	}
	
	public ArrayList<Setting> getSettingsInMod(Module mod) {
		ArrayList<Setting> sets = new ArrayList<>();
		for(Setting s : settings) {
			if(s.getMod() == mod) {
				sets.add(s);
			}
		}
		return sets;
	}

	public ArrayList<Setting> getSettings() {
		return settings;
	}

}

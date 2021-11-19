package dev.hause.mackmod.setting.settings;

import java.util.ArrayList;

import dev.hause.mackmod.module.Module;
import dev.hause.mackmod.setting.Setting;

public class SettingMode extends Setting {
	
	public String value;
	public ArrayList<String> values;
	public int index;
	
	public SettingMode(String name, Module mod, ArrayList<String> values, String value) {
		this.name = name;
		this.mod = mod;
		this.values = values;
		this.value = value;
		this.type = Setting.Type.MODE;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ArrayList<String> getValues() {
		return values;
	}

	public void setValues(ArrayList<String> values) {
		this.values = values;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	public void increment() {
		index++;
		if(index > values.size() - 1) {
			index = 0;
		}
		if(index < 0) {
			index = values.size() - 1;
		}
		value = values.get(index);
	}

}

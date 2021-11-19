package dev.hause.mackmod.managers;

import java.util.ArrayList;
import org.lwjgl.input.Keyboard;

import dev.hause.mackmod.module.Category;
import dev.hause.mackmod.module.Module;
import dev.hause.mackmod.module.modules.combat.*;
import dev.hause.mackmod.module.modules.movement.*;
import dev.hause.mackmod.module.modules.other.*;
import dev.hause.mackmod.module.modules.player.*;
import dev.hause.mackmod.module.modules.render.*;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

public class ModuleManager {
	
	public ArrayList<Module> modules;
	
	public ModuleManager() {
		modules = new ArrayList<Module>();
		MinecraftForge.EVENT_BUS.register(this);
		init();
	}
	
	public void init() {
		// combat
		modules.add(new Criticals());
		
		// exploits
		
		// misc
		
		// movement
		modules.add(new Step());
		modules.add(new Sprint());
		
		// player
		modules.add(new Velocity());
		
		// render
		modules.add(new Fullbright());
		
		//other
		modules.add(new ClickGuiModule());
	}
	
	public ArrayList<Module> getModules() {
		return modules;
	}
	
	public Module getModule(String name) {
		for(Module m : modules) {
			if(m.getName().equalsIgnoreCase(name)) {
				return m;
			}
		}
		return null;
	}
	
	public ArrayList<Module> getModulesInCategory(Category category) {
		ArrayList<Module> mods = new ArrayList<Module>();
		for(Module m : modules) {
			if(m.getCategory() == category) {
				mods.add(m);
			}
		}
		return mods;
	}
	
	@SubscribeEvent
	public void onKey(KeyInputEvent event) {
		if(Keyboard.getEventKeyState()) {
			for(Module m : modules) {
				if(m.getKey() == Keyboard.getEventKey()) {
					m.toggle();
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onUpdate(ClientTickEvent event) {
		for(Module m : modules) {
			if(m.isToggled()) {
				m.update();
			}
		}
	}
	
	@SubscribeEvent
	public void onRender(RenderWorldLastEvent event) {
		for(Module m : modules) {
			if(m.isToggled()) {
				m.render();
			}
		}
	}

}

package dev.hause.mackmod;

import dev.hause.mackmod.gui.ClickGUI;
import dev.hause.mackmod.managers.ModuleManager;
import dev.hause.mackmod.managers.SettingsManager;
import me.zero.alpine.EventManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "mackmod", name = "MackMod", version = "v0.1")
public class MackMod {
	
	@Instance
	public static MackMod instance = new MackMod();
	public static EventManager EVENT_BUS = new EventManager();
	
	public ModuleManager moduleManager;
	public SettingsManager settingsManager;
	public ClickGUI clickGui;
	
	@EventHandler
	public void init(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(instance);
		
		settingsManager = new SettingsManager();
		moduleManager = new ModuleManager();
		
		clickGui = new ClickGUI();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		System.out.println("fun fact: i got my knee stuck in the monkey bars once, almost had to call 911 - hause");
	}

}

package dev.hause.mackmod.event;

import dev.hause.mackmod.MackMod;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

public class EventProccessor {
	
	public EventProccessor() {
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	public void onKey(KeyInputEvent event) {
		MackMod.EVENT_BUS.post(event);
	}
	
	@SubscribeEvent
	public void onTick(ClientTickEvent event) {
		MackMod.EVENT_BUS.post(event);
	}
	
	@SubscribeEvent
	public void onRender(RenderGameOverlayEvent event) {
		MackMod.EVENT_BUS.post(event);
	}
	
	@SubscribeEvent
	public void onRenderWorld(RenderWorldLastEvent event) {
		MackMod.EVENT_BUS.post(event);
	}

}

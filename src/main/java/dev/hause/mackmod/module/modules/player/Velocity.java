package dev.hause.mackmod.module.modules.player;

import org.lwjgl.input.Keyboard;

import dev.hause.mackmod.event.events.PacketEvent;
import dev.hause.mackmod.module.Category;
import dev.hause.mackmod.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.network.play.server.SPacketExplosion;

public class Velocity extends Module {
	
	public Velocity() {
		super("Velocity", Keyboard.KEY_NONE, Category.PLAYER);
	}
	
	@EventHandler
	private final Listener<PacketEvent.Recieve> recieveListener = new Listener<>(event -> {
		if(event.getPacket() instanceof SPacketEntityVelocity) {
			if(((SPacketEntityVelocity) event.getPacket()).getEntityID() == mc.player.getEntityId()) {
				event.cancel();
			}
		}
		if(event.getPacket() instanceof SPacketExplosion) {
			event.cancel();
		}
	});

}

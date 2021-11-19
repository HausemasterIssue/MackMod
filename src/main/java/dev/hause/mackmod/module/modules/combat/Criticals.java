package dev.hause.mackmod.module.modules.combat;

import dev.hause.mackmod.event.events.PacketEvent;
import dev.hause.mackmod.module.Category;
import dev.hause.mackmod.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketUseEntity;
import org.lwjgl.input.Keyboard;

public class Criticals extends Module {
	
	public Criticals() {
		super("Criticals", Keyboard.KEY_NONE, Category.COMBAT);
	}
	
	@EventHandler
	private Listener<PacketEvent.Send> sendListener = new Listener<>(event -> {
		CPacketUseEntity packet = (CPacketUseEntity) event.getPacket();
		if(event.getPacket() instanceof CPacketUseEntity) {
			/*
			if(packet.getAction() != CPacketUseEntity.Action.ATTACK) {
				return;
			}
			
			Entity entity = packet.getEntityFromWorld(mc.world);
			if(!(entity instanceof EntityLivingBase)) {
				return;
			}
			*/
			
			mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 0.062602401692772D, mc.player.posZ, false));
            mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 0.0726023996066094D, mc.player.posZ, false));
            mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY, mc.player.posZ, false));
		}
	
	});

}

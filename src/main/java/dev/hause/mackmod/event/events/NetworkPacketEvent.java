package dev.hause.mackmod.event.events;

import dev.hause.mackmod.event.Event;
import net.minecraft.network.Packet;

public class NetworkPacketEvent extends Event {
	
	public Packet mPacket;
	
	public NetworkPacketEvent(Packet pPacket) {
		super();
		mPacket = pPacket;
	}
	
	public Packet GetPacket() {
		return mPacket;
	}
	
	public Packet getPacket() {
		return mPacket;
	}

}

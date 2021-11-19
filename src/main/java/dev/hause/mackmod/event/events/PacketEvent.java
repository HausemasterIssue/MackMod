package dev.hause.mackmod.event.events;

import dev.hause.mackmod.event.Event;
import net.minecraft.network.Packet;

public class PacketEvent extends Event {
	
	private final Packet packet;
	
	public PacketEvent(Packet packet) {
		super();
		this.packet = packet;
	}
	
	public Packet getPacket() {
		return this.packet;
	}
	
	public static class Recieve extends PacketEvent {
		public Recieve(Packet packet) {
			super(packet);
		}
	}
	
	public static class Send extends PacketEvent {
		public Send(Packet packet) {
			super(packet);
		}
	}
	
	public static class PostRecieve extends PacketEvent {
		public PostRecieve(Packet packet) {
			super(packet);
		}
	}
	
	public static class PostSend extends PacketEvent {
		public PostSend(Packet packet) {
			super(packet);
		}
	}

}

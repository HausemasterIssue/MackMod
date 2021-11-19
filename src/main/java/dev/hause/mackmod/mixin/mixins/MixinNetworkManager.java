package dev.hause.mackmod.mixin.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;
import dev.hause.mackmod.MackMod;
import dev.hause.mackmod.event.events.NetworkPacketEvent;
import dev.hause.mackmod.event.events.PacketEvent;
import dev.hause.mackmod.event.events.PacketEvent.PostRecieve;
import dev.hause.mackmod.event.events.PacketEvent.Recieve;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;

@Mixin(NetworkManager.class)
public class MixinNetworkManager {
 
	@Inject(method = "sendPacket(Lnet/minecraft/network/Packet;)V", at = @At("HEAD"), cancellable = true)
	private void onSendPacket(Packet<?> p_Packet, CallbackInfo callbackInfo) {
	    NetworkPacketEvent event = new NetworkPacketEvent(p_Packet);
	    MackMod.EVENT_BUS.post(event);
 
	    if (event.isCancelled()) {
	        callbackInfo.cancel();
	     }
	}
 
	@Inject(method = "sendPacket(Lnet/minecraft/network/Packet;)V", at = @At("HEAD"), cancellable = true)
	private void preSendPacket(Packet<?> packet, CallbackInfo callbackInfo) {
		PacketEvent.Send event = new PacketEvent.Send(packet);
		MackMod.EVENT_BUS.post(event);
 
		if (event.isCancelled()) {
			callbackInfo.cancel();
		}
	}
 
	@Inject(method = "channelRead0", at = @At("HEAD"), cancellable = true)
	private void preChannelRead(ChannelHandlerContext context, Packet<?> packet, CallbackInfo callbackInfo) {
		Recieve event = new Recieve(packet);
		MackMod.EVENT_BUS.post(event);
 
		if (event.isCancelled()) {
			callbackInfo.cancel();
		}
	}
 
	@Inject(method = "sendPacket(Lnet/minecraft/network/Packet;)V", at = @At("TAIL"), cancellable = true)
	private void postSendPacket(Packet<?> packet, CallbackInfo callbackInfo) {
		PacketEvent.PostSend event = new PacketEvent.PostSend(packet);
		MackMod.EVENT_BUS.post(event);
 
		if (event.isCancelled()) {
			callbackInfo.cancel();
		}
	}
 
	@Inject(method = "channelRead0", at = @At("TAIL"), cancellable = true)
	private void postChannelRead(ChannelHandlerContext context, Packet<?> packet, CallbackInfo callbackInfo) {
		PostRecieve event = new PostRecieve(packet);
		MackMod.EVENT_BUS.post(event);
 
		if (event.isCancelled()) {
			callbackInfo.cancel();
		}
	}
}

package dev.hause.mackmod.mixin.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.text.TextFormatting;

@Mixin((GuiMainMenu.class))
public class MixinGuiMainMenu extends GuiScreen {
	
	@Inject(method = {"drawScreen"}, at = {@At("TAIL")}, cancellable = true)
		public void drawText(CallbackInfo ci) {
			mc.fontRenderer.drawStringWithShadow(TextFormatting.WHITE + "MackMod " + TextFormatting.GRAY + "v0.1", 1, 1, -1);
			mc.fontRenderer.drawStringWithShadow(TextFormatting.WHITE + "Developed by " + TextFormatting.GRAY + "HausemasterIssue", 1, mc.fontRenderer.FONT_HEIGHT, 1);
		}
	}


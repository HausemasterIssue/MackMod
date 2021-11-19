package dev.hause.mackmod.gui;

import java.io.IOException;

import dev.hause.mackmod.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public class Button {
	
	public Frame parent;
	public Module module;
	public int offset;
	
	public Button(Frame parent, Module module) {
		this.parent = parent;
		this.module = module;
	}
	
	public void update(int mouseX, int mouseY) {

	}
	
	public void drawScreen(int mouseX, int mouseY, float partialTicks, int offset) {
		this.offset = offset;
		Gui.drawRect(parent.x, parent.y + offset, parent.x + parent.width, parent.y + offset + parent.barHeight, module.isToggled() ? 0x192090 : 0x90020201);
		Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(module.getName() + " ...", parent.x + 2, parent.y + offset + 2, -1);
	}

	protected void keyTyped(char typedChar, int keyCode) throws IOException {

	}

	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		if(mouseButton == 0) {
			if(bounding(mouseX, mouseY)) {
				module.toggle();
			}
		}
	}

	protected void mouseReleased(int mouseX, int mouseY, int state) {

	}
	
	public boolean bounding(int mouseX, int mouseY) {
		if(mouseX >= this.parent.x && mouseX <= this.parent.x + this.parent.width && mouseY >= this.parent.y + offset && mouseY <= this.parent.y + offset + parent.barHeight) {
			return true;
		} else {
			return false;
		}
		
	}

}

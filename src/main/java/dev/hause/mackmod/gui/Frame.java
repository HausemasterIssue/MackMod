package dev.hause.mackmod.gui;

import java.io.IOException;
import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public class Frame {
	
	public String name;
	public int x;
	public int y;
	public int width;
	public int height;
	public int barHeight;
	public int dragx;
	public int dragy;
	public boolean hovered;
	public boolean dragging;
	public boolean open;
	public int offset;
	public ArrayList<Button> buttons;
	
	public Frame(String name, int x, int y, int width, int barHeight) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.height = 200;
		this.barHeight = barHeight;
		this.width = width;
		buttons = new ArrayList<Button>();
	}
	
	public void update(int mouseX, int mouseY) {
		if(dragging) {
			x = mouseX - dragx;
			y = mouseY - dragy;
		}
		for(Button b : buttons) {
			b.update(mouseX, mouseY);
		}
	}
	
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		Gui.drawRect(x, y, x + width, y + barHeight, 0x70020201);
		Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(name, x + 2, y + 2, -1);
		offset = barHeight;
		for(Button b : buttons) {
			b.drawScreen(mouseX, mouseY, partialTicks, offset);
			offset += barHeight;
		}
	}

	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		for(Button b : buttons) {
			b.keyTyped(typedChar, keyCode);
		}
	}

	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		if(mouseButton == 0) {
			if(bounding(mouseX, mouseY)) {
				dragging = true;
				this.dragx = mouseX - x;
				this.dragy = mouseY - y;
			}
		}
		for(Button b : buttons) {
			b.mouseClicked(mouseX, mouseY, mouseButton);
		}
	}

	protected void mouseReleased(int mouseX, int mouseY, int state) {
		dragging = false;
		for(Button b : buttons) {
			b.mouseReleased(mouseX, mouseY, state);
		}
	}
	
	public boolean bounding(int mouseX, int mouseY) {
		if(mouseX >= this.x && mouseX <= this.x + this.width && mouseY >= this.y && mouseY <= this.y + barHeight) {
			return true;
		} else {
			return false;
		}
		
	}

}

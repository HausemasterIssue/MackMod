package dev.hause.mackmod.gui;

import java.io.IOException;
import java.util.ArrayList;

import dev.hause.mackmod.MackMod;
import dev.hause.mackmod.module.Category;
import dev.hause.mackmod.module.Module;
import net.minecraft.client.gui.GuiScreen;

public class ClickGUI extends GuiScreen {
	
	public ArrayList<Frame> frames;
	
	public ClickGUI() {
		int offset = 0;
		frames = new ArrayList<>();
		for(Category c : Category.values()) {
			Frame frame = new Frame(c.name(), 20 + offset, 20, 100, 12);
			for(Module m : MackMod.instance.moduleManager.getModulesInCategory(c)) {
				Button button = new Button(frame, m);
				frame.buttons.add(button);
			}
			frames.add(frame);
			offset += 120;
		}
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		super.drawScreen(mouseX, mouseY, partialTicks);
		for(Frame f : frames) {
			f.update(mouseX, mouseY);
			f.drawScreen(mouseX, mouseY, partialTicks);
		}
	}

	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		super.keyTyped(typedChar, keyCode);
		for(Frame f : frames) {
			f.keyTyped(typedChar, keyCode);
		}
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		for(Frame f : frames) {
			f.mouseClicked(mouseX, mouseY, mouseButton);
		}
	}

	@Override
	protected void mouseReleased(int mouseX, int mouseY, int state) {
		super.mouseReleased(mouseX, mouseY, state);
		for(Frame f : frames) {
			f.mouseReleased(mouseX, mouseY, state);
		}
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}


}

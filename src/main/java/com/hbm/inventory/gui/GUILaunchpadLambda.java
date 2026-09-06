package com.hbm.inventory.gui;

import org.lwjgl.opengl.GL11;

import com.hbm.inventory.container.ContainerLaunchpadLambda;
import com.hbm.lib.RefStrings;
import com.hbm.tileentity.machine.TileEntityLaunchpadLambda;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GUILaunchpadLambda extends GuiInfoContainer {

	private static ResourceLocation texture = new ResourceLocation(RefStrings.MODID + ":textures/gui/machine/gui_launchpad_lambda.png");
	private TileEntityLaunchpadLambda launcher;
	
	public GUILaunchpadLambda(InventoryPlayer invPlayer, TileEntityLaunchpadLambda tedf) {
		super(new ContainerLaunchpadLambda(invPlayer, tedf));
		launcher = tedf;
		
		this.xSize = 176;
		this.ySize = 226;
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float f) {
		super.drawScreen(mouseX, mouseY, f);

		launcher.tanks[0].renderTankInfo(this, mouseX, mouseY, guiLeft + 107, guiTop + 44, 16, 52);
		launcher.tanks[1].renderTankInfo(this, mouseX, mouseY, guiLeft + 125, guiTop + 44, 16, 52);
		this.drawElectricityInfo(this, mouseX, mouseY, guiLeft + 89, guiTop + 26, 16, 52, launcher.power, launcher.maxPower);
	}

	@Override
	protected void drawGuiContainerForegroundLayer( int i, int j) {
		this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float interp, int x, int y) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
}

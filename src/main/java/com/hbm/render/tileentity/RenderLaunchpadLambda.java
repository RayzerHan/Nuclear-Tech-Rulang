package com.hbm.render.tileentity;

import org.lwjgl.opengl.GL11;

import com.hbm.main.ResourceManager;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class RenderLaunchpadLambda extends TileEntitySpecialRenderer {

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float interp) {
		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5, y, z + 0.5);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		
		float rotation = 0F;

		switch(tile.getBlockMetadata() - 10) {
		case 2: rotation = 90F; break;
		case 4: rotation = 180F; break;
		case 3: rotation = 270F; break;
		case 5: rotation = 0F; break;
		}
		
		GL11.glRotatef(rotation, 0F, 1F, 0F);

		double doors = 3D;
		double erector = 0D;
		double rotor = 0D;
		double clamps = 0D;
		double pistons = 0D;

		bindTexture(ResourceManager.launchpad_lambda_tex);
		ResourceManager.launchpad_lambda.renderPart("Silo");

		GL11.glPushMatrix(); {
			GL11.glTranslated(0, 0, doors);
			ResourceManager.launchpad_lambda.renderPart("DoorLeft");
		} GL11.glPopMatrix();
		
		GL11.glPushMatrix(); {
			GL11.glTranslated(0, 0, -doors);
			ResourceManager.launchpad_lambda.renderPart("DoorRight");
		} GL11.glPopMatrix();
		
		
		GL11.glTranslated(0, erector, 0);
		
		ResourceManager.launchpad_lambda.renderPart("Erector");

		GL11.glTranslated(0, 13.25, 0);
		GL11.glRotated(rotor, 1, 0, 0);
		GL11.glTranslated(0, -13.25, 0);
		
		ResourceManager.launchpad_lambda.renderPart("Rotor");
		
		GL11.glPushMatrix(); {
			GL11.glTranslated(3.5, 19.75, 0);
			GL11.glRotated(-clamps, 0, 0, 1);
			GL11.glTranslated(-3.5, -19.75, 0);
			ResourceManager.launchpad_lambda.renderPart("PivotUpper1");
			GL11.glTranslated(pistons, 0, 0);
			ResourceManager.launchpad_lambda.renderPart("ClampUpper1");
		} GL11.glPopMatrix();

		GL11.glPushMatrix(); {
			GL11.glTranslated(3.5, 6.75, 0);
			GL11.glRotated(clamps, 0, 0, 1);
			GL11.glTranslated(-3.5, -6.75, 0);
			ResourceManager.launchpad_lambda.renderPart("PivotLower1");
			GL11.glTranslated(pistons, 0, 0);
			ResourceManager.launchpad_lambda.renderPart("ClampLower1");
		} GL11.glPopMatrix();
		
		GL11.glPushMatrix(); {
			GL11.glTranslated(-3.5, 19.75, 0);
			GL11.glRotated(clamps, 0, 0, 1);
			GL11.glTranslated(3.5, -19.75, 0);
			ResourceManager.launchpad_lambda.renderPart("PivotUpper2");
			GL11.glTranslated(-pistons, 0, 0);
			ResourceManager.launchpad_lambda.renderPart("ClampUpper2");
		} GL11.glPopMatrix();

		GL11.glPushMatrix(); {
			GL11.glTranslated(-3.5, 6.75, 0);
			GL11.glRotated(-clamps, 0, 0, 1);
			GL11.glTranslated(3.5, -6.75, 0);
			ResourceManager.launchpad_lambda.renderPart("PivotLower2");
			GL11.glTranslated(-pistons, 0, 0);
			ResourceManager.launchpad_lambda.renderPart("ClampLower2");
		} GL11.glPopMatrix();

		GL11.glTranslated(0, 2, 0);
		bindTexture(ResourceManager.lambda_rocket_tex);
		ResourceManager.lambda_rocket.renderAll();
		
		GL11.glShadeModel(GL11.GL_FLAT);
		GL11.glPopMatrix();
	}

}

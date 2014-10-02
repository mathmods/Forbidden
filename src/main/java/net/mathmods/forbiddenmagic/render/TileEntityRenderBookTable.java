package net.mathmods.forbiddenmagic.render;

import org.lwjgl.opengl.GL11;

import net.mathmods.forbiddenmagic.Forbidden;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityRenderBookTable extends TileEntitySpecialRenderer {

	public ResourceLocation Texture = new ResourceLocation("forbiddenmagic", "tile/tileBookStand/tileBookStand.png");
	
	float pixel = 1F/16F;
	float texturepixel = 1F/64F;
	
	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y,
			double z, float f) {
		GL11.glTranslated(x, y, z);
		GL11.glDisable(GL11.GL_LIGHTING);
		this.bindTexture(Texture);
		drawSide(tile);
		drawBottom(tile);
		drawTop(tile);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glTranslated(-x, -y, -z);
	}
	
	public void drawSide(TileEntity tile){
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		{
			tessellator.addVertexWithUV(1, 0, 1, texturepixel*32, texturepixel*32);
			tessellator.addVertexWithUV(1, 1-pixel*7, 1, texturepixel*32, texturepixel*18);
			tessellator.addVertexWithUV(0, 1-pixel*7, 1, texturepixel*0, texturepixel*18);
			tessellator.addVertexWithUV(0, 0, 1, texturepixel*0, texturepixel*32);
			
			tessellator.addVertexWithUV(1, 0, 0, texturepixel*32, texturepixel*32);
			tessellator.addVertexWithUV(1, 1-pixel*7, 0, texturepixel*32, texturepixel*18);
			tessellator.addVertexWithUV(1, 1-pixel*7, 1, texturepixel*0, texturepixel*18);
			tessellator.addVertexWithUV(1, 0, 1, texturepixel*0, texturepixel*32);
			
			tessellator.addVertexWithUV(0, 0, 0, texturepixel*32, texturepixel*32);
			tessellator.addVertexWithUV(0, 1-pixel*7, 0, texturepixel*32, texturepixel*18);
			tessellator.addVertexWithUV(1, 1-pixel*7, 0, texturepixel*0, texturepixel*18);
			tessellator.addVertexWithUV(1, 0, 0, texturepixel*0, texturepixel*32);
			
			tessellator.addVertexWithUV(0, 0, 1, texturepixel*32, texturepixel*32);
			tessellator.addVertexWithUV(0, 1-pixel*7, 1, texturepixel*32, texturepixel*18);
			tessellator.addVertexWithUV(0, 1-pixel*7, 0, texturepixel*0, texturepixel*18);
			tessellator.addVertexWithUV(0, 0, 0, texturepixel*0, texturepixel*32);
		}
		tessellator.draw();
	}
	
	public void drawTop(TileEntity tile){
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		{
			tessellator.addVertexWithUV(1, pixel*9, 1, texturepixel*32, 1);
			tessellator.addVertexWithUV(1, pixel*9, 0, texturepixel*32, texturepixel*32);
			tessellator.addVertexWithUV(0, pixel*9, 0, texturepixel*0, texturepixel*32);
			tessellator.addVertexWithUV(0, pixel*9, 1, texturepixel*0, 1);
		}
		tessellator.draw();
	}
	
	public void drawBottom(TileEntity tile){
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		{
			tessellator.addVertexWithUV(1, 0, 1, texturepixel*64, texturepixel*32);
			tessellator.addVertexWithUV(0, 0, 1, texturepixel*64, texturepixel*0);
			tessellator.addVertexWithUV(0, 0, 0, texturepixel*33, texturepixel*0);
			tessellator.addVertexWithUV(1, 0, 0, texturepixel*33, texturepixel*32);
		}
		tessellator.draw();
	}

}

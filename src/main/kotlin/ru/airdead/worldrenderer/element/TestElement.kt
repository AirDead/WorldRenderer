package ru.airdead.worldrenderer.element

import com.mojang.blaze3d.systems.RenderSystem
import net.minecraft.client.render.GameRenderer
import net.minecraft.client.render.Tessellator
import net.minecraft.client.render.VertexFormat
import net.minecraft.client.render.VertexFormats
import net.minecraft.client.util.math.MatrixStack
import org.lwjgl.opengl.GL11

class TestElement : AbstractElement() {
    override fun render(matrixStack: MatrixStack) {
        val positionMatrix = matrixStack.peek().positionMatrix
        val tessellator = Tessellator.getInstance()
        val buffer = tessellator.buffer

        buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR)
        buffer.vertex(positionMatrix, 0f, 1f, 0f).color(1f, 1f, 1f, 1f).next()
        buffer.vertex(positionMatrix, 0f, 0f, 0f).color(1f, 1f, 1f, 1f).next()
        buffer.vertex(positionMatrix, 1f, 0f, 0f).color(1f, 1f, 1f, 1f).next()
        buffer.vertex(positionMatrix, 1f, 1f, 0f).color(1f, 1f, 1f, 1f).next()

        RenderSystem.setShader { GameRenderer.getPositionColorProgram() }
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f)
        RenderSystem.disableCull()
        RenderSystem.depthFunc(GL11.GL_ALWAYS)

        tessellator.draw()

        RenderSystem.depthFunc(GL11.GL_LEQUAL)
        RenderSystem.enableCull()
    }
}
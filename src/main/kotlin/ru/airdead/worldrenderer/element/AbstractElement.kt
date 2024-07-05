package ru.airdead.worldrenderer.element

import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext
import net.minecraft.client.render.Camera
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.math.RotationAxis
import ru.airdead.worldrenderer.utility.V3
import ru.airdead.worldrenderer.utility.WEST

abstract class AbstractElement : IElement {
    override var location: V3 = V3(0f, 100f, 0f)
    override var scale: V3 = V3(1f, 1f, 1f)
    var side: Float = WEST

    fun transformAndRender(worldContext: WorldRenderContext) {
        val camera: Camera = worldContext.camera()
        val transformedPosition = location.subtract(camera.pos)
        val matrixStack = MatrixStack().apply {
            multiply(RotationAxis.POSITIVE_X.rotationDegrees(camera.pitch))
            multiply(RotationAxis.POSITIVE_Y.rotationDegrees(camera.yaw + 180.0F))
            translate(
                transformedPosition.x - scale.x / 2,
                transformedPosition.y - scale.y / 2,
                transformedPosition.z - scale.z / 2
            )

            multiply(RotationAxis.POSITIVE_Y.rotationDegrees(side))
            scale(scale.x, scale.y, scale.z)
        }
        render(matrixStack)
    }


    abstract fun render(matrixStack: MatrixStack)
}

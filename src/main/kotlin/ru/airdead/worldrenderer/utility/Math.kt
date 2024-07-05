package ru.airdead.worldrenderer.utility

import net.minecraft.util.math.Vec3d

data class V3(
    val x: Float,
    val y: Float,
    val z: Float
) {
    fun subtract(other: Vec3d): V3 {
        return V3(x - other.x.toFloat(), y - other.y.toFloat(), z - other.z.toFloat())
    }

    fun subtract(other: V3): V3 {
        return V3(x - other.x, y - other.y, z - other.z)
    }
}
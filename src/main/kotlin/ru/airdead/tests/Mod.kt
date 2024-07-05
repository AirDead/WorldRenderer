package ru.airdead.tests

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents
import ru.airdead.worldrenderer.element.TestElement

class Mod : ClientModInitializer {
    override fun onInitializeClient() {
        WorldRenderEvents.END.register { context ->
            TestElement().transformAndRender(context)
        }



    }
}
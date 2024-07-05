package ru.airdead.worldrenderer.element

import ru.airdead.worldrenderer.utility.V3

/**
 * Interface representing a UI element.
 */
interface IElement {

    /**
     * The size of the element.
     */
    var scale: V3

    /**
     * The location of the element.
     */
    var location: V3

}

package com.tcreative.addons.furniture

import com.tcreative.devtools.stdlib.furnitures.furniture
import com.tcreative.devtools.stdlib.furnitures.furniturepresets.lamp.util.LightState
import com.tcreative.devtools.stdlib.furnitures.lamp
import com.tcreative.devtools.tranclate.builder.getResource
import com.tcreative.devtools.tranclate.systemaddon.Addon
import java.awt.Color

class TableLamp(addon: Addon) {
    init {
        lamp("table_lamp", "Table Lamp", addon) {

            /**
             * reads the geometry from the file and adds it to the entity.
             * The geo file also automatically added to the addon.
             * The name will include a hash of the file path, so don't worry about file name collisions
             */
            geometry = getResource("furniture-resources/modern_lamp/modern_lamp1.geo.json")

            /**
             * adds the texture file to the addon and adds the texture to the entity.
             * The name will include a hash of the file path, so don't worry about file name collisions
             */
            texture = getResource("furniture-resources/modern_lamp/modern_lamp1.png")

            height = 0.7f   // hitbox height
            width = 0.5f    // hitbox width

            initialLightState = LightState.OFF
            lightSwitchOnInteract = true // player can switch the lamp on and off via interaction

            /**
             * defines the appearance of the spawn egg.
             * In this case it is a normal spawn egg with custom colors set by hash values.
             */
            icon {
                eggByColor("#5c5c5c", "#f9ff4c")
            }


            /**
             * Defines the relative position and brightness of the light block that gets set to emit light
             */
            lightSource {
                x = 0f
                y = 0f
                z = 0f
                brightness = 8
            }
        }
    }
}
package com.tcreative.addons.furniture

import com.tcreative.devtools.stdlib.furnitures.furniturepresets.lamp.util.LightState
import com.tcreative.devtools.stdlib.furnitures.lamp
import com.tcreative.devtools.tranclate.builder.getResource
import com.tcreative.devtools.tranclate.systemaddon.Addon

class Chandelier(addon: Addon) {
    init {
        lamp("chandelier", "Chandelier", addon) {
            /**
             * This function loads every resource from a blockbench file to your addon and adds it to this entiy.
             * including: geometry, textures, animations
             *
             * The names of the textures and geometry will include a hash of the file path,
             * so don't worry about file name collisions
             */
            loadBlockbenchFile(getResource("furniture-resources/modern_chandelier/modern_chandelier1.bbmodel"))


            hangingLamp = true  // disables gravity for the lamp, so it doesn't fall down from the place where it should hang
            initialLightState = LightState.ON

            /**
             * defines the appearance of the spawn egg.
             * In this case the spawn egg is a custom texture. The texture will be automatically added to addon.
             *
             * The names of the textures and geometry will include a hash of the file path,
             * so don't worry about file name collisions
             */
            icon {
                eggByFile(getResource("furniture-resources/modern_chandelier/moderin_chandelier_1.icon.png"))
            }

            lightSource { // defines the position (relative to the entity) and brightness of the light block that gets set to emit light
                x = 0f
                y = 0f
                z = 0f
                brightness = 15
            }
        }
    }
}
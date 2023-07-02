package com.tcreative.addons.furniture

import com.tcreative.devtools.stdlib.furnitures.furniture
import com.tcreative.devtools.tranclate.builder.getResource
import com.tcreative.devtools.tranclate.systemaddon.Addon
import java.awt.Color

class Table(addon: Addon) {
    init {
        furniture("table", "Table", addon) {

            /**
             * This function loads every resource from a blockbench file to your addon and adds it to this entiy.
             * including: geometry, textures, animations
             *
             * The names of the textures and geometry will include a hash of the file path,
             * so don't worry about file name collisions
             */
            loadBlockbenchFile(getResource("furniture-resources/modern_table1.bbmodel"))

            height = 1f // hitbox height
            width = 2f  // hitbox width

            autoRotationAdjustment = true // aligns the entity with the closest axis after spawned

            /**
             * defines the appearance of the spawn egg.
             * In this case it is a normal spawn egg with custom colors set by using the java.awt Color class.
             * You can use the rgb values to set a custom color or use one of the color presets.
             */
            icon {
                eggByColor(Color(75,75,75), Color.lightGray)
            }
        }
    }
}
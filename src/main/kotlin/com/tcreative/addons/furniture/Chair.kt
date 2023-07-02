package com.tcreative.addons.furniture

import com.tcreative.devtools.stdlib.furnitures.seatingFurniture
import com.tcreative.devtools.tranclate.addon.molang.Query
import com.tcreative.devtools.tranclate.builder.getResource
import com.tcreative.devtools.tranclate.systemaddon.Addon
import java.awt.Color

class Chair(val addon: Addon) {
    fun buildVariant(color : String) : Chair {
        seatingFurniture("chair_$color", "${color[0].uppercase()}${color.subSequence(1, color.length)} Chair", addon) {
            /**
             * reads the geometry from the file and adds it to the entity.
             * The geo file also automatically added to the addon.
             * The name will include a hash of the file path, so don't worry about file name collisions
             */
            geometry = getResource("furniture-resources/modern_chair/modern_chair_1.geo.json")

            /**
             * Adds the texture file to the addon and adds the texture to the entity.
             * The name will include a hash of the file path, so don't worry about file name collisions
             *
             * The filename with the $color has to exist in the resources otherwise there will be a FileNotFound exeption
             */
            texture = getResource("furniture-resources/modern_chair/modern_chair_1_$color.png")

            addSeat(Triple(0f, 0.4f, -0.1f)) // adds a seat to the rideable component of the entity. Can be called multiple times

            autoRotationAdjustment = true // aligns the entity with the closest axis after spawned

            /**
             * defines the appearance of the spawn egg.
             * In this case the spawn egg appearance is set with two colors using the java.awt color class
             */
            icon {
                eggByColor(stringToColor(color), Color.LIGHT_GRAY)
            }
        }
        return this
    }

    /**
     * function to allocate color name strings to Color objects and return the corresponding color
     */
    private fun stringToColor(color: String) : Color {
        when(color) {
            "white" -> return Color.WHITE
            "grey" -> return Color.GRAY
            "black" -> return Color.BLACK
            "orange" -> return Color.ORANGE
            "cyan" -> return Color.CYAN
            "green" -> return Color(1,136,0) // you can also set a custom color with its rgb values
        }
        return Color.RED // should not reach this. The Color should be returned before
    }
}
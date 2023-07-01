package com.tcreative.addons.furniture

import com.tcreative.devtools.stdlib.furnitures.seatingFurniture
import com.tcreative.devtools.tranclate.addon.molang.Query
import com.tcreative.devtools.tranclate.builder.getResource
import com.tcreative.devtools.tranclate.systemaddon.Addon

class Chair(val addon: Addon) {
    fun buildVariant(color : String) : Chair {
        seatingFurniture("chair_$color", "${color[0].uppercase()}${color.subSequence(1, color.length)} Chair", addon) {
            geometry = getResource("furniture-resources/modern_chair/modern_chair_1.geo.json")
            texture = getResource("furniture-resources/modern_chair/modern_chair_1_$color.png")
            addSeat(Triple(0f, 0.4f, 0f))
        }
        return this
    }
}
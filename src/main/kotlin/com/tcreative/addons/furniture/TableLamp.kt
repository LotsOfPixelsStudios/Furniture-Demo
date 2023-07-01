package com.tcreative.addons.furniture

import com.tcreative.devtools.stdlib.furnitures.furniture
import com.tcreative.devtools.stdlib.furnitures.lamp
import com.tcreative.devtools.tranclate.builder.getResource
import com.tcreative.devtools.tranclate.systemaddon.Addon

class TableLamp(addon: Addon) {
    init {
        lamp("table_lamp", "Table Lamp", addon) {
            geometry = getResource("furniture-resources/modern_lamp/modern_lamp1.geo.json")
            texture = getResource("furniture-resources/modern_lamp/modern_lamp1.png")
        }
    }
}
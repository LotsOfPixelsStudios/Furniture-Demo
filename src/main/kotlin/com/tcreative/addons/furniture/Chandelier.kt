package com.tcreative.addons.furniture

import com.tcreative.devtools.stdlib.blockbench.loadBlockbenchFile
import com.tcreative.devtools.stdlib.furnitures.furniture
import com.tcreative.devtools.stdlib.furnitures.lamp
import com.tcreative.devtools.tranclate.builder.getResource
import com.tcreative.devtools.tranclate.systemaddon.Addon

class Chandelier(val addon: Addon) {
    init {
        lamp("chandelier", "Chandelier", addon) {
            loadBlockbenchFile(getResource("furniture-resources/modern_chandelier1.bbmodel"))
        }
    }
}
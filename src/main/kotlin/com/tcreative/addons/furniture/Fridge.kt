package com.tcreative.addons.furniture

import com.tcreative.devtools.stdlib.blockbench.loadBlockbenchFile
import com.tcreative.devtools.stdlib.furnitures.furniture
import com.tcreative.devtools.tranclate.builder.getResource
import com.tcreative.devtools.tranclate.systemaddon.Addon

/**
 *
 */
class Fridge(val addon: Addon) {
    init {
        furniture("fridge", "Fridge", addon) {
            resource {
                //loadBlockbenchFile(getResource("furniture-resources/fridge1.bbmodel"))
            }
        }
    }
}
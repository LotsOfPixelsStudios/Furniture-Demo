package com.tcreative.addons.furniture

import com.tcreative.devtools.stdlib.blockbench.loadBlockbenchFile
import com.tcreative.devtools.stdlib.furnitures.furniture
import com.tcreative.devtools.tranclate.addon.molang.Query
import com.tcreative.devtools.tranclate.builder.getResource
import com.tcreative.devtools.tranclate.systemaddon.Addon

class Chair(val addon: Addon) {
    fun buildVariant(color : String) : Chair{
        furniture("chair_$color", "${color[0].uppercase()}${color.subSequence(1, color.length)} Chair", addon) {
            resource {
                loadBlockbenchFile(getResource("furniture-resources/modern_chair_1.bbmodel"), Query.skinId)
            }
        }
        return this
    }
}
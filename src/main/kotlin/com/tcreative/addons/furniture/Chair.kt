package com.tcreative.addons.furniture

import com.tcreative.devtools.stdlib.furnitures.furniture
import com.tcreative.devtools.tranclate.systemaddon.Addon

class Chair(val addon: Addon) {
    fun buildVariant(color : String) : Chair{
        furniture("chair", "Chair", addon) {
            //TODO implement chair in different colors
        }
        return this
    }
}
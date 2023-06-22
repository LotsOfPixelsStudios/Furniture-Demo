package com.tcreative.addons.furniture

import com.tcreative.devtools.stdlib.furnitures.furniture
import com.tcreative.devtools.stdlib.furnitures.lamp
import com.tcreative.devtools.tranclate.systemaddon.Addon

class TableLamp(val addon: Addon) {
    init {
        lamp("table_lamp", "Table Lamp", addon) {

        }
    }
}
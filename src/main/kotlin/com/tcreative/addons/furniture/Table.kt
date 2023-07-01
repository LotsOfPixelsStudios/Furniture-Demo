package com.tcreative.addons.furniture

import com.tcreative.devtools.stdlib.blockbench.loadBlockbenchFile
import com.tcreative.devtools.stdlib.furnitures.furniture
import com.tcreative.devtools.tranclate.builder.getResource
import com.tcreative.devtools.tranclate.systemaddon.Addon

class Table(val addon: Addon) {
    init {
        furniture("table", "Table", addon) {
            loadBlockbenchFile(getResource("furniture-resources/modern_table1.bbmodel"))
        }
    }
}
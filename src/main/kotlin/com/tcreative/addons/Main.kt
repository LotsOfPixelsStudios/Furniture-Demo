package com.tcreative.addons

import com.tcreative.addons.furniture.*
import com.tcreative.devtools.stdlib.blockbench.loadBlockbenchFile
import com.tcreative.devtools.stdlib.templateworld.modifyTemplateWorldName
import com.tcreative.devtools.tranclate.builder.getResource
import com.tcreative.devtools.tranclate.builder.zipper.zipWorld
import com.tcreative.devtools.tranclate.systemaddon.addon

fun main(args: Array<String>) {
    val properties = addon({
        projectName = "TranClate Furniture Demo"
        projectShort = "tfd"
        description = "A demo project for the furniture library for TranClate (included in the std-lib)"
        packIcon = getResource("general/pack.png")
        world = getResource("world/template-world").modifyTemplateWorldName("FurnitureLib")
        version = arrayListOf(0, 0, 1)
        targetMcVersion = arrayListOf(1, 20, 0)
    }) {
       Chair(this)
           .buildVariant("white")
           .buildVariant("grey")
           .buildVariant("black")
       Chandelier(this)
       Fridge(this)
       Table(this)
       TableLamp(this)
       entity {
           name("test", "Test")
           resource {
               loadBlockbenchFile(getResource("furniture-resources/fridge1.bbmodel"))
           }
       }
    }

    if (args.contains("zip-world"))
        zipWorld(world = getResource("world/template-world"), properties, System.getenv("CI_PROJECT_NAME") ?: "local")
}
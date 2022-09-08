package com.tcreative.addons

import com.tcreative.devtools.stdlib.cameratrack.Coordinate
import com.tcreative.devtools.stdlib.cameratrack.cameraTracks
import com.tcreative.devtools.stdlib.commands.Selector
import com.tcreative.devtools.stdlib.furnitures.furniture
import com.tcreative.devtools.stdlib.player.Player
import com.tcreative.devtools.stdlib.statesys.stateSystem
import com.tcreative.devtools.stdlib.templateworld.modifyTemplateWorldName
import com.tcreative.devtools.tranclate.builder.getResource
import com.tcreative.devtools.tranclate.builder.zipper.zipWorld
import com.tcreative.devtools.tranclate.systemaddon.addon

fun main(args: Array<String>) {
    //todo
    //---------------------------------------------------------------
    // [ ] make sure to modify addon() to loadAddon() if some json code already exist
    // [ ] replace ProjectName, in addon & settings.gradle.kts
    // [ ] replace ProjectShort
    // [ ] replace or remove description
    // [ ] replace or remove world
    // [ ] replace or remove pack icon
    // [ ] replace or remove sample entity
    // [ ] replace or remove sample item
    // [ ] replace or remove sample system
    // [ ] modify or remove zipProject
    // [ ] modify packageAddon()
    //---------------------------------------------------------------

    val properties = addon(
        projectName = "Template",
        projectShort = "tp",
        description = "",
        packIcon = getResource("general/pack.png"),
        world = getResource("world/template-world").modifyTemplateWorldName("Template"),
        version = arrayListOf(1, 0, 0)
    ) {
        if (args.contains("package")) {
            packageAddonCustom {
                this.world = getResource("world/template-world")
                addSkinPack(validate = true, getResource("skin_pack"))
                addStoreArt { }
                addMarketing { }
                addBehaviorPack { }
                addResourcePack { }
            }
        }

        entity {
            name("sample_entity", "Sample Entity")
            resource {
                textureLayer(getResource("entities/default_texture.png"))
                geometryLayer(getResource("entities/default_model.geo.json"))
            }
            behaviour {
                components {
                    physics { }
                }
            }
        }
        item {
            name("sample_item", "display name")
            renderOffset("tool")
            texture(getResource("item/default_texture.png"))
        }
        stateSystem(this) {
            identifier = "sample"
            state {

            }
        }
        cameraTracks(this) {
            addCameraTrack {
                identifier = "a_to_b"
                values = arrayListOf(
                    Pair(Coordinate(0f, -50f, 0f, 0f, 0f), 0f),
                    Pair(Coordinate(10f, -50f, 0f, 20f, 0f), 5f)
                )
                selector = Selector.a.toString()
                exitOnJumpOrCrouch = true
                onExit = arrayListOf("/function exit_fun")
            }
        }
        Player
            .modify(this)
            .modifyBehaviour { }

        furniture("vase", "Vase", this) {

        }
    }

    if (args.contains("zip-world"))
        zipWorld(world = getResource("world/template-world"), properties, System.getenv("CI_PROJECT_NAME") ?: "local")
}
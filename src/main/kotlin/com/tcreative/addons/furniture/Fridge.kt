package com.tcreative.addons.furniture

import com.tcreative.devtools.stdlib.blockbench.loadBlockbenchFile
import com.tcreative.devtools.stdlib.furnitures.furniture
import com.tcreative.devtools.tranclate.addon.beh.entites.data.Subject
import com.tcreative.devtools.tranclate.addon.molang.Query
import com.tcreative.devtools.tranclate.addon.molang.and
import com.tcreative.devtools.tranclate.builder.getResource
import com.tcreative.devtools.tranclate.systemaddon.Addon

/**
 *
 */
class Fridge(addon: Addon) {
    init {
        furniture("fridge", "Fridge", addon) {

            loadBlockbenchFile(getResource("furniture-resources/fridge1.bbmodel")) // this function loads every
                                                                                        // resource from a blockbench file
                                                                                        // to your addon and adds it to this entiy.
                                                                                        // including: geometry, textures, animations
            // hitbox height and width
            height = 2f
            width = 1f

            // you can expand the resource and behavior,
            // however, there is a certain threshold, where it might make more sense to create a new entity from scratch
            resource {
                animationController("open_close") {
                    initialState = "closing"
                    animStates {
                        animState("closing") {
                            animation = arrayListOf("top_closed")
                            transitions {
                                transition("open") { Query.property("door_open") }
                            }
                            blendTransition = 0.61f //this is so the door is opening smoothly instead of being instantly open
                        }
                        animState("open") {
                            animation = arrayListOf("top_opened")
                            transitions {
                                transition("closing") { !Query.property("door_open") }
                            }
                            blendTransition = 0.61f
                        }
                    }
                }
            }
            behaviour {
                animController("open_close") {
                    initialState = "closed"
                    animStates {
                        animState("closed") {
                            onEntry = arrayListOf(
                                "@s reset_interaction",
                                "@s door_closed"
                            )

                            transitions { transition("open") { Query.property("interaction") } }
                        }

                        animState("open") {
                            onEntry = arrayListOf(
                                "@s reset_interaction",
                                "@s door_open"
                            )
                            transitions { transition("closed") { Query.property("interaction") } }
                        }
                    }
                }
                properties {
                    bool("interaction") {
                        default(false)
                    }
                    bool("door_open") {
                        default(false)
                        clientSync = true
                    }
                }
                components {
                    interact {
                        interactGroup {
                            cooldown = 1f
                            onInteract {
                                event("interaction", Subject.SELF)
                            }
                        }
                    }
                }
                events {
                    event("interaction") {
                        setProperty("interaction", true)
                    }
                    event("reset_interaction") {
                        setProperty("interaction", false)
                    }
                    event("door_open") {
                        setProperty("door_open", true)
                    }
                    event("door_closed") {
                        setProperty("door_open", false)
                    }
                }
            }
        }
    }
}
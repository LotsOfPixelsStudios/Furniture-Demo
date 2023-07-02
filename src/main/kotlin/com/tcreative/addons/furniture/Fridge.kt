package com.tcreative.addons.furniture

import com.tcreative.devtools.stdlib.furnitures.furniture
import com.tcreative.devtools.tranclate.addon.beh.entites.data.Subject
import com.tcreative.devtools.tranclate.addon.molang.Query
import com.tcreative.devtools.tranclate.builder.getResource
import com.tcreative.devtools.tranclate.systemaddon.Addon

/**
 *
 */
class Fridge(addon: Addon) {
    init {
        furniture("fridge", "Fridge", addon) {

            /**
             * This function loads every resource from a blockbench file to your addon and adds it to this entiy.
             * including: geometry, textures, animations
             *
             * The names of the textures and geometry will include a hash of the file path,
             * so don't worry about file name collisions
             */
            loadBlockbenchFile(getResource("furniture-resources/fridge/fridge1.bbmodel"))

            height = 2f // hitbox height
            width = 1f  // hitbox width

            autoRotationAdjustment = true // aligns the entity with the closest axis after spawned

            /**
             * defines the appearance of the spawn egg.
             * In this case the spawn egg is a custom texture. The texture will be automatically added to addon.
             *
             * The names of the textures and geometry will include a hash of the file path,
             * so don't worry about file name collisions
             */
            icon {
                eggByFile(getResource("furniture-resources/fridge/fridge1.icon.png"))
            }

            /**
             * you can expand the resource and behavior, however, there is a certain threshold where it might
             * be reasonable to create a new entity from scratch
             */
            resource {

                /**
                 * Animation controller to play the animation visibly
                 */
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
                /**
                 * Animation controller to implement the logic behind the open and closing behavior
                 */
                animController("open_close") {
                    initialState = "closed"
                    animStates {
                        animState("closed") {
                            onEntry = arrayListOf( // firing two events on entry to the state
                                "@s reset_interaction",
                                "@s door_closed" // sets the property "door_open" to false
                            )

                            transitions { transition("open") { Query.property("interaction") } } // leave the state, when property "interaction" is true
                        }

                        animState("open") {
                            onEntry = arrayListOf( // firing two events on entry to the state
                                "@s reset_interaction",
                                "@s door_open" // sets the property "door_open" to true
                            )
                            transitions { transition("closed") { Query.property("interaction") } } // leave the state, when property "interaction" is true
                        }
                    }
                }

                /**
                 * introducing two properties
                 */
                properties {

                    // property to catch interactions
                    bool("interaction") { // actual name is "tranclate:interaction" but tranclate will handle that in the background
                        default(false)
                    }

                    // property to save the state.
                    // synch it with client side, so the resource animations can be played according to the state
                    bool("door_open") {
                        default(false)
                        clientSync = true
                    }
                }

                /**
                 * setting the components
                 */
                components {

                    interact {
                        interactGroup {
                            cooldown = 1f
                            onInteract {
                                event("interaction", Subject.SELF) // fire the "interact" event on interact
                            }
                        }
                    }
                }

                /**
                 * introducing all events needed
                 */
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
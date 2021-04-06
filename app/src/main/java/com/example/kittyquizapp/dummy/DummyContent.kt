package com.example.kittyquizapp.dummy

import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards (in this case tests list items)
 *
 */
object DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<DummyItem> = ArrayList()

    /**
     * A map of sample (dummy) items, by ID.
     */
    private val ITEM_MAP: MutableMap<String, DummyItem> = HashMap()

    init {
        // creating three dummy items
            addItem(createDummyItem(1,"cars"))
            addItem(createDummyItem(2,"who is bigger"))
            addItem(createDummyItem(3,"find the different"))
    }

    private fun addItem(item: DummyItem) {
        ITEMS.add(item)
        ITEM_MAP[item.id] = item
    }

    private fun createDummyItem(position: Int, content: String): DummyItem {
        return DummyItem(position.toString(), content)
    }

    // class for a dummy item
    data class DummyItem(val id: String, val content: String) {
        override fun toString(): String = content
    }
}
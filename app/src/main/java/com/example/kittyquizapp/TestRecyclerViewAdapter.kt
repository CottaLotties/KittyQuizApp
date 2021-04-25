package com.example.kittyquizapp

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.findNavController

import com.example.kittyquizapp.dummy.DummyContent.DummyItem

//[RecyclerView.Adapter] that can display a Test item

class TestRecyclerViewAdapter(
    private val values: List<DummyItem>
) : RecyclerView.Adapter<TestRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_tests_item, parent, false)
        return ViewHolder(view)
    }

    // here we set how we want to show the data to our user in a Test item
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        setPic(holder, item.content)
        holder.contentView.text = item.content
        // onClickListener for a test item button to show the TestFragment for the selected test
        holder.itemButton.setOnClickListener {
            val action = TestsListFragmentDirections.actionTestsListFragmentToTestFragment(item.content)
            holder.contentView.findNavController().navigate(action)
        }
    }

    // temporary function to show the icons for the dummy test items
    private fun setPic(holder: ViewHolder, content : String){
        when (content) {
            "cars" -> holder.iconView.setImageResource(R.drawable.free_icon_van_1601983)
            "who is bigger" -> holder.iconView.setImageResource(R.drawable.free_icon_magnifying_glass_1601971)
            else -> holder.iconView.setImageResource(R.drawable.free_icon_notebook_1601970)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val iconView: ImageView = view.findViewById(R.id.item_icon) // test item icon
        val contentView: TextView = view.findViewById(R.id.content) // test item name
        val itemButton: LinearLayout = view.findViewById(R.id.test_item) // button to show the selected test

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }
}
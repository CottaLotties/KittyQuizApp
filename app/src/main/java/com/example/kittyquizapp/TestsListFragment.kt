package com.example.kittyquizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kittyquizapp.dummy.DummyContent

/**
 * A fragment representing a list of tests
 */
class TestsListFragment : Fragment() {

    //private var columnCount = 1

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_tests_list, container, false)
        val view = v.findViewById<View>(R.id.list) as RecyclerView
        // Set the adapter
        //if (view is RecyclerView) {
            with(view) {
                //layoutManager = when {
                    /*columnCount <= 1 ->*/ LinearLayoutManager(context)
                    //else -> GridLayoutManager(context, columnCount)
                //}
                adapter = TestRecyclerViewAdapter(DummyContent.ITEMS)
            }
        //}
        return v
    }

    /*companion object {

        // Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            TestsListFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }*/
}
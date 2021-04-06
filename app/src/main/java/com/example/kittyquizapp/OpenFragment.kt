package com.example.kittyquizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.kittyquizapp.databinding.FragmentOpenBinding

/* the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"*/

class OpenFragment : Fragment() {
    /*private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }*/

    /*override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_open, container, false)
    }*/

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentOpenBinding>(inflater,
                R.layout.fragment_open,container,false)
        // setting onClickListener on play button to show the tests list fragment using navigation
        // controller and directions
        val btn = binding.root.findViewById<View>(R.id.play_button) as Button
        btn.setOnClickListener {
            val action = OpenFragmentDirections.actionOpenFragmentToTestsListFragment()
            navController?.navigate(action)
        }
        return binding.root
    }

    /*companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment OpenFragment.
         */
        @JvmStatic fun newInstance(param1: String, param2: String) =
                OpenFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }*/
}
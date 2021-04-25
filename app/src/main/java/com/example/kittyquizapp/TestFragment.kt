package com.example.kittyquizapp

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.kittyquizapp.databinding.FragmentTestBinding
import java.util.ArrayList

// class for a dummy test
data class DummyTest(val id: Int, val testId: Int, val questionId: Int,  val answer: Boolean, val pic: Int)

// class for a dummy test variant
data class DummyTestVariant(val view: ImageView, val pic: DummyTest)

class TestFragment : Fragment() {
    private var test: String? = null
    private var testName: String? = null
    private var currentQuestion: Int = 1
    private var rightQuestions: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            testName = it.getString("testName").toString()
        }
    }

    // test run function
    private fun testRun(binding: FragmentTestBinding) {
        val PICS: MutableList<DummyTest> = ArrayList() // array of dummy pictures
        val VIEWS: MutableList<ImageView> = ArrayList() // array of buttons for test variants

        PICS.add(DummyTest(1, 1, 1, false, R.drawable.pic1))
        PICS.add(DummyTest(2, 1, 1, false, R.drawable.pic2))
        PICS.add(DummyTest(3, 1, 1, true, R.drawable.pic3))
        PICS.add(DummyTest(4, 1, 1, false, R.drawable.pic4))

        PICS.add(DummyTest(5, 1, 2, true, R.drawable.pic5))
        PICS.add(DummyTest(6, 1, 2, false, R.drawable.pic6))

        PICS.add(DummyTest(7, 2, 1, true, R.drawable.pic7))
        PICS.add(DummyTest(8, 2, 1, false, R.drawable.pic8))

        val QUESTIONS: MutableList<String> = ArrayList() // array of dummy questions

        // getting test id and questions for it
        var testId = 1
        if (testName.equals("cars")) {
            QUESTIONS.add("Show the bus")
            QUESTIONS.add("Show the red car")
            testId = 1
        }
        if (testName.equals("who is bigger")) {
            QUESTIONS.add("Who is bigger, tiger or a cat?")
            testId = 2
        }

        test = QUESTIONS[currentQuestion-1] // getting the current question
        val testPics: MutableList<DummyTest> = ArrayList() // getting all the pictures
        // getting pictures for the current test
        for (pic in PICS){
            if (pic.testId == testId) testPics.add(pic)
        }

        // filling and editing properties for the array of views
        VIEWS.add(binding.testButton1)
        VIEWS.add(binding.testButton2)
        VIEWS.add(binding.testButton3)
        VIEWS.add(binding.testButton4)
        for (view in VIEWS){
            view.isEnabled = true
            view.visibility = View.GONE
        }

        // setting question for the test
        val testTV : TextView = binding.question
        testTV.text = test

        val variants: MutableList<DummyTestVariant> = ArrayList()// creating array of question variants
        // setting question pics
        var i =0
        for (pic in testPics){
            if (pic.questionId == currentQuestion){
                if (i<VIEWS.size) {
                    VIEWS[i].setImageResource(pic.pic)
                    VIEWS[i].visibility = View.VISIBLE
                    variants.add(DummyTestVariant(VIEWS[i], pic))
                    i++
                }
            }
        }

        // setting the onClickListener for the question variants
        for (variant in variants){
            variant.view.setOnClickListener {
                // disabling the views and checking if the answer is right
                for (view in VIEWS){
                    view.isEnabled = false
                }
                if (variant.pic.answer)rightQuestions++
                currentQuestion++
                // showing the next question or test result
                if (currentQuestion < QUESTIONS.size+1) testRun(binding)
                else showResult(QUESTIONS.size)
            }
        }

    }

    // function to show the test result alert dialog
    private fun showResult(questions: Int){
        val alertBuilder = AlertDialog.Builder(requireContext())
        alertBuilder.setTitle(getString(R.string.finish_test))
        alertBuilder.setMessage("$rightQuestions question from $questions")

        // going to the tests list on Ok button click
        alertBuilder.setPositiveButton("OK") { _, _ ->
            val action = TestFragmentDirections.actionTestFragmentToTestsListFragment()
            navController?.navigate(action)
        }

        // setting the layout for the alert dialog
        val layout : View = layoutInflater.inflate(R.layout.win_alert_dialog_layout, null)
        alertBuilder.setView(layout)
        alertBuilder.show()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentTestBinding>(inflater,
            R.layout.fragment_test,container,false)
        // run the dummy test for certain test item values
        if ((testName.equals("cars"))||(testName.equals("who is bigger")))testRun(binding)
        else {
            val action = TestFragmentDirections.actionTestFragmentToTestsListFragment()
            navController?.navigate(action)
        }
        return binding.root
    }
}
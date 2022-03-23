package com.chairunissa.singleactivity

import android.app.Person
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class FourthFragment : Fragment() {

    lateinit var ageEditText: EditText
    lateinit var addressEditText: EditText
    lateinit var jobEditText: EditText
    lateinit var navigateBackToThirdFragment: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigateBackToThirdFragment = view.findViewById<Button>(R.id.navigate_back_to_third_fragment_button)
        ageEditText = view.findViewById<EditText>(R.id.age_edit_text)
        addressEditText = view.findViewById<EditText>(R.id.address_edit_text)
        jobEditText = view.findViewById<EditText>(R.id.job_edit_text)

        val name = arguments?.getString("name")
        navigateBackToThirdFragment.setOnClickListener {
            val fragmentManager: FragmentManager = parentFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            val thirdFragment = ThirdFragment()

            val inputUmur = ageEditText.text.toString()
            val inputAlamat = addressEditText.text.toString()
            val inputPekerjaan = jobEditText.text.toString()

            name?.let {
                val dataClassPerson = Person(
                    it, inputUmur, inputAlamat, inputPekerjaan
                )

//            person itu data yang mau dikirim
                val bundle = Bundle()
                bundle.putParcelable("key_person", dataClassPerson)
                thirdFragment.arguments = bundle

                fragmentTransaction.replace(R.id.frame_layout_container, thirdFragment, ThirdFragment::class.java.simpleName)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }
        }
    }

}
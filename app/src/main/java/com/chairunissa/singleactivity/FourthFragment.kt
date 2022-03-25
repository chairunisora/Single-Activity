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
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class FourthFragment : Fragment() {

    val args: FourthFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ageEditText = view.findViewById<EditText>(R.id.age_edit_text)
        val addressEditText = view.findViewById<EditText>(R.id.address_edit_text)
        val jobEditText = view.findViewById<EditText>(R.id.job_edit_text)
        val navigateBackToThirdFragment = view.findViewById<Button>(R.id.navigate_back_to_third_fragment_button)

        val name = args.person.name
        navigateBackToThirdFragment.setOnClickListener {

            val age = ageEditText.text.toString()
            val address = addressEditText.text.toString()
            val job = jobEditText.text.toString()

            val person = PersonParcelable(name, age, address, job)
            findNavController().navigate(
                FourthFragmentDirections.actionFourthFragmentToThirdFragment(person)
            )
        }
    }
}



//            val fragmentManager: FragmentManager = parentFragmentManager
//            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
//            val thirdFragment = ThirdFragment()
//
//            val inputUmur = ageEditText.text.toString()
//            val inputAlamat = addressEditText.text.toString()
//            val inputPekerjaan = jobEditText.text.toString()
//
//            name?.let {
//                val dataClassPerson = Person(
//                    it, inputUmur, inputAlamat, inputPekerjaan
//                )
//
////            person itu data yang mau dikirim
//                val bundle = Bundle()
//                bundle.putParcelable("key_person", dataClassPerson)
//                thirdFragment.arguments = bundle
//
//                fragmentTransaction.replace(R.id.frame_layout_container, thirdFragment, ThirdFragment::class.java.simpleName)
//                fragmentTransaction.addToBackStack(null)
//                fragmentTransaction.commit()
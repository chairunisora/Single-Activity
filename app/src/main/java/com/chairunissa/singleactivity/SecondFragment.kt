package com.chairunissa.singleactivity

import android.app.Person
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import java.util.jar.Attributes

class SecondFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameEditText = view.findViewById<EditText>(R.id.name_edit_text)
        val navigateToThirdFragment = view.findViewById<Button>(R.id.navigate_to_third_fragment_button)

        navigateToThirdFragment.setOnClickListener {
            val name = nameEditText.text.toString()

            val person = PersonParcelable(name)
            findNavController().navigate(
                SecondFragmentDirections.actionSecondFragmentToThirdFragment(person)
            )
        }


//        navigateToThirdFragment.setOnClickListener {
//            it.findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)

//            val fragmentManager: FragmentManager = parentFragmentManager
//            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
//            val thirdFragment = ThirdFragment()
//
////         manggil inputannya
//            val inputNama = nameEditText.text.toString()
//
////            person itu data yang mau dikirim
//            val bundle = Bundle()
//            bundle.putString("key_name", inputNama)
//            thirdFragment.arguments = bundle
//
//            fragmentTransaction.replace(R.id.frame_layout_container, thirdFragment, ThirdFragment::class.java.simpleName)
//            fragmentTransaction.addToBackStack(null)
//            fragmentTransaction.commit()
        }
    }

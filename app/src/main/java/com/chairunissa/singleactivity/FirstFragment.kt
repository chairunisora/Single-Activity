package com.chairunissa.singleactivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class FirstFragment : Fragment() {

    private lateinit var navigateToSecondFragmentButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigateToSecondFragmentButton = view.findViewById(R.id.navigate_to_second_fragment_button)

//        navigateToSecondFragmentButton.setOnClickListener {
//            Toast.makeText(requireActivity(), "hai", Toast.LENGTH_SHORT).show()
//            openSecondFragment()
//        }
        navigateToSecondFragmentButton.setOnClickListener {
            val fragmentManager: FragmentManager = parentFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            val secondFragment = SecondFragment()
            fragmentTransaction.replace(R.id.frame_layout_container,secondFragment, SecondFragment::class.java.simpleName)
            fragmentTransaction.commit()
        }
    }

//    private fun openSecondFragment() {
//        val fragmentManager: FragmentManager = parentFragmentManager
//        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
//        val secondFragment = SecondFragment()
//        fragmentTransaction.replace(R.id.frame_layout_container,secondFragment, SecondFragment::class.java.simpleName)
//        fragmentTransaction.commit()
//    }

    }

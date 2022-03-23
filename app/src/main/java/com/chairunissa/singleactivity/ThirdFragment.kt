package com.chairunissa.singleactivity

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class ThirdFragment : Fragment() {

    lateinit var nameTextView: TextView
    lateinit var ageTextView: TextView
    lateinit var addressTextView: TextView
    lateinit var jobTextView: TextView
    lateinit var navigateToFourthFragment: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        val name = arguments?.getString("key_name")
        val dataPerson = arguments?.getParcelable<Person>("key_person")
//        Log.d("ThirdFragment", dataPerson!!.toString())


        nameTextView = view.findViewById<TextView>(R.id.name_text_view)
        addressTextView = view.findViewById<TextView>(R.id.address_text_view)
        ageTextView = view.findViewById<TextView>(R.id.age_text_view)
        jobTextView = view.findViewById<TextView>(R.id.job_text_view)

        navigateToFourthFragment = view.findViewById<Button>(R.id.navigate_to_fourth_fragment_button)
        nameTextView.text = name

        dataPerson?.let{
            val age = if(it.age.toInt() % 2 == 0) "Genap" else "Ganjil"
            nameTextView.text = it.name
            ageTextView.visibility = View.VISIBLE
            addressTextView.visibility = View.VISIBLE
            jobTextView.visibility = View.VISIBLE
            ageTextView.text = "${it.age}, ${age}"
            addressTextView.text = it.address
            jobTextView.text = it.job
        }

        navigateToFourthFragment.setOnClickListener {
            val fragmentManager: FragmentManager = parentFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            val fourthFragment = FourthFragment()

//            person itu data yang mau dikirim
            val bundle = Bundle()
            bundle.putString("name", name)
            fourthFragment.arguments = bundle

            fragmentTransaction.replace(R.id.frame_layout_container, fourthFragment, FourthFragment::class.java.simpleName)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }

}
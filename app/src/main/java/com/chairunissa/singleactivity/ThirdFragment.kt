package com.chairunissa.singleactivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavArgs
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs


class ThirdFragment : Fragment() {

    val args: ThirdFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameTextView = view.findViewById<TextView>(R.id.name_text_view)
        val addressTextView = view.findViewById<TextView>(R.id.address_text_view)
        val ageTextView = view.findViewById<TextView>(R.id.age_text_view)
        val jobTextView = view.findViewById<TextView>(R.id.job_text_view)

        val name = args.person.name
        nameTextView.text = name

        val navigateToFourthFragment =
            view.findViewById<Button>(R.id.navigate_to_fourth_fragment_button)

        val dataPerson = args.person

        if (dataPerson?.address != null && dataPerson?.age != null && dataPerson?.job != null) {
            val age = if (dataPerson.age.toInt() % 2 == 0) "Genap" else "Ganjil"
            ageTextView.visibility = View.VISIBLE
            addressTextView.visibility = View.VISIBLE
            jobTextView.visibility = View.VISIBLE

            ageTextView.text = "${dataPerson.age}, ${age}"
            addressTextView.text = dataPerson.address
            jobTextView.text = dataPerson.job
        }

        navigateToFourthFragment.setOnClickListener {
            val person = PersonParcelable(name)
            findNavController().navigate(
                ThirdFragmentDirections.actionThirdFragmentToFourthFragment(person)
            )
        }
    }

}


//        val name = arguments?.getString("key_name")
//        val dataPerson = arguments?.getParcelable<PersonParcelable>("key_person")
//        Log.d("ThirdFragment", dataPerson!!.toString())



//            val fragmentManager: FragmentManager = parentFragmentManager
//            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
//            val fourthFragment = FourthFragment()
//
////            person itu data yang mau dikirim
//            val bundle = Bundle()
//            bundle.putString("name", name)
//            fourthFragment.arguments = bundle
//
//            fragmentTransaction.replace(R.id.frame_layout_container, fourthFragment, FourthFragment::class.java.simpleName)
//            fragmentTransaction.addToBackStack(null)
//            fragmentTransaction.commit()

//            it.findNavController().navigate(R.id.action_thirdFragment_to_fourthFragment)
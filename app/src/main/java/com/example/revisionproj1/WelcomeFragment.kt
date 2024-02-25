package com.example.revisionproj1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WelcomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WelcomeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)
//        this doesn't work as it might be possible that view is not created here and we are trying to find
//        navcontroller
//        while both approaches might seem similar, the timing of when the NavController object is obtained
//        can affect the behavior and reliability of your navigation logic. It's generally safer to obtain
//        the NavController object directly inside the OnClickListener lambda or other relevant callback
//        functions to ensure that it's obtained when needed.
//        val navController  = view.findNavController()

        val startButton = view.findViewById<Button>(R.id.startButtId)

        startButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_welcomeFragment_to_messageFragment)
        }

        return  view
    }

}
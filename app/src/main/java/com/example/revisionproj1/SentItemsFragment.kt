package com.example.revisionproj1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

class SentItemsFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_sent_items, container, false)
        view.findViewById<Button>(R.id.sentToHelp).setOnClickListener {
            view.findNavController().navigate(R.id.action_sentItemsFragment_to_helpFragment)
        }
        return view
    }
}
package com.example.revisionproj1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController

/**
 * A simple [Fragment] subclass.
 * Use the [MessageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MessageFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_message, container, false)
        val nextbutt = view.findViewById<Button>(R.id.sendButtonId)

        val message = view.findViewById<EditText>(R.id.writeMessageId).text.toString()
        nextbutt.setOnClickListener {
            view.findNavController().navigate((R.id.action_messageFragment_to_encrytedFragment))

        }

        return view
    }
}
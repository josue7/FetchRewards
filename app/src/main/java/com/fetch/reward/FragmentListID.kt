package com.fetch.reward

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.fetch.reward.databinding.FragmentListidBinding

class FragmentListID : Fragment() {
    private lateinit var binding: FragmentListidBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //val bundle = arguments
        //val value = bundle?.getString("text").toString()

        binding = FragmentListidBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_listid, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //binding.txFrag.text = arguments?.getString("text").toString()
        //Toast.makeText(view.context, , Toast.LENGTH_LONG).show()
    }
}
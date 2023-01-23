package com.route.islami.fragments

import android.os.Bundle
import android.os.ParcelFileDescriptor.open
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.route.islami.R
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class RadioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_radio, container, false)
    }

}
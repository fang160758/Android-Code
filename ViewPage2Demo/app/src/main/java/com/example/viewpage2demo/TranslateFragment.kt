package com.example.viewpage2demo

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import kotlin.random.Random

class TranslateFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_translate, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val imageView:ImageView = requireActivity().findViewById(R.id.imageView3)
        imageView.setOnClickListener{
            ObjectAnimator.ofFloat(it,"translationX",it.translationX + Random.nextInt(-100,100)).start()
        }
    }


}
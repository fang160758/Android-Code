package com.example.viewpage2demo

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import kotlin.random.Random


class ScaleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scale, container, false)
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val imageView:ImageView = view.findViewById(R.id.imageView)
//        imageView.setOnClickListener {
//            val factor:Float = if (Random.nextBoolean()) 0.1f else -0.1f
//            ObjectAnimator.ofFloat(it,"scaleX",it.scaleX + factor).start()
//            ObjectAnimator.ofFloat(it,"scaleY",it.scaleY + factor).start()
//        }
//    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val imageView:ImageView = requireActivity().findViewById(R.id.imageView2)
        imageView.setOnClickListener {
            val factor:Float = if (Random.nextBoolean()) 0.1f else -0.1f
            ObjectAnimator.ofFloat(it,"scaleX",it.scaleX + factor).start()
            ObjectAnimator.ofFloat(it,"scaleY",it.scaleY + factor).start()
        }
    }

}
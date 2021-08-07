package com.example.customviewgroup.custom_group

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.view.children
import androidx.databinding.BindingAdapter
import com.example.customviewgroup.R
import com.example.customviewgroup.custom_group.interfaces.Childs
import com.example.customviewgroup.databinding.CustomGroupBinding

class CustomGroup : Childs, LinearLayoutCompat{
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr)
    lateinit var binding: CustomGroupBinding
    override val textV get() = binding.tex

    init{
        initView(context)
    }

    private fun initView(context: Context){
        binding = CustomGroupBinding.inflate(LayoutInflater.from(context),  this, true)
        binding.tex.setOnClickListener {
            Log.d("из кастомного: ", "custom")
        }
    }

    override fun getTextView() = binding.tex
}
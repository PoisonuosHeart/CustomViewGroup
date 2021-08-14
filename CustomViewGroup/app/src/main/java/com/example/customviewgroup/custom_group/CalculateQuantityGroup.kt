package com.example.customviewgroup.custom_group

import android.content.Context
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import android.util.Log
import android.util.SparseArray
import android.view.LayoutInflater
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.customviewgroup.R
import com.example.customviewgroup.custom_group.interfaces.ChildReference
import com.example.customviewgroup.databinding.CalculateQuantityGroupBinding

class CalculateQuantityGroup : ChildReference, LinearLayoutCompat{
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr)

    val SUPER_CLASS = "SUPER_CLASS"
    val DATA = "DATA"

    lateinit var binding: CalculateQuantityGroupBinding
    override val textV get() = binding.tex
    var txt: String? = null

    init{
        initView(context)
    }

    private fun initView(context: Context){
        binding = CalculateQuantityGroupBinding.inflate(LayoutInflater.from(context),  this, true)
        preporeToRestore()
        binding.tex.setOnClickListener {
            Log.d("из кастомного: ", "custom")
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        if(state is Bundle){
            super.onRestoreInstanceState(state.getParcelable(SUPER_CLASS))
            val res = state.getString(DATA)
            res
        }else super.onRestoreInstanceState(state)
    }

    override fun onSaveInstanceState(): Parcelable {
        return Bundle().apply{
            putParcelable(SUPER_CLASS, super.onSaveInstanceState())
            putString(DATA, binding.tex.text.toString())
        }
    }

    override fun dispatchRestoreInstanceState(container: SparseArray<Parcelable>?) {
        super.dispatchThawSelfOnly(container)
    }

    override fun dispatchSaveInstanceState(container: SparseArray<Parcelable>?) {
        //super.dispatchSaveInstanceState(container)
        super.dispatchFreezeSelfOnly(container)
    }


    //todo потестить поворот экрана

    private fun preporeToRestore(){
        this.id = if(this.id == -1) R.id.CalcQuanGroup else this.id
    }

    fun setTxt1(tx: String){
        binding.tex.text = tx
    }
}
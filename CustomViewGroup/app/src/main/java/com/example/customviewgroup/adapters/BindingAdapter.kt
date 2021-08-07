package com.example.customviewgroup.adapters

import android.graphics.Color.red
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.children
import androidx.databinding.BindingAdapter
import com.example.customviewgroup.R
import com.example.customviewgroup.custom_group.CustomGroup
import com.example.customviewgroup.custom_group.interfaces.Childs
import org.jetbrains.annotations.NotNull

@BindingAdapter(value =["customText"], requireAll = false)
fun <T: String> setCustom(view: CustomGroup?, item: T?){
    item?.let{
        view?.textV?.text = it
//        view?.let{
//            it.background = ContextCompat.getDrawable(it.context, R.color.purple_200)
//            (it.children.firstOrNull() as? TextView)?.text = item
//        }
    }
}
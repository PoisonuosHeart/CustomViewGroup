package com.example.customviewgroup.adapters

import androidx.databinding.BindingAdapter
import com.example.customviewgroup.custom_group.CalculateQuantityGroup
import com.example.customviewgroup.custom_group.interfaces.BasicRecalculate

@BindingAdapter(value =["customText"], requireAll = false)
fun /*<S, T: BasicRecalculate<T, S>>*/<T: String> setCustom(view: CalculateQuantityGroup?, item: T?){
    item?.let{
        view?.textV?.text = it
        view?.txt = it
//        view?.let{
//            it.background = ContextCompat.getDrawable(it.context, R.color.purple_200)
//            (it.children.firstOrNull() as? TextView)?.text = item
//        }
    }
}
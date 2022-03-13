package com.emreakcadag.baseandroid.feature.tweetlist.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
class BaseViewHolder constructor(val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object {

        inline fun <reified VB : ViewBinding> create(
            parent: ViewGroup,
            crossinline binder: (inflater: LayoutInflater, container: ViewGroup, attach: Boolean) -> VB,
        ) = BaseViewHolder(binder(LayoutInflater.from(parent.context), parent, false))
    }
}
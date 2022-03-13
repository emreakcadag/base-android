package com.emreakcadag.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
class BaseViewHolder constructor(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object {

        inline fun <reified VB : ViewDataBinding> create(
            parent: ViewGroup,
            crossinline binder: (inflater: LayoutInflater, container: ViewGroup, attach: Boolean) -> VB,
        ) = BaseViewHolder(binder(LayoutInflater.from(parent.context), parent, false))
    }
}
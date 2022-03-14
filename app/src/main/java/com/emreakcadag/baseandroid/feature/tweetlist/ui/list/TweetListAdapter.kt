package com.emreakcadag.baseandroid.feature.tweetlist.ui.list

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.emreakcadag.base.recyclerview.BaseViewHolder
import com.emreakcadag.baseandroid.BR
import com.emreakcadag.baseandroid.databinding.TweetItemBinding
import com.emreakcadag.data.viewentity.tweetlist.TweetViewEntity

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
class TweetListAdapter(private val onItemClick: ((TweetViewEntity) -> Unit)? = null) : ListAdapter<TweetViewEntity, BaseViewHolder>(TweetDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BaseViewHolder.create(parent, TweetItemBinding::inflate)

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        with(holder.binding) {
            val item = getItem(position)
            setVariable(BR.viewModel, item)
            setVariable(BR.onItemClick, onItemClick)
        }
    }

    object TweetDiffCallback : DiffUtil.ItemCallback<TweetViewEntity>() {

        override fun areItemsTheSame(oldItem: TweetViewEntity, newItem: TweetViewEntity) = oldItem == newItem

        override fun areContentsTheSame(oldItem: TweetViewEntity, newItem: TweetViewEntity) = oldItem.id == newItem.id
    }
}
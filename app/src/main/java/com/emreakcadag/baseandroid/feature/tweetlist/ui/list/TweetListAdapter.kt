package com.emreakcadag.baseandroid.feature.tweetlist.ui.list

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.emreakcadag.baseandroid.databinding.TweetItemBinding
import com.emreakcadag.data.entity.tweetlist.TweetViewEntity

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
class TweetListAdapter(
    private val tweetList: List<TweetViewEntity>?,
) : RecyclerView.Adapter<BaseViewHolder>() {

    override fun getItemCount(): Int = tweetList?.size ?: 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return BaseViewHolder.create(parent, TweetItemBinding::inflate)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        with(holder.binding as TweetItemBinding) {
            tweetList?.getOrNull(position)?.let {
                text.text = it.text
            }
        }
    }
}
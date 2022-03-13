package com.emreakcadag.base.extension

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.emreakcadag.base.recyclerview.PagingListener

/**
 * Created by Emre Akçadağ on 13.03.2022
 */

/**
 * Pagination listener for RecyclerView. Sets [PagingListener] and Returns a function to call a request to load more items.
 */
fun RecyclerView.setOnPagingListener(onLoadMore: (Int) -> Unit) {
    tryCatch({ addOnScrollListener(PagingListener(layoutManager as LinearLayoutManager, onLoadMore)) })
}
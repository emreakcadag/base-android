package com.emreakcadag.base.recyclerview

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
class PagingListener(private val layoutManager: LinearLayoutManager, val onLoadMore: (page: Int) -> Unit) : RecyclerView.OnScrollListener() {

    private var previousTotal = 0
    private var loading = true
    var visibleThreshold = 15
    private var currentItemCount = 0
    private var currentPage = 0

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        currentItemCount = layoutManager.itemCount

        if (currentItemCount < previousTotal) {
            reset()
        }

        if (loading && isTotalItemCountRecentlyIncreased()) {
            loading = false
            previousTotal = currentItemCount
        }

        if (shouldLoadNextPage(visibleThreshold)) {
            currentPage++
            onLoadMore(currentPage)
            loading = true
        }
    }

    private fun isTotalItemCountRecentlyIncreased() = currentItemCount > previousTotal

    private fun shouldLoadNextPage(threshold: Int) = !loading && layoutManager.findLastCompletelyVisibleItemPosition() + threshold >= currentItemCount

    private fun reset() {
        previousTotal = 0
        loading = true
        currentPage = 0
    }
}

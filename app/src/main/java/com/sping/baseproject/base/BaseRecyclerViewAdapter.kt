package com.sping.baseproject.base

import androidx.recyclerview.widget.RecyclerView

/**
 * Base class that every RecyclerView in the project should extend
 *
 * @param T generic type of data
 * @param V generic type of container for views that extends [RecyclerView.ViewHolder]
 * @property itemList the [List] that holds adapters data
 */
abstract class BaseRecyclerViewAdapter<T, V : RecyclerView.ViewHolder> : RecyclerView.Adapter<V>() {

    private var itemList: MutableList<T> = mutableListOf()

    override fun getItemCount(): Int {
        return itemList.size
    }

    /**
     * Sets [List] of type [T] to the adapter that overrides any previous [List] that might have been set
     */
    fun setItems(itemList: List<T>) {
        this.itemList = itemList.toMutableList()
        notifyDataSetChanged()
    }

    /**
     * Adds items of type [T] to the data [List] appending the data
     */
    fun addItems(itemList: List<T>) {
        this.itemList.addAll(itemList)
        notifyDataSetChanged()
    }

    fun getItems(): MutableList<T> {
        return itemList
    }

    /**
     * Clears all adapter data
     */
    fun clearItems() {
        this.itemList.clear()
        notifyDataSetChanged()
    }

    /**
     * Generic interface that handles click events of the [RecyclerView.ViewHolder] items and returns bound data of type [T] that resides within each [RecyclerView.ViewHolder]
     */
    interface ItemClickListener<T>{
        fun onItemClicked(item: T)
    }
}
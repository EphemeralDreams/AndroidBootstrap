package com.ephemeraldreams.androidbootstrap.ui.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ephemeraldreams.androidbootstrap.databinding.FragmentPostListItemBinding
import com.ephemeraldreams.androidbootstrap.ui.feed.PostFragment.OnListFragmentInteractionListener
import com.ephemeraldreams.androidbootstrap.ui.feed.dummy.DummyContent.DummyItem

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class PostRecyclerViewAdapter(
    private val values: List<DummyItem>,
    private val listener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<PostRecyclerViewAdapter.ViewHolder>() {

    private val onClickListener: View.OnClickListener

    init {
        onClickListener = View.OnClickListener { view ->
            val item = view.tag as DummyItem
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            listener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = FragmentPostListItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.bind(item, onClickListener)
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(private val binding: FragmentPostListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DummyItem, onClickListener: View.OnClickListener) {
            with(binding) {
                itemNumberTextView.text = item.id
                contentTextView.text = item.id
            }
            with(binding.root) {
                tag = item
                setOnClickListener(onClickListener)
            }
        }

        override fun toString(): String {
            return super.toString() + " '" + binding.contentTextView.text + "'"
        }
    }
}

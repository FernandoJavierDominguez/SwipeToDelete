package com.fernandodominguezpacheco.reign.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.fernandodominguezpacheco.reign.R
import com.fernandodominguezpacheco.reign.Story
import com.fernandodominguezpacheco.reign.databinding.RowStoryBinding
import kotlinx.android.synthetic.main.row_story.view.*
import kotlin.properties.Delegates

class StoryAdapter(
    private val listener: (Story) -> Unit
) : RecyclerView.Adapter<StoryAdapter.ViewHolder>() {

    var items: MutableList<Story> by Delegates.observable(mutableListOf()) { _, _, _ -> notifyDataSetChanged() }

    private val _storyLiveData = MutableLiveData<Story>()
    val storyLiveData: LiveData<Story> get() = _storyLiveData

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_story, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.itemView.setOnClickListener{
            listener(item)
        }
    }

    override fun getItemCount(): Int = items.size

    fun deleteItem(position: Int){
        _storyLiveData.value = items[position]
        items.removeAt(position)
        notifyItemRemoved(position)
        notifyItemChanged(position)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = RowStoryBinding.bind(view)

        fun bind(storyItem: Story){

            with(binding){
                storyTitle.text = storyItem.story_title
                internalRow.author.text = storyItem.author
                internalRow.createdAt.text = storyItem.created_at.toString()
            }
        }

    }
}
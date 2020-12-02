package com.fernandodominguezpacheco.reign.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.fernandodominguezpacheco.reign.R
import com.fernandodominguezpacheco.reign.Story
import com.fernandodominguezpacheco.reign.databinding.FragmentStoryBinding
import com.fernandodominguezpacheco.reign.utils.SharedViewModel
import com.fernandodominguezpacheco.reign.utils.observer
import dagger.hilt.android.AndroidEntryPoint


/**
 * A fragment representing a list of Stories.
 */
@AndroidEntryPoint
class StoryFragment : Fragment() {

    private val viewModel : StoryViewModel by viewModels()
    private val sharedViewModel : SharedViewModel by activityViewModels()
    private lateinit var binding: FragmentStoryBinding
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    private val adapter = StoryAdapter{
        sharedViewModel.selectStory(it)
        requireView().findNavController().navigate(R.id.action_StoryFragment_to_DetailFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentStoryBinding.inflate(layoutInflater)
        with(binding) {
            list.adapter = adapter
            list.addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
            observer(viewModel.storyItems) {
                adapter.items = it as MutableList<Story>
            }
        }
        val itemTouchHelper = ItemTouchHelper(SwipeToDelete(adapter))
        itemTouchHelper.attachToRecyclerView(binding.list)
        observer(adapter.storyLiveData){
            viewModel.deleteStory(it)
        }
        swipeRefreshLayout = binding.swipeRefreshLayout
        swipeRefreshLayout.setOnRefreshListener {
            viewModel.getStories()
            swipeRefreshLayout.isRefreshing = false
        }
        return binding.root

    }
    override fun onResume() {
        super.onResume()
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onStop() {
        super.onStop()
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
    }

}
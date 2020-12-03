package com.fernandodominguezpacheco.reign.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.fernandodominguezpacheco.reign.databinding.FragmentDetailBinding
import com.fernandodominguezpacheco.reign.utils.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_detail.*


/**
 * A fragment representing a detail of Story.
 */
@AndroidEntryPoint
class DetailFragment : Fragment() {

    private val sharedViewModel : SharedViewModel by activityViewModels()
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailBinding.inflate(layoutInflater)
        with(binding){
            webView.webChromeClient = object : WebChromeClient(){
            }
            webView.webViewClient = object : WebViewClient(){
            }
            val settings = webView.settings
            settings.javaScriptEnabled = true
        }

        sharedViewModel.getSelectedStory().observe(viewLifecycleOwner,{
            webView.loadUrl(it.story_url ?: "http://www.google.com")
            binding.storyTitle.text = it.story_title
        })
        return binding.root
    }
}
package com.example.newideas

import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.newideas.databinding.FragmentFragBBinding

class FragBFragment : Fragment() {

    private lateinit var binding: FragmentFragBBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        binding = FragmentFragBBinding.inflate(inflater, container, false)

        binding.textView.setOnClickListener {view ->
            Navigation.findNavController(view).navigate(R.id.action_fragBFragment2_to_fragmentC)
        }

        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)

        val menuItem = menu.findItem(R.id.app_bar_search)

        val searchView = menuItem.actionView  as androidx.appcompat.widget.SearchView

        searchView.isSubmitButtonEnabled = true

        searchView.queryHint = "Search"
        searchView.maxWidth= Int.MAX_VALUE

        searchView.setIconifiedByDefault(false)
        searchView.pointerIcon = null
    }

}
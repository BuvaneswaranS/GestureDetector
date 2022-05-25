package com.example.newideas

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.newideas.databinding.FragmentFragABinding
import com.google.android.material.navigation.NavigationView

class FragAFragment : Fragment() {

    private lateinit var binding: FragmentFragABinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        binding = FragmentFragABinding.inflate(inflater, container, false)

        binding.textView.setOnClickListener { view ->
            Navigation.findNavController(view)
                .navigate(R.id.action_fragAFragment2_to_fragBFragment2)
        }

        return binding.root
    }

}
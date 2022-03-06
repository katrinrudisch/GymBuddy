package com.katrinrudisch.gymbuddy.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.fragment.app.Fragment
import com.katrinrudisch.gymbuddy.databinding.FragmentMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding
    private val viewModel by viewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.composeView.setContent {
            PlansList()
        }
    }

    @Composable
    fun PlansList() {
        val state = viewModel.planState.value
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            StatefulLayout(state) { data ->
                LazyColumn {
                    data.forEach {
                        item {
                            Text(text = it.title)
                        }
                    }
                }
            }
        }

    }
}
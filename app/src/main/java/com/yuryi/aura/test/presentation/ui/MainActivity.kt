package com.yuryi.aura.test.presentation.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.work.WorkManager
import com.yuryi.aura.test.R
import com.yuryi.aura.test.databinding.ActivityMainBinding
import com.yuryi.aura.test.presentation.ui.adapter.BootEventsAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    private lateinit var binding: ActivityMainBinding
    private val adapter by lazy { BootEventsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupView()

        subscribeToState()

        if (savedInstanceState == null) {
            scheduleNotification()
        }

        checkPermissions()
    }

    private fun setupView() {
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            eventsForDatesRecycler.layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            eventsForDatesRecycler.adapter = adapter
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun subscribeToState() {
        lifecycleScope.launch {
            viewModel.state
                .flowWithLifecycle(lifecycle)
                .collect(::display)
        }
    }

    private fun scheduleNotification() {
        // TODO: Notification Worker
    }

    private fun checkPermissions() {
        // TODO: Check if permissions available
        // TODO: Request missing permissions
    }

    private fun display(state: MainState) {
        adapter.bootEventsForDates = state.bootEventsForDates
    }
}

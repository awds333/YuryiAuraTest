package com.yuryi.aura.test.presentation.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.yuryi.aura.test.databinding.BootEventsForDateItemBinding
import com.yuryi.aura.test.domain.model.BootEventsForDate
import com.yuryi.aura.test.presentation.util.format
import kotlinx.datetime.LocalDate

class BootEventsForDateViewHolder(private val binding: BootEventsForDateItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(bootEventsForDate: BootEventsForDate) = with(binding) {
        dateLabel.text = bootEventsForDate.date.format()
        eventsCountLabel.text = bootEventsForDate.bootEvents.size.toString()
    }
}

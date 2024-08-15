package com.yuryi.aura.test.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.yuryi.aura.test.databinding.BootEventsForDateItemBinding
import com.yuryi.aura.test.domain.model.BootEventsForDate
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class BootEventsAdapter : RecyclerView.Adapter<BootEventsForDateViewHolder>() {

    private val differ = AsyncListDiffer(this, diffCallback)

    var bootEventsForDates: List<BootEventsForDate> by differ.delegate()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BootEventsForDateViewHolder {
        val binding = BootEventsForDateItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BootEventsForDateViewHolder(binding)
    }

    override fun getItemCount(): Int = bootEventsForDates.size

    override fun onBindViewHolder(holder: BootEventsForDateViewHolder, position: Int) {
        holder.bind(bootEventsForDates[position])
    }

    private fun <T : Any> AsyncListDiffer<T>.delegate() =
        object : ReadWriteProperty<Any, List<T>> {

            override fun getValue(thisRef: Any, property: KProperty<*>): List<T> = currentList

            override fun setValue(thisRef: Any, property: KProperty<*>, value: List<T>) =
                submitList(value)
        }

    companion object {

        private val diffCallback = object : DiffUtil.ItemCallback<BootEventsForDate>() {

            override fun areItemsTheSame(
                oldItem: BootEventsForDate,
                newItem: BootEventsForDate
            ): Boolean =
                oldItem.date == newItem.date

            override fun areContentsTheSame(
                oldItem: BootEventsForDate,
                newItem: BootEventsForDate
            ): Boolean =
                oldItem == newItem
        }
    }
}

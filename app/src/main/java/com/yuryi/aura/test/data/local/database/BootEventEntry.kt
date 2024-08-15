package com.yuryi.aura.test.data.local.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "boot_events")
data class BootEventEntry(
    @PrimaryKey val instant: Long,
)

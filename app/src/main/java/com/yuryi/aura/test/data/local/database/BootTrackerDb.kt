package com.yuryi.aura.test.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BootEventEntry::class], version = 1)
abstract class BootTrackerDb : RoomDatabase() {
    abstract fun bootEventDao(): BootEventDao
}

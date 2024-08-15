package com.yuryi.aura.test.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BootEventDao {

    @Query("SELECT * FROM boot_events")
    fun allBootEvents(): Flow<List<BootEventEntry>>

    @Insert
    suspend fun insert(bootEventEntry: BootEventEntry)
}

package com.example.simbirsoft.notes.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.simbirsoft.notes.data.db.entity.NoteEntity

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(noteEntity: NoteEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNoteList(noteEntityList: List<NoteEntity>)

    @Query(
        "SELECT * FROM notes_table WHERE " +
                "CAST(strftime('%m',dateStart,'unixepoch') AS INTEGER) = :month AND " +
                "CAST(strftime('%Y',dateStart,'unixepoch') AS INTEGER) = :year OR " +
                "CAST(strftime('%m',dateFinish,'unixepoch') AS INTEGER) = :month AND " +
                "CAST(strftime('%Y',dateFinish,'unixepoch') AS INTEGER) = :year"
    )
    suspend fun getMonthNotes(month: Int, year: Int): List<NoteEntity>

    @Query(
        "SELECT * FROM notes_table WHERE " +
                "CAST(strftime('%d',dateStart,'unixepoch') AS INTEGER) <= :day AND " +
                "CAST(strftime('%m',dateStart,'unixepoch') AS INTEGER) <= :month AND " +
                "CAST(strftime('%Y',dateStart,'unixepoch') AS INTEGER) <= :year AND " +
                "CAST(strftime('%d',dateFinish,'unixepoch') AS INTEGER) >= :day AND " +
                "CAST(strftime('%m',dateFinish,'unixepoch') AS INTEGER) >= :month AND " +
                "CAST(strftime('%Y',dateFinish,'unixepoch') AS INTEGER) >= :year"
    )
    suspend fun getDayNotes(day: Int, month: Int, year: Int): List<NoteEntity>
}
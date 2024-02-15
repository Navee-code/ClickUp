package com.example.clickup.RoomDB
import androidx.room.*


@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertNote(note: Note?)
    @Query("SELECT * FROM note_table")
    fun getData(): List<Note>

    @Query("DELETE FROM note_table WHERE noteId=:id")
    fun deleteNote(id:Long)

    @Query("DELETE FROM note_table")
    fun deleteAllNotes()
    @Update
    fun updateNote(note: Note)



}
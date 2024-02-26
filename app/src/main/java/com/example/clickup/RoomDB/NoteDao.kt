package com.example.clickup.RoomDB
import androidx.room.*
import com.example.clickup.constant.AppConstant


@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertNote(note: Note?)
    @Query("SELECT * FROM ${AppConstant.table_name}")
    fun getData(): List<Note>

    @Query("DELETE FROM ${AppConstant.table_name} WHERE noteId=:id")
    fun deleteNote(id:Long)

    @Query("DELETE FROM ${AppConstant.table_name}")
    fun deleteAllNotes()
    @Update
    fun updateNote(note: Note)



}
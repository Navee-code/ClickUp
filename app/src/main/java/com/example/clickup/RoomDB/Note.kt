package com.example.clickup.RoomDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.clickup.constant.AppConstant

@Entity(tableName = AppConstant.table_name)
data class Note(
    @PrimaryKey(autoGenerate = true) val  noteId:Int?,
    @ColumnInfo(name = "notes") val note:String?,
    @ColumnInfo(name = "date") val date:String?
)

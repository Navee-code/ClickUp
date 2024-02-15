package com.example.clickup.RoomDB

import android.content.Context
import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [Note::class], version = 1,exportSchema = false)
abstract class AppDb:RoomDatabase() {


    abstract fun noteDao():NoteDao

//    class CallBack @Inject constructor(private val dataBase: Provider<AppDataBase>):RoomDatabase.Callback(){
//        override fun onCreate(db: SupportSQLiteDatabase) {
//            super.onCreate(db)
//           //   val db=  dataBase.get().noteDao()
//        }
//    }

    companion object{
        @Volatile
        private var instance:AppDb?=null

        fun getDatabase(context:Context):AppDb{

            val tempInstance= instance
            if(tempInstance !=null){
                return tempInstance
            }
            synchronized(this){
                val instanceNew= Room.databaseBuilder(context.applicationContext,AppDb::class.java,"app_database").build()
                instance=instanceNew
                return instanceNew
            }

        }
    }

}
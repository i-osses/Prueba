package com.prodev.superheros.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.prodev.superheros.model.SuperheroCharacter

@Database(entities = [SuperheroCharacter::class],version = 1)
abstract class SuperheroDatabase : RoomDatabase(){
    // Boilerplate code, change entities. make it abstract.
    abstract val superheroDAO : SuperheroDAO

    companion object{

        @Volatile
        private var INSTANCE : SuperheroDatabase? = null
        fun getInstance(context: Context): SuperheroDatabase {
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SuperheroDatabase::class.java,
                        "superhero_database"
                    ).build()
                }
                return instance
            }
        }

    }

}
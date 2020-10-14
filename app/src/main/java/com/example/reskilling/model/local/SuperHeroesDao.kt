package com.example.reskilling.model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SuperHeroesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE )
    suspend fun insertAllSuperHeroes(mList: List<SuperHeroesEntity>)

    @Query("SELECT * FROM super_heroes_table")
    fun showAllSuperHeroes(): LiveData<List<SuperHeroesEntity>>

    @Query("SELECT * FROM super_heroes_table WHERE id =:mId")
    fun showOnSuperHeroesByID(mId : Int): LiveData<SuperHeroesEntity>
}
package com.example.roomlivedatasample

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

/**
 * created by ghopkins 6/15/18.
 */
@Dao
interface WordDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE) //if more than one row has the same primary key the row will be replaced. Default is ABORT
    fun insert(word: Word)

    @Query("DELETE FROM word_table")
    fun deleteAll()

    @Query("SELECT * from word_table ORDER BY word ASC")
    fun getAllWords() : LiveData<List<Word>>
}
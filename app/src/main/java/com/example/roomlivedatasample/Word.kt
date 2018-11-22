package com.example.roomlivedatasample

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

/**
 * created by ghopkins 6/15/18.
 */
@Entity(tableName = "word_table")
data class Word(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "word")
        var mWord: String)
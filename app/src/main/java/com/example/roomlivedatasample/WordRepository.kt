package com.example.roomlivedatasample

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask


/**
 * created by ghopkins 6/15/18.
 */
class WordRepository {
    private var mWordDao: WordDao?
    private var mAllWords: LiveData<List<Word>>?

    constructor(application: Application) {
        val db: WordRoomDatabase? = WordRoomDatabase.getDataBase(application)
        mWordDao = db?.wordDao()
        mAllWords = mWordDao?.getAllWords()
    }

    fun getAllWords(): LiveData<List<Word>>? {
        return mAllWords
    }

    fun insert(word : Word){
        InsertAsyncTask(mWordDao).execute(word)
    }

    private class InsertAsyncTask internal constructor(private val mAsyncTaskDao: WordDao?) : AsyncTask<Word, Void, Void>() {

        override fun doInBackground(vararg params: Word): Void? {
            mAsyncTaskDao?.insert(params[0])
            return null
        }
    }
}
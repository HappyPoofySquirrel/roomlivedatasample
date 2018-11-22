package com.example.roomlivedatasample

import android.os.AsyncTask

/**
 * created by ghopkins 6/18/18.
 */
class PopulateDbAsync internal constructor(db: WordRoomDatabase) : AsyncTask<Void, Void, Void>() {

    private val mDao: WordDao

    init {
        mDao = db.wordDao()
    }

    override fun doInBackground(vararg params: Void): Void? {
        mDao.deleteAll()
        var word = Word("Challah")
        mDao.insert(word)
        word = Word("Bread")
        mDao.insert(word)
        return null
    }
}
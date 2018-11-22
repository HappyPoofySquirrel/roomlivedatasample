package com.example.roomlivedatasample

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData

/**
 * created by ghopkins 6/15/18.
 */
class WordViewModel constructor(application: Application) : AndroidViewModel(application) { // if need to use context in a view model extend androidviewmodel, never use direct context reference or activity

    private val mRepository: WordRepository

    internal val allWords: LiveData<List<Word>>?

    init {
        mRepository = WordRepository(application)
        allWords = mRepository.getAllWords()
    }

    fun getAllWords(): LiveData<List<Word>>? {
        return allWords
    }

    fun insert(word: Word) {
        mRepository.insert(word)
    }
}

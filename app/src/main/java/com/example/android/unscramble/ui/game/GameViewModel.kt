package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

//extending ViewModel Class
class GameViewModel : ViewModel() {
    //This block of code is run when the object instance is first created and initialized.
    init {
        Log.d("GameFragment", "GameViewModel created")
    }
    //data variables
    private var score = 0
    private var currentWordCount = 0
    private var _currentScrambledWord = "test"

    //sets a read-only property of _currentScrambleWord to be used for UI - immutability principle
    val currentScrambleWord: String
        get() = _currentScrambledWord

    //before the ViewModel is destroyed, the onCleared() callback is called.
    override fun onCleared() {
        super.onCleared()
        //track viewModel lifecycle
        Log.d("GameFragment", "GameViewModel destroyed!")
    }

}
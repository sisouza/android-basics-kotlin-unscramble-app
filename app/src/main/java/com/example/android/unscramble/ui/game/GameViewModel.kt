package com.example.android.unscramble.ui.game

import androidx.lifecycle.ViewModel

//extending ViewModel Class
class GameViewModel : ViewModel() {

    //data variables
    private var score = 0
    private var currentWordCount = 0
    private var _currentScrambledWord = "test"

    //sets a read-only property of _currentScrambleWord to be used for UI - immutability principle
    val currentScrambleWord: String
        get() = _currentScrambledWord
}
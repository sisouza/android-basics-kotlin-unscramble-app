package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

//extending ViewModel Class
class GameViewModel : ViewModel() {

    //data variables
    private var _score = 0
    private var _currentWordCount = 0
    private var wordsList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String
    private lateinit var _currentScrambledWord: String

    //sets a read-only property of _currentScrambleWord to be used for UI - immutability principle
    val currentScrambledWord: String
        get() = _currentScrambledWord

    val score: Int
        get() = _score

    val currentWordCount: Int
        get() = _currentWordCount


    /*
    * Updates currentWord and currentScrambledWord with the next word.
    */

    private fun getNextWord() {
        //Get a random word from the allWordsList and assign it to currentWord
        currentWord = allWordsList.random()
        //converts currentWord string to an array of chars
        val tempWord = currentWord.toCharArray()
        tempWord.shuffle()
        //continue the loop until the scrambled word is not the same as the original word.
        while (String(tempWord).equals(currentWord, false)) {
            tempWord.shuffle()
        }
        if (wordsList.contains(currentWord)) {
            getNextWord()
        } else {
            _currentScrambledWord = String(tempWord)
            ++_currentWordCount
            wordsList.add(currentWord)
        }
    }

    /*
  * Re-initializes the game data to restart the game.
  */
    fun reinitializeData() {
        _score = 0
        _currentWordCount = 0
        wordsList.clear()
        getNextWord()
    }


    /*
    * Increases the game score if the player's word is correct.
    */
    private fun increaseScore() {
        _score += SCORE_INCREASE
    }

    /*
   * validate the player's word and increase the score if the guess is correct.
   * */
    fun isUserWordCorrect(playerWord: String): Boolean {
        if (playerWord.equals(currentWord, true)) {
            increaseScore()
            return true
        }
        return false
    }

    /*
     Returns true if the current word count is less than MAX_NO_OF_WORDS.
    * Updates the next word.
    */
    fun nextWord(): Boolean {
        return if (currentWordCount < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else false
    }

    //This block of code is run when the object instance is first created and initialized.
    init {
        Log.d("GameFragment", "GameViewModel created")
        getNextWord()
    }


    //before the ViewModel is destroyed, the onCleared() callback is called.
    override fun onCleared() {
        super.onCleared()
        //track viewModel lifecycle
        Log.d("GameFragment", "GameViewModel destroyed!")
    }

}
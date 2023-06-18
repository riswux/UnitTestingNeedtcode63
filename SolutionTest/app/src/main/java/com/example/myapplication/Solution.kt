package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Solution {
    fun minDistance(word1: String, word2: String): Int {
        if (!isValidInput(word1) || !isValidInput(word2))
            throw IllegalArgumentException("Invalid input: words should consist of lowercase English letters only.")

        val dp = Array(word1.length + 1) { IntArray(word2.length + 1) { -1 } }

        fun dfs(i: Int, j: Int): Int {
            return when {
                dp[i][j] != -1 -> dp[i][j]
                i == word1.length && j == word2.length -> 0
                i == word1.length -> 1 + dfs(i, j + 1)
                j == word2.length -> 1 + dfs(i + 1, j)
                word1[i] == word2[j] -> dfs(i + 1, j + 1)
                else -> {
                    val insert1Delete2 = 1 + dfs(i, j + 1)
                    val insert2Delete1 = 1 + dfs(i + 1, j)
                    val replace1Or2 = 1 + dfs(i + 1, j + 1)
                    val res = minOf(insert1Delete2, insert2Delete1, replace1Or2)
                    dp[i][j] = res
                    res
                }
            }
        }

        return dfs(0, 0)
    }

    private fun isValidInput(word: String): Boolean {
        val pattern = Regex("^[a-z]+$")
        return word.isNotBlank() && word.length <= 500 && word.matches(pattern)    }
}


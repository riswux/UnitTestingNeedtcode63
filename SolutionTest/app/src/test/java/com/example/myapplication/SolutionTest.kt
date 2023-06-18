package com.example.myapplication

import org.junit.Test

import org.junit.Assert.*


class SolutionTest {
    private val solution = Solution()


    @Test
    fun testValidWords() {
        val word1 = "cat"
        val word2 = "car"
        val result = solution.minDistance(word1, word2)
        assertTrue(result == 1)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testInvalidWords() {
        val word1 = "cat"
        val word2 = "123"
        solution.minDistance(word1, word2)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testLongWords() {
        val word1 = "a".repeat(501)
        val word2 = "a"
        solution.minDistance(word1, word2)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testUppercaseWords() {
        val word1 = "Cat"
        val word2 = "car"
        solution.minDistance(word1, word2)
    }

    @Test(expected = IllegalArgumentException::class)
    fun specialCharacters() {
        val word1 = "@#@#@#"
        val word2 = "car"
        solution.minDistance(word1, word2)
    }
}
import com.example.neetcodeunittesting67.FromNeetCode
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class FromNeetCodeTest {
    private lateinit var fromNeetCode: FromNeetCode

    @Before
    fun setUp() {
        fromNeetCode = FromNeetCode()
    }

    @Test
    fun testMinDistanceWithSpecialCharacters() {
        val word1 = "abc!@#"
        val word2 = "def$%^"
        val expectedDistance = 6
        val actualDistance = fromNeetCode.minDistance(word1, word2)
        assertEquals(expectedDistance, actualDistance)
    }

    @Test
    fun testMinDistanceWithLongWords() {
        val word1 = "a".repeat(501)
        val word2 = "b".repeat(500)
        val expectedDistance = 501
        val actualDistance = fromNeetCode.minDistance(word1, word2)
        assertEquals(expectedDistance, actualDistance)
    }

    @Test
    fun testMinDistanceWithUppercaseLetters() {
        val word1 = "abcDEF"
        val word2 = "defABC"
        val expectedDistance = 6
        val actualDistance = fromNeetCode.minDistance(word1, word2)
        assertEquals(expectedDistance, actualDistance)
    }

    @Test
    fun testMinDistanceWithEmptyInput() {
        val word1 = ""
        val word2 = ""
        val expectedDistance = 0
        val actualDistance = fromNeetCode.minDistance(word1, word2)
        assertEquals(expectedDistance, actualDistance)
    }

    @Test
    fun testMinDistanceWithValidInput() {
        val word1 = "kitten"
        val word2 = "sitting"
        val expectedDistance = 3
        val actualDistance = fromNeetCode.minDistance(word1, word2)
        assertEquals(expectedDistance, actualDistance)
    }
}
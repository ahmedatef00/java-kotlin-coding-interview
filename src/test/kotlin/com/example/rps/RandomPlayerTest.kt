package com.example.rps

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.random.Random

class RandomPlayerTest {

    @Test
    fun `RandomPlayer should always return a valid move`() {
        val randomPlayer = RandomPlayer(Random(0)) // fixed seed for deterministic tests
        repeat(10) {
            val move = randomPlayer.nextMove()
            assertTrue(Move.values().contains(move))
        }
    }
}

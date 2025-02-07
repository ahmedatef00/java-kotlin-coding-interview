package com.example.rps

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RockPlayerTest {

    @Test
    fun `RockPlayer should always return ROCK`() {
        val rockPlayer = RockPlayer()
        repeat(10) {
            assertEquals(Move.ROCK, rockPlayer.nextMove())
        }
    }
}

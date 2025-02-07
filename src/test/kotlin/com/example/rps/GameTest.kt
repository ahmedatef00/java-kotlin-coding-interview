package com.example.rps

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GameTest {
    // A simple test player that cycles through a predetermined list of moves
    class TestPlayer(private val moves: List<Move>) : Player {
        private var index = 0
        override fun nextMove(): Move {
            val move = moves[index % moves.size]
            index++
            return move
        }
    }

    @Test
    fun `Game should aggregate results correctly`() {
        val playerA = TestPlayer(listOf(Move.ROCK, Move.PAPER, Move.SCISSORS))
        val playerB = TestPlayer(listOf(Move.ROCK))
        val game = Game(playerA, playerB, rounds = 3)
        val result = game.play()

        assertEquals(1, result.playerAWins)
        assertEquals(1, result.playerBWins)
        assertEquals(1, result.draws)
    }
}

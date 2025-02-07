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
    // A FixedPlayer that always returns the same move.
    class FixedPlayer(private val move: Move) : Player {
        override fun nextMove(): Move = move
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

    @Test
    fun `Game with zero rounds returns all zeros`() {
        val playerA = RockPlayer()
        val playerB = RockPlayer()
        val game = Game(playerA, playerB, rounds = 0)
        val result = game.play()

        assertEquals(0, result.playerAWins)
        assertEquals(0, result.playerBWins)
        assertEquals(0, result.draws)
    }
    @Test
    fun `Game with fixed players always results in draws`() {
        // Both players always return ROCK, so every round should be a draw.
        val playerA = FixedPlayer(Move.ROCK)
        val playerB = FixedPlayer(Move.ROCK)
        val game = Game(playerA, playerB, rounds = 50)
        val result = game.play()

        assertEquals(50, result.draws, "All 50 rounds should be draws")
        assertEquals(0, result.playerAWins, "Player A should have 0 wins")
        assertEquals(0, result.playerBWins, "Player B should have 0 wins")
    }

}

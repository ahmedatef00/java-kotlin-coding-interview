package com.example.rps

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class GameEvaluatorTest {

    @Test
    fun `ROCK vs ROCK should be DRAW`() {
        assertEquals(RoundResult.DRAW, GameEvaluator.evaluateRound(Move.ROCK, Move.ROCK))
    }

    @Test
    fun `ROCK vs PAPER should be LOSE`() {
        assertEquals(RoundResult.LOSE, GameEvaluator.evaluateRound(Move.ROCK, Move.PAPER))
    }

    @Test
    fun `ROCK vs SCISSORS should be WIN`() {
        assertEquals(RoundResult.WIN, GameEvaluator.evaluateRound(Move.ROCK, Move.SCISSORS))
    }

    // Additional tests for PAPER and SCISSORS matchups...
}

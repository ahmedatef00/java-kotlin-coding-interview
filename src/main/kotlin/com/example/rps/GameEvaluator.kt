package com.example.rps

object GameEvaluator {
    /**
     * Evaluates the outcome of a round from the perspective of the first move.
     */
    fun evaluateRound(moveA: Move, moveB: Move): RoundResult {
        if (moveA == moveB) return RoundResult.DRAW

        return when (moveA) {
            Move.ROCK -> if (moveB == Move.SCISSORS) RoundResult.WIN else RoundResult.LOSE
            Move.PAPER -> if (moveB == Move.ROCK) RoundResult.WIN else RoundResult.LOSE
            Move.SCISSORS -> if (moveB == Move.PAPER) RoundResult.WIN else RoundResult.LOSE
        }
    }
}

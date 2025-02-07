package com.example.rps

data class GameResult(val playerAWins: Int, val playerBWins: Int, val draws: Int)

class Game(
    private val playerA: Player,
    private val playerB: Player,
    private val rounds: Int = 100
) {
    /**
     * Plays the specified number of rounds and returns the aggregated results.
     */
    fun play(): GameResult {
        var aWins = 0
        var bWins = 0
        var draws = 0

        for (i in 1..rounds) {
            val moveA = playerA.nextMove()
            val moveB = playerB.nextMove()

            when (GameEvaluator.evaluateRound(moveA, moveB)) {
                RoundResult.WIN -> aWins++
                RoundResult.LOSE -> bWins++
                RoundResult.DRAW -> draws++
            }
        }
        return GameResult(aWins, bWins, draws)
    }
}

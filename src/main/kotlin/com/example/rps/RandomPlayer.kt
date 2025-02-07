package com.example.rps

import kotlin.random.Random

class RandomPlayer(private val random: Random = Random.Default) : Player {
    override fun nextMove(): Move {
        val moves = Move.values()
        return moves[random.nextInt(moves.size)]
    }
}

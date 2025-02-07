package com.example.rps

fun main() {
    val playerA: Player = RandomPlayer()
    val playerB: Player = RockPlayer()

    val game = Game(playerA, playerB, rounds = 100)
    val result = game.play()

    println("Player A wins ${result.playerAWins} of 100 games")
    println("Player B wins ${result.playerBWins} of 100 games")
    println("Draws: ${result.draws} of 100 games")
}

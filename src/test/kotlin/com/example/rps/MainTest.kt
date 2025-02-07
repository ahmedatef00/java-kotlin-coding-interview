package com.example.rps

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class MainTest {

    @Test
    fun `main produces expected output format`() {
        // Redirect System.out to capture the output
        val originalOut = System.out
        val baos = ByteArrayOutputStream()
        System.setOut(PrintStream(baos))

        try {
            main()
            val output = baos.toString()

            // Validate that output contains the expected text fragments.
            assertTrue(output.contains("Player A wins"))
            assertTrue(output.contains("Player B wins"))
            assertTrue(output.contains("Draws:"))
        } finally {
            // Restore the original System.out after the test
            System.setOut(originalOut)
        }
    }
}

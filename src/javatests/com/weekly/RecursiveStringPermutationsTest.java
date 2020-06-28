package com.weekly;

import com.Cake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecursiveStringPermutationsTest {
  private static final String INPUT = "cat";
  private static final String OUTPUT = "act atc cat cta tac tca";
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @BeforeEach
  void setUp() {
    System.setOut(new PrintStream(outContent));
  }

  private void setUpInput(String input) {
    System.setIn(new ByteArrayInputStream(input.getBytes()));
  }

  private String getOutput() {
    return outContent.toString().substring(outContent.toString().lastIndexOf("\n") + 1).trim();
  }

  @Test
  void testSolution() {
    setUpInput(INPUT);

    Cake.execute(RecursiveStringPermutations.class);

    assertEquals(OUTPUT, getOutput());
  }
}

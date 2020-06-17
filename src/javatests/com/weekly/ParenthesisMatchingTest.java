package com.weekly;

import static org.junit.jupiter.api.Assertions.*;

import com.Cake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ParenthesisMatchingTest {
  private static final String VALID_SENTENCE =
      "Sometimes (when I nest them (my parentheticals) too much " +
      "(like this (and this))) they get confusing.";
  private static final String INVALID_SENTENCE =
      "This is a (sentence) with (an invalid (amount) of parenthesis.\n";
  private static final String VALID_POSITION = "\n10";
  private static final String INVALID_POSITION = "\n4";
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @BeforeEach
  void setUp() {
    System.setOut(new PrintStream(outContent));
  }

  private void setUpInput(String input) {
    System.setIn(new ByteArrayInputStream(input.getBytes()));
  }

  private String getOutput() {
    return outContent.toString().substring(outContent.toString().lastIndexOf("\n") + 1);
  }

  @Test
  void testSolution() {
    setUpInput(VALID_SENTENCE + VALID_POSITION);

    Cake.execute(ParenthesisMatching.class);

    assertEquals("79", getOutput());
  }

  @Test
  void testSentenceValidation() {
    setUpInput(INVALID_SENTENCE + VALID_SENTENCE + VALID_POSITION);

    Cake.execute(ParenthesisMatching.class);

    assertEquals("79", getOutput());
  }

  @Test
  void testPositionValidation() {
    setUpInput(VALID_SENTENCE + INVALID_POSITION + VALID_POSITION);

    Cake.execute(ParenthesisMatching.class);

    assertEquals("79", getOutput());
  }
}
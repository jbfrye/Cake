package com.weekly;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Num300ParenthesisMatchingTest {
  private static final String VALID_SENTENCE =
      "Sometimes (when I nest them (my parentheticals) too much " +
      "(like this (and this))) they get confusing.";
  private static final String INVALID_SENTENCE =
      "This is a (sentence) with (an invalid (amount) of parenthesis.";
  private static final int VALID_POSITION = 10;
  private static final int INVALID_POSITION = 4;

  @Test
  void testSentenceValidation() {
    IllegalArgumentException exception =
            assertThrows(
                    IllegalArgumentException.class,
                    () -> Num300ParenthesisMatching.runSolution(INVALID_SENTENCE, VALID_POSITION));

    assertEquals(exception.getMessage(), "Invalid Input.");
  }

  @Test
  void testPositionValidation() {
    IllegalArgumentException exception =
            assertThrows(
                    IllegalArgumentException.class,
                    () -> Num300ParenthesisMatching.runSolution(VALID_SENTENCE, INVALID_POSITION));

    assertEquals(exception.getMessage(), "Invalid Input.");
  }

  @Test
  void testSolution() {
    int output = Num300ParenthesisMatching.runSolution(VALID_SENTENCE, VALID_POSITION);

    assertEquals(79, output);
  }
}

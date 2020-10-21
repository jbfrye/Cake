package com.weekly;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Num299PermutationPalindromeTest {
  @ParameterizedTest
  @ValueSource(strings = {"vicci", "ViCcI"})
  void testSolution_True(String input) {
    boolean output = Num299PermutationPalindrome.runSolution(input);

    assertTrue(output);
  }

  @ParameterizedTest
  @ValueSource(strings = {"civil", "CiViL"})
  void testSolution_False(String input) {
    boolean output = Num299PermutationPalindrome.runSolution(input);

    assertFalse(output);
  }
}

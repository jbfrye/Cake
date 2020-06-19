package com.weekly;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.Cake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PermutationPalindromeTest {
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

  @ParameterizedTest
  @ValueSource(strings = {"vicci", "ViCcI"})
  void testSolution_True(String input) {
    setUpInput(input);

    Cake.execute(PermutationPalindrome.class);

    assertEquals("Is Palindrome: True", getOutput());
  }

  @ParameterizedTest
  @ValueSource(strings = {"civil", "CiViL"})
  void testSolution_False(String input) {
    setUpInput(input);

    Cake.execute(PermutationPalindrome.class);

    assertEquals("Is Palindrome: False", getOutput());
  }
}

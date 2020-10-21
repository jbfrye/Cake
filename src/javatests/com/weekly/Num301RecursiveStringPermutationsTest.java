package com.weekly;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Num301RecursiveStringPermutationsTest {
  @Test
  void testSolution() {
    List<String> output = Num301RecursiveStringPermutations.runSolution("cat");

    List<String> expectedOutput = new ArrayList<>();
    expectedOutput.add("act");
    expectedOutput.add("atc");
    expectedOutput.add("cat");
    expectedOutput.add("cta");
    expectedOutput.add("tac");
    expectedOutput.add("tca");
    assertEquals(expectedOutput, output);
  }
}

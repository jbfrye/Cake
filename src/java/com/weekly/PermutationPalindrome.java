package com.weekly;

import static java.lang.System.out;

import java.util.*;

/** Solution to Interview Cake Weekly Problem #299: Permutation Palindrome */
public class PermutationPalindrome implements Problem {
  private String input;

  public PermutationPalindrome() {}

  public void execute() {
    readInput();
    runSolution();
  }

  /** Problem solution. */
  private void runSolution() {
    Set<Character> unpairedSet = new HashSet<>();

    for (char character : input.toCharArray()) {
      if (!unpairedSet.contains(character)) {
        unpairedSet.add(character);
      } else {
        unpairedSet.remove(character);
      }
    }

    out.print("Is Palindrome: ");
    if (unpairedSet.size() <= 1) {
      out.print("True");
    } else {
      out.print("False");
    }
  }

  /** Read in a string. */
  private void readInput() {
    Scanner scanner = new Scanner(System.in);

    out.println("Enter a string:");
    input = scanner.nextLine().toLowerCase();
  }
}

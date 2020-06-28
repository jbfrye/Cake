package com.weekly;

import static java.lang.System.out;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/** Solution to Interview Cake Weekly Problem #299: Permutation Palindrome. */
public class PermutationPalindrome implements Problem {
  public PermutationPalindrome() {}

  public void execute() {
    runSolution(readInput());
  }

  /** Problem solution. */
  private void runSolution(String input) {
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
  private String readInput() {
    Scanner scanner = new Scanner(System.in);

    out.println("Enter a string:");
   return scanner.nextLine().toLowerCase();
  }
}

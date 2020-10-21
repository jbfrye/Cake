package com.weekly;

import static java.lang.System.out;

import java.util.HashSet;
import java.util.Set;

/** Solution to Interview Cake Weekly Problem #299: Permutation Palindrome. */
public class Num299PermutationPalindrome {
  /** Problem solution. */
  public static boolean runSolution(String input) {
    Set<Character> unpairedSet = new HashSet<>();

    for (char character : input.toLowerCase().toCharArray()) {
      if (!unpairedSet.contains(character)) {
        unpairedSet.add(character);
      } else {
        unpairedSet.remove(character);
      }
    }

    out.print("Is Palindrome: ");
    if (unpairedSet.size() <= 1) {
      out.print("True");
      return true;
    } else {
      out.print("False");
      return false;
    }
  }
}

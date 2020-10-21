package com.weekly;

import static java.lang.System.out;

import java.util.Scanner;

/** Solution to Interview Cake Weekly Problem #300: Parenthesis Matching. */
public class Num300ParenthesisMatching {
  /** Problem solution. */
  public static int runSolution(String sentence, int position) {
    validateInput(sentence, position);

    int openParens = 1;
    for (int i = ++position; i < sentence.length(); i++) {
      if (sentence.charAt(i) == '(') {
        openParens++;
      } else if (sentence.charAt(i) == ')') {
        openParens--;
      }
      if (openParens == 0) {
        out.print("Location of '(':\n" + i);
        return i;
      }
    }

    throw new IllegalArgumentException("Invalid Input.");
  }

  /** Validate that the sentence contains parentheses that are properly closed. */
  private static void validateInput(String sentence, int position) {
    int openParens = 0;
    boolean containsParens = false;
    boolean validParens = true;

    for (char input : sentence.toCharArray()) {
      if (input == '(') {
        containsParens = true;
        openParens++;
      } else if (input == ')') {
        containsParens = true;
        openParens--;
      }
      if (openParens < 0) {
        validParens = false;
        break;
      }
    }

    if (!containsParens || !validParens || openParens != 0 || sentence.charAt(position) != '(') {
      throw new IllegalArgumentException("Invalid Input.");
    }
  }
}

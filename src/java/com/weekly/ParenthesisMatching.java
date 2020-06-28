package com.weekly;

import static java.lang.System.out;

import java.util.Scanner;

/** Solution to Interview Cake Weekly Problem #300: Parenthesis Matching. */
public class ParenthesisMatching implements Problem {
  private String sentence;
  private int position;

  public ParenthesisMatching() {}

  public void execute() {
    readAndValidateInput();
    runSolution();
  }

  /** Problem solution. */
  private void runSolution() {
    int openParens = 1;
    for (int i = ++position; i < sentence.length(); i++) {
      if (sentence.charAt(i) == '(') {
        openParens++;
      } else if (sentence.charAt(i) == ')') {
        openParens--;
      }
      if (openParens == 0) {
        out.print("Location of '(':\n" + i);
        break;
      }
    }
  }

  /**
   * Read the sentence with parenthesis and the location of the parenthesis to match from
   * the user with validation.
   */
  private void readAndValidateInput() {
    Scanner scanner = new Scanner(System.in);
    int loopCounter = 0;
    boolean isValid;

    out.println("====Problem #300: Parenthesis Matching====");
    out.println("Enter a sentence with a valid parenthesis configuration:");
    do {
      sentence = scanner.nextLine();
      isValid = validateSentenceInput(sentence);
      if (!isValid) {
        out.println("Invalid sentence format, try again:");
        loopCounter++;
      }
    } while(!isValid && loopCounter < 10);

    out.println("Enter the number location of a '(' (starting with 0):");
    loopCounter = 0;
    do {
      position = scanner.nextInt();
      isValid = validatePositionInput(position);
      if (!isValid) {
        out.println("Invalid '(' location, try again:");
        loopCounter++;
      }
    } while(!isValid && loopCounter < 10);
  }

  /** Validate that the inputted sentence has a valid parenthesis configuration. */
  private boolean validateSentenceInput(String sentence) {
    int validParens = 0;
    boolean containsParens = false;

    for (char input : sentence.toCharArray()) {
      if (input == '(') {
        containsParens = true;
        validParens++;
      } else if (input == ')') {
        containsParens = true;
        validParens--;
      }
      if (validParens < 0) {
        return false;
      }
    }

    if (!containsParens) {
      return false;
    }
    return validParens == 0;
  }

  /** Validate that the inputted position is a '('. */
  private boolean validatePositionInput(int position) {
    return sentence.charAt(position) == '(';
  }
}

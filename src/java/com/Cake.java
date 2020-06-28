package com;

import static java.lang.System.out;

import com.weekly.*;
import java.lang.reflect.InvocationTargetException;

public class Cake {
  public static void main(String[] args) {
    // #299: Permutation Palindrome
    //execute(PermutationPalindrome.class);

    // #300: Parenthesis Matching
    //execute(ParenthesisMatching.class);

    // #301: Recursive String Permutations
    execute(RecursiveStringPermutations.class);
  }

  public static void execute(Class<? extends Problem> problemToExecute) {
    try {
      problemToExecute.getDeclaredConstructor().newInstance().execute();
    } catch (NoSuchMethodException | InstantiationException |
            IllegalAccessException | InvocationTargetException ex) {
      out.println("Error with executing " + problemToExecute + ": " + ex.getMessage());
    }
  }
}

package com.weekly;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Solution to the Interview Cake Weekly Problem #301: Recursive String Permutations. */
public class Num301RecursiveStringPermutations {
  /** Problem solution. */
  public static List<String> runSolution(String input) {
    Set<String> answers = everyPermutation(input);
    List<String> sortedAnswers = new ArrayList<>(answers);
    Collections.sort(sortedAnswers);

    for (String answer : sortedAnswers) {
      out.print(answer + " ");
    }
    return sortedAnswers;
  }

  private static Set<String> everyPermutation(String input) {
    if (input.length() <= 1) {
      return new HashSet<>(Collections.singletonList(input));
    }

    String withoutEnd = input.substring(0, input.length() - 1);
    char endChar = input.charAt(input.length() - 1);

    Set<String> permutationsOfWithoutEnd = everyPermutation(withoutEnd);

    Set<String> permutations = new HashSet<>();
    for (String permutationOfWithoutEnd : permutationsOfWithoutEnd) {
      for (int position = 0; position <= withoutEnd.length(); position++) {
        String permutation = permutationOfWithoutEnd.substring(0, position)
            + endChar
            + permutationOfWithoutEnd.substring(position);
        permutations.add(permutation);
      }
    }

    return permutations;
  }
}

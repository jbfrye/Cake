package com.weekly;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Solution to Interview Cake Weekly Problem #302: Find Repeat, Space Edition. */
public class Num302FindRepeatSpaceEdition {
  /** Problem solution. */
  public static int runSolution(List<Integer> inputList) {
    int floor = 1;
    int ceiling = inputList.size() - 1;

    List<Integer> lowerRange = new ArrayList<>();
    while (floor < ceiling) {
      int midpoint = floor + ((ceiling - floor) / 2);

      for (Integer integer : inputList) {
        if (integer >= floor && integer <= midpoint) {
          lowerRange.add(integer);
        }
      }

      if (lowerRange.size() > (midpoint - floor + 1)) {
        ceiling = midpoint;
      } else {
        floor = midpoint + 1;
      }
    }

    out.println("A duplicate integer is: " + floor);
    return floor;
  }

  private static boolean validateInput(List<Integer> inputList) {
    // Validate the input by streaming and making sure that each integer is between 1 and n-1.


    Scanner scanner = new Scanner(System.in);
    inputList.clear();

    out.println("====Problem #302: Find Repeat, Space Edition====");
    out.println("Enter a list of n comma separated integers from the range 1...n-1:");
    do {
      String input = scanner.nextLine();
      try {
        out.println("Invalid list format, try again:");
      } catch (Exception e) {
        out.println("Invalid list format, try again:");
      }
    } while (true);
  }
}

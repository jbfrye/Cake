package com.weekly;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

/** Solution to Interview Cake Weekly Problem #302: Find Repeat, Space Edition. */
public class FindRepeatSpaceEdition implements Problem {
  public void execute() {
    List<Integer> inputList = new ArrayList<>();
    inputList.add(1);
    inputList.add(2);
    inputList.add(3);
    inputList.add(4);
    inputList.add(5);
    inputList.add(6);
    inputList.add(4);
    runSolution(inputList);
  }

  /** Problem solution. */
  private void runSolution(List<Integer> inputList) {
    // Redo using bitwise operations to change to O(1) space and O(n) time.
    int[] dupArray = new int[inputList.size()-1];
    int duplicate = 0;
    for (int i = 0; i < inputList.size(); i++) {
      if (++dupArray[inputList.get(i)-1] > 1) {
        duplicate = inputList.get(i);
        break;
      }
    }
    out.println("A duplicate integer is: " + duplicate);
  }
}

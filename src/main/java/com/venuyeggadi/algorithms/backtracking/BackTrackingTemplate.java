package com.venuyeggadi.algorithms.backtracking;

/**
 * 1. Base case
 * 2. Choices
 * 3. Constraints
 * 4. Backtrack step
 */

/**
public class BackTrackingTemplate {

    void backtrack(params) {
        if (isBaseCase) {  // if (isSolutionComplete)
            results.add(copyOf(currentSolution));
            return;
        }

        for (Choice choice : choices) {
            if (violatesConstraints)
                continue;

            makeChoice();
            backtrack(updatedParams);
            undoChoice();                 // backtrack step
        }
    }

}
*/
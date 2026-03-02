# Stack

### Stack
* LIFO - Last In First Out order  

| Operation     | Big-O Time |
|---------------|------------|
| Push          | O(1)       |
| Pop           | O(1)       |
| Peek / Top    | O(1)       |
* [Stack implementation](../datastructures/stack)
* Problems
  * [Baseball Game](https://leetcode.com/problems/baseball-game/) - [Solution](../problemsolving/leetcode/682.BaseBallGame.java)
  * [Valid Parentheses](https://leetcode.com/problems/valid-parentheses/) - [Solution](../problemsolving/leetcode/20.ValidParentheses.java)
  * [Min Stack](https://leetcode.com/problems/min-stack/) - [Solution](../problemsolving/leetcode/155.MinStack.java)

### Monotonic Stack
* https://algo.monster/problems/mono_stack_intro
* The word "monotonic" means a list or a function is either always increasing, or always decreasing. 
  In that case, a "monotonic stack" or a "monotonic deque" is a stack or a deque that has this property.
* Monotonic stack is like a regular stack with one key distinction in the push operation: 
  Before we push a new element onto the stack, we first check if adding it breaks the monotonic condition. 
  If it does, then we pop the top element off the stack until pushing the new element no longer breaks the monotonic condition.
* Applications
  * Monotonically Decreasing stack
    * [Next Larger Element](../algorithms/stack/NextLargerElement.java)
    * [Previous Larger Element](../algorithms/stack/PreviousLargerElement.java)
  * Monotonically Increasing stack
    * [Next Smaller Element](../algorithms/stack/NextSmallerElement.java)
    * [Previous Smaller Element](../algorithms/stack/PreviousSmallerElement.java)
* Problems
  * [Daily Temperatures](https://leetcode.com/problems/daily-temperatures/) - [Solution](../problemsolving/leetcode/739.DailyTemperatures.java)
  * [Car Fleet](https://leetcode.com/problems/car-fleet/) - Solution
  * [Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/) - Solution
# New 21 Game

## Problem Description
Alice plays the following game, loosely based on the card game "21":

Alice starts with 0 points and draws numbers while she has less than k points. During each draw, she gains an integer number of points randomly from the range [1, maxPts], where maxPts is an integer. Each draw is independent and the outcomes have equal probabilities.

Alice stops drawing numbers when she gets k or more points. Return the probability that Alice has n or fewer points.

## Approach
This is a dynamic programming problem that requires understanding of probability and state transitions. The key insight is that the probability of reaching a certain point value depends on the probabilities of reaching previous point values.

## Algorithm
1. **Base Cases:**
   - If k = 0, Alice always wins (no draws needed)
   - If n ≥ k + maxPts - 1, Alice always wins (can't exceed n)

2. **Dynamic Programming:**
   - `dp[i]` represents the probability of reaching exactly i points
   - `dp[0] = 1.0` (base case: starting with 0 points)
   - For each point value i, the probability is the average of probabilities from the previous maxPts positions

3. **Sliding Window Optimization:**
   - Maintain a running sum of probabilities for the sliding window
   - Add new probabilities when i < k (still drawing)
   - Remove old probabilities that are no longer in the window

4. **Final Result:**
   - Sum up all probabilities from 0 to n (all winning outcomes)

## Mathematical Intuition
- The probability of reaching point i is: `dp[i] = (dp[i-1] + dp[i-2] + ... + dp[i-maxPts]) / maxPts`
- This represents the average probability of reaching any of the previous maxPts positions, divided by the number of possible draws
- We use a sliding window to efficiently calculate this sum

## Time Complexity
- **Time**: O(n) where n is the maximum points we need to consider
- **Space**: O(n) for the dp array

## Example
- Input: n = 6, k = 1, maxPts = 10
- Process: Calculate probabilities for each point value using sliding window
- Output: Probability that Alice ends with ≤ 6 points

## Key Insights
- The problem is about calculating probabilities of reaching specific states
- The sliding window technique avoids recalculating sums repeatedly
- We only need to consider points up to n, not beyond

# Minimum Jumps to Reach End via Prime Teleportation (Medium)

**Problem ID:** 3629  
**Date:** 2026-05-08  
**Link:** https://leetcode.com/problems/minimum-jumps-to-reach-end-via-prime-teleportation/

## Approach

To solve the problem of finding the minimum jumps to reach the end of the array using both adjacent steps and prime teleportation, we can employ a breadth-first search (BFS) approach. Here’s a concise explanation of the solution strategy:

### Main Idea
The goal is to explore all possible ways to reach the last index of the array using the allowed operations: moving to adjacent indices and teleporting based on prime divisibility. BFS is suitable here because it explores all positions at the current jump level before moving to the next, ensuring that we find the shortest path (minimum jumps) to the last index.

### Steps to Solve the Problem
1. **Identify Primes**: First, we need a method to determine if a number is prime and to find all prime numbers up to the maximum possible value in `nums`. This can be efficiently done using the Sieve of Eratosthenes.

2. **Build a Prime Map**: Create a mapping from each prime number to the indices of elements in `nums` that are divisible by that prime. This will facilitate quick access during the teleportation step.

3. **BFS Initialization**: Start BFS from index 0. Use a queue to manage the indices to explore and a set to keep track of visited indices to avoid cycles.

4. **Explore Adjacent Steps**: At each index, check the adjacent indices (i + 1 and i - 1) and enqueue them if they haven't been visited yet.

5. **Utilize Prime Teleportation**: If the current number is prime, use the prime map to find all indices that can be reached via teleportation. Enqueue these indices as well, ensuring they haven't been visited.

6. **Track Levels**: Maintain a count of jumps (levels) as you explore the indices. When you reach the last index, return the count of jumps.

### Data Structures
- **Queue**: For BFS traversal to explore indices level by level.
- **Set**: To track visited indices and prevent re-processing.
- **Map**: To store the prime numbers and their corresponding indices for quick access during teleportation.

### Complexity Analysis
- **Time Complexity**: The overall complexity is O(n log log m), where n is the length of the `nums` array and m is the maximum value in `nums`. This accounts for the Sieve of Eratosthenes and the BFS traversal.
- **Space Complexity**: O(n + p), where p is the number of primes found, due to the storage of visited indices and the prime mapping.

This approach efficiently combines number theory (for prime checking) with graph traversal (BFS) to solve the problem within the given constraints.

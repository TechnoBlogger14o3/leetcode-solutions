# Destroying Asteroids (Medium)

**Problem ID:** 2126  
**Date:** 2026-05-31  
**Link:** https://leetcode.com/problems/destroying-asteroids/

## Approach

To solve the "Destroying Asteroids" problem, the main idea is to simulate the process of the planet colliding with asteroids in a strategic order to maximize the chances of survival. The approach can be summarized as follows:

1. **Sort the Asteroids**: Begin by sorting the array of asteroids in ascending order. This allows the planet to tackle the smaller asteroids first, which increases its mass gradually and enables it to potentially destroy larger asteroids later.

2. **Iterate Through the Sorted Asteroids**: Initialize a variable to keep track of the current mass of the planet. Start with the given initial mass. Then, iterate through the sorted list of asteroids:
   - For each asteroid, check if the current mass of the planet is greater than or equal to the mass of the asteroid.
   - If it is, the asteroid is destroyed, and the mass of the asteroid is added to the planet's mass.
   - If the planet's mass is less than the asteroid's mass, the planet cannot destroy this asteroid, and the function should return false immediately.

3. **Return True if All Asteroids are Destroyed**: If the loop completes without returning false, it means the planet has successfully destroyed all asteroids, and the function should return true.

### Data Structures:
- A simple array (or list) to hold the asteroids.
- Sorting the array will require O(n log n) time complexity, where n is the number of asteroids.

### Complexity:
- **Time Complexity**: O(n log n) due to the sorting step, followed by O(n) for the iteration through the asteroids, resulting in an overall complexity of O(n log n).
- **Space Complexity**: O(1) if the sorting is done in place, or O(n) if a new sorted array is created.

This approach ensures that the planet maximizes its mass gain by destroying the smallest asteroids first, thereby increasing the likelihood of surviving against larger asteroids.

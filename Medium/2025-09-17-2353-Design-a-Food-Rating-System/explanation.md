# Design a Food Rating System (Medium)

**Problem ID:** 2353  
**Date:** 2025-09-17  
**Link:** https://leetcode.com/problems/design-a-food-rating-system/

## Approach

To solve the problem of designing a food rating system, we need to efficiently handle two operations: changing the rating of a food item and retrieving the highest-rated food item for a specific cuisine. Here’s a structured approach to tackle this problem:

### Main Idea
The core idea is to maintain a mapping of food items to their ratings and cuisines, while also keeping track of the highest-rated food items for each cuisine. This allows us to quickly update ratings and retrieve the highest-rated food efficiently.

### Data Structures
1. **HashMap for Food Ratings**: Use a dictionary (or hash map) to store the food item as the key and its corresponding rating as the value. This allows O(1) time complexity for updating the rating of a food item.
   
2. **HashMap for Cuisines**: Use another dictionary to map each cuisine to a priority queue (or a sorted list) that contains food items sorted by their ratings. This allows us to efficiently retrieve the highest-rated food item for a given cuisine.

3. **Priority Queue (or Sorted List)**: Each cuisine's food items can be stored in a priority queue (or sorted list) to enable efficient retrieval of the highest-rated food item. In Python, this can be implemented using a min-heap, where we store negative ratings to simulate a max-heap behavior.

### Operations
- **Initialization**: During the initialization of the `FoodRatings` class, populate the food ratings map and the cuisine map, filling the priority queues with food items based on their initial ratings.

- **Change Rating**: When the `changeRating` method is called:
  - Update the food's rating in the food ratings map.
  - Remove the old rating of the food from the corresponding cuisine's priority queue and insert the new rating. This can be done efficiently if we maintain a structure that allows for quick updates (like a balanced tree or a heap).

- **Highest Rated**: When the `highestRated` method is called:
  - Simply retrieve the top item from the priority queue associated with the specified cuisine. This operation is efficient due to the properties of the priority queue.

### Complexity
- **Initialization**: O(n log n) due to inserting `n` food items into the priority queues.
- **Change Rating**: O(log m) where `m` is the number of food items in the specific cuisine, due to the operations on the priority queue.
- **Highest Rated**: O(1) for retrieving the highest-rated food item from the priority queue.

Overall, this approach ensures that both operations are efficient, making the system scalable to the problem's constraints. The use of hash maps and priority queues allows for quick access and updates, which is crucial given the potential number of operations.

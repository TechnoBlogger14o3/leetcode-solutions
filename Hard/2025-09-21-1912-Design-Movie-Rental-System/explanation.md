# Design Movie Rental System (Hard)

**Problem ID:** 1912  
**Date:** 2025-09-21  
**Link:** https://leetcode.com/problems/design-movie-rental-system/

## Approach

To solve the "Design Movie Rental System" problem, we need to implement a system that can efficiently manage movie rentals across multiple shops while supporting various operations such as searching for unrented movies, renting movies, dropping off rented movies, and reporting currently rented movies.

### Main Idea:
The core of the solution revolves around maintaining two main data structures:
1. **A mapping from movies to their available rental information**: This allows us to quickly find which shops have unrented copies of a specific movie.
2. **A list of currently rented movies**: This enables us to efficiently report the cheapest rented movies.

### Data Structures:
1. **A Min-Heap (Priority Queue)**: This is used to maintain the unrented movies for each shop in a way that allows us to efficiently retrieve the cheapest options. Each entry in the heap will contain the shop index, movie index, and rental price.
2. **A Dictionary (HashMap)**: This maps each movie to a list of tuples containing (price, shop index) for all shops that have an unrented copy of that movie. The list can be kept sorted or can be inserted into a min-heap for efficient retrieval.
3. **A Set**: This keeps track of which movies are currently rented and from which shops, allowing for quick checks when renting or dropping off movies.

### Operations:
- **Search**: For a given movie, retrieve the first five shops with unrented copies by accessing the dictionary and extracting the cheapest entries. If fewer than five shops are available, return all of them.
  
- **Rent**: When renting a movie from a shop, update the data structures to reflect that the movie is now rented. Remove the corresponding entry from the unrented list and add it to the rented set.

- **Drop**: When dropping off a rented movie, update the data structures to mark the movie as unrented again. This involves adding the movie back to the appropriate shop's unrented list.

- **Report**: To generate a report of the cheapest rented movies, we can maintain a min-heap of currently rented movies. This allows us to efficiently retrieve the top five cheapest entries for reporting.

### Complexity:
- The time complexity for each operation (search, rent, drop, report) is primarily O(log k) for heap operations, where k is the number of shops with unrented copies of a movie or the number of rented movies. Given the constraints, this approach is efficient enough to handle the upper limits of the input sizes.

Overall, this structured approach allows us to efficiently manage the movie rental system while ensuring that we can quickly respond to queries and updates regarding movie availability and rentals.

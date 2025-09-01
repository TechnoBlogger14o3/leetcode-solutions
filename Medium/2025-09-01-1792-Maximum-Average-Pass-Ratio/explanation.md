# Maximum Average Pass Ratio (Medium)

**Problem ID:** 1792  
**Date:** 2025-09-01  
**Link:** https://leetcode.com/problems/maximum-average-pass-ratio/

## Approach

To solve the "Maximum Average Pass Ratio" problem, we need to strategically allocate extra students to classes to maximize the average pass ratio across all classes. The approach can be summarized as follows:

### Main Idea:
The key insight is to prioritize classes based on how much their pass ratio can be improved by adding extra students. The improvement in the pass ratio for a class can be quantified by calculating the difference in the pass ratio before and after assigning an extra student. This difference is given by the formula:

\[
\text{gain} = \frac{(pass + 1)}{(total + 1)} - \frac{pass}{total}
\]

This formula represents the increase in the pass ratio when one extra student is added to a class. We want to maximize the total gain across all classes by strategically assigning the extra students.

### Approach:
1. **Calculate Initial Pass Ratios**: For each class, calculate the initial pass ratio.
2. **Use a Max-Heap**: Utilize a max-heap (priority queue) to store classes based on their potential gain from adding an extra student. The class with the highest gain should be prioritized.
3. **Allocate Extra Students**: For each of the extra students, extract the class with the highest gain from the heap, update its pass and total counts, and then recalculate its gain. Push the updated class back into the heap.
4. **Compute Final Average Pass Ratio**: After all extra students have been assigned, compute the final average pass ratio by summing the pass ratios of all classes and dividing by the number of classes.

### Data Structures:
- A max-heap (priority queue) to efficiently retrieve and update the class with the highest gain.
- An array or list to store the classes and their respective pass and total counts.

### Complexity:
- **Time Complexity**: The overall time complexity is \(O(N \log N + E \log N)\), where \(N\) is the number of classes and \(E\) is the number of extra students. The \(O(N \log N)\) comes from initially inserting all classes into the heap, and the \(O(E \log N)\) arises from extracting and reinserting classes for each extra student.
- **Space Complexity**: The space complexity is \(O(N)\) due to the storage of classes in the heap.

This approach efficiently maximizes the average pass ratio by focusing on the classes that benefit the most from additional students, ensuring an optimal allocation strategy.

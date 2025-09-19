# Design Spreadsheet (Medium)

**Problem ID:** 3484  
**Date:** 2025-09-19  
**Link:** https://leetcode.com/problems/design-spreadsheet/

## Approach

To solve the "Design Spreadsheet" problem, we can adopt an object-oriented approach by implementing a `Spreadsheet` class that encapsulates the required functionalities. Here's a concise breakdown of the approach:

### Main Idea:
The goal is to create a spreadsheet that supports setting and resetting cell values, along with evaluating simple arithmetic formulas involving cell references and integers.

### Data Structures:
1. **2D Array (or List of Lists)**: To represent the spreadsheet, we can use a 2D list where each element corresponds to a cell in the spreadsheet. The rows will be indexed from 0 to `rows - 1`, and the columns will be represented by indices corresponding to letters 'A' to 'Z' (0 to 25).
   
2. **Dictionary (or HashMap)**: To facilitate quick access to cell values, we can maintain a dictionary that maps cell references (like "A1", "B2") to their respective values. This will allow us to handle cases where cells have not been explicitly set, defaulting to 0.

### Methods:
1. **Constructor (`Spreadsheet(int rows)`)**: Initializes the spreadsheet with the specified number of rows and sets all cell values to 0.

2. **`setCell(String cell, int value)`**: Converts the cell reference into its respective row and column indices, updates the value in the 2D list, and also updates the dictionary.

3. **`resetCell(String cell)`**: Similar to `setCell`, but sets the specified cell's value back to 0 in both the 2D list and the dictionary.

4. **`getValue(String formula)`**: This method parses the formula string to extract the components (X and Y). It checks if they are cell references or integers, retrieves their values (defaulting to 0 for unset cells), and computes the sum. The parsing can be done using string manipulation techniques.

### Complexity:
- **Time Complexity**:
  - `setCell`: O(1) for direct updates.
  - `resetCell`: O(1) for direct resets.
  - `getValue`: O(1) for retrieving values, but parsing the formula may take O(n) where n is the length of the formula string. In the worst case, this could be O(1) since the formula is always in the format "=X+Y" with a fixed length.
  
- **Space Complexity**: O(rows * 26) for the 2D array and O(1) for the dictionary, as it only stores values for cells that have been set.

### Conclusion:
This approach efficiently manages the spreadsheet's state and allows for quick updates and evaluations of cell values, adhering to the constraints provided. The use of a 2D array and a dictionary ensures that operations are performed in constant time for most cases, making the solution both effective and scalable.

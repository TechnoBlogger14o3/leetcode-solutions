# Decode the Slanted Ciphertext (Medium)

**Problem ID:** 2075  
**Date:** 2026-04-04  
**Link:** https://leetcode.com/problems/decode-the-slanted-ciphertext/

## Approach

To solve the problem of decoding the slanted ciphertext, we need to reverse the encoding process described. The approach can be broken down into the following steps:

1. **Understanding the Matrix Structure**: The encoded text is derived from a matrix filled in a specific order. The matrix has a fixed number of rows, and the characters from `originalText` are filled diagonally. The first step is to determine the number of columns in the matrix. This can be calculated as:
   - `columns = (length of encodedText + rows - 1) // rows`
   This formula ensures that we have enough columns to accommodate the entire `encodedText` when filled in the specified manner.

2. **Reconstructing the Matrix**: Using the calculated number of columns, we can reconstruct the matrix from the `encodedText`. The matrix will be filled row by row, where each row will contain `columns` characters from the `encodedText`.

3. **Filling the Matrix**: We fill the matrix by iterating over the `encodedText` and placing characters in their respective positions according to the diagonal filling order. This involves:
   - For each column, starting from the top row and moving downwards, we fill the matrix diagonally until we reach the bottom row or the end of the string.

4. **Extracting the Original Text**: Once the matrix is filled, we can extract the `originalText` by reading the matrix in a row-wise manner. This means concatenating characters from each row sequentially to form the final decoded string.

5. **Handling Edge Cases**: We need to consider cases where `encodedText` is empty or when there is only one row, in which case the output would be the same as the input.

**Data Structures**: A 2D list (matrix) is used to store the characters while reconstructing the matrix. This allows for easy access and modification of individual elements.

**Complexity**: The time complexity of this approach is O(n), where n is the length of `encodedText`, as we are iterating through the string a constant number of times. The space complexity is also O(n) due to the storage of the matrix.

By following this structured approach, we can efficiently decode the slanted ciphertext back to the original text.

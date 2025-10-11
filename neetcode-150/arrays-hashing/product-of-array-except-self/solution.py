"""
Time Complexity: O(n) - Two passes through the array
Space Complexity: O(1) - Excluding the output array
"""
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [1] * n
        
        # First pass: calculate left products
        for i in range(1, n):
            result[i] = result[i - 1] * nums[i - 1]
        
        # Second pass: calculate right products and multiply
        right_product = 1
        for i in range(n - 1, -1, -1):
            result[i] *= right_product
            right_product *= nums[i]
        
        return result

# Alternative approach using two arrays
class SolutionTwoArrays:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        left_products = [1] * n
        right_products = [1] * n
        result = [0] * n
        
        # Calculate left products
        for i in range(1, n):
            left_products[i] = left_products[i - 1] * nums[i - 1]
        
        # Calculate right products
        for i in range(n - 2, -1, -1):
            right_products[i] = right_products[i + 1] * nums[i + 1]
        
        # Multiply left and right products
        for i in range(n):
            result[i] = left_products[i] * right_products[i]
        
        return result

# Using reduce for more functional approach
from functools import reduce
import operator

class SolutionFunctional:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = []
        
        for i in range(n):
            # Create list without current element
            other_elements = nums[:i] + nums[i+1:]
            # Calculate product of other elements
            product = reduce(operator.mul, other_elements, 1)
            result.append(product)
        
        return result

# One-liner using list comprehension (not efficient)
class SolutionOneLiner:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        return [reduce(operator.mul, nums[:i] + nums[i+1:], 1) for i in range(len(nums))]

class Solution:
    def minimumScore(self, nums: List[int]) -> int:
        min_num = min(nums)
        max_num = max(nums)
        
        # If there are at least two elements, we can always make the low score 0
        # by changing two elements to be the same.
        low_score = 0
        
        # The high score can be minimized by changing the max and min elements
        # to the second min and second max elements.
        nums_sorted = sorted(nums)
        if len(nums_sorted) > 2:
            high_score = nums_sorted[-2] - nums_sorted[1]
        else:
            high_score = 0
        
        return low_score + high_score
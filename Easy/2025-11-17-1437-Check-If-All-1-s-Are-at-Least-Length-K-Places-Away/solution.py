class Solution:
    def kLengthApart(self, nums: List[int], k: int) -> bool:
        last_position = -1
        
        for i in range(len(nums)):
            if nums[i] == 1:
                if last_position != -1 and i - last_position <= k:
                    return False
                last_position = i
        
        return True
class Solution:
    def countValidSelections(self, nums: List[int]) -> int:
        n = len(nums)
        valid_count = 0
        
        for i in range(n):
            if nums[i] == 0:
                # Check left direction
                left_valid = self.checkDirection(nums, i, -1)
                # Check right direction
                right_valid = self.checkDirection(nums, i, 1)
                valid_count += left_valid + right_valid
        
        return valid_count
    
    def checkDirection(self, nums: List[int], start: int, direction: int) -> bool:
        n = len(nums)
        curr = start
        visited = set()
        
        while 0 <= curr < n:
            if curr in visited:
                return False
            visited.add(curr)
            if nums[curr] == 0:
                curr += direction
            else:
                nums[curr] -= 1
                curr -= direction
                direction *= -1
        
        return True
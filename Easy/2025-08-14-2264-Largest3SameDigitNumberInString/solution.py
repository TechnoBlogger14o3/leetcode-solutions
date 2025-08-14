class Solution:
    def largestGoodInteger(self, num: str) -> str:
        result = ""
        
        # Check for 3 consecutive same digits starting from the left
        for i in range(len(num) - 2):
            # Check if current position and next two positions have the same digit
            if num[i] == num[i + 1] == num[i + 2]:
                
                current = num[i:i + 3]
                
                # Update result if current is larger (lexicographically)
                if current > result:
                    result = current
        
        return result

# Alternative approach using sliding window
class Solution2:
    def largestGoodInteger(self, num: str) -> str:
        result = ""
        
        # Use sliding window of size 3
        for i in range(len(num) - 2):
            c1, c2, c3 = num[i], num[i + 1], num[i + 2]
            
            # Check if all three characters are the same
            if c1 == c2 == c3:
                current = c1 + c2 + c3
                
                # Update result if current is larger
                if not result or current > result:
                    result = current
        
        return result

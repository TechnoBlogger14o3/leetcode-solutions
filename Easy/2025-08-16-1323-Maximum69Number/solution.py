class Solution:
    def maximum69Number(self, num: int) -> int:
        # Convert to string to easily manipulate digits
        num_str = str(num)
        digits = list(num_str)
        
        # Find the first occurrence of '6' and change it to '9'
        for i in range(len(digits)):
            if digits[i] == '6':
                digits[i] = '9'
                break  # Only change the first occurrence
        
        # Convert back to integer
        return int(''.join(digits))

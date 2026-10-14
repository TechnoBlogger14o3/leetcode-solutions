class Solution:
    def maximumSum(self, num: int, sum: int) -> str:
        if sum > 9 * num or sum < 1:
            return ""
        
        digits = []
        for i in range(num):
            if sum > 0:
                digit = min(9, sum)
                digits.append(digit)
                sum -= digit
            else:
                digits.append(0)
        
        return ''.join(map(str, digits))
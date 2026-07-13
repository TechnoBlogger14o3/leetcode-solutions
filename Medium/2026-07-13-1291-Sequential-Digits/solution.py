class Solution:
    def sequentialDigits(self, low: int, high: int) -> List[int]:
        result = []
        for start in range(1, 10):
            num = start
            for next_digit in range(start + 1, 10):
                num = num * 10 + next_digit
                if low <= num <= high:
                    result.append(num)
                if num > high:
                    break
        return sorted(result)
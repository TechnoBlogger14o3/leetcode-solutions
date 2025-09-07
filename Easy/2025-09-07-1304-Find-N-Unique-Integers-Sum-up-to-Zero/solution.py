class Solution:
    def sumZero(self, n: int) -> List[int]:
        return [i for i in range(-n // 2, n // 2 + 1) if i != 0] + ([0] if n % 2 == 1 else [])
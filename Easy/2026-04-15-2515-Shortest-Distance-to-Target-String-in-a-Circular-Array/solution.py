class Solution:
    def closestTarget(self, words: List[str], target: str, startIndex: int) -> int:
        n = len(words)
        if target not in words:
            return -1
        
        left_distance = float('inf')
        right_distance = float('inf')
        
        for i in range(n):
            if words[i] == target:
                left_distance = min(left_distance, (startIndex - i) % n)
                right_distance = min(right_distance, (i - startIndex) % n)
        
        return min(left_distance, right_distance)
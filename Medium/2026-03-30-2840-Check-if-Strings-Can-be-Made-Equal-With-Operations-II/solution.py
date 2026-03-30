class Solution:
    def canBeEqual(self, s1: str, s2: str) -> bool:
        if len(s1) != len(s2):
            return False
        
        even_s1 = [s1[i] for i in range(len(s1)) if i % 2 == 0]
        odd_s1 = [s1[i] for i in range(len(s1)) if i % 2 == 1]
        
        even_s2 = [s2[i] for i in range(len(s2)) if i % 2 == 0]
        odd_s2 = [s2[i] for i in range(len(s2)) if i % 2 == 1]
        
        return sorted(even_s1) == sorted(even_s2) and sorted(odd_s1) == sorted(odd_s2)
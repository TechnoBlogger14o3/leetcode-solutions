class Solution:
    def findThePrefixCommonArray(self, A: List[int], B: List[int]) -> List[int]:
        common_count = 0
        prefix_common = []
        seen = set()
        
        for a, b in zip(A, B):
            seen.add(a)
            if b in seen:
                common_count += 1
            prefix_common.append(common_count)
        
        return prefix_common
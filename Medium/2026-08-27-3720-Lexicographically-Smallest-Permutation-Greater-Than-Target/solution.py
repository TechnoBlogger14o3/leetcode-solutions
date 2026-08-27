from itertools import permutations

class Solution:
    def lexicographicallySmallestPermutation(self, s: str, target: str) -> str:
        perms = sorted(set(''.join(p) for p in permutations(s)))
        for perm in perms:
            if perm > target:
                return perm
        return ""
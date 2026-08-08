class Solution:
    def findTheLexicographicallySmallestValidSequence(self, word1: str, word2: str) -> List[int]:
        n, m = len(word1), len(word2)
        indices = []
        
        def is_almost_equal(s1, s2):
            diff_count = sum(1 for a, b in zip(s1, s2) if a != b)
            return diff_count <= 1
        
        def backtrack(start, seq):
            if len(seq) == m:
                if is_almost_equal(''.join(word1[i] for i in seq), word2):
                    indices.append(seq[:])
                return
            
            for i in range(start, n):
                seq.append(i)
                backtrack(i + 1, seq)
                seq.pop()
        
        backtrack(0, [])
        
        return min(indices) if indices else []
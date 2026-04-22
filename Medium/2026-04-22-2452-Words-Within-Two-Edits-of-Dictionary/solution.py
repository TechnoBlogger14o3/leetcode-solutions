class Solution:
    def twoEditWords(self, queries: List[str], dictionary: List[str]) -> List[str]:
        def is_within_two_edits(query: str, word: str) -> bool:
            diff_count = sum(1 for a, b in zip(query, word) if a != b)
            return diff_count <= 2
        
        result = []
        for query in queries:
            if any(is_within_two_edits(query, word) for word in dictionary):
                result.append(query)
        return result
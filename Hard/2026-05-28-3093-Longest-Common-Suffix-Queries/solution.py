class Solution:
    def longestCommonSuffix(self, wordsContainer: List[str], wordsQuery: List[str]) -> List[int]:
        def common_suffix_length(s1: str, s2: str) -> int:
            l1, l2 = len(s1), len(s2)
            length = 0
            while length < l1 and length < l2 and s1[l1 - 1 - length] == s2[l2 - 1 - length]:
                length += 1
            return length
        
        ans = []
        for query in wordsQuery:
            max_length = -1
            best_index = -1
            for index, word in enumerate(wordsContainer):
                suffix_length = common_suffix_length(word, query)
                if (suffix_length > max_length or
                    (suffix_length == max_length and (best_index == -1 or len(wordsContainer[best_index]) > len(word)))):
                    max_length = suffix_length
                    best_index = index
            ans.append(best_index)
        
        return ans
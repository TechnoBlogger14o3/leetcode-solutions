class Solution:
    def maximizePartitions(self, s: str, k: int) -> int:
        def count_partitions(s: str, k: int) -> int:
            count = 0
            left = 0
            char_count = {}
            for right in range(len(s)):
                char_count[s[right]] = char_count.get(s[right], 0) + 1
                while len(char_count) > k:
                    char_count[s[left]] -= 1
                    if char_count[s[left]] == 0:
                        del char_count[s[left]]
                    left += 1
                count += 1
            return count

        max_partitions = count_partitions(s, k)
        for i in range(len(s)):
            original_char = s[i]
            for new_char in 'abcdefghijklmnopqrstuvwxyz':
                if new_char != original_char:
                    modified_s = s[:i] + new_char + s[i+1:]
                    max_partitions = max(max_partitions, count_partitions(modified_s, k))
        return max_partitions
class Solution:
    def maximizeActiveSections(self, s: str) -> int:
        # Augment the string with '1's at both ends
        s = '1' + s + '1'
        n = len(s)
        
        # Count the number of active sections
        active_sections = 0
        for i in range(1, n):
            if s[i] == '1' and s[i - 1] == '0':
                active_sections += 1
        
        max_active_sections = active_sections
        
        # Iterate through the string to find blocks of '1's surrounded by '0's
        for i in range(1, n - 1):
            if s[i] == '0' and s[i - 1] == '1' and s[i + 1] == '1':
                # Find the length of the block of '0's
                j = i
                while j < n and s[j] == '0':
                    j += 1
                # Calculate the new number of active sections after the trade
                new_active_sections = active_sections - 1 + 2
                max_active_sections = max(max_active_sections, new_active_sections)
        
        return max_active_sections
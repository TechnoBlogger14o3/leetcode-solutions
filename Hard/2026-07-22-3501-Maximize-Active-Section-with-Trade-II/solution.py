class Solution:
    def maximizeActiveSections(self, s: str, queries: List[List[int]]) -> List[int]:
        n = len(s)
        active_sections = [0] * (n + 1)
        
        # Count initial active sections
        for i in range(n):
            if s[i] == '1':
                if i == 0 or s[i - 1] == '0':
                    active_sections[i + 1] = active_sections[i] + 1
                else:
                    active_sections[i + 1] = active_sections[i]
            else:
                active_sections[i + 1] = active_sections[i]
        
        result = []
        
        for l, r in queries:
            # Augment the substring
            left_active = active_sections[l]  # Active sections before l
            right_active = active_sections[r + 1]  # Active sections after r
            
            # Count the number of '1's in the substring
            ones_count = s[l:r + 1].count('1')
            zeros_count = (r - l + 1) - ones_count
            
            # If there are no '1's in the substring, we can't perform a trade
            if ones_count == 0:
                result.append(left_active + right_active)
                continue
            
            # If there are '1's, we can perform a trade
            new_active_sections = left_active + right_active
            
            # Check if we can increase the active sections by 1
            if (l > 0 and s[l - 1] == '0') and (r < n - 1 and s[r + 1] == '0'):
                new_active_sections += 1
            
            # Add the result for this query
            result.append(new_active_sections)
        
        return result
class Solution:
    def minTimeToBrew(self, skill: List[int], mana: List[int]) -> int:
        n = len(skill)
        m = len(mana)
        
        # Initialize the time taken for each potion
        potion_time = [0] * m
        
        for j in range(m):
            # Calculate the time for each wizard on the j-th potion
            for i in range(n):
                if j == 0:
                    potion_time[j] += skill[i] * mana[j]
                else:
                    potion_time[j] += skill[i] * mana[j]
                    potion_time[j] = max(potion_time[j], potion_time[j-1])
        
        return potion_time[-1]
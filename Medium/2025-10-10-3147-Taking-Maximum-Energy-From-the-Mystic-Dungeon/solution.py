class Solution:
    def maxEnergy(self, energy: List[int], k: int) -> int:
        n = len(energy)
        max_energy = float('-inf')
        
        for i in range(n):
            total_energy = 0
            j = i
            while j < n:
                total_energy += energy[j]
                j += k
            max_energy = max(max_energy, total_energy)
        
        return max_energy
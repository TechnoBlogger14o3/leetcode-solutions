class Solution:
    def bestClosingTime(self, customers: str) -> int:
        n = len(customers)
        penalty = [0] * (n + 1)
        
        for i in range(n):
            penalty[i + 1] = penalty[i] + (customers[i] == 'N')
        
        min_penalty = float('inf')
        best_time = 0
        
        for j in range(n + 1):
            current_penalty = penalty[j] + (n - j - (penalty[n] - penalty[j]))
            if current_penalty < min_penalty:
                min_penalty = current_penalty
                best_time = j
        
        return best_time
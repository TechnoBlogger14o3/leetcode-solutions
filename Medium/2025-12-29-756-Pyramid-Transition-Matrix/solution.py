class Solution:
    def pyramidTransition(self, bottom: str, allowed: List[str]) -> bool:
        from collections import defaultdict
        
        # Create a mapping from pairs of blocks to the possible top blocks
        transitions = defaultdict(set)
        for pattern in allowed:
            transitions[pattern[:2]].add(pattern[2])
        
        def canBuild(current_row):
            if len(current_row) == 1:
                return True
            
            next_row = []
            for i in range(len(current_row) - 1):
                pair = current_row[i:i+2]
                if pair not in transitions:
                    return False
                next_row.append(transitions[pair])
            
            # Use backtracking to explore all combinations of the next row
            return self.backtrack(next_row, 0, "")
        
        return canBuild(bottom)
    
    def backtrack(self, next_row, index, current):
        if index == len(next_row):
            return self.backtrack(next_row, 0, "")
        
        for block in next_row[index]:
            if index == len(next_row) - 1:
                if self.backtrack(next_row, index + 1, current + block):
                    return True
            else:
                if self.backtrack(next_row, index + 1, current + block):
                    return True
        
        return False
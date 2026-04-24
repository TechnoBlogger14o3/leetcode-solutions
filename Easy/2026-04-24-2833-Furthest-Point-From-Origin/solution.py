class Solution:
    def furthestDistanceFromOrigin(self, moves: str) -> int:
        left_moves = moves.count('L')
        right_moves = moves.count('R')
        underscore_moves = moves.count('_')
        
        return left_moves + right_moves + underscore_moves
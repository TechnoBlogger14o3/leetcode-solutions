class Solution:
    def rotateGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        m, n = len(grid), len(grid[0])
        
        def get_layer(r1, c1, r2, c2):
            layer = []
            for c in range(c1, c2 + 1):
                layer.append(grid[r1][c])
            for r in range(r1 + 1, r2 + 1):
                layer.append(grid[r][c2])
            for c in range(c2 - 1, c1 - 1, -1):
                layer.append(grid[r2][c])
            for r in range(r2 - 1, r1, -1):
                layer.append(grid[r][c1])
            return layer
        
        def set_layer(r1, c1, r2, c2, layer):
            idx = 0
            for c in range(c1, c2 + 1):
                grid[r1][c] = layer[idx]
                idx += 1
            for r in range(r1 + 1, r2 + 1):
                grid[r][c2] = layer[idx]
                idx += 1
            for c in range(c2 - 1, c1 - 1, -1):
                grid[r2][c] = layer[idx]
                idx += 1
            for r in range(r2 - 1, r1, -1):
                grid[r][c1] = layer[idx]
                idx += 1
        
        layers = min(m, n) // 2
        
        for layer in range(layers):
            r1, c1 = layer, layer
            r2, c2 = m - layer - 1, n - layer - 1
            
            current_layer = get_layer(r1, c1, r2, c2)
            l = len(current_layer)
            k = k % l
            
            rotated_layer = current_layer[-k:] + current_layer[:-k]
            set_layer(r1, c1, r2, c2, rotated_layer)
        
        return grid
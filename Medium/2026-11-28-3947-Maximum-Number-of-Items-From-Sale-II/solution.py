class Solution:
    def maxItems(self, items: List[List[int]], budget: int) -> int:
        from collections import defaultdict
        import heapq
        
        # Sort items by price
        items.sort(key=lambda x: x[1])
        
        # Dictionary to store free items
        free_items = defaultdict(set)
        
        # Build the free items mapping
        for i in range(len(items)):
            for j in range(len(items)):
                if i != j and items[j][0] % items[i][0] == 0:
                    free_items[i].add(j)
        
        max_count = 0
        
        # Try to buy each item and calculate the total items including free ones
        for i in range(len(items)):
            price = items[i][1]
            if price > budget:
                continue
            
            # Calculate how many can be bought
            count = budget // price
            total_items = count
            
            # Add free items
            free_set = set()
            for _ in range(count):
                free_set.update(free_items[i])
            
            total_items += len(free_set)
            max_count = max(max_count, total_items)
        
        return max_count
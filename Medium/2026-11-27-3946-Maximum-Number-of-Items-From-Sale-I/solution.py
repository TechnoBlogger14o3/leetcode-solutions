class Solution:
    def maxItems(self, items: List[List[int]], budget: int) -> int:
        from collections import defaultdict
        
        # Sort items by price
        items.sort(key=lambda x: x[1])
        
        # To store the free items we can get from each item
        free_items = defaultdict(set)
        
        # Build the free items mapping
        for i in range(len(items)):
            factor_i = items[i][0]
            for j in range(len(items)):
                if i != j and items[j][0] % factor_i == 0:
                    free_items[i].add(j)
        
        max_count = 0
        
        # Try to buy each item and calculate the total items we can get
        for i in range(len(items)):
            factor_i, price_i = items[i]
            if price_i > budget:
                continue
            
            # Calculate how many of this item we can buy
            max_buy = budget // price_i
            total_items = max_buy
            
            # Set to track which items we have bought
            bought_items = set()
            bought_items.add(i)
            
            # Add free items from the bought items
            for _ in range(max_buy):
                total_items += len(free_items[i])
                for free_item in free_items[i]:
                    bought_items.add(free_item)
            
            # Count total items including free items
            total_items += len(bought_items) - 1  # -1 to not count the bought item itself
            
            max_count = max(max_count, total_items)
        
        return max_count
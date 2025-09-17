from collections import defaultdict
import heapq

class FoodRatings:

    def __init__(self, foods: List[str], cuisines: List[str], ratings: List[int]):
        self.food_rating = {}
        self.cuisine_map = defaultdict(list)
        self.cuisine_heap = {}
        
        for food, cuisine, rating in zip(foods, cuisines, ratings):
            self.food_rating[food] = rating
            self.cuisine_map[cuisine].append(food)
            if cuisine not in self.cuisine_heap:
                self.cuisine_heap[cuisine] = []
            heapq.heappush(self.cuisine_heap[cuisine], (-rating, food))

    def changeRating(self, food: str, newRating: int) -> None:
        oldRating = self.food_rating[food]
        self.food_rating[food] = newRating
        cuisine = next(c for c, foods in self.cuisine_map.items() if food in foods)
        
        # Update the heap
        heapq.heappush(self.cuisine_heap[cuisine], (-newRating, food))
        
        # Remove the old rating from the heap
        while self.cuisine_heap[cuisine]:
            if -self.cuisine_heap[cuisine][0][0] == oldRating and self.cuisine_heap[cuisine][0][1] == food:
                heapq.heappop(self.cuisine_heap[cuisine])
                break
            else:
                heapq.heappop(self.cuisine_heap[cuisine])

    def highestRated(self, cuisine: str) -> str:
        while self.cuisine_heap[cuisine]:
            rating, food = self.cuisine_heap[cuisine][0]
            if -rating == self.food_rating[food]:
                return food
            else:
                heapq.heappop(self.cuisine_heap[cuisine])
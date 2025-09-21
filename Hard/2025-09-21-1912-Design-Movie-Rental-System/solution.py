import heapq
from collections import defaultdict

class MovieRentingSystem:

    def __init__(self, n: int, entries: List[List[int]]):
        self.n = n
        self.movies = defaultdict(list)
        self.rented = {}
        self.price_map = {}
        
        for shop, movie, price in entries:
            self.movies[movie].append((price, shop))
            self.price_map[(shop, movie)] = price
        
        for movie in self.movies:
            self.movies[movie].sort()

    def search(self, movie: int) -> List[int]:
        if movie not in self.movies:
            return []
        available_shops = [(price, shop) for price, shop in self.movies[movie] if (shop, movie) not in self.rented]
        return [shop for _, shop in sorted(available_shops)[:5]]

    def rent(self, shop: int, movie: int) -> None:
        price = self.price_map[(shop, movie)]
        self.rented[(shop, movie)] = price
        self.movies[movie] = [(p, s) for p, s in self.movies[movie] if s != shop]

    def drop(self, shop: int, movie: int) -> None:
        price = self.rented.pop((shop, movie))
        self.movies[movie].append((price, shop))
        self.movies[movie].sort()

    def report(self) -> List[List[int]]:
        rented_movies = [(price, shop, movie) for (shop, movie), price in self.rented.items()]
        rented_movies.sort()
        return [[shop, movie] for _, shop, movie in rented_movies[:5]]
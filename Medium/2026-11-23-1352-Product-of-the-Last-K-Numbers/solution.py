class ProductOfNumbers:

    def __init__(self):
        self.products = [1]
        self.zero_count = 0

    def add(self, num: int) -> None:
        if num == 0:
            self.products = [1]
            self.zero_count += 1
        else:
            self.products.append(self.products[-1] * num)

    def getProduct(self, k: int) -> int:
        if self.zero_count > 0:
            return 0
        return self.products[-1] // self.products[-1 - k]
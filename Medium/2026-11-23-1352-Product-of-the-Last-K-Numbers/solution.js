class ProductOfNumbers {
    constructor() {
        this.products = [1];
        this.zeroCount = 0;
    }

    add(num) {
        if (num === 0) {
            this.products = [1];
            this.zeroCount++;
        } else {
            this.products.push(this.products[this.products.length - 1] * num);
        }
    }

    getProduct(k) {
        if (this.zeroCount > 0) {
            return 0;
        }
        const n = this.products.length;
        return this.products[n - 1] / this.products[n - 1 - k];
    }
}
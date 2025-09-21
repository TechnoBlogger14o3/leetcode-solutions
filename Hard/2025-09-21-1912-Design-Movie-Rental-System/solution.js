class MovieRentingSystem {
    constructor(n, entries) {
        this.shops = new Array(n).fill(0).map(() => new Map());
        this.rentedMovies = [];
        this.rentedMap = new Map();

        for (const [shop, movie, price] of entries) {
            this.shops[shop].set(movie, price);
        }
    }

    search(movie) {
        const available = [];
        for (let shop = 0; shop < this.shops.length; shop++) {
            if (this.shops[shop].has(movie)) {
                available.push([shop, movie, this.shops[shop].get(movie)]);
            }
        }
        available.sort((a, b) => a[2] - b[2] || a[0] - b[0]);
        return available.slice(0, 5).map(([shop]) => shop);
    }

    rent(shop, movie) {
        const price = this.shops[shop].get(movie);
        this.shops[shop].delete(movie);
        this.rentedMovies.push([price, shop, movie]);
        this.rentedMap.set(`${shop}-${movie}`, price);
    }

    drop(shop, movie) {
        const price = this.rentedMap.get(`${shop}-${movie}`);
        this.rentedMap.delete(`${shop}-${movie}`);
        this.rentedMovies = this.rentedMovies.filter(([p, s, m]) => !(s === shop && m === movie));
        this.shops[shop].set(movie, price);
    }

    report() {
        const reportList = this.rentedMovies.slice();
        reportList.sort((a, b) => a[0] - b[0] || a[1] - b[1] || a[2] - b[2]);
        return reportList.slice(0, 5).map(([, shop, movie]) => [shop, movie]);
    }
}
class FoodRatings {
    constructor(foods, cuisines, ratings) {
        this.foodMap = new Map();
        this.cuisineMap = new Map();
        this.foods = foods;

        for (let i = 0; i < foods.length; i++) {
            this.foodMap.set(foods[i], { cuisine: cuisines[i], rating: ratings[i] });
            if (!this.cuisineMap.has(cuisines[i])) {
                this.cuisineMap.set(cuisines[i], []);
            }
            this.cuisineMap.get(cuisines[i]).push(foods[i]);
        }
    }

    changeRating(food, newRating) {
        const foodInfo = this.foodMap.get(food);
        const cuisine = foodInfo.cuisine;
        foodInfo.rating = newRating;
    }

    highestRated(cuisine) {
        const foodsInCuisine = this.cuisineMap.get(cuisine);
        let highestRatedFood = foodsInCuisine[0];
        let highestRating = this.foodMap.get(highestRatedFood).rating;

        for (const food of foodsInCuisine) {
            const rating = this.foodMap.get(food).rating;
            if (rating > highestRating || (rating === highestRating && food < highestRatedFood)) {
                highestRatedFood = food;
                highestRating = rating;
            }
        }
        return highestRatedFood;
    }
}
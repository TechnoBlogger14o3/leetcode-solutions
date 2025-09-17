import java.util.*;

class FoodRatings {
    private Map<String, Integer> foodRating;
    private Map<String, String> foodCuisine;
    private Map<String, TreeSet<String>> cuisineFoods;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodRating = new HashMap<>();
        foodCuisine = new HashMap<>();
        cuisineFoods = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            foodRating.put(foods[i], ratings[i]);
            foodCuisine.put(foods[i], cuisines[i]);
            cuisineFoods.putIfAbsent(cuisines[i], new TreeSet<>((a, b) -> {
                if (foodRating.get(a).equals(foodRating.get(b))) {
                    return a.compareTo(b);
                }
                return foodRating.get(b) - foodRating.get(a);
            }));
            cuisineFoods.get(cuisines[i]).add(foods[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodCuisine.get(food);
        TreeSet<String> foodsSet = cuisineFoods.get(cuisine);
        foodsSet.remove(food);
        foodRating.put(food, newRating);
        foodsSet.add(food);
    }

    public String highestRated(String cuisine) {
        return cuisineFoods.get(cuisine).first();
    }
}
import java.util.*;

class MovieRentingSystem {
    private final Map<Integer, PriorityQueue<int[]>> availableMovies;
    private final Map<Integer, Map<Integer, Integer>> rentedMovies;
    private final List<int[]> rentedList;

    public MovieRentingSystem(int n, int[][] entries) {
        availableMovies = new HashMap<>();
        rentedMovies = new HashMap<>();
        rentedList = new ArrayList<>();

        for (int[] entry : entries) {
            int shop = entry[0], movie = entry[1], price = entry[2];
            availableMovies.putIfAbsent(movie, new PriorityQueue<>((a, b) -> {
                if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
                return Integer.compare(a[0], b[0]);
            }));
            availableMovies.get(movie).offer(new int[]{shop, price});
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();
        if (!availableMovies.containsKey(movie)) return result;

        PriorityQueue<int[]> pq = availableMovies.get(movie);
        for (int i = 0; i < 5 && !pq.isEmpty(); i++) {
            result.add(pq.poll()[0]);
        }
        return result;
    }

    public void rent(int shop, int movie) {
        int price = 0;
        if (availableMovies.containsKey(movie)) {
            PriorityQueue<int[]> pq = availableMovies.get(movie);
            for (int[] entry : pq) {
                if (entry[0] == shop) {
                    price = entry[1];
                    pq.remove(entry);
                    break;
                }
            }
        }
        rentedMovies.putIfAbsent(movie, new HashMap<>());
        rentedMovies.get(movie).put(shop, price);
        rentedList.add(new int[]{shop, movie, price});
        rentedList.sort((a, b) -> {
            if (a[2] != b[2]) return Integer.compare(a[2], b[2]);
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
    }

    public void drop(int shop, int movie) {
        if (rentedMovies.containsKey(movie) && rentedMovies.get(movie).containsKey(shop)) {
            int price = rentedMovies.get(movie).remove(shop);
            availableMovies.putIfAbsent(movie, new PriorityQueue<>((a, b) -> {
                if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
                return Integer.compare(a[0], b[0]);
            }));
            availableMovies.get(movie).offer(new int[]{shop, price});
        }
    }

    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < Math.min(5, rentedList.size()); i++) {
            int[] entry = rentedList.get(i);
            result.add(Arrays.asList(entry[0], entry[1]));
        }
        return result;
    }
}
class ProductOfNumbers {
    private List<Integer> nums;
    private List<Integer> products;

    public ProductOfNumbers() {
        nums = new ArrayList<>();
        products = new ArrayList<>();
        products.add(1); // Initial product for empty case
    }

    public void add(int num) {
        nums.add(num);
        if (num == 0) {
            products.clear();
            products.add(1); // Reset products on zero
        } else {
            products.add(products.get(products.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        int size = products.size();
        if (k >= size) return 0; // Not enough numbers
        return products.get(size - 1) / products.get(size - 1 - k);
    }
}
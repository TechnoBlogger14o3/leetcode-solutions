class Fancy {
    private List<Long> sequence;
    private long add;
    private long mult;
    private static final long MOD = 1000000007;

    public Fancy() {
        sequence = new ArrayList<>();
        add = 0;
        mult = 1;
    }

    public void append(int val) {
        sequence.add((long) val - add);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        add = (add * m) % MOD;
        mult = (mult * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= sequence.size()) {
            return -1;
        }
        long value = (sequence.get(idx) * mult + add) % MOD;
        return (int) value;
    }
}
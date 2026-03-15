class Fancy {
    constructor() {
        this.sequence = [];
        this.add = 0;
        this.mul = 1;
    }

    append(val) {
        val = (val - this.add + 10**9 + 7) % (10**9 + 7);
        this.sequence.push((val * this.mul) % (10**9 + 7));
    }

    addAll(inc) {
        this.add = (this.add + inc) % (10**9 + 7);
    }

    multAll(m) {
        this.add = (this.add * m) % (10**9 + 7);
        this.mul = (this.mul * m) % (10**9 + 7);
    }

    getIndex(idx) {
        if (idx >= this.sequence.length) return -1;
        return (this.sequence[idx] + this.add) % (10**9 + 7);
    }
}
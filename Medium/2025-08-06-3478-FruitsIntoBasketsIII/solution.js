/**
 * @param {number[]} fruits
 * @param {number[]} baskets
 * @return {number}
 */
var numOfUnplacedFruits = function(fruits, baskets) {
    const sect_mx = [];
    const m = baskets.length;
    const a = Math.floor(Math.sqrt(m)); // size of one array

    let cnt = 0, mx = 0;
    for (let i = 0; i < m; i++) {
        if (cnt === a) {
            // creating sector of size a
            sect_mx.push(mx);
            mx = baskets[i];
            cnt = 1;
        } else {
            cnt++;
            mx = Math.max(mx, baskets[i]);
        }
    }

    // last sector
    sect_mx.push(mx);

    let remain = 0;

    // start allocating
    for (let i = 0; i < fruits.length; i++) {
        let k = 0, set = 1;

        for (let j = 0; j < m; j += a) {
            if (sect_mx[k] < fruits[i]) {
                // skip this segment
                k++;
                continue;
            }

            // find place to allocate
            for (let r = j; r < Math.min(j + a, m); r++) {
                if (baskets[r] >= fruits[i]) {
                    set = 0;
                    baskets[r] = 0;
                    break;
                }
            }

            // if fruit is allocated in a sector
            if (set === 0) {
                sect_mx[k] = 0; // find new mx
                // update new sector mx
                for (let r = j; r < Math.min(j + a, m); r++) {
                    sect_mx[k] = Math.max(baskets[r], sect_mx[k]);
                }
                break;
            }

            k++;
        }

        remain += set;
    }

    return remain;
}; 
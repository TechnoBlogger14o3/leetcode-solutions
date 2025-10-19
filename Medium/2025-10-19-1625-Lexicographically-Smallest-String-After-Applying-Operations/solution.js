var lexSmallestString = function(s, a, b) {
    const n = s.length;
    const seen = new Set();
    let minString = s;

    const add = (str) => {
        let arr = str.split('');
        for (let i = 1; i < n; i += 2) {
            arr[i] = (parseInt(arr[i]) + a) % 10;
        }
        return arr.join('');
    };

    const rotate = (str) => {
        return str.slice(-b) + str.slice(0, n - b);
    };

    const dfs = (str) => {
        if (seen.has(str)) return;
        seen.add(str);
        minString = minString < str ? minString : str;

        dfs(add(str));
        dfs(rotate(str));
    };

    dfs(s);
    return minString;
};
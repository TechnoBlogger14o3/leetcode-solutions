var braceExpansionII = function(expression) {
    const parse = (expr) => {
        const stack = [];
        let current = [];
        let i = 0;

        while (i < expr.length) {
            if (expr[i] === '{') {
                let j = i, braces = 0;
                while (i < expr.length) {
                    if (expr[i] === '{') braces++;
                    if (expr[i] === '}') braces--;
                    if (braces === 0) break;
                    i++;
                }
                current.push(parse(expr.slice(j + 1, i)));
            } else if (expr[i] === ',') {
                if (current.length) {
                    stack.push(current);
                    current = [];
                }
            } else {
                current.push(expr[i]);
            }
            i++;
        }
        if (current.length) stack.push(current);

        return stack.reduce((acc, curr) => {
            if (Array.isArray(curr)) {
                return acc.flatMap(a => curr.flatMap(b => typeof b === 'string' ? a + b : b));
            } else {
                return acc.concat(curr);
            }
        }, ['']).filter(Boolean);
    };

    const result = parse(expression);
    return Array.from(new Set(result)).sort();
};
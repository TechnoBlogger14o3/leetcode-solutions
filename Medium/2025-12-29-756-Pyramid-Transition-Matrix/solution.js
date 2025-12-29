var pyramidTransition = function(bottom, allowed) {
    const allowedMap = new Map();
    for (const pattern of allowed) {
        const [left, right, top] = pattern;
        if (!allowedMap.has(left + right)) {
            allowedMap.set(left + right, []);
        }
        allowedMap.get(left + right).push(top);
    }

    const canBuild = (currentRow) => {
        if (currentRow.length === 1) return true;
        const nextRow = [];
        for (let i = 0; i < currentRow.length - 1; i++) {
            const left = currentRow[i];
            const right = currentRow[i + 1];
            const key = left + right;
            if (!allowedMap.has(key)) return false;
            nextRow.push(allowedMap.get(key));
        }
        const buildNextRow = (index) => {
            if (index === nextRow.length) return canBuild(nextRow);
            for (const top of nextRow[index]) {
                if (buildNextRow(index + 1, top)) return true;
            }
            return false;
        };
        return buildNextRow(0);
    };

    return canBuild(bottom);
};
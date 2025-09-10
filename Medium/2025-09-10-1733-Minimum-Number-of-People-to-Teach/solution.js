var minimumTeachings = function(n, languages, friendships) {
    const m = languages.length;
    const langUsers = Array.from({ length: n + 1 }, () => new Set());
    
    for (let i = 0; i < m; i++) {
        for (const lang of languages[i]) {
            langUsers[lang].add(i + 1);
        }
    }
    
    const friends = friendships.map(([u, v]) => [u - 1, v - 1]);
    const needTeaching = new Set();
    
    for (const [u, v] of friends) {
        const uLangs = new Set(languages[u]);
        const vLangs = new Set(languages[v]);
        if (uLangs.size === 0 || vLangs.size === 0 || ![...uLangs].some(lang => vLangs.has(lang))) {
            needTeaching.add(u + 1);
            needTeaching.add(v + 1);
        }
    }
    
    if (needTeaching.size === 0) return 0;

    let minTeach = Infinity;

    for (let lang = 1; lang <= n; lang++) {
        const usersToTeach = [...needTeaching].filter(user => !languages[user - 1].includes(lang)).length;
        minTeach = Math.min(minTeach, usersToTeach);
    }

    return minTeach;
};
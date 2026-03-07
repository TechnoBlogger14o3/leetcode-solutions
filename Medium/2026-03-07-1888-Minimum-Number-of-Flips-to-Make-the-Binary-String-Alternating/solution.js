var minFlips = function(s) {
    const n = s.length;
    s += s; // Concatenate the string to handle rotations
    let count1 = 0, count2 = 0;

    for (let i = 0; i < n; i++) {
        // Expected characters for alternating patterns
        if (s[i] !== (i % 2 === 0 ? '0' : '1')) count1++;
        if (s[i] !== (i % 2 === 0 ? '1' : '0')) count2++;
    }

    let minFlips = Math.min(count1, count2);
    
    for (let i = n; i < s.length; i++) {
        // Slide the window
        if (s[i - n] !== (i - n % 2 === 0 ? '0' : '1')) count1--;
        if (s[i - n] !== (i - n % 2 === 0 ? '1' : '0')) count2--;
        
        if (s[i] !== (i % 2 === 0 ? '0' : '1')) count1++;
        if (s[i] !== (i % 2 === 0 ? '1' : '0')) count2++;
        
        minFlips = Math.min(minFlips, count1, count2);
    }

    return minFlips;
};
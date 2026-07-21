var maximizeActiveSections = function(s) {
    const n = s.length;
    let count = 0;
    
    // Count initial active sections
    for (let i = 0; i < n; i++) {
        if (s[i] === '1' && (i === 0 || s[i - 1] === '0')) {
            count++;
        }
    }
    
    let maxSections = count;
    
    // Augment the string with '1' at both ends
    const augmented = '1' + s + '1';
    const m = augmented.length;
    
    // Iterate through the augmented string
    for (let i = 1; i < m - 1; i++) {
        if (augmented[i] === '0' && augmented[i - 1] === '1' && augmented[i + 1] === '1') {
            let left = i - 1;
            let right = i + 1;
            
            // Expand to the left
            while (left > 0 && augmented[left] === '1') {
                left--;
            }
            // Expand to the right
            while (right < m - 1 && augmented[right] === '1') {
                right++;
            }
            
            // Calculate new sections
            const newSections = (count - 1) + (right - left - 1);
            maxSections = Math.max(maxSections, newSections);
        }
    }
    
    return maxSections;
};
var maximizePartitions = function(s, k) {
    const getMaxPartitions = (str, k) => {
        let count = 0;
        let left = 0;
        const charCount = new Map();

        for (let right = 0; right < str.length; right++) {
            charCount.set(str[right], (charCount.get(str[right]) || 0) + 1);

            while (charCount.size > k) {
                charCount.set(str[left], charCount.get(str[left]) - 1);
                if (charCount.get(str[left]) === 0) {
                    charCount.delete(str[left]);
                }
                left++;
            }
            count++;
        }
        return count;
    };

    const originalPartitions = getMaxPartitions(s, k);
    let maxPartitions = originalPartitions;

    for (let i = 0; i < s.length; i++) {
        const originalChar = s[i];
        for (let j = 0; j < 26; j++) {
            const newChar = String.fromCharCode('a'.charCodeAt(0) + j);
            if (newChar !== originalChar) {
                const modifiedString = s.slice(0, i) + newChar + s.slice(i + 1);
                maxPartitions = Math.max(maxPartitions, getMaxPartitions(modifiedString, k));
            }
        }
    }

    return maxPartitions;
};
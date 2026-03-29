var canBeEqual = function(s1, s2) {
    if (s1.length !== s2.length) return false;

    const count1 = Array(26).fill(0);
    const count2 = Array(26).fill(0);

    for (let i = 0; i < s1.length; i++) {
        count1[s1.charCodeAt(i) - 'a'.charCodeAt(0)]++;
        count2[s2.charCodeAt(i) - 'a'.charCodeAt(0)]++;
    }

    return (count1[0] === count2[0] && count1[1] === count2[1] && count1[2] === count2[2] && count1[3] === count2[3]) ||
           (count1[0] === count2[2] && count1[1] === count2[3] && count1[2] === count2[0] && count1[3] === count2[1]);
};
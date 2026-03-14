var getHappyString = function(n, k) {
    const happyStrings = [];
    
    function generate(current) {
        if (current.length === n) {
            happyStrings.push(current);
            return;
        }
        const lastChar = current[current.length - 1];
        for (const char of 'abc') {
            if (char !== lastChar) {
                generate(current + char);
            }
        }
    }
    
    generate('');
    
    return happyStrings.length >= k ? happyStrings[k - 1] : '';
};
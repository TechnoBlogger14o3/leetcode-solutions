var minAddToMakeValid = function(s) {
    let open = 0, close = 0;
    
    for (let char of s) {
        if (char === '(') {
            open++;
        } else {
            if (open > 0) {
                open--;
            } else {
                close++;
            }
        }
    }
    
    return open + close;
};
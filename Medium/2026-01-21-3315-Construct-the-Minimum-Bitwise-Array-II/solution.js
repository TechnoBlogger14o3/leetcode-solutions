function constructArray(nums) {
    const ans = [];
    
    for (const num of nums) {
        let found = false;
        for (let i = 0; i <= num; i++) {
            if ((i | (i + 1)) === num) {
                ans.push(i);
                found = true;
                break;
            }
        }
        if (!found) {
            ans.push(-1);
        }
    }
    
    return ans;
}
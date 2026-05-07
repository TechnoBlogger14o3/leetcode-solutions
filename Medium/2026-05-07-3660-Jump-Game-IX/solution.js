var maxJump = function(nums) {
    const n = nums.length;
    const ans = new Array(n).fill(0);
    const stack = [];

    for (let i = 0; i < n; i++) {
        while (stack.length && nums[stack[stack.length - 1]] < nums[i]) {
            ans[stack.pop()] = Math.max(ans[stack[stack.length - 1]] || 0, nums[i]);
        }
        stack.push(i);
    }

    stack.length = 0; // Clear the stack for the next pass

    for (let i = n - 1; i >= 0; i--) {
        while (stack.length && nums[stack[stack.length - 1]] > nums[i]) {
            ans[stack.pop()] = Math.max(ans[stack[stack.length - 1]] || 0, nums[i]);
        }
        stack.push(i);
    }

    for (let i = 0; i < n; i++) {
        ans[i] = Math.max(ans[i], nums[i]);
    }

    return ans;
};
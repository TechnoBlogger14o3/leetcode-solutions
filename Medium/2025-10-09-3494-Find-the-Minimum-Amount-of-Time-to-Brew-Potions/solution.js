class Solution {
    minTimeToBrew(skill, mana) {
        const n = skill.length;
        const m = mana.length;
        let totalTime = 0;
        let potionStartTime = Array(m).fill(0);
        
        for (let j = 0; j < m; j++) {
            for (let i = 0; i < n; i++) {
                const brewTime = skill[i] * mana[j];
                if (i === 0) {
                    potionStartTime[j] = totalTime + brewTime;
                } else {
                    potionStartTime[j] = Math.max(potionStartTime[j], totalTime) + brewTime;
                }
                totalTime = potionStartTime[j];
            }
        }
        
        return totalTime;
    }
}
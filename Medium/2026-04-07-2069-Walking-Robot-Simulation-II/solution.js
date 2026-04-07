class Robot {
    constructor(width, height) {
        this.width = width;
        this.height = height;
        this.x = 0;
        this.y = 0;
        this.directions = ['East', 'North', 'West', 'South'];
        this.currentDir = 0; // 0: East, 1: North, 2: West, 3: South
    }

    step(num) {
        for (let i = 0; i < num; i++) {
            let nextX = this.x;
            let nextY = this.y;

            if (this.currentDir === 0) nextX++; // East
            else if (this.currentDir === 1) nextY++; // North
            else if (this.currentDir === 2) nextX--; // West
            else if (this.currentDir === 3) nextY--; // South

            if (nextX < 0 || nextX >= this.width || nextY < 0 || nextY >= this.height) {
                this.currentDir = (this.currentDir + 1) % 4; // Turn counterclockwise
            } else {
                this.x = nextX;
                this.y = nextY;
            }
        }
    }

    getPos() {
        return [this.x, this.y];
    }

    getDir() {
        return this.directions[this.currentDir];
    }
}
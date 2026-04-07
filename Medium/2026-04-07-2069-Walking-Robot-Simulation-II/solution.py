class Robot:
    def __init__(self, width: int, height: int):
        self.width = width
        self.height = height
        self.x = 0
        self.y = 0
        self.directions = ["East", "North", "West", "South"]
        self.direction_index = 0  # Initially facing East

    def step(self, num: int) -> None:
        for _ in range(num):
            if self.direction_index == 0:  # East
                if self.x + 1 < self.width:
                    self.x += 1
                else:
                    self.direction_index = 1  # Turn North
            elif self.direction_index == 1:  # North
                if self.y + 1 < self.height:
                    self.y += 1
                else:
                    self.direction_index = 2  # Turn West
            elif self.direction_index == 2:  # West
                if self.x - 1 >= 0:
                    self.x -= 1
                else:
                    self.direction_index = 3  # Turn South
            elif self.direction_index == 3:  # South
                if self.y - 1 >= 0:
                    self.y -= 1
                else:
                    self.direction_index = 0  # Turn East

    def getPos(self) -> list[int]:
        return [self.x, self.y]

    def getDir(self) -> str:
        return self.directions[self.direction_index]
class BrowserHistory:

    #
    # Solution v1: Brute Force
    #
    # Runtime: 225 ms @ (beats) 75.17%
    # Memory Usage: 16.6 MB @ (beats) 85.99%
    #
    # def __init__(self, homepage: str):
    #     self.history = [homepage]
    #     self. curr = 0
    #
    # def visit(self, url: str) -> None:
    #     self.history = self.history[:self.curr + 1]
    #     self.history.append(url)
    #     self.curr = len(self.history) - 1
    #
    # def back(self, steps: int) -> str:
    #     self.curr -= steps
    #     if self.curr < 0:
    #         self.curr = 0
    #
    #     return self.history[self.curr]
    #
    # def forward(self, steps: int) -> str:
    #     self.curr += steps
    #     if self.curr >= len(self.history):
    #         self.curr = len(self.history) - 1
    #
    #     return self.history[self.curr]

    #
    # Solution v1.1: Brute Force
    # Improvement
    #
    # Runtime: 205 ms @ (beats) 98.55%
    # Memory Usage: 16.8 MB @ (beats) 37.33%
    #
    def __init__(self, homepage: str):
        self.history = [homepage]
        self.curr = 1

    def visit(self, url: str) -> None:
        self.history = self.history[:self.curr]
        self.history.append(url)
        self.curr = len(self.history)

    def back(self, steps: int) -> str:
        self.curr = max(1, self.curr - steps)
        return self.history[self.curr - 1]

    def forward(self, steps: int) -> str:
        self.curr = min(len(self.history), self.curr + steps)
        return self.history[self.curr - 1]

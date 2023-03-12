import random
from typing import Optional

from Python.auxiliary.ListNode import ListNode


class Solution:

    def __init__(self, head: Optional[ListNode]):
        #
        # Solution v1: Brute Force
        #
        # Runtime: 340 ms @ (beats) 5.2%
        # Memory Usage: 17.1 MB @ (beats) 97.21%
        #
        self.vals = []

        while head:
            self.vals.append(head.val)
            head = head.next

        #
        # Solution v1.1: Performance improvement
        #
        #
        # Runtime: 69 ms @ (beats) 85.87%
        # Memory Usage: 17.6 MB @ (beats) 6.13%
        #
        # self.n = len(self.vals) - 1

    def getRandom(self) -> int:
        #
        # Solution v1: Brute Force
        #
        # rand = random.Random()
        # return self.vals[rand.randint(0, self.n)]

        #
        # Solution v1.1: Performance improvement
        #
        pos = int(random.random() * len(self.vals))
        return self.vals[pos]

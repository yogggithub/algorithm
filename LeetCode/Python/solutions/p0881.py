from typing import List


class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        #
        # Solution v1: Brute Force
        #
        # Runtime: 466 ms @ (beats) 55.29%
        # Memory Usage: 20.8 MB @ (beats) 60.46%
        #
        ans = 0

        people.sort()

        i = 0
        j = len(people) - 1

        # most two people on a boat
        while i <= j:
            if people[i] + people[j] <= limit:
                i += 1
            j -= 1
            ans += 1

        return ans


if __name__ == "__main__":
    solution = Solution()

    people = [1, 2]
    limit = 3
    print(f"return: {solution.numRescueBoats(people, limit)}")  # 1

    people = [3, 2, 2, 1]
    limit = 3
    print(f"return: {solution.numRescueBoats(people, limit)}")  # 3

    people = [3, 5, 3, 4]
    limit = 5
    print(f"return: {solution.numRescueBoats(people, limit)}")  # 4

    people = [2, 49, 10, 7, 11, 41, 47, 2, 22, 6, 13, 12, 33, 18, 10, 26, 2, 6, 50, 10]
    limit = 50
    print(f"return: {solution.numRescueBoats(people, limit)}")  # 11

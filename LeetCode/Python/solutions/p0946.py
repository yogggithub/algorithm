from typing import List


class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        #
        # Solution v1: Brute Force
        #
        # Runtime: 81 ms @ (beats) 16.53%
        # Memory Usage: 14.2 MB @ (beats) 34.32%
        #
        # stack = []
        # l = len(pushed)
        # i = 0
        # j = 0
        # while i < l or j < l:
        #     if stack and stack[-1] == popped[j]:
        #         stack.pop()
        #         j += 1
        #
        #         if j == l:
        #             break
        #         continue
        #
        #     if i < l:
        #         stack.append(pushed[i])
        #         i += 1
        #     else:
        #         return False
        #
        # return not stack

        #
        # Solution v1.1: Brute Force
        # Simplify
        #
        # Runtime: 76 ms @ (beats) 42.9%
        # Memory Usage: 14.1 MB @ (beats) 85.17%
        #
        # stack = []
        # i = 0
        # l = len(popped)
        # for p in pushed:
        #     stack.append(p)
        #     while stack and i < l and stack[-1] == popped[i]:
        #         stack.pop()
        #         i += 1
        # return i == l

        #
        # Solution v1.5: Brute Force
        # Performance Improvement
        #
        # Runtime: 74 ms @ (beats) 54.80%
        # Memory Usage: 14.1 MB @ (beats) 85.17%
        #
        stack = []
        i = 0

        for p in pushed:
            while stack and stack[-1] == popped[i]:
                stack.pop()
                i += 1
            stack.append(p)

        while stack and stack[-1] == popped[i]:
            stack.pop()
            i += 1

        return len(stack) == 0


if __name__ == "__main__":
    solution = Solution()

    pushed = [1, 2, 3, 4, 5]
    popped = [4, 5, 3, 2, 1]
    print(f"return: {solution.validateStackSequences(pushed, popped)}")  # True

    pushed = [1, 2, 3, 4, 5]
    popped = [4, 5, 3, 1, 2]
    print(f"return: {solution.validateStackSequences(pushed, popped)}")  # False

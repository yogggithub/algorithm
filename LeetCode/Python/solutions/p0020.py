class Solution:
    def isValid(self, s: str) -> bool:
        #
        # Solution v1: Brute Force
        #
        # Runtime: 47 ms @ (beats) 18.11%
        # Memory Usage: 14.2 MB @ (beats) 87.35%
        #
        left = []
        for i in range(len(s)):
            if s[i] in {"(", "{", "["}:
                left += s[i]
            elif len(left) == 0:
                return False
            else:
                if s[i] == ")" and left.pop() != "(":
                    return False
                elif s[i] == "}" and left.pop() != "{":
                    return False
                elif s[i] == "]" and left.pop() != "[":
                    return False

        return len(left) == 0

#
# (learn from Internet)
# Solution v3: Newton
#
def isValid(self, s: str) -> bool:
    stack = []
    dict = {']': '[', '}': '{', ')': '('}
    for char in s:
        if char in dict.values():
            stack.append(char)
        elif char in dict.keys():
            if stack == []:
                return False
            elif dict[char] != stack.pop():
                return False
        else:
            return False
    if stack == []:
        return True

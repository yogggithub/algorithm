from sys import flags


class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        """
        All letters in this word are capitals, like "USA".
        All letters in this word are not capitals, like "leetcode".
        Only the first letter in this word is capital, like "Google".
        """
        flag = True
        for i in range(len(word)):
            val = ord(word[i])
            if i == 0:
                if val > 90:
                    flag = False
            elif i == 1:
                if flag and val > 90:
                    flag = False
                elif not flag and val <= 90:
                    return False
            else:
                if flag and val > 90:
                    return False
                elif not flag and val <= 90:
                    return False

        return True

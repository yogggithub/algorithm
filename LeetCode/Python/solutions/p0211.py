import re


class WordDictionary:

    #
    # Solution v1: p208 Trie data structure
    #
    # Runtime: 12431 ms @ (beats) 17.15%
    # Memory Usage: 84 MB @ (beats) 5.71%
    #
    def __init__(self):
        self.dictionary = [None] * 26
        self.is_completed = False

    def addWord(self, word: str) -> None:
        node = self
        for c in word:
            i = ord(c) - ord("a")
            if not node.dictionary[i]:
                node.dictionary[i] = WordDictionary()
            node = node.dictionary[i]

        node.is_completed = True

    def search(self, word: str) -> bool:
        node = self
        i = 0
        while i < len(word):
            c = word[i]
            if c == ".":
                for child in node.dictionary:
                    if child and child.search(word[i + 1:]):
                        return True
                return False

            j = ord(word[i]) - ord("a")
            if node.dictionary[j]:
                node = node.dictionary[j]
                i += 1
            else:
                return False

        return node and node.is_completed

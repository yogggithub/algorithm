#
# Solution v1: Brute Force
#
# Runtime: 180 ms @ (beats) 57.25%
# Memory Usage: 31.5 MB @ (beats) 74.7%
#
# class TrieNode:
#     def __init__(self):
#         self.children = {}
#         self.is_end = False
#
#
# class Trie:
#
#     def __init__(self):
#         self.root = TrieNode()
#
#     def insert(self, word: str) -> None:
#         node = self.root
#         for c in word:
#             if c not in node.children:
#                 node.children[c] = TrieNode()
#             node = node.children[c]
#
#         node.is_end = True
#
#     def search(self, word: str) -> bool:
#         node = self.root
#         i = 0
#         while i < len(word):
#             if word[i] in node.children.keys():
#                 node = node.children[word[i]]
#                 i += 1
#             else:
#                 return False
#
#         return node.is_end
#
#     def startsWith(self, prefix: str) -> bool:
#         node = self.root
#         i = 0
#         while i < len(prefix):
#             if prefix[i] in node.children.keys():
#                 node = node.children[prefix[i]]
#                 i += 1
#             else:
#                 return False
#
#         return True

#
# Solution v1.1: Brute Force
# Simplify the object structure
#
# Runtime: 127 ms @ (beats) 93.71%
# Memory Usage: 27.5 MB @ (beats) 92.85%
#
class Trie:

    def __init__(self):
        self.root = {}

    def insert(self, word: str) -> None:
        node = self.root
        for c in word:
            if c not in node:
                node[c] = {}
            node = node[c]

        node["*"] = ""

    def search(self, word: str) -> bool:
        node = self.root
        i = 0
        while i < len(word):
            c = word[i]
            if c in node:
                node = node[c]
                i += 1
            else:
                return False

        return "*" in node

    def startsWith(self, prefix: str) -> bool:
        node = self.root
        for p in prefix:
            if p in node:
                node = node[p]
            else:
                return False

        return True


if __name__ == "__main__":
    trie = Trie()
    print(f"insert apple: {trie.insert('apple')}")  # None
    print(f"search apple: {trie.search('apple')}")  # True
    print(f"search app: {trie.search('app')}")  # False
    print(f"startsWith app: {trie.startsWith('app')}")  # Ture
    print(f"insert app: {trie.insert('app')}")  # None
    print(f"search app: {trie.search('app')}")  # True

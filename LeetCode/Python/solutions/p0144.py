from typing import Optional, List

from Python.auxiliary.TreeNode import TreeNode


class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        #
        # Solution v1: iterative
        #
        # Runtime: 27 ms @ (beats) 95.77%
        # Memory Usage: 13.9 MB @ (beats) 12.22%
        #
        if not root:
            return []
        elif not root.left and not root.right:
            return [root.val]
        else:
            ans = []
            stack = [root]
            while stack:
                temp = stack.pop()
                ans.append(temp.val)
                if temp.right:
                    stack.append(temp.right)
                if temp.left:
                    stack.append(temp.left)
            return ans

        #
        # Solution v2: recursive
        #
        # Runtime: 32 ms @ (beats) 84.58%
        # Memory Usage: 14.1 MB @ (beats) 12.22%
        #
        def dfs(root):
            if root:
                ans.append(root.val)
                dfs(root.left, ans)
                dfs(root.right, ans)
        ans = []
        dfs(root, ans)
        return ans



if __name__ == "__main__":
    solution = Solution()

    root = [1, None, 2, 3]
    print(f"return: {solution.preorderTraversal(root)}")

    root = []
    print(f"return: {solution.preorderTraversal(root)}")

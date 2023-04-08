from Python.auxiliary.Node import Node


class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':

        if not node:
            return None

        if not node.neighbors:
            return Node(node.val)

        ans = {node: Node(node.val)}
        q = [node]
        while q:
            curr = q.pop()

            for n in curr.neighbors:
                if n not in ans:
                    ans[n] = Node(n.val)
                    q.append(n)
                ans[curr].neighbors.append(ans[n])

        return ans[node]

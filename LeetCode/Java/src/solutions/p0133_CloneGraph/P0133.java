package solutions.p0133_CloneGraph;

import auxiliary.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P0133 {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> ans = new HashMap<>();
        ans.put(node, new Node(node.val));

        Stack<Node> stack = new Stack<>();
        stack.add(node);
        while (!stack.empty()) {
            Node curr = stack.pop();

            for (Node n : curr.neighbors) {
                if (ans.get(n) == null) {
                    ans.put(n, new Node(n.val));
                    stack.add(n);
                }
                ans.get(curr).neighbors.add(ans.get(n));
            }
        }
        return ans.get(node);
    }
}

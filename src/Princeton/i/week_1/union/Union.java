package Princeton.i.week_1.union;

public class Union {
    public static void main(String[] args) {
        QuickFind quickFind = new QuickFind(10);
        quickFind.union(4, 3);
        quickFind.union(3, 8);
        quickFind.union(6, 5);
        quickFind.union(9, 4);
        quickFind.union(2, 1);
        System.out.println(">>>Quick Find<<<");
        System.out.println(
                quickFind.connected(8, 9)); // true
        System.out.println(
                quickFind.connected(5, 4)); // false

        QuickUnion quickUnion = new QuickUnion(10);
        quickUnion.union(4, 3);
        quickUnion.union(3, 8);
        quickUnion.union(6, 5);
        quickUnion.union(9, 4);
        quickUnion.union(2, 1);
        System.out.println(">>>Quick Union<<<");
        System.out.println(
                quickUnion.connected(8, 9)); // true
        System.out.println(
                quickUnion.connected(5, 4)); // false
    }

}

class Node {
    /**
     * a simple implementation of dynamic connectivity
     * use array as the data structure,
     * so, assume array index represent the union,
     * and the element keeps the id of each union.
     * <p>
     * different algorithm mainly change the union methodology
     */

    int[] id;

    /**
     * constructure that initialize an array,
     * and set each element equals to its index
     *
     * @param n the size of the union objects
     */
    public Node(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }
}

/**
 * Quick Find
 * array will store the same id for elements in one connected component
 * <p>
 * so, we say, the unions are connected when they have the same id
 * i.e. array[p] == array[q]
 * <p>
 * to achieve this, need to change up to N element when we link unions
 */
class QuickFind extends Node {
    public QuickFind(int n) {
        super(n);
    }

    /**
     * check whether two unions are connect to each other
     * return true if they have the same id (value)
     *
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    /**
     * connect two union
     * make the id of first union equals the id of second union
     * <p>
     * additionally, iterate through the array,
     * do the same change to all ids which equal to the first union's id.
     *
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int pId = id[p];
        int qId = id[q];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
    }
}

/**
 * Quick Union
 * organize the component like tree
 * array will store the root union for elements
 * <p>
 * so, we say, the unions are connected when they have the same root
 * to achieve this, need to find the top root of the union
 * <p>
 * relatively, link union become more simple, only need to change one union
 */
class QuickUnion extends Node {
    public QuickUnion(int n) {
        super(n);
    }

    /**
     * need to find and compare top root of both union
     *
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q) {
        while (id[p] != p) {
            p = id[p];
        }
        while (id[q] != q) {
            q = id[q];
        }
        return p == q;
    }

    /**
     * link two union
     * only change value of pth element to q
     * that means p's root is q
     *
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        id[p] = q;
    }
}

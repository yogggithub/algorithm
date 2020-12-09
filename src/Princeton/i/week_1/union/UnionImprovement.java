package Princeton.i.week_1.union;

public class UnionImprovement {
    public static void main(String[] args) {

        WeightedQuickUnion quickUnion = new WeightedQuickUnion(10);
        quickUnion.union(4, 3);
        quickUnion.union(3, 8);
        quickUnion.union(6, 5);
        quickUnion.union(9, 4);
        quickUnion.union(2, 1);
        System.out.println(">>>Weighted Quick Union<<<");
        System.out.println(
                quickUnion.connected(8, 9)); // true
        System.out.println(
                quickUnion.connected(5, 4)); // false
        PathQuickUnion pathQuickUnion = new PathQuickUnion(10);
        pathQuickUnion.union(4, 3);
        pathQuickUnion.union(3, 8);
        pathQuickUnion.union(6, 5);
        pathQuickUnion.union(9, 4);
        pathQuickUnion.union(2, 1);
        System.out.println(">>>Path Quick Union<<<");
        System.out.println(
                pathQuickUnion.connected(8, 9)); // true
        System.out.println(
                pathQuickUnion.connected(5, 4)); // false
    }
}

class NodeImprovement {

    int[] id;

    // weighted quick union
    // store the depth of tree
    int[] size;

    public NodeImprovement(int n) {
        id = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            // original size of all element is 1
            size[i] = 1;
        }
    }
}


/**
 *
 */
class WeightedQuickUnion extends NodeImprovement {
    public WeightedQuickUnion(int n) {
        super(n);
    }

    /**
     * find the top root of one union
     * top root is id[i] = i
     *
     * @param i
     * @return
     */
    public int root(int i) {
        while (id[i] != i) {
            i = id[i];
        }
        return i;
    }

    /**
     * need to find and compare top root of both union
     *
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    /**
     * link two union
     * following teacher's code, set value to q's root
     *
     * @param p
     * @param q
     */

    public void union(int p, int q) {
        /*
         improvement:
         always put a small tree as child to a tall tree
         use an size[] array to store the depth of the tree

         when link unions, update the size array
         */
        int i = root(p);
        int j = root(q);
        if (i == j) {
            return;
        }
        if (size[i] < size[j]) {
            // link small tree to tall tree
            id[i] = j;
            // but, the size calculation is wired
            // i think there is no need to increase the size of tall tree
            size[j] += size[i];
        } else {
            id[j] = i;
            size[i] += size[j];
        }

        // original quick union, set root
        // id[p] = root(q);
    }
}

class PathQuickUnion extends WeightedQuickUnion {
    public PathQuickUnion(int n) {
        super(n);
    }

    /**
     * flatten the tree
     * <p>
     * only need to add one line
     * when find the top root of a union
     * change the root of all the unions through the path to the grandparent
     *
     * @param i
     * @return
     */
    @Override
    public int root(int i) {
        while (id[i] != i) {
            // only need to add this line
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
}

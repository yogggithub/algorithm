# Algorithm Learning
[中文说明文档](https://github.com/yogggithub/algorithm/blob/master/README_ZH_CN.md)在这里

## Catalog
- [Princeton Algorithm Course](#princetonalgorithmcourse)
  1. [Part I](#parti)
  2. [Part II](#partii) 
- [LeetCode Solutions](#leetCodesolution)


## Princeton Algorithm Course
Self-learning [Princeton Algorithms](https://www.coursera.org/learn/algorithms-part1/home/welcome) course

Here are some hints for weekly assignments
Maybe I would write down some ideas for weekly interview questions in the future.

### Part I

#### Week 1

### Assignment: Percolation
My score is 89

1. use a two two-dimensional boolean arrays represent the open status, and use other one dimensional array store the id of the node. Then following the idea that learned from the lecture to justify whether nodes are connected or not. When top row and bottom row are connected to each other, we say the grid is percolated.
2. use two virtual points to simple the problem: beginning/top and end/bottom point.
3. link all row 1 to the begin point, and link row n to the end point.
4. If the two virtual points are in one set, the grid is percolated.


#### Week 2

##### Assignment：Deques and Randomized Queues
My score is 88

1. Very simple, can either implement by array or doubly linked list
   > it's better to use array for RandomizedQueue. If use doubly linked list, be careful for null pointer exception


#### Week 3

##### Assignment: Collinear Points
My score is 81

1. repeat items are not important
2. carefully when trying the quick method, because sort would change the array forever
3. store the line segment after comparing the beginning and ending points, that would help to reduce repeat items and avoid partial segments


#### Week 4

##### Assignment: 8 Puzzle
My score is 88

1. Main method is using MinPQ, deal with the node which has the lowest priority each time.
2. According to the introduction, need to create an inner class to represent every node in the priority queue which could store related information, including previous node, move count so far, priority, and whether the node is a twin or original. And the compareTo() of the inner class is based on priority of the nodes.
   > lowest priority means the board of this node needs the lesst steps to the goal.
3. Board::manhattan(): pay attention to the index, there is no leading 0.
4. A* algorithm is quite simple, find and add all the neighbors of the 0 into PQ, then delete the minimum priority node. If the node is the goal, add it as well as all its previous nodes to the solution. If not, repeat the process.


#### Week 5

##### Assignment: Kd-Trees
My score is 86
1. relatively simple
2. PointSET.class only needs to use the provided SET data type to save points, and then call the corresponding methods of Point2D.class to complete the API one by one.
3. KdTree.class can refer to BinarySeachTree, create an inner class named TreeNode, and save and find nodes according to BST.
   > My TreeNode inner class should have a lot of room for optimization, I just use BST directly, not carefully optimize the code


### Part II

#### Week 1

### Assignment: WordNet
My score is 98

1. wordNet.class
   > 1. isRooted(): each node needs to have out edge, otherwise it is not rooted
   > 2. hasCycle(): call DirectedCycle::hasCycle() in the course API
2. SAP.class
   > 1. Whether int or Iterable, you can directly call the BreadthFirstDirectedPaths constructor in the course API
   > 2. Whether length() or ancestor(), the idea is to find the shortest route.
   > 3. Not sure why it fails Test 17: check length() and ancestor() with zero-length iterable arguments

#### Week 2

### Assignment: Seam Carving
My score is 99

1. The processing of fixed-value boundaries is tedious and requires careful handling.
1. To find the set of points with the lowest energy, I need to traverse the whole image and calculate the energy. I create two arrays: distTo to save the nearest distance and edgeTo to save the corresponding "parent node". After traversing the whole image, we find the minimum value of distTo in the last row/column, which is the tail element of the desired seam, and trace edgeTo to get the seam node.
1. The handling of energy after seam deletion is a difficult point, which requires careful consideration of which points of energy can be reused and which need to be recalculated after each column or row of seam is removed.


## LeetCode Solutions

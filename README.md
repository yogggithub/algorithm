# Princeton Algorithm
Self-learning Princeton [Algorithms](https://www.coursera.org/learn/algorithms-part1/home/welcome) course

Here are some hints for weekly assignments
Maybe I would write down some ideas for weekly interview questions in the future.

# Part I

## Week 1

### Assignment: Percolation
My score is 89

1. use a two two-dimensional boolean arrays represent the open status, and use other one dimensional array store the id of the node. Then following the idea that learned from the lecture to justify whether nodes are connected or not. When top row and bottom row are connected to each other, we say the grid is percolated.
2. use two virtual points to simple the problem: beginning/top and end/bottom point.
3. link all row 1 to the begin point, and link row n to the end point.
4. If the two virtual points are in one set, the grid is percolated.

## Week 2

### Assignment：Deques and Randomized Queues
My score is 89

1. Very simple, can either implement by array or doubly linked list
2. it's better to use array for RandomizedQueue. If use doubly linked list, be careful for null pointer exception
3. it's hard to make RandomizedQueue be random sequence when using doubly linked list
   I consider one way, is user cycling doubly linked list. but compare to arrays, it's much more complicate, not worth it.
4. the third class just simple read from Scanner, and ouput random k times.

## Week 3

### Assignment: Collinear Points
My score is 81.

1. repeat items are not important
2. carefully when trying the quick method, because sort would change the array forever
3. store the line segment after comparing the beginning and ending points, that would help to reduce repeat items and avoid partial segments

## Week 4

### Assignment: 8 Puzzle
My score is 88.

1. Main method is using MinPQ, deal with the node which has the lowest priority each time.
3. Board::manhattan(): pay attention to the index, there is no leading 0.
2. According to the introduction, need to create an inner class to represent every node in the priority queue which could store related information, including previous node, move count so far, priority, and whether the node is a twin or original. And the compareTo() of the inner class is based on priority of the nodes.
4. A* algorithm is quite simple, find and add all the neighbors of the 0 into PQ, then delete the minimum priority node. If the node is the goal, add it as well as all its previous nodes to the solution. If not, repeat the process.

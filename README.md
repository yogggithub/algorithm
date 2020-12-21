# algorithm
Self-learning Princeton [Algorithms](https://www.coursera.org/learn/algorithms-part1/home/welcome) course

Here are some hints for weekly assignments
Maybe I would write down some ideas for weekly interview questions in the future.

# Part I

## Week 1

## Week 2

## Week 3

## Week 4
My score is 88.

1. Main method is using MinPQ, deal with the node which has the lowest priority each time.
3. Board::manhattan(): pay attention to the index, there is no leading 0.
2. According to the introduction, need to create an inner class to represent every node in the priority queue which could store related information, including previous node, move count so far, priority, and whether the node is a twin or original. And the compareTo() of the inner class is based on priority of the nodes.
4. A* algorithm is quite simple, find and add all the neighbors of the 0 into PQ, then delete the minimum priority node. If the node is the goal, add it as well as all its previous nodes to the solution. If not, repeat the process.

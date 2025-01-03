# 算法自学

本人水平有限，欢迎大家交流

Here is the [ReadMe](https://github.com/yogggithub/algorithm/blob/master/README.md) in English.

## 目录
- 
- <a href="#princetonalgorithmcourse">普林斯顿算法课程</a>
  1. <a href="#parti">第一部分</a>
  2. <a href="#partii">第二部分</a>
- <a href="#leetCodesolution">LeetCode Solutions</a>

## <a id="princetonalgorithmcourse">普林斯顿算法课程</a>
这个项目是自学[普林斯顿算法](https://www.coursera.org/learn/algorithms-part1/home/welcome)课程中的一些想法。


### <a id="parti">第一部分</a>

#### 第1周

##### 作业: Percolation
成绩：89

1. 使用二维boolean数组存放状态，使用一维int数组存放ID，然后按照课程讲解的连接判断方法，判断节点是否联通。
2. 建议创建2个虚拟节点（开始和结束），来简化联通判断。
    > 将第一行与开始节点链接，将第n行与结束节点链接。当开始和结束两个节点联通时，就是已穿透

#### 第2周

##### 作业：Deques and Randomized Queues
成绩：88

1. 本周非常简单，使用链表或者数组都可以，各有简单的地方
   > 最简化是Deque用链表，Randomized用数组

#### 第3周

##### 左右额: Collinear Points
成绩：81

1. 重复的LineSegment不重要，重要的是线段要完整
2. 快速方法实现时，要先复制一份，因为排序会改变数组
3. 保存LineSegment之前，先把首尾排序区分出来，会一定程度上避免重复


#### 第4周

##### 作业: 8 Puzzle
成绩：88

1. 整体思路：利用MinPQ，每次处理优先级最低的点
2. 根据作业要求，必须要创建一个内部类，用此类对象来代表PQ中的节点，并保存相关信息，包括前一个节点、已移动次数、优先级、是否twin节点等。该内部类的compareTo()基于优先级
3. Board::manhattan()方法，要注意索引。因为第一个点不是0，所有索引都要 -1。
4. A* 思路较直线，就是从0开始，把每种移动结果都添加到PQ中，然后从最低优先级的节点开始处理。如果节点已完成，则将此节点和所有前序节点都放到solution中，否则继续移动。


#### 第5周

##### 作业: Kd-Trees
成绩：86
1. 相对简单
2. PointSET只需要使用提供的SET保存point，然后调用Point2D的相应方法，逐个将API补完即可。
3. KdTree可以参考BinarySeachTree，创建TreeNode内部类，按照BST思路来保存、查找节点
   > 我的TreeNode内部类应该还有很大的优化空间，我只是直接拿来BST，并没有仔细优化代码
   
   
### <a id="partii">第二部分</a>

#### 第1周

##### 作业: WordNet
成绩：98
1. wordNet.class
   > isRooted()：每个word都需要有连线，否则就不是rooted
   > hasCycle()：调用课程API中的DirectedCycle::hasCycle()
2. SAP.class
   > 不管是int还是Iterable，都可以直接调用课程API中的BreadthFirstDirectedPaths构造方法
   > 无论length()还是ancestor()，其思路都是找到最短的路线。
   > 不知道为什么未能通过 Test 17: check length() and ancestor() with zero-length iterable arguments

#### 第2周

##### 作业：Seam Carving
成绩：99

1. 对于固定值边界的处理比较繁琐，需要仔细处理。
1. 要找到能量最小的点的集合，需要对整个图像遍历并计算energy，我创建两个数组：distTo保存最近距离，edgeTo保存对应的“父节点”。遍历全图后在最后一行 / 列找到distTo的最小值即为所求seam的尾元素，追踪edgeTo获得seam节点。
1. seam删除后的energy处理是一个难点，需要认真考虑每移除一列或一行seam后，哪些点的energy可以复用，而哪些需要重新计算

#### 第3周

##### 作业：Baseball Elimination
成绩：97

1. 建议直接使用课程内置的包（FlowEdge，FlowNetwork和FordFulkerson）
2. 在建立每只队伍的Edge时，可以简单使用计数器来代表不同的比赛
3. 难点在于想清楚如何建立FlowNetwork


## <a id="leetCodesolution">LeetCode刷题</a>



# CritcalPathSPE

The solution we made doesn’t have the most elegant algorithm, but it still solves the problem for this assignment. It calculates earliest- and latest start/finish, critical path and total float, for the graph.

We first calculated the earliest start and finish values, since they are need in order to calculate “latest” values together with the total float. 

We started at our “start” node, which in this case was node “A”. Node A have a duration of ten, which makes the activity at that node last from zero/one to ten. Then we can calculate any other nodes earliest start and finish values, by adding node A’s earliest finish values to the duration of the next node. If we look at the picture we can see, that the ten from node A multiplied with B’s duration gives us B earliest finish value of thirty. This is done to all nodes to you reach the end node E. The only case where this doesn’t hold, is when two competing node point to the same child node, in that case you take the highest value from the parent pointing to the child.

When we have the earliest start and finish values for all nodes, we can then backtrack from our end node E. We know what to put into E, since it is the end node and therefor have the same earliest and latest values. We then do the opposite of before by subtracting latest finish with the duration and gets the latest start value. That value is then transferred to the latest finish of the node pointing to it. The only case where this doesn’t hold either, is when the parent node points at 1 or more nodes then  we pick the lowest value. See picture below.

![asd](https://github.com/Flazhed/CritcalPathSPE/blob/master/asd.png)


The critical path is calculated by looking at the earliest- and latest finish values, if subtracted gives the values 0 we know that this node/activity is on the critical path. BECOS? .. 

The TotalFloat is the amount of time the activity can be postponed. It is calculated by subtracting latest finish value with earliest finish values and gives us the total float/slack.

## Results:

![Results](https://github.com/Flazhed/CritcalPathSPE/blob/master/criticalPath.png)

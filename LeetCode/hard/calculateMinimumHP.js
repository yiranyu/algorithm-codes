/* 174. Dungeon Game
The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N 
rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the 
dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies 
immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either
 empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path 
RIGHT-> RIGHT -> DOWN -> DOWN.

-2 (K)	-3	3
-5	   -10	1
10	    30	-5 (P)

Notes:

The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned. 
*/

/* 思路分析：
（1）这题容易想到的思路是用search DFS或者BFS解，给定起点和终点，可以搜索所有从起点到终点的路径，然后贪心保存下来最小的路径权值之和，
     同时要保证每次扩展分支时当前的生命值状态始终大于0。但是这并不是好的解法，时间复杂度太高。
（2）用动态规划解。关键是如何定义dp数组。假设给定的网格是m*n维，我们需要定义dp[][]表示从(i,j)到终点(m-1,n-1)需要的最小生命值，那么
	递推方程为dp[i][j] = max(min(dp[i][j+1], dp[i+1][j]) - dungeon[i][j], 0)，如果 dungeon[i][j]为正，则减去一个正数，初始需要的生命值变小。
	同理可以理解 dungeon[i][j]为负数的情况。和0取最大保证了初始生命值为非负。代码实现很简单，就是初始化后自下而上自由向左填表，典型的二维DP
	问题的做法。 */

/** Binary Search Dynamic Programming
 二维空间DP问题
 * @param {number[][]} dungeon
 * @return {number}
 */
var calculateMinimumHP = function(dungeon) {
    var m = dungeon.length;
    var n = dungeon[0].length;
	if(m===0){
		return 1;
	}
    var dp = dungeon;//dp[i][j]表示从(i,j)到目的地(m-1,n-1)需要的最小生命值
	var i,j;
	
    //初始化
	//如果dp[m-1][n-1]为负，则knight此时需要的最小健康值为其绝对值，否则为0
    dp[m-1][n-1]=Math.max(0-dungeon[m-1][n-1], 0);
	
	//初始化最后一列
    for(i=m-2,j=n-1; i>= 0; i--){
		dp[i][j] = Math.max(dp[i+1][j]-dungeon[i][j], 0);
    }
	//初始化最后一行
    for(i=m-1,j=n-2; j>=0; j--){
		dp[i][j] = Math.max(dp[i][j+1]-dungeon[i][j], 0);
    }
	
    //从下到上，从右到左
	//dp[i][j] = min(dp[i][j+1], dp[i+1][j])-dungeon[i][j],max(dp[i][j],0)
	//这一步到下一步有两种（往右或往下），从中选择需要生命值较小的一个，然后再加上这一步需要的生命值（负表示要加，正的减）
    for(i = m-2; i >= 0; i--){
		for(j = n-2; j >= 0; j--){
			dp[i][j] = Math.max(Math.min(dp[i][j+1],dp[i+1][j])-dungeon[i][j], 0);
		}
    }
    return dp[0][0] + 1;
};

//test
var dungeon=[[-2,-3,3],[-5,-10,1],[10,30,-5]];

console.log(calculateMinimumHP(dungeon));
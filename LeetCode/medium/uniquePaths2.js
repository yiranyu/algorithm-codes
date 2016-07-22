/* 63. Unique Paths II
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
*/


/**Array Dynamic Programming
 * @param {number[][]} obstacleGrid
 * @return {number}
 */
var uniquePathsWithObstacles = function(obstacleGrid) {
    if(obstacleGrid===null){
        return 0;
    }
    //当出发点就有障碍时，直接返回0
    if(obstacleGrid[0][0]===1){
        return 0;
    }
	var m=obstacleGrid.length,n=obstacleGrid[0].length;
    var paths=new Array(m);
	var i,j;
	
    //初始化
	paths[0]=new Array(n);
	paths[0][0]=1;
	
	//初始化第一列
	for(i=1;i<m;i++){
		paths[i]=new Array(n);	
		//当前格子无障碍并且前边的格子有路径时为1，否则为0
		if(obstacleGrid[i][0]===0&&paths[i-1][0]!==0){
			paths[i][0]=1;
		}else{
			paths[i][0]=0;
		}
	}
	//初始化第一行
	for(j=1;j<n;j++){
		if(obstacleGrid[0][j]===0&&paths[0][j-1]!==0){
			paths[0][j]=1;
		}else{
			paths[0][j]=0;
		}
	}
	
	for(i=1;i<m;i++){
		for(j=1;j<n;j++){
		    //当前格子无障碍，将从上和从右来的路径相加
			if(obstacleGrid[i][j]===0){ 
				paths[i][j]=paths[i][j-1]+paths[i-1][j];
			}else{//another condition
				paths[i][j]=0;
			}	
		}
	}
	return paths[m-1][n-1];
};
//test
var a=[[0,0,0,1,0],[0,0,1,0,0],[0,0,0,0,0]];

console.log(uniquePathsWithObstacles(a));
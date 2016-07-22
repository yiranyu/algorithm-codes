/* 62. Unique Paths 
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the 
bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there? 

Note: m and n will be at most 100.
*/


/**Array Dynamic Programming
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
    var paths=new Array(m);
	paths[0]=new Array(n);
	var i,j;
	
	//initialize
	paths[0][0]=1;
	for(i=1,j=0;i<m;i++){
		paths[i]=new Array(n);
		paths[i][j]=1;
	}
	for(i=0,j=1;j<n;j++){
		paths[i][j]=1;
	}
	
	for(i=1;i<m;i++){
		for(j=1;j<n;j++){
			paths[i][j]=paths[i-1][j]+paths[i][j-1];
		}
	}
	return paths[m-1][n-1];
};

/**
 *空间轮转，减少空间复杂度，O(n)
 */
var uniquePaths2 = function(m, n) {
    var paths=new Array(n);
	var i,j;
	
	//initialize
	
	for(i=0;i<n;i++){
		paths[i]=1;
	}
	for(i=1;i<m;i++){
		for(j=1;j<n;j++){
			paths[j]=paths[j-1]+paths[j];
		}
	}
	return paths[n-1];
};
//test

console.log(uniquePaths(3,5));
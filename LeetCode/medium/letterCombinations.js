/* 17. Letter Combinations of a Phone Number
Given a digit string, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
backtracking String */

/**backtracking String
 回溯法,字符串组合
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
	if(digits.length<1){
		return [];
	}
	if(digits.indexOf('0')!==-1){
		return [];
	}
	//keyboard
	var letters=[
			[' '],
			['*'],
			['a','b','c'],
			['d','e','f'],
			['g','h','i'],
			['j','k','l'],
			['m','n','o'],
			['p','q','r','s'],
			['t','u','v'],
			['w','x','y','z']
		],
		i,j,k,digit,cur,len,
		results=[''];
	//枚举法	
	for(i=0;i<digits.length;i++){
		digit=digits.charAt(i);
		len=results.length; //当前的result大小
		for(j=0;j<len;j++){
			cur=results.shift(); //获取第一个元素，并将其移出results
			//重组字母
			for(k=0;k<letters[digit].length;k++){
				results.push(cur+letters[digit][k]); //加入results
			}
		}
		
	}
	return results;
};

/* DFS recursive */
var letterCombinations2 = function(digits) {
	if(digits.length<1){
		return [];
	}
	if(digits.indexOf('0')!==-1){
		return [];
	}
	//keyboard
	var letters=[
			[' '],
			['*'],
			['a','b','c'],
			['d','e','f'],
			['g','h','i'],
			['j','k','l'],
			['m','n','o'],
			['p','q','r','s'],
			['t','u','v'],
			['w','x','y','z']
		],
		results=[];
	search('',0);
	function search(str, index) {
		if (index==digits.length) {
			results.push(str);
			return;
		}
		var candidates=letters[digits.charAt(index)];
		//console.log(candidates);
		for(var j in candidates){
			search(str+''+candidates[j], index+1);
		}	
	}
	return results;
}

//test
console.log(letterCombinations2('233'));
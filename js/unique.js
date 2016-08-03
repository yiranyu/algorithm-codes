/**
 * 数组去重：
 * 给定一个数组，调用去重方法，返回数值副本，副本中没有重复元素。一般来说，
 * 两个元素通过 === 比较返回 true 的视为相同元素，需要去重，所以，1 和 "1"
 * 是不同的元素。
 */

//用一个数组res保存结果，遍历需要去重的数组，如果该元素存在于res，则表明是重复元素，否则push入res
//时间复杂度为O(n^2)
function unique(a) {
    if (!(a instanceof Array)) {
        return [];
    }
    var res = [],
        len = a.length;
    for (var i = 0; i < len; i++) {
        var item = a[i];
        for (var j = 0, resLen = res.length; j < resLen; j++) {
            if (res[j] === item) { //全等，所以1不等于“1”，1不等于new Number(1)
                break;
            }
        }
        j === resLen && res.push(item); //&&是一个短路操作符
    }
    return res;
}

//简洁版1：使用indexOf方法代替第二个for循环
function unique1(a) {
    if (!(a instanceof Array)) {
        return [];
    }
    var res = [],
        len = a.length;
    for (var i = 0; i < len; i++) {
        var item = a[i];
        res.indexOf(item) === -1 && res.push(item);
    }
    return res;
}

//简洁版2：使用数组的filter方法过滤
function unique2(a) {
    if (!(a instanceof Array)) {
        return [];
    }
    var res = a.filter(function(item, index, array) {
        return array.indexOf(item) === index;
    });
    return res;
}

//把对象作为哈希表来用
function uniqueHash(a) {
    if (!(a instanceof Array)) {
        return [];
    }
    var hash = {},
        res = [];
    res = a.filter(function(item, index, array) {
        var pro = typeof item + item; //对象的属性为String类型，类型值+value可以解决1和“1”的问题
        return hash.hasOwnProperty(pro) ? false : hash[pro] = true;
    });
    return res;
}
//test
var a = [1, 1, '1', '2', 1];
var ans = uniqueHash(a);
console.log(ans); // => [1, "1", "2"]

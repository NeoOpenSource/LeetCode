package com.example.leetcode

/**
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
*/

class LeetCode_22 {

    fun generateParenthesis(n: Int): List<String> {
        if(n <= 0){
            return emptyList()
        }
        if(n==1){
            return arrayListOf("()")
        }
        val result: MutableList<String> = arrayListOf()
        val re = generateParenthesis(n-1)
        val mr = HashSet<String>()
        for (i in re.indices){
            val combination = re[i]
            //(()),()()
            for (j in combination.indices){
                val ns: String = combination.substring(0, j)+
                        "()" + combination.substring(j)
                mr.add(ns)
            }
        }
        for (s in mr) {
            result.add(s)
        }
        return result
    }
}
//一開始卡住的原因是，以為用bfs會比較快，後來才想出來說，要算的連結種類，應該是用dfs才對，
//接下來卡住的點是substring的問題，一直在想回圈怎麼跑，才能切成(()),()()
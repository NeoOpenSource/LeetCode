package com.example.leetcode

import org.junit.Test
import org.hamcrest.Matchers.containsInAnyOrder
import org.hamcrest.MatcherAssert.assertThat

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun test_Generate_Parentheses() {
        val leetCode22 = LeetCode_22()
        val result = leetCode22.generateParenthesis(3)
        assertThat(
            result,
            containsInAnyOrder("((()))","(()())","(())()","()(())","()()()")
        )
    }


}
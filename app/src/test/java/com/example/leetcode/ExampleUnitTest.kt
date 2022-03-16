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

    @Test
    fun test_Merge_k_Sorted_Lists(){
        val leetcode23 = LeetCode_23()
        //[[1,4,5],[1,3,4],[2,6]]
        val first = ListNode23(1)
        first.next = ListNode23(4)
        first.next?.next = ListNode23(5)
        //-----------------------
        val second  = ListNode23(1)
        second.next = ListNode23(3)
        second.next?.next = ListNode23(4)
        //-------------------------
        val third  = ListNode23(2)
        third.next = ListNode23(6)

        val array:Array<ListNode23?> = arrayOf(first,second,third)
        val listNode23 = leetcode23.mergeKLists(array)
        assert(leetcode23.junit(listNode23,intArrayOf(1,1,2,3,4,4,5,6)))
    }


    @Test
    fun test_Swap_Nodes_in_Pairs(){
        val leetcode24 = LeetCode_24()
        val data = ListNode24(1)
        data.next = ListNode24(2)
        data.next?.next = ListNode24(3)
        data.next?.next?.next = ListNode24(4)
        val listNode24 = leetcode24.swapPairs(data)
        assert(leetcode24.junit(listNode24,intArrayOf(2,1,4,3)))
    }

}
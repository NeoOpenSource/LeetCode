package com.example.leetcode

import java.lang.Exception

/**
*
* Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem
* without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
* Input: head = [1,2,3,4]
* Output: [2,1,4,3]
*/



class LeetCode_24 {
    fun swapPairs(head: ListNode24?): ListNode24? {
        return swap(head, head?.next)
    }

    private fun swap(head: ListNode24?, next: ListNode24?): ListNode24? {
        if (next == null) return head
        head!!.next = swap(next.next, next.next?.next)
        next.next = head
        return next
    }

    fun junit(listNode24: ListNode24?, testData: IntArray): Boolean {
        if (listNode24 == null) {
            throw Exception("listNode23 is null ")
        }
        var head: ListNode24? = listNode24
        var size = 0
        while (head != null) {
            if (head.`val` == testData[size]) {
                head = head.next
                size += 1
            } else {
                throw Exception("value is error ${head.`val`} testData ${testData[size]} count:${size}")
            }
        }
        return true
    }
}

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 */
class ListNode24(var `val`: Int) {
    var next: ListNode24? = null
}

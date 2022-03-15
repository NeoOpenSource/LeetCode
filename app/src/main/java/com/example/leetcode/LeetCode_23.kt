package com.example.leetcode

import java.lang.Exception
import java.util.*


//You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
//
//Merge all the linked-lists into one sorted linked-list and return it.

/*
    Input: lists = [[1,4,5],[1,3,4],[2,6]]
    Output: [1,1,2,3,4,4,5,6]
    Explanation: The linked-lists are:
    [
    1->4->5,
    1->3->4,
    2->6
    ]
    merging them into one sorted list:
    1->1->2->3->4->4->5->6
*/
class LeetCode_23 {
    fun mergeKLists(lists: Array<ListNode23?>): ListNode23? {
        if (lists.isEmpty()) {
            return null
        }
        val pq: PriorityQueue<ListNode23> = PriorityQueue { a, b ->
            a.`val` - b.`val`
        }
        for (ln in lists) {
            ln?.let {
                pq.add(ln)
            }
        }
        if (pq.size == 0) return null

        val head = ListNode23(0)
        var prev: ListNode23? = head
        //[1,1,3]
        //[1,2,4]  prev 1
        //[2,3,4]  prev 1,1
        //[3,4,6]  prev 1,1,2
        while (pq.size > 0) {
            val min = pq.poll()

            min!!.next?.let {
                pq.add(it)
            }
            prev!!.next = min

            prev = min
        }
        return head.next
    }

    fun junit(listNode23: ListNode23?, testData: IntArray):Boolean{
        if (listNode23 == null) {
            throw Exception("listNode23 is null ")
        }
        var head: ListNode23? = listNode23
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

class ListNode23(var `val`: Int) {
    var next: ListNode23? = null
}
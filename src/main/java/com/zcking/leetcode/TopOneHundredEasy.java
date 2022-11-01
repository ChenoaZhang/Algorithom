package com.zcking.leetcode;

import java.util.*;

/**
 * @Description: Top liked 100 easy
 * @Author Chenoa.Zhang
 * @Date 2022/11/1 10:56
 */
public class TopOneHundredEasy {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> answer = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (answer.containsKey(target - nums[i])) {

                return new int[]{i, answer.get(target - nums[i])};

            } else {

                answer.put(nums[i], i);

            }

        }

        return null;
    }

    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *
     * An input string is valid if:
     *
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Every close bracket has a corresponding open bracket of the same type.
     */
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        if (s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<Character, Character>(){{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};

        for (char c : s.toCharArray()) {

            if (pairs.containsKey(c)) {

                if (stack.isEmpty() || stack.pop() != pairs.get(c)) {
                    return  false;
                }

            } else {
                stack.push(c);
            }

        }
//        for (char c : s.toCharArray()) {
//            if (c == '(') {
//                stack.push(')');
//            } else if (c == '[') {
//                stack.push(']');
//            } else if (c == '{') {
//                stack.push('}');
//            } else if (stack.isEmpty() || stack.pop() != c) {
//                return false;
//            }
//        }

        return stack.isEmpty();
    }


    /**
     * You are given the heads of two sorted linked lists list1 and list2.
     *
     * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
     *
     * Return the head of the merged linked list.
     * @param list1
     * @param list2
     * @return
     */

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }



    /**
     * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
     *
     * You must write an algorithm with O(log n) runtime complexity.
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {

//        for (int i = 0; i < nums.length; i ++) {
//            if (nums[i] == target || nums[i] > target) {
//                return i;
//            }
//        }
//
        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }

        }
        return lo;

    }


    /**
     * You are climbing a staircase. It takes n steps to reach the top.
     *
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int allWays = 0;
        int oneStepBefore = 2;
        int twoStepBefore = 1;

        for (int i = 2; i < n ; i++) {
            //n阶台阶方式 = n-1阶台阶方式 + n-2阶台阶方式
            allWays = oneStepBefore + twoStepBefore;
            //
            twoStepBefore = oneStepBefore;
            //下次循环为n+1 = n阶台阶方式 + n-2阶台阶方式
            //
            oneStepBefore = allWays;
        }

        return allWays;
    }


    /**
     * Given the root of a binary tree, return the inorder traversal of its nodes' values.
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> inorderList = new ArrayList<>();
//
//        if (root == null) {
//            return inorderList;
//        }
//
//        help(root, inorderList);

//        Deque<TreeNode> stack = new ArrayDeque<>();
//        TreeNode curr = root;
//        while (curr != null || !stack.isEmpty()) {
//            while (curr != null) {
//                stack.push(curr);
//                curr = curr.left;
//            }
//            curr = stack.pop();
//            inorderList.add(curr.val);
//            curr = curr.right;
//
//        }


        return inorderList;
    }

//    public void help(TreeNode root, List<Integer> list) {
//        if (root != null) {
//            help(root.left, list);
//            list.add(root.val);
//            help(root.right, list);
//        }
//    }
    
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
}

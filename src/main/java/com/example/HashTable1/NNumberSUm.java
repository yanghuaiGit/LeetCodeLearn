package com.example.HashTable1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//对一个数组找出n个数之和为Target的集合
public class NNumberSUm {


    public static void main(String[] args) {

        System.out.println(fourSum(new int[]{1, 2, 3, 4, 5, 4, 5, 67, 2, 67, 43, 5, 7, 9, 12, 354, 6}, 12));


    }

    /**
     先排序，Arrays.sort(num)
     固定i和j，去找low和high
     使用Hashset防止重复
     * @param nums
     * @param target
     * @return
     */

    public static ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        HashSet<ArrayList<Integer>> hs = new HashSet<>();
        if (nums == null || nums.length < 4)
            return res;
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 4; i++) {//注意i的范围
            for (int j = i + 1; j <= nums.length - 3; j++) {//注意j的范围
                int low = j + 1;
                int high = nums.length - 1;
                while (low < high) {
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if (sum == target) {
                        ArrayList<Integer> al = new ArrayList<>();
                        al.add(nums[i]);
                        al.add(nums[j]);
                        al.add(nums[low]);
                        al.add(nums[high]);
                        if (!hs.contains(al)) {
                            hs.add(al);
                            res.add(al);
                        }
                        low++;
                        high--;
                    } else if (sum < target) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return res;


    }

}




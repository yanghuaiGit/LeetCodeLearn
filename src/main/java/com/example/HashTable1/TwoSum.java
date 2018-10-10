package com.example.HashTable1;




public class TwoSum {
    //给定一个整数数组和一个目标值，找出数组中和为目标值的两个数

    public static void main(String[] args){
       int target=1;
       int[] result= twoSum(new int[]{1,2,3,4,7,45,675,3,4},target);
          if(result.length>1){
              System.out.println("target:"+target+"的两个结果是"+result[0]+"以及"+result[1]);
          }
         }

    public static int[] twoSum(int[] nums,int target){
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]==target-nums[i]){
                    return new int[]{nums[i],nums[j]};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
        }
    }

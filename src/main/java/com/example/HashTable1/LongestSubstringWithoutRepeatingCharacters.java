package com.example.HashTable1;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//无重复字符的最长子串
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args){



       String target="abcc";
       //这种方式时间复杂度是O(n)
        System.out.println("最长的子串长度是"+lengthOfLongestSubstring(target));

       int n=target.length();
       int ans=0;
       for(int i=0;i<n;i++){
           for(int j=i+1;j<=n;j++){
               if(longestSubstringWithoutRepeatingCharacters(target,i,j)){
               ans= Math.max(ans,j-i);

               }

           }
       }
        System.out.println("最长的子串长度是"+ans);
    }

    public static Boolean  longestSubstringWithoutRepeatingCharacters(String  target,int start,int end){
        Set<Character>set=new HashSet<>();
        for(int i=start;i<end;i++){
            Character ch=target.charAt(i);
            if(set.contains(ch)){
                return false;

            }
            set.add(ch);

        }

       return true;
    }

    //第二种方式O(n)
    public  static int lengthOfLongestSubstring(String s) {

        //temp就是长度，max就是记录到找到重复时的最大的一个子串的长度，和现在的长度进行比较
        Map<Character, Integer> pos = new HashMap<>();
        char[] ss = s.toCharArray();

        int max = 0, temp = 0;

        for(int i = 0; i < s.length(); i++){

            if( !pos.containsKey(ss[i]) ){
                pos.put(ss[i],i);
                temp++;
            }else{
                if(pos.get(ss[i]) + temp < i){
                    temp++;
                }else{
                    max = Math.max(max,temp);
                    temp = i - pos.get(ss[i]);
                }
                pos.put(ss[i],i);
            }

        }
        max = Math.max(max,temp);
        return max;
    }





}

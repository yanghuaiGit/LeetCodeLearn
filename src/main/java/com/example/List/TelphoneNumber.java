package com.example.List;

import java.util.*;

/**
 * 电话号码排列字母组合
 */

public class TelphoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinationsList("23"));
        System.out.println(letterCombinations("23"));
    }


    //队列
    public static List<String> letterCombinationsList(String digits) {
        Map<Integer,String> map = new HashMap<Integer,String>();
        map.put(0, "");
        map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        List<String> result = new LinkedList<>();//结果集
        if(digits.length()==0){
            return result;
        }
        Queue<StringBuilder> queue = new LinkedList<>();//队列
        queue.add(new StringBuilder());//先在队列中添加一个新的空字符串

        for (int i = 0; i < digits.length(); ++i){//循环所有输入的数字
            int limitSize = queue.size();//记录每次出队列之前的元素的个数
            if (digits.charAt(i) == '0' || digits.charAt(i) == '1'){//如果数字是0或1,因为没有对应的字母，则跳过
                continue;
            }
            int tar = digits.charAt(i) - '0';
            int j = 0;//用于将queue中的元素依次出队列
            while (!queue.isEmpty() && j < limitSize){//循环j将limitsize个元素依次出队列
                StringBuilder stringBuilder1 = queue.poll();//每次将队列头一个stringBuilder出队列
                for (char x: map.get(tar).toCharArray()){//循环每一个数字对应的字母，依次加入到队列中
                    StringBuilder tmp = new StringBuilder(stringBuilder1);//获得每一个出对列的stringBuilder，并将后面的字母append到后面
                    tmp.append(x);
                    queue.add(tmp);//将stringBuilder加入到队列中
                }
                ++j;
            }
        }
        while (!queue.isEmpty()){
            result.add(queue.poll().toString());//依次将队列中的字符串加入到结果集中
        }
        return result;
    }

//回朔
    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        if (digits.length()==0){
            return list;
        }
        backtracking("",digits,0,list);//回溯
        return list;
    }
    /*
     *比如输入1,2。对应的是abc,def。回先从a开始，然后flag+1，依次向下遍历def，
     * 然后依次向上返回返回ad,ae,af，并且添加到结果集中，然后再向上返回到i=0的循环
     * 然后i+1，从b开始，再依次向下遍历def，如同a一样，依次返回所有结果，当所有的遍历完之和，返回到letterCombinations中结束。
     */
    public static void backtracking(String s,String digits,int flag,List<String> list){
        String[] strings = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        if (flag >= digits.length()){//如果已经遍历完所有输入的数字，说明已经到达底部，需要向上溯源。
            list.add(s);//到达底部说明已经是完整的一个结果，则将此次结果添加到结果集中
            return;//返回，向上回溯
        }

        String chars = strings[digits.charAt(flag) - '0'];
        for (int i = 0; i < chars.length(); i++) {//遍历一个数字对应的所有字母

            backtracking(s + chars.charAt(i),digits,flag+1,list);//将当前字符加到s上并将flag+1循环下一个数字的字母
        }
    }


}

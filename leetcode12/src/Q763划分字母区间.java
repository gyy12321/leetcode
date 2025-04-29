import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q763划分字母区间 {
    public static void main(String[] args) {
        List<Integer> x = partitionLabels("eccbbbbdec");
        x.forEach(System.out::println);
    }
    //比下面集合版本的效率高一些，55%
    public static List<Integer> partitionLabels(String s) {
        //统计字母出现的次数
        int[] letterNums=new int[130];
        //为true表示该字母已出现
        boolean[] startDel=new boolean[130];
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            letterNums[s.charAt(i)]++;
        }
        //当前需要检查的字母数量
        int needCheck=0;
        int end=0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //第一次出现，需要
            if(!startDel[c]){
                startDel[c]=true;
                needCheck++;
            }
            letterNums[c]--;
            if(letterNums[c]==0)
                needCheck--;
            if(needCheck==0){
                integers.add(i-end+1);
                end=i+1;
            }
        }
        return integers;
    }
    //23%
    public static List<Integer> partitionLabels1(String s) {
        //统计字母出现的次数
        int[] letterNums=new int[130];
        //为true表示该字母已出现
        Set<Character> set=new HashSet<>();
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            letterNums[s.charAt(i)]++;
        }
        int end=0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            set.add(c);
            letterNums[c]--;
            if(letterNums[c]==0)
                set.remove(c);
            if(set.isEmpty()){
                integers.add(i-end+1);
                end=i+1;
            }
        }
        return integers;
    }
}
//官方解法
class Solution_763 {
    public List<Integer> partitionLabels(String s) {
        //记录每个字母最后出现的位置
        int[] last = new int[26];
        int length = s.length();
        //遍历一遍字符串，记录每个字母最后出现的位置
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            //更新当前子串最后的位置
            end = Math.max(end, last[s.charAt(i) - 'a']);
            //当前子串结束，添加子串
            if (i == end) {
                //添加子串
                partition.add(end - start + 1);
                //下一个子串的起始位置
                start = end + 1;
            }
        }
        return partition;
    }
}

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Q739每日温度_$ {
    public static void main(String[] args) {
        int[] res = dailyTemperatures1(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        Arrays.stream(res).forEach(System.out::println);
        System.out.println("sa1");
    }
    //暴力法超时
//    public int[] dailyTemperatures(int[] temperatures) {
//        int n = temperatures.length;
//        int[] days=new int[n];
//        for (int i = 0; i < n; i++) {
//            for (int j = i+1; j < n; j++) {
//                if(temperatures[j]>temperatures[i]) {
//                    days[i] = j - i;
//                    break;
//                }
//            }
//        }
//        return days;
//    }
    //自己想的方法，效率还不错
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        if(n==1)
            return new int[]{0};
        int[] days=new int[n];
        days[n-1]=0;
        for (int i = n-2; i >= 0; i--) {
            //比下一天温度低，则更新为1
            if(temperatures[i]<temperatures[i+1])
                days[i]=1;
            //与下一天同温度
            else if(temperatures[i]==temperatures[i+1]){
                if(days[i+1]==0)
                    days[i]=0;
                else
                    days[i]=days[i+1]+1;
            }
            //比下一天温度要更高
            else {
                int daysCount=1;
                //73, 74, 75, 71, 69, 72, 76, 73
                while (true){
                    //dayscount后的某一天温度比今天高，跟更新days[i]并退出循环
                    if(temperatures[i+daysCount]>temperatures[i]){
                        days[i]=daysCount;
                        break;
                    }
                    else {
                        if(days[i+daysCount]==0){
                            days[i]=0;
                            break;
                        }
                        else
                            daysCount+=days[i+daysCount];
                    }
                }
            }
        }
        return days;
    }
    //单调栈
//    public static int[] dailyTemperatures1(int[] temperatures) {
//        Deque<Integer> deque=new LinkedList<>();
//        int[] days=new int[temperatures.length];
//        deque.push(0);
//        for (int i = 1; i < temperatures.length; i++) {
//            if(temperatures[i]<=temperatures[deque.peek()])
//                deque.push(i);
//            else {
//                while (deque.size()>0&&temperatures[i]>temperatures[deque.peek()]){
//                    Integer pop = deque.pop();
//                    days[pop]=i-pop;
//                }
//                deque.push(i);
//            }
//        }
//        return days;
//    }


    //进一步精简
    public static int[] dailyTemperatures1(int[] temperatures) {
        Deque<Integer> deque=new LinkedList<>();
        int[] days=new int[temperatures.length];
        deque.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            while (deque.size()>0&&temperatures[i]>temperatures[deque.peek()]){
                Integer pop = deque.pop();
                days[pop]=i-pop;
            }
            deque.push(i);
        }
        return days;
    }
    //第二次写,最后还是和第一次写的精简写法想通了，这道题不难，但方法很重要
    public int[] dailyTemperatures2(int[] temperatures) {
        int length = temperatures.length;
        int[] res=new int[length];
        Deque<Integer> stack=new LinkedList<>();
        stack.push(0);
        for(int i=1;i<length;++i){
            while (!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                int pop = stack.pop();
                res[pop]=i-pop;
            }
            stack.push(i);
        }
        return res;
    }

    //自己想的方法，效率还不错
    public static int[] dailyTemperatures4(int[] temperatures) {
        int n = temperatures.length;
        if(n==1)
            return new int[]{0};
        int[] days=new int[n];
        days[n-1]=0;
        for (int i = n-2; i >= 0; i--) {
            //比下一天温度低，则更新为1
            if(temperatures[i]<temperatures[i+1])
                days[i]=1;
                //与下一天同温度
            else if(temperatures[i]==temperatures[i+1]){
                if(days[i+1]>0)
                    days[i]=days[i+1]+1;
            }
            //比下一天温度要更高
            else {
                if(days[i+1]>0){
                    int newPlusDay=days[i+1]+1;
                    //到达最远的地方
                    while (temperatures[i+newPlusDay]<=temperatures[i]&&days[i+newPlusDay]!=0){
                        newPlusDay+=days[i+newPlusDay];
                    }
                    if(temperatures[i+newPlusDay]>temperatures[i])
                        days[i]=newPlusDay;
                }

//                int daysCount=1;
//                //73, 74, 75, 71, 69, 72,
//                while (true){
//                    //dayscount后的某一天温度比今天高，跟更新days[i]并退出循环
//                    if(temperatures[i+daysCount]>temperatures[i]){
//                        days[i]=daysCount;
//                        break;
//                    }
//                    else {
//                        if(days[i+daysCount]==0){
//                            days[i]=0;
//                            break;
//                        }
//                        else
//                            daysCount+=days[i+daysCount];
//                    }
//                }
            }
        }
        return days;
    }


    //自己想的方法，效率还不错
    public static int[] dailyTemperatures5(int[] temperatures) {
        int n = temperatures.length;
                int[] days=new int[n];
        days[n-1]=0;
        for (int i = n-2; i >= 0; i--) {
            //比下一天温度低，则更新为1
            if(temperatures[i]<temperatures[i+1])
                days[i]=1;
            //与下一天同温度或比下一天高
            else if(days[i+1]>0){
                int newPlusDay=days[i+1]+1;
                //到达最远的地方
                while (temperatures[i+newPlusDay]<=temperatures[i]&&days[i+newPlusDay]!=0){
                    newPlusDay+=days[i+newPlusDay];
                }
                if(temperatures[i+newPlusDay]>temperatures[i])
                    days[i]=newPlusDay;
            }
        }
        return days;
    }

    //自己想的方法，效率还不错
    public static int[] dailyTemperatures6(int[] temperatures) {
        int n = temperatures.length;
        int[] days=new int[n];
        days[n-1]=0;
        for (int i = n-2; i >= 0; i--) {
            //比下一天温度低，则更新为1
            if(temperatures[i]<temperatures[i+1])
                days[i]=1;
                //与下一天同温度或比下一天高
            else if(days[i+1]>0){
                int newPlusDay=days[i+1]+1;
                //到达最远的地方
                while (temperatures[i+newPlusDay]<=temperatures[i]){
                    if(days[i+newPlusDay]==0){
                        newPlusDay=0;
                        break;
                    }
                    newPlusDay+=days[i+newPlusDay];
                }
                days[i]=newPlusDay;
            }
        }
        return days;
    }
}

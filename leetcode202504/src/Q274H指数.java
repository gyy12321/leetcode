import java.util.Arrays;

public class Q274H指数 {
    //8
    public int hIndex(int[] citations) {
        int h = citations.length;
        int num=0;
        while (true){
            for (int citation : citations) {
                if(citation>=h)
                    num++;
            }
            if(num>=h)
                return h;
            else{
                h--;num=0;
            }
        }
    }
    //21
    public int hIndex1(int[] citations) {
        Arrays.sort(citations);
        int h=0;
        int l = citations.length;
        for (int i = 0; i < l; i++) {
            h=Math.max(h,Math.min(l-i,citations[i]));
        }
        return h;
    }

    //79
    public int hIndex2(int[] citations) {
        Arrays.sort(citations);
        int l = citations.length;
        int i;
        for (i = 1; i <= l; i++) {
            //从后往前找，citations不断变小，i不断变大
            if(citations[l-i]<i)
                break;
        }
        return i-1;
    }
}

//和我的最后的做法相似
class Solution274_1 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0, i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }
}


//计数排序，100，最优good
class Solution274_2 {
    public int hIndex(int[] citations) {
        int n = citations.length, tot = 0;
        int[] counter = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                counter[n]++;
            } else {
                counter[citations[i]]++;
            }
        }
        for (int i = n; i >= 0; i--) {
            tot += counter[i];
            if (tot >= i) {
                return i;
            }
        }
        return 0;
    }
}

//二分
class Solution274_3 {
    public int hIndex(int[] citations) {
        int left=0,right=citations.length;
        int mid=0,cnt=0;
        while(left<right){
            // +1 防止死循环
            mid=(left+right+1)>>1;
            cnt=0;
            for(int i=0;i<citations.length;i++){
                if(citations[i]>=mid){
                    cnt++;
                }
            }
            if(cnt>=mid){
                // 要找的答案在 [mid,right] 区间内
                left=mid;
            }else{
                // 要找的答案在 [0,mid) 区间内
                right=mid-1;
            }
        }
        return left;
    }
}


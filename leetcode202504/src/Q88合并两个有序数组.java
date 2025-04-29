public class Q88合并两个有序数组 {

    public static void main(String[] args) {

    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res=new int[m+n];
        int p1=0,p2=0;
        for (int i = 0; i < m + n; i++) {
            if(p1==m)
                res[i]=nums2[p2++];
            else if(p2==n)
                res[i]=nums1[p1++];
            else if(nums1[p1]<=nums2[p2])
                res[i]=nums1[p1++];
            else
                res[i]=nums2[p2++];
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i]=res[i];
        }
    }

    //尝试逆向写法
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1=m-1,p2=n-1;
        int index=m+n-1;
        while (index>=0){
            if(p1==-1)
                nums1[index--]=nums2[p2--];
            else if(p2==-1)
                nums1[index--]=nums1[p1--];
            else if(nums1[p1]>=nums2[p2])
                nums1[index--]=nums1[p1--];
            else
                nums1[index--]=nums2[p2--];
        }
    }
}

//双指针法也能这样写
class Solution88_2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }
}
//答案的逆向写法
class Solution88_3 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }
}


import java.util.Arrays;

public class Q189轮转数组_官方第二种复杂没看 {
    public static void main(String[] args) {

    }
    //空间复杂度n,我的方法和官方的方法一类似
    public static void rotate(int[] nums, int k) {
        if(nums.length==1)
            return;
        int n = nums.length;
        k=k%n;
        int[] res=new int[n];
        //没必要分两类
        for (int i = 0; i < k; i++) {
            res[i]=nums[n-k+i];
        }
        for (int i = k; i < n; i++) {
            res[i]=nums[i-k];
        }
        for (int i = 0; i < n; i++) {
            nums[i]=res[i];
        }
    }

}

//好理解的解法
class Solution189_1 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        //一步搞定更快
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }
}
//暂时没看懂
class Solution189_2 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }
}
//最好的官方解法，不停地翻转
class Solution189_3 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}

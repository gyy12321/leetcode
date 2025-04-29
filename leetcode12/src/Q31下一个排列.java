public class Q31下一个排列 {

}

class Solution31 {
    public static void main(String[] args) {
        int[] nums=new int[]{5,4,3,2,1};
        for (int i = 0; i < 30; i++) {
            new Solution31().nextPermutation(nums);
        }
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //首先从后向前查找第一个顺序对 (i,i+1)
        //123(5)98764
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        //如果找到了顺序对，那么在区间 [i+1,n) 中从后向前查找第一个元素 j 满足 a[i]<a[j]。这样「较大数」即为 a[j]
        //123(5)987(6)4,交换5和6，交换后变成123(6)987(5)4
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        //i<0证明不存在顺序对，7654321,那么直接翻转数组即可
        //123(6)987(5)4->123(6)45789
        reverse(nums, i + 1);
    }

    // 交换数组中下标为 i 和 j 的元素
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 翻转数组中下标从 start 到数组末尾的元素
    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}

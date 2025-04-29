import java.util.Arrays;

public class Q75颜色分类 {

}

/*
单指针
我们可以考虑对数组进行两次遍历。在第一次遍历中，我们将数组中所有的 0
 交换到数组的头部。在第二次遍历中，我们将数组中所有的 1 交换到头部的 0 之后。
 此时，所有的 2 都出现在数组的尾部，这样我们就完成了排序
 */
//最好理解
class Solution75_1 {
    public void sortColors(int[] nums) {
        int ptr=0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i]==0){
                swap(nums,ptr,i);
                ptr++;
            }
        }
        //i从ptr开始
        for (int i = ptr; i < n; i++) {
            if(nums[i]==1){
                swap(nums,ptr,i);
                ptr++;
            }
        }
    }
    public void swap(int[] nums,int x,int y){
        int temp=nums[x];
        nums[x]=nums[y];
        nums[y]=temp;
    }
}
//双指针法，0和1各有一个指针，稍微难理解
class Solution75_2 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        //p0,p1是下一次插入0和1的指针位置
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                swap(nums, i, p1);
                ++p1;
            }

            else if (nums[i] == 0) {
                //先i与p0交换
                swap(nums, i, p0);
                //p0<p1，则有1已经放好位置了。上一步操作把1移到后面去了，接下来需要再移回来。
                if (p0 < p1) {
                    swap(nums, i, p1);
                }
                //两个指针需要同时移动
                ++p0;
                ++p1;
            }
        }
    }
    public void swap(int[] nums,int x,int y){
        int temp=nums[x];
        nums[x]=nums[y];
        nums[y]=temp;
    }
}



//双指针法，0和2各有一个指针，分别一前一后。好比较好理解。
//在遍历的过程中，我们需要找出所有的 0 交换至数组的头部，并且找出所有的 2 交换至数组的尾部
class Solution75_3 {
    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length - 1;
        for(int i=0;i<=p2;i++){
            //先处理所有2，和p2位置交换
            while (i<=p2&&nums[i]==2)
                swap(nums,i,p2--);
            //当前位置是0则与p0位置交换，否则不用理会
            if(nums[i]==0)
                swap(nums,i,p0++);
        }
    }
    public void swap(int[] nums,int x,int y){
        int temp=nums[x];
        nums[x]=nums[y];
        nums[y]=temp;
    }
}


public class Q287寻找重复数 {

}

//二分查找勉强能看懂。第二遍看又看不懂了。
class Solution287_1 {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }

            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
}

//二进制，没看懂
class Solution287_2 {
    public int findDuplicate(int[] nums) {
        int n = nums.length, ans = 0;
        int bit_max = 31;
        while (((n - 1) >> bit_max) == 0) {
            bit_max -= 1;
        }
        for (int bit = 0; bit <= bit_max; ++bit) {
            int x = 0, y = 0;
            for (int i = 0; i < n; ++i) {
                if ((nums[i] & (1 << bit)) != 0) {
                    x += 1;
                }
                if (i >= 1 && ((i & (1 << bit)) != 0)) {
                    y += 1;
                }
            }
            if (x > y) {
                ans |= 1 << bit;
            }
        }
        return ans;
    }
}


//快慢指针，和链表的快慢指针差不多。华南溜达虎视频。基本懂了*****
//1,4,6,5,2,6,3
//0,1,4,2,6,3,5,6...................形成了环
class Solution287_3 {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            // 快指针走两步，慢指针走一步，直到相遇
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        // 慢指针从起点出发，快指针从相遇点出发，再次相遇点就是环的入口点
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}



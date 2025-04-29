import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Q169多数元素 {
    //常规的hash表法，记录每个元素的个数，打擂台
    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            if(!map.containsKey(num)){
                map.put(num,1);
            }
            else {
                map.put(num,map.get(num)+1);
            }
        }
        return map;
    }

    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map=countNums(nums);
        Map.Entry<Integer,Integer> majorityEntry=null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(majorityEntry==null||entry.getValue()>majorityEntry.getValue())
                majorityEntry=entry;
        }
        return majorityEntry.getKey();
    }
}
class Solution169_1 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}


//分治的神奇做法
class Solution169_2 {
    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }
}


//随机化
class Solution169_3 {
    private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    public int majorityElement(int[] nums) {
        Random rand = new Random();

        int majorityCount = nums.length / 2;

        while (true) {
            int candidate = nums[randRange(rand, 0, nums.length)];
            if (countOccurences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }
    }
}



//Boyer-Moore 投票算法,效率更高一些
class Solution169_4 {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}


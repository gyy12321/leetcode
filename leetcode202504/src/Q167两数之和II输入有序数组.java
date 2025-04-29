public class Q167两数之和II输入有序数组 {
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                int sum=numbers[i]+ numbers[j];
                if(sum==target)
                    return new int[]{i+1,j+1};
                if(sum>target)
                    break;
            }
        }
        return null;
    }

    //也才击败15，类似答案1
    public int[] twoSum1(int[] numbers, int target) {
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            int num=target-numbers[i];
            int l=i+1;int r=length-1;int mid;
            while (l<=r){
                mid=(l+r)/2;
                if(numbers[mid]==num)
                    return new int[]{i+1,mid+1};
                else if(numbers[mid]<num)
                    l=mid+1;
                else
                    r=mid-1;
            }
        }
        return null;
    }
}

//固定一个值，另一个用二分
class Solution167_1 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }
}

//双指针写法记忆一下

//初始时两个指针分别指向第一个元素位置和最后一个元素的位置。
//        每次计算两个指针指向的两个元素之和，并和目标值比较。
//        如果两个元素之和等于目标值，则发现了唯一解。如果两个元素之和小于目标值，
//        则将左侧指针右移一位。如果两个元素之和大于目标值，则将右侧指针左移一位。移动指针之后
//        重复上述操作，直到找到答案。


class Solution167_2 {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                ++low;
            } else {
                --high;
            }
        }
        return new int[]{-1, -1};
    }
}




public class Q11盛最多水的容器 {
    public static void main(String[] args) {

    }
    //经典题，思路还算简单
    public int maxArea(int[] height) {
        int l=0,r=height.length-1;
        int areaMax=0;
        while (l<r){
            areaMax=Math.max(areaMax,(r-l)*Math.min(height[l],height[r]));
            if(height[l]<height[r])
                l++;
            else
                r--;
        }
        return areaMax;
    }
}

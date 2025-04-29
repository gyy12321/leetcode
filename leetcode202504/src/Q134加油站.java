public class Q134加油站 {
    public static void main(String[] args) {

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int[] oil=new int[length];
        for (int i = 0; i < length; i++) {
            oil[i]=gas[i]-cost[i];
        }
        int curIndex=0;
        int sumOil=0;
        int begin=0;
        while (begin<length){
            sumOil+=oil[curIndex];
            if(sumOil<0){
                sumOil=0;
                begin=curIndex+1;
            }
            curIndex++;
        }
        return 1;

    }
}

//官方贪心解法

class Solution134_1 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        //i表示车从哪个节点出发
        //尝试完从0——n-1节点出发都失败后返回-1
        while (i < n) {
            int sumOfGas = 0, sumOfCost = 0;
            //表示走了几段，若走了n段表示回到出发点，即成功
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                //没有油了，退出
                if (sumOfCost > sumOfGas) {
                    break;
                }
                //成功来到下一站，继续while虚幻
                cnt++;
            }
            //走了一圈了，返回起点位置
            if (cnt == n) {
                return i;
            } else {
                //没有油了，更新起点位置，从第一个到达不了的位置再出发
                i = i + cnt + 1;
            }
        }
        return -1;
    }
}


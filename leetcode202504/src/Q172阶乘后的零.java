public class Q172阶乘后的零 {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(11));
    }
    public static int trailingZeroes(int n) {
        int num=0;
        while (n!=0){
            n/=5;
            num+=n;
        }
        return num;
    }
}

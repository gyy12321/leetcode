public class Main1 {

    // 求两个整数的最大公因数（辗转相除法）
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a); // 保证结果为正
    }

    public static void main(String[] args) {
        int num1 = 48;
        int num2 = 18;

        int result = gcd(num1, num2);
        System.out.println("最大公因数是: " + result);
    }
}
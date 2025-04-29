public class Q12整数转罗马数字 {

    public static void main(String[] args) {
        System.out.println(new Q12整数转罗马数字().intToRoman(3749));
    }
//    I	1
//    V	5
//    X	10
//    L	50
//    C	100
//    D	500
//    M	1000
//    4 (IV)，9 (IX)，40 (XL)，90 (XC)，400 (CD) 和 900 (CM)
    //50
    public String intToRoman(int num) {
        int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        int index=0;
        String res="";
        while (num!=0){
            int value = values[index];
            int times=num/value;
            if(times>=1){
                String appendStr=getRomanStr(value);
                for (int i = times; i > 0; i--) {
                    res+=appendStr;
                }
                num%=value;
            }
            index++;
        }
        return res;
    }
    //由于stringbuilder达到了97
    public String intToRoman1(int num) {
        int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        int index=0;
        StringBuilder stringBuilder=new StringBuilder();
        while (num!=0){
            int value = values[index];
            int times=num/value;
            if(times>=1){
                String appendStr=getRomanStr(value);
                for (int i = times; i > 0; i--) {
                    stringBuilder.append(appendStr);
                }
                num%=value;
            }
            index++;
        }
        return stringBuilder.toString();
    }
    private String getRomanStr(int number){
        switch (number){
            case 1000:return "M";
            case 900:return "CM";
            case 500:return "D";
            case 400:return "CD";
            case 100:return "C";
            case 90:return "XC";
            case 50:return "L";
            case 40:return "XL";
            case 10:return "X";
            case 9:return "IX";
            case 5:return "V";
            case 4:return "IV";
            case 1:return "I";
            default:return "";
        }
    }
}
//97,和我的类似
class Solution12_1 {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; ++i) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }
}

//硬编码97，有创意，不难
class Solution12_2 {
    String[] thousands = {"", "M", "MM", "MMM"};
    String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] tens      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] ones      = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public String intToRoman(int num) {
        StringBuffer roman = new StringBuffer();
        roman.append(thousands[num / 1000]);
        roman.append(hundreds[num % 1000 / 100]);
        roman.append(tens[num % 100 / 10]);
        roman.append(ones[num % 10]);
        return roman.toString();
    }
}

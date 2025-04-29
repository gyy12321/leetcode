public class Q125验证回文串 {
    public static void main(String[] args) {
        System.out.println("11".toLowerCase());
    }
    //35.19->68.44
    public boolean isPalindrome(String s) {
        //得益于这一句话
        s=s.toLowerCase();
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if((c>='0'&&c<='9')||(c>='a'&&c<='z'))
                stringBuilder.append(c);
        }
        int left=0;int right=stringBuilder.length()-1;

        while (left<right){
            if(stringBuilder.charAt(left)!=stringBuilder.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }


    //时间通不过
    //改了改逻辑，变为97
    public boolean isPalindrome1(String s) {
        //得益于这一句话
        s=s.toLowerCase();
        int left=0;int right=s.length()-1;
        while (left<right){
            //寻找左指针下一个符合要求的字符
            while (!isValid(s.charAt(left))&&left<right)
                left++;
            //寻找右指针下一个符合要求的字符
            while (!isValid(s.charAt(right))&&left<right)
                right--;
            if(left<right){
                if(s.charAt(left)!=s.charAt(right))
                    return false;
                left++;
                right--;
            }
        }

        return true;
    }
    public boolean isValid(char c){
        return (c>='0'&&c<='9')||(c>='a'&&c<='z');
    }
}

//筛选加判断35
class Solution125_1 {
    public boolean isPalindrome(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        //反转并比较
        StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
        return sgood.toString().equals(sgood_rev.toString());
    }
}

//97
class Solution125_2 {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }
}


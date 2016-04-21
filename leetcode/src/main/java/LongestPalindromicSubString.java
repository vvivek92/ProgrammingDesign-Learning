/**
 * Created by vivek.vanga on 21/04/16.
 */
public class LongestPalindromicSubString {

    public String find(String str) {
        if(str.length() == 0) {
            return str;
        }
        int startIndexLongestPalindrome=0, endIndexLongestPalindrome=1;
        for(int midIndex = 0; midIndex < str.length();midIndex++) {
            boolean isPalindrome = true;
            int startIndex = midIndex;
            int endIndex = midIndex + 1;
            for(int offset = 1; startIndex >0 && endIndex < str.length() && isPalindrome;offset++) {
                if(str.charAt(startIndex -1)  == str.charAt(endIndex)) {
                    startIndex--;
                    endIndex++;
                } else {
                    break;
                }
                if(endIndex - startIndex > endIndexLongestPalindrome - startIndexLongestPalindrome) {
                    endIndexLongestPalindrome = endIndex;
                    startIndexLongestPalindrome = startIndex;
                }
            }
        }

        for(int midSpace = 0; midSpace <= str.length();midSpace++) {
            boolean isPalindrome = true;
            int startIndex = midSpace;
            int endIndex = midSpace;
            for(int offset = 1; startIndex >0 && endIndex < str.length() && isPalindrome;offset++) {
                if(str.charAt(startIndex -1)  == str.charAt(endIndex)) {
                    startIndex--;
                    endIndex++;
                } else {
                    break;
                }
                if(endIndex - startIndex > endIndexLongestPalindrome - startIndexLongestPalindrome) {
                    endIndexLongestPalindrome = endIndex;
                    startIndexLongestPalindrome = startIndex;
                }
            }
        }

        return str.substring(startIndexLongestPalindrome, endIndexLongestPalindrome);
    }


    public static void main(String[] args) {
        LongestPalindromicSubString l = new LongestPalindromicSubString();
        System.out.println(l.find("a"));
        System.out.println(l.find("aaa"));
        System.out.println(l.find("bb"));
        System.out.println(l.find("whereistheracecar"));
        System.out.println("tests passed");
    }
}

/**
 * Created by vivek.vanga on 22/04/16.
 */

//Determine whether an integer is a palindrome. Do this without extra space.
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        return isPalindrome(s);
    }

    public boolean isPalindrome(String s) {
        if(s.length() <=1){
            return true;
        }
        return (s.charAt(0) == s.charAt(s.length() -1)) && isPalindrome(s.substring(1,s.length() - 1));
    }

    public static void main(String[] args) {
        PalindromeNumber p = new PalindromeNumber();
        assert p.isPalindrome(121);
        assert !p.isPalindrome(123);
        System.out.println("tests passed");
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by vivek.vanga on 25/04/16.
 */
//Write a function that takes a string as input and reverse only the vowels of a string.
//
//        Example 1:
//        Given s = "hello", return "holle".
//
//        Example 2:
//        Given s = "leetcode", return "leotcede".

public class ReverseVowels {
    public String reverseVowels(String str) {
        StringBuffer s = new StringBuffer(str);
        HashSet<Character> vowels = new HashSet<Character>(Arrays.asList(new Character[]{'a','e','i','o','u','A','E','I','O','U'}));
        List<Integer> vowelIndices = new ArrayList<Integer>();
        for(int i = 0; i < s.length();i++) {
            if (vowels.contains(s.charAt(i))) {
                vowelIndices.add(i);
            }
        }

        s = swapBasedOnIndices(s,vowelIndices);
        return s.toString();
    }

    private StringBuffer swapBasedOnIndices(StringBuffer s, List<Integer> indices) {
        if(indices.size() <=1) {
            return s;
        } else {
            // swap characters in string buffer. swap at indices from start and end of indices.
            for(int i=0; i < indices.size()/2 ;i++) {
                int firstIndex = indices.get(i);
                int lastIndex = indices.get(indices.size() -1 -i);
                Character tempChar = s.charAt(firstIndex);
                s.setCharAt(firstIndex, s.charAt(lastIndex));
                s.setCharAt(lastIndex,tempChar );
            }
            return s;
        }
    }

    public static void main(String[] args) {
        ReverseVowels rv = new ReverseVowels();
        System.out.println(rv.reverseVowels("hello"));
        System.out.println(rv.reverseVowels("leetcode"));
        System.out.println(rv.reverseVowels("A man a plan a canal: Panama"));
        assert  "holle".equals(rv.reverseVowels("hello"));
        assert  "leetcode".equals(rv.reverseVowels("leotcede"));
        System.out.println("tests passed");
    }
}

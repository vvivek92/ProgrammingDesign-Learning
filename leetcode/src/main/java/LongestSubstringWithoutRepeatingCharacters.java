import java.util.HashSet;

/**
 * Created by vivek.vanga on 14/04/16.
 */
public class LongestSubstringWithoutRepeatingCharacters {


    public String find(String str) {
        if(str.length() == 0) {
            return str;
        }
        HashSet<Character> set = new HashSet<Character>();
        int startIndexLongestSubstring = 0;
        int endIndexLongestSubstring = 0;
        int endIndexLastConsidered = 0;
        for(int i=0; i< str.length();i++) {
            int j = Math.max(i, endIndexLastConsidered);
            for(;j < str.length();j++) {
                if(!set.contains(str.charAt(j))) {
                    set.add(str.charAt(j));
                    if(j+1 - i > endIndexLongestSubstring - startIndexLongestSubstring) {
                        startIndexLongestSubstring = i;
                        endIndexLongestSubstring = j+1;
                    }
                } else {
                    endIndexLastConsidered = j;
                    break;
                }
            }
            set.remove(str.charAt(i));
        }
        return str.substring(startIndexLongestSubstring, endIndexLongestSubstring);
    }


    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        assert l.find("abcabcbb").equals("abc");
        assert l.find("bbbbb").equals("b");
        assert l.find("pwwkew").equals("wke");
        assert l.find("dvdf").equals("vdf");
        assert l.find("au").equals("au");
        assert l.find("eee").equals("e");
        assert l.find("loddktdji").equals("ktdji");
        System.out.println("tests passed");
    }
}

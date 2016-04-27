/**
 * Created by vivek.vanga on 26/04/16.
 */
public class ReverseString {
    public String reverseString(String str) {
        StringBuffer s = new StringBuffer(str);
        for(int i =0; i < s.length()/2;i++) {
            int firstIndex = i;
            int lastIndex = s.length() -1 -i;
            Character tempChar = s.charAt(firstIndex);
            s.setCharAt(firstIndex, s.charAt(lastIndex));
            s.setCharAt(lastIndex,tempChar);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        System.out.println(rs.reverseString("hello"));
    }

}

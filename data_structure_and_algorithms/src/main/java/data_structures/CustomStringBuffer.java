package data_structures;


import java.util.ArrayList;

/**
 * Created by vivek.vanga on 27/04/16.
 */
public class CustomStringBuffer {

    ArrayList<Character> internalRepresentation;

    CustomStringBuffer() {
        internalRepresentation = new ArrayList<Character>();
    }

    public void append(String string) {
        for(int i=0;i< string.length();i++) {
            internalRepresentation.add(string.charAt(i));
        }
    }

    @Override
    public String toString() {
        char[] temp = new char[internalRepresentation.size()];
        for(int i =0; i < internalRepresentation.size();i++) {
            temp[i] = internalRepresentation.get(i);
        }
        return new String(temp);
    }

    public static void main(String[] args) {
        CustomStringBuffer csb = new CustomStringBuffer();
        csb.append("hi");
        csb.append(" there");
        System.out.println(csb.toString());
    }
}

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vivek.vanga on 19/04/16.
 */
public class RemoveDuplicates {
    HashMap<String, Integer> counter;
    RemoveDuplicates() {
        counter = new HashMap<String, Integer>();
    }

    void addString(String s) {
        if(counter.containsKey(s)) {
            counter.put(s, counter.get(s) +1);
        } else {
            counter.put(s,1);
        }
    }


    void printUniqueStrings() {
        for(Map.Entry<String,Integer> entry: counter.entrySet()) {
            if(entry.getValue() <=1 ) {
                System.out.println(entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        removeDuplicates.addString("Ted");
        removeDuplicates.addString("John");
        removeDuplicates.addString("Mark");
        removeDuplicates.addString("Ted");
        removeDuplicates.addString("David");
        removeDuplicates.printUniqueStrings();

    }
}

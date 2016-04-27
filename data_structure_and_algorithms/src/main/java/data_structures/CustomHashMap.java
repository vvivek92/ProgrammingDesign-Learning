package data_structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

/**
 * Created by vivek.vanga on 27/04/16.
 */
public class CustomHashMap {
    private ArrayList<TreeMap<Integer,Integer>> internalRepresentation;
    private static final int SIZE = 10;

    public CustomHashMap() {
        internalRepresentation = new ArrayList<TreeMap<Integer, Integer>>(SIZE * 2 + 2);
        for(int i =0;i<SIZE;i++) {
            internalRepresentation.add(new TreeMap<Integer, Integer>());
        }
    }

    public void set(int key, int value) {
        int index = hashToIndex(key);
        internalRepresentation.get(index).put(key,value);
    }

    public int get(int key) {
        int index = hashToIndex(key);
        return internalRepresentation.get(index).get(key);
    }

    private int hashToIndex(int key) {
        return key % SIZE;
    }

    public static void main(String[] args) {
        CustomHashMap hashMap = new CustomHashMap();
        hashMap.set(1,3);
        hashMap.set(22,4);
        hashMap.set(21,6);
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(22));
        System.out.println(hashMap.get(21));
    }
}
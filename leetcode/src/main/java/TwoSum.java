
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by vivek.vanga on 13/04/16.
 */

//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//You may assume that each input would have exactly one solution.

public class TwoSum {

    // O(n^2)
    public int[] bruteForce(int[] nums, int target) {
        System.out.println("using brute force solution");
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // O(n) using hash map
    public int[] linear(int[] nums, int target) {
        List<Integer> numsAsArrayList = buildArrayList(nums);
        System.out.println("using linear solution");
        HashMap<Integer,Integer> counter = buildCounter(nums);
        for(int i=0; i < nums.length;i++) {
            int firstElem = nums[i];
            int secondElem = target - firstElem;
            if(firstElem != secondElem) {
                if(counter.containsKey(secondElem)) {
                    return new int[] {numsAsArrayList.indexOf(firstElem),numsAsArrayList.lastIndexOf(secondElem) };
                }
            } else {
                if(counter.get(firstElem) > 1) {
                    return new int[] {numsAsArrayList.indexOf(firstElem),numsAsArrayList.lastIndexOf(firstElem) };
                }
            }
        }
        return null;
    }

    private List<Integer> buildArrayList(int [] nums) {
        List<Integer> arrayList = new ArrayList<Integer>();
        for(int i: nums) {
            arrayList.add(i);
        }
        return arrayList;
    }

    private HashMap<Integer, Integer> buildCounter(int[] nums) {
        HashMap<Integer,Integer> counter = new HashMap<Integer, Integer>();
        for(int i : nums ){
            if(!counter.containsKey(i)) {
                counter.put(i, 0);
            }
            counter.put(i, counter.get(i) +1 );
        }
        return counter;
    }

    public static void main(String[] args) {
        TwoSum t = new TwoSum();
        int[] x = t.bruteForce(new int[]{2, 5, 3, 4}, 6);
        assert Arrays.equals(new int[]{0, 3}, t.bruteForce(new int[]{2, 5, 3, 4}, 6));
        assert Arrays.equals(new int[]{0, 3}, t.linear(new int[]{2, 5, 3, 4}, 6));
       assert Arrays.equals(new int[]{1, 2}, t.linear(new int[]{3, 2, 4}, 6));
        System.out.println("tests passed");
    }


}

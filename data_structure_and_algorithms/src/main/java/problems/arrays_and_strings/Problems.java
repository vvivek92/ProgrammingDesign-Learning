package problems.arrays_and_strings;

import java.util.*;

/**
 * Created by vivek.vanga on 27/04/16.
 */
public class Problems {

    //Implement an algorithm to determine if a string has all unique characters. What
    //if you cannot use additional data structures?
    boolean hasUniqueCharactersTimeEfficient(String s) {
        Set<Character> characterSet = new HashSet<Character>();
        for(int i=0; i < s.length();i++) {
            if(characterSet.contains(s.charAt(i))) {
                return false;
            } else {
                characterSet.add(s.charAt(i));
            }
        }
        return true;
    }

    boolean hasUniqueCharactersSpaceEfficient(String s) {
        for(int i = 0; i < s.length();i++) {
            for(int j=0;j< s.length();j++) {
                if(j!=i && s.charAt(i) == s.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /// find transponse of an image.
    int[][] rotate(int[][] image) {
        if(image.length != image[0].length) {
           throw new IllegalArgumentException();
        }
        // can assume the image is square matrix.
        int dimension = image.length;
        for(int i=0;i< dimension; i++) {
            for(int j=i;j<dimension;j++) {
                int temp = image[j][i];
                image[j][i] = image[i][j];
                image[i][j] = temp;
            }
        }
        return image;
    }

    void printImage(int[][] image) {
        int dimension = image.length;
        for(int i=0;i< dimension;i++){
            for(int j=0;j<dimension;j++) {
                System.out.println(image[i][j]);
            }
        }
    }

    // assumes image is a 2D matrix. otherwise behaviour is undefined.
    ArrayList<ArrayList<Integer>> convert2DArrayToList(int[][] image) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i < image.length;i++) {
            list.add(new ArrayList<Integer>());
            for(int j=0; j< image[0].length;j++) {
                list.get(i).add(image[i][j]);
            }
        }
        return list;
    }

//    Write an algorithm such that if an element in an MxN matrix is 0, its entire row
//    and column are set to 0.
    void markRowAndColumnZero(int[][] matrix) {
        HashSet<Integer> rows = new HashSet<Integer>();
        HashSet<Integer> columns = new HashSet<Integer>();
        for(int i=0; i< matrix.length;i++) {
            for(int j =0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        Iterator<Integer> rowsIterator = rows.iterator();
        while(rowsIterator.hasNext()) {
            int rowToBeSetToZero = rowsIterator.next();
            for(int i=0;i< matrix[0].length;i++) {
                matrix[rowToBeSetToZero][0] = 0;
            }
        }

        Iterator<Integer> columnsIterator = columns.iterator();
        while(columnsIterator.hasNext()) {
            int columnToBeSetToZero = columnsIterator.next();
            for(int i=0;i< matrix[0].length;i++) {
                matrix[i][columnToBeSetToZero] = 0;
            }
        }

        return;


    }

    public static void main(String[] args) {
        Problems p = new Problems();
        assert p.hasUniqueCharactersTimeEfficient("String");
        assert p.hasUniqueCharactersSpaceEfficient("String");
        assert !p.hasUniqueCharactersTimeEfficient("StringS");
        assert !p.hasUniqueCharactersSpaceEfficient("StringS");
        int[][]image = new int[][]{new int[]{1,2}, new int[]{3,4}};
        p.printImage(image);
        p.rotate(image);
        p.printImage(image);
        p.convert2DArrayToList(image);
        System.out.println("hi");
        int[][] dummyMatrix = new int[][]{new int[]{1,2,0},new int[]{1,0,3},new int[]{1,2,4}  };
        p.printImage(dummyMatrix);
        p.markRowAndColumnZero(dummyMatrix);
        p.printImage(dummyMatrix);
        System.out.println("tests passed");
    }

}

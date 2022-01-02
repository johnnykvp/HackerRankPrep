import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
    // Write your code here

    /* Questions
    Are the given elements sorted? (No, may be in any order)
    Do duplicate values affect the ratios? (Yes, multiple zeros, etc.)
    */
    
    /* Approach
    int counters for positive, negative, & zero
    for loop iterates through array nums
        if statement checks num is positive
            increment positive count
        else if checks num is negative
            increment negative count
        else zero
            increment zero count
    double-type ratio count / array size
    convert double to string
    if statement checks string length < 8
        while loop iterates through until string length = 8
            add 0 to end of string
    if statement checks string length > 8
        substring(0,9) (inclusive, exclusive)
    print string ratios
    */
    
       int pos = 0;
       int neg = 0;
       int zer = 0;
       for (int i = 0; i < arr.size(); i++) {
           if (arr.get(i) > 0) {
               pos++;
           }
           else if (arr.get(i) < 0) {
               neg++;
           }
           else {
               zer++;
           }
       }
       double posRatio = (double) pos / arr.size();
       double negRatio = (double) neg / arr.size();
       double zerRatio = (double) zer / arr.size();
       String posResult = Double.toString(posRatio);
       String negResult = Double.toString(negRatio);
       String zerResult = Double.toString(zerRatio);
       posResult = lengthCheck(posResult);
       negResult = lengthCheck(negResult);
       zerResult = lengthCheck(zerResult);
       System.out.println(posResult);
       System.out.println(negResult);
       System.out.println(zerResult);
    }
    
    private static String lengthCheck(String ratio) {
        if (ratio.length() > 8) {
            return ratio.substring(0,9);
        }
        else {
            while (ratio.length() < 8) {
                ratio += "0";
            }
        }
        return ratio;
    }

    /* Tests
    [1,1,0,-1,-1] -> i = 0, pos = 1; i = 1, pos = 2; i = 2, zer = 1;
    i = 3, neg = 1; i = 4, neg = 2; posRatio = 0.4; negRatio = 0.4;
    zerRatio = 0.2; posResult = "0.4"; negResult = "0.4"; zerResult = "0.2";
    posResult < 8, posResult = "0.400000"; negResult < 8,
    negResult = "0.400000"; zerResult < 8, zerResult = "0.200000" -> prints
    */

    /* Optimize
    O(n) runtime, separate for loop & while loop
    O(n) space, strings storage of specified length
    
    Could write another method for double to string conversion, to reduce similar lines of code
    */

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
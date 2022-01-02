import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
    // Write your code here
        
    /* Questions
    Are the given numbers sorted? (No, may be in any order)
    Are duplicate numbers counted in the sums? (Yes)
    Can any numbers be part of the sum, or does it need to be a numbers
    in a continuous order? (Any 4 of the 5 numbers)
    */
    
    /* Approach
    int stores min, max nums in array
    for loop iterates through array nums
        add value to total sum
        if statement checks less than min, greater than max
    print sum - max, sum - min
    */
    
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // Prevent int overflow
        long sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
            if (arr.get(i) < min) {
                min = arr.get(i);
            }
            if (arr.get(i) > max) {
                max = arr.get(i);
            }
        }
        System.out.println( (sum - max) + " " + (sum - min) );
        
    /* Tests
    [1,3,5,7,9] -> i = 0, sum = 1, min = 1, max = 1; i = 1, sum = 4, max = 3;
    i = 2, sum = 9, max = 5; i = 3, sum = 16, max = 7; i = 4, sum = 25, 
    max = 9 -> print 25 - 9 = 16, 25 - 1 = 24
    */
    
    /* Optimize
    O(n) runtime, single for loop iterates through given array size
    O(1) space, no additional data structures created
    */
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
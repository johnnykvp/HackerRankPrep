import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
    // Write your code here

    /* Questions
    Is the square matrix always the sane size? (No, may have different sizes)
    Are the values sorted in some way? (No, values may be in any order)
    Is the behavior changed at all for duplicates? (No, stays the same)
    */
    
    /* Approach
    square will always have the same num of rows & columns
    
    int sums store sum of both diagonals
    int counters stores row to check, 2nd counter starts at size - 1
    for loop iterates through columns
        increment sums
        increment 1st counter, decrement 2nd counter
    return absolute value of sum difference
    */
    
        int sum1 = 0;
        int sum2 = 0;
        int row1 = 0;
        int row2 = arr.size() - 1;
        for (int i = 0; i < arr.size(); i++) {
            sum1 += arr.get(i).get(row1);
            sum2 += arr.get(i).get(row2);
            row1++;
            row2--;
        }
        return Math.abs(sum1 - sum2);
    
        /* Tests
        123
        456
        989 -> i = 0, sum1 += c0r0 = 1, sum2 += c0r2 = 3, row1 = 1, row2 = 2;
        i = 1, sum1 += c1r1 = 6, sum2 += c1r1 = 8, row1 = 2, row2 = 0; i = 2,
        sum1 += c2r2 = 15, sum2 += c0r2 = 17 -> return 2
        */
        
        /* Optimize
        O(n) runtime, single for loop iterates through given array lengths
        O(1) space, no additional data structures created
        */
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }

        int result = Result.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
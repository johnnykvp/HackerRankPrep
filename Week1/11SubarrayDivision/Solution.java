import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'birthday' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY s
     *  2. INTEGER d
     *  3. INTEGER m
     */

    public static int birthday(List<Integer> s, int d, int m) {
    // Write your code here
    
    /* Questions
    Contiguous meaning a continuous section of the array? (Yes)
    Is the given array sorted? (No, may be in any order)
    */
    
    /* Approach
    int counter stores successful segments
    for loop iterates through array nums
        int stores sum
        nested for loop iterates through until reaching m length
            increment sum
        if statement checks sum == d
            increment success count
    return success count
    
    *Note: nested loops don't have to iterate over the next (i + 1) index
    */
    
        /*
        int success = 0;
        // Prevent index out of bounds
        for (int i = 0; i <= s.size() - m; i++) {
            int sum = 0;
            for (int j = i; j < i + m; j++) {
                sum += s.get(j);
            }
            if (sum == d) {
                success++;
            }
        }
        return success;
        */
        
    /* Tests
    [2,2,1,3,2], d = 4, m = 2 -> i = 0, j = 0, sum = 2; j = 1, sum = 4;
    success = 1; i = 1, j = 1, sum = 2; j = 2, sum = 3; i = 2, j = 2,
    sum = 1; j = 3, sum = 4; success = 2; i = 3, j = 3, sum = 3; j = 4,
    sum = 5 -> return 2
    */
    
    /* Optimize
    O(n^2) runtime, iterating through nested for loops based on given array
    O(1) space, no additional data structures created
    
    *Note: use sliding window
    
    int counter stores successful segments
    int stores sum
    int stores start index
    for loop iterates through array
        increment sum
        if statement checks length == m
            if statement checks sum == d
                increment success count
            remove previous start index from sum
            increment start index for next iteration
    return success count
    */
    
        int success = 0;
        int sum = 0;
        int start = 0;
        for (int i = 0; i < s.size(); i++) {
            sum += s.get(i);
            // Current length is current index - start index + 1 
            if (i - start + 1 == m) {
                if (sum == d) {
                    success++;
                }
                sum -= s.get(start);
                start++;
            }
        }
        return success;
        
        /* Tests
        [2,2,1,3,2], d = 4, m = 2 -> i = 0, sum = 2, 0 - 0 + 1 != 2; i = 1,
        sum = 4, 1 - 0 + 1 == 2, 4 == 4, success = 1, sum = 2, start = 1;
        i = 2, sum = 3, 2 - 1 + 1 == 2, 3 != 4, sum = 1, start = 2; i = 3,
        sum = 4, 3 - 2 + 1 == 2, 4 == 4, success = 2, sum = 3, start = 3;
        i = 4, sum = 5, 4 - 3 + 1 == 2, 5 != 4, sum = 2, start = 4
        -> return 2
        */
        
        /* Optimize
        O(n) runtime, iterate through single for loop based on given array
        O(1) space, no additional data structures created
        */
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] sTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> s = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sItem = Integer.parseInt(sTemp[i]);
            s.add(sItem);
        }

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.birthday(s, d, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
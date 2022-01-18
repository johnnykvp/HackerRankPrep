import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'pageCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER p
     */

    public static int pageCount(int n, int p) {
    // Write your code here

    /* Questions 
    Page nums start from either side, page 1 in front & page 1 in back? (No)
    */
    
    /* Examples
    *Note: write out a more detailed example/runthrough if confused
    
    length = 7, page num = 3
    [ ,1] -> [2,3] -> [4,5] -> [6,7]
          -> 1   2 <-     1 <-
    min: 1 turn
    */
    
    /* Approach
    int stores total page turns to reach end, n / 2
    int stores left to right page turns, p / 2
    int stores right to left page turns, total turns - left to right turns
    return min of left to right, right to left
    */
    
        int totalTurns = n / 2;
        int leftToRight = p / 2;
        int rightToLeft = totalTurns - leftToRight;
        return Math.min(leftToRight, rightToLeft);
        
    /* Tests
    n = 5, p = 3 -> totalTurns = 5 / 2 = 2; leftToRight = 3 / 2 = 1;
    rightToLeft = 2 - 1 = 1; min(1,1) = 1 -> return 1
    
    n = 7, p = 6 -> totalTurns = 7 / 2 = 3; leftToRight = 6 / 2 = 3;
    rightToLeft = 3 - 3 = 0; min(3,0) -> return 0
    
    n = 5, p = 1 -> totalTurns = 5 / 2 = 2; leftToRight = 1 / 2 = 0;
    rightToLeft = 2 - 0 = 2; min(0,2) -> return 0;
    */
    
    /* Optimize
    O(1) runtime, no loops to iterate through
    O(1) space, no additional data structures created
    */
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
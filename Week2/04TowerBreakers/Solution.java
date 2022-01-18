import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'towerBreakers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     */

    public static int towerBreakers(int n, int m) {
    // Write your code here

    /* Questions
    Are there only 2 choices? Mod 2 or reduce to 1? (Yes, for optimal play)
    Are tower heights always the same between other towers? (Yes, 1 size)
    Are tower heights always even? (No, just means there is only 1 choice)
    */
    
    /* Examples
    Think about how optimal moves are determined
    towers = any, height = 1 -> p1 loses
    
    towers = 1, height = 2 -> p2 loses
    towers = 2, height = 2 -> p1 loses
    towers = 3, height = 2 -> p2 loses
    
    towers = 1, height = 3 -> p2 loses
    towers = 2, height = 3 -> p1 loses
    towers = 3, height = 3 -> p2 loses
    
    towers = 1, height = 4 -> p2 loses
    towers = 2, height = 4 -> p1 loses
    towers = 3, height = 4 -> p2 loses
    
    pattern: 
    odd tower count, even height -> p1 wins
    even tower count, even height -> p2 wins
    odd tower count, odd height -> p1 wins
    even tower count, odd height -> p2 wins
    
    reduce pattern to:
    odd tower count -> p1 wins
    even tower count -> p2 wins
    */
    
    /* Approach
    if statement checks m == 1 || n % 2 == 0
        return p2
    else
        return p1
    */
    
        if (m == 1 || n % 2 == 0) {
            return 2;
        }
        return 1;

    /* Tests
    n = 2, m = 6 -> 2 % 2 = 0 -> return 2
    n = 2, m = 2 -> 2 % 2 = 0 -> return 2
    n = 1, m = 4 -> 1 % 2 != 0 -> return 1
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

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            int m = Integer.parseInt(firstMultipleInput[1]);

            int result = Result.towerBreakers(n, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
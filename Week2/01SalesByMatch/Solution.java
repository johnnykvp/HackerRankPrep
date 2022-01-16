import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
    // Write your code here

    /* Questions
    Is the given array sorted? (No, may be in any order)
    */
    
    /* Approach
    sort int array
    int counter stores pairs
    int counter stores sock color count
    for loop iterates through int array
        if statement checks color count == 2
            increment pairs
        if statement checks prev index is different
            reset color count to 0
    return pair count
    */
        
        /*
        Collections.sort(ar);
        int pairs = 0;
        int socks = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                if (ar.get(i - 1) != ar.get(i)) {
                    socks = 1;
                    continue;
                }
            }
            socks++;
            if (socks == 2) {
                pairs++;
                socks = 0;
            }
        }
        return pairs;
        */
        
    /* Tests
    [1,2,1,2,1,3,2] -> [1,1,1,2,2,2,3]; i = 0, socks = 1; i = 1, 1 == 1,
    socks = 2, pairs = 1, socks = 0; i = 2, 1 == 1, socks = 1; i = 2, 1 == 1,
    socks = 1; i = 3, 2 == 2, socks = 1; i = 4, 2 == 2, socks = 2, pairs = 2;
    i = 5, 2 == 2, socks = 1; i = 6, 2 != 3, socks = 1 -> return 2
    */
    
    /* Optimize
    O(nlogn) runtime, used Java collections to sort array
    O(1) space, no additional data structures created
    
    int stores max value
    for loop iterates through given int array
        if statement checks max < current value
            change max value
    int array stores color occurances, length is max int found in given array
    for loop iterates through given int array
        increment count in occurance array
    int counter stores pairs
    for loop iterates through occurance array
        increment pair count by taking value / 2
    return pair count
    */
    
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < ar.size(); i++) {
            if (max < ar.get(i)) {
                max = ar.get(i);
            }
        }
        int[] occurances = new int[max + 1];
        for (int i = 0; i < ar.size(); i++) {
            occurances[ar.get(i)] += 1;
        }
        int pairs = 0;
        for (int i = 0; i < occurances.length; i++) {
            pairs += occurances[i] / 2;
        }
        return pairs;
        
    /* Tests
    [1,2,1,2,1,3,2] -> max = 3; occurances = [0,0,0,0]; i = 0, [0,1,0,0];
    i = 1, [0,1,1,0]; i = 2, [0,2,1,0]; i = 3, [0,2,2,0]; i = 4, [0,3,2,0];
    i = 5, [0,3,2,1]; i = 6, [0,3,3,1]; i = 0, pairs = 0; i = 1, pairs = 1;
    i = 2, pairs = 2, i = 3, pairs = 2 -> return 2 
    */
    
    /* Optimize
    O(n) runtime, iterating through seperate for loops based on max value
    O(n) space, created array to store color counts
    
    *Note: could've used a map to store the color,occurances for a
    slightly more optimized & cleaner solution
    */
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> ar = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arTemp[i]);
            ar.add(arItem);
        }

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
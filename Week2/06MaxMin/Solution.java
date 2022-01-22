import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'maxMin' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */

    public static int maxMin(int k, List<Integer> arr) {
    // Write your code here

    /* Questions
    Can there be duplicate values given? (Yes)
    For duplicates, can you have the same value as both a min & max? (Yes, seems like it)
    Is the given array sorted? (No, may be in any order)
    Wouldn't the min unfairness just be the diff between the smallest values? (No, min diff in a range)
    */
    
    /* Approach
    find the range of values with the lowest difference
    
    sort int array
    int stores min diff
    for loop iterates through array ints
        int diff stores (current index + k - 1) - current index
        if statement checks diff < min
            min = diff
    return min
    */
    
        Collections.sort(arr);
        int min = Integer.MAX_VALUE;
        // Remember to put <= when subtracting k from array bounds to include last wanted indes
        for (int i = 0; i <= arr.size() - k; i++) {
            int diff = arr.get(i + k - 1) - arr.get(i);
            if (diff < min) {
                min = diff;
            }
        }
        return min;
    
    /* Tests
    [100,200,300,401,402,403], k = 3 -> i = 0, diff = 300 - 100 = 200, min = 200; i = 1,
    diff = 401 - 200 = 201; i = 2, diff = 300 - 402 = 202, i = 3, diff = 403 - 401 = 2, min = 2
    -> return 2
    */
    
    /* Optimize
    O(nlogn) runtime, uses Java Collections to sort given array
    O(1) space, no additional data structures created
    */
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(bufferedReader.readLine().trim());
            arr.add(arrItem);
        }

        int result = Result.maxMin(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
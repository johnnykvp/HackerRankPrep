import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'countingSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> countingSort(List<Integer> arr) {
    // Write your code here

    /* Questions
    The range is always 0 to n? (Yes, start at zero)
    */
    
    /* Approach
    int array stores frequencies, sorted by range of ints
    int max stores largest num found
    for loop iterates through given num array
        if statement checks max < current value
            change max value
    for loop iterates through until max value reached
        initialize frequency array values to 0
    for loop iterates through given array
        get value from array, increment frequency
    return frequency array
        
    * max value is not needed, always 100
    
    int array stores frequencies, sorted by range of ints
    for loop iterates to max value 100
        initialize freqency value
    for loop iterates through num array
        get value from array, increment frequency
    return frequency array
    */
    
        List<Integer> freq = new ArrayList<>();
        // Always 100 elements
        for (int i = 0; i < 100; i++) {
            freq.add(0);
        }
        for (int i = 0; i < arr.size(); i++) {
            int val = arr.get(i);
            freq.set(val, freq.get(val) + 1);
        }
        return freq;
        
        /* Tests
        [1,1,3,2,1] -> max = 3; freq = [0,0,0,0]; i = 0, val = 1,
        freq = [0,1,0,0]; i = 1, val = 1, freq = [0,2,0,0]; i = 2,
        val = 3, freq = [0,2,0,1]; i = 3, val = 2, freq = [0,2,1,1];
        i = 4, val = 1, freq = [0,3,1,1] -> return [0,3,1,1]
        */
    
        /* Optimize
        O(n) runtime, 2 separate for loops based on given array length
        O(n) space, create array to store frequency values
        */
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        List<Integer> result = Result.countingSort(arr);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
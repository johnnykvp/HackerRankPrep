import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int lonelyinteger(List<Integer> a) {
    // Write your code here
    
    /* Questions
    Is the given array sorted? (No, elements aren't sorted)
    */
    
    /* Approach
    sort int array
    int counter tracks element count
    for loop iterates through int array
        increment count
        if statement checks next index is different
            if statement checks count == 1
                return current index value
            else
                reset count to 0
    */
    
        Collections.sort(a);
        int count = 0;
        for (int i = 0; i < a.size() - 1; i++) {
            count++;
            if (a.get(i) != a.get(i + 1)) {
                if (count == 1) {
                    return a.get(i);
                }
                else {
                    count = 0;
                }
            }
        }
        // Return last index if it's the unique value
        return a.get(a.size() - 1);
        
    /* Tests
    [1,2,3,4,3,2,1] -> sort [1,1,2,2,3,3,4]; i = 0, count = 1; i = 1, count = 2, reset count;
    i = 2, count = 1; i = 3, count = 2, reset count; i = 4, count = 1; i = 5, count = 2, reset count;
    i = 6, count = 1 -> return 4
    */
    
    /* Optimize
    O(n) runtime, iterate through single for loop based on given array size
    O(1) space, no additional data structures created
    */
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aTemp[i]);
            a.add(aItem);
        }

        int result = Result.lonelyinteger(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
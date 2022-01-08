import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'twoArrays' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     *  3. INTEGER_ARRAY B
     */

    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
    // Write your code here

    /* Questions
    Set the resulting pairs always >= k if possible? (Yes)
    Are the given values sorted? (No, could be in any order)
    */
    
    /* Approach
    if max value + min value is not >= k, then permutation will fail
    
    sort arrays
    int iterator to traverse backwards in array B
    for loop iterates through array nums
        if statement checks array A min + array B max is < k
            return NO
    return YES
    */
    
        Collections.sort(A);
        Collections.sort(B);
        int iteratorB = B.size() - 1;
        for (int i = 0; i < A.size(); i++) {
            if ((A.get(i) + B.get(iteratorB)) < k) {
                return "NO";
            }
            iteratorB--;
        }
        return "YES";
        
    /* Tests
    A = [0,1], B = [0,2], k = 1 -> iteratorB = 1; i = 0, 0 + 2 >= 1,
    iteratorB = 0; i = 1, 1 + 0 >= 1, iteratorB = -1 -> return "YES"
    */
    
    /* Optimize
    O(nlogn) runtime, use of Java array sorting method
    O(1) space, no additional data structures created
    */
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            int k = Integer.parseInt(firstMultipleInput[1]);

            String[] ATemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> A = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int AItem = Integer.parseInt(ATemp[i]);
                A.add(AItem);
            }

            String[] BTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> B = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int BItem = Integer.parseInt(BTemp[i]);
                B.add(BItem);
            }

            String result = Result.twoArrays(k, A, B);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
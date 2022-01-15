import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'flippingMatrix' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int flippingMatrix(List<List<Integer>> matrix) {
    // Write your code here
    
    /* Example
    Think about where the values are placed after reversal
    112 42  83  119     a    b    b   a
    56  125 56  49  ->  c    d    d   c
    15  78  101 43      c    d    d   c
    62  98  114 108     a    b    b   a
    Need the greatest of a,b,c,d in the top left corner
    
    a: (0,0), (length - 1,0), (0,length - 1), (length - 1,length - 1)
    b: (0,0 + 1), (0,length - 2), (length - 2,0 + 1), (length - 2,length - 2)
    c: (0 + 1,0), (0 + 1,length - 1), (length - 2,0), (length - 2,length - 1)
    d: (0 + 1,0 + 1), (0 + 1,length - 2), (length - 2,0 + 1), (length - 2,length - 2)
    */
    
    /* Approach
    Find the first quadrant values, & match them up to their counterparts
    on the opposite side row-wise. Then take the max value between them,
    & continue to take the max for the opposites column-wise, finally
    taking the max between all corners, adding it to the sum.
    
    int stores sum
    for loop iterates through rows until length / 2
        nested for loop iterates through columns until length / 2
            int r1 stores row
            int r2 stores length - row - 1, the opposite side
            int c1 stores column
            int c2 stores length - column - 1, the opposite side
            find max of max([r1,c1], [r1, c2]), max([r2,c1], [r2, c2])
            increment max to sum
    */
        
        int sum = 0;
        for (int r = 0; r < matrix.size() / 2; r++) {
            for (int c = 0; c < matrix.size() / 2; c++) {
                int r1 = r;
                int r2 = matrix.size() - r - 1;
                int c1 = c;
                int c2 = matrix.size() - c - 1;
                sum += Math.max( 
                    Math.max(matrix.get(r1).get(c1), matrix.get(r1).get(c2)),
                    Math.max(matrix.get(r2).get(c1), matrix.get(r2).get(c2)) );
            }
        }
        return sum;
        
    /* Complexity
    O(n^2) runtime, iterating through nested for loop based on given matrix size
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
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<List<Integer>> matrix = new ArrayList<>();

            for (int i = 0; i < 2 * n; i++) {
                String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                List<Integer> matrixRowItems = new ArrayList<>();

                for (int j = 0; j < 2 * n; j++) {
                    int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
                    matrixRowItems.add(matrixItem);
                }

                matrix.add(matrixRowItems);
            }

            int result = Result.flippingMatrix(matrix);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
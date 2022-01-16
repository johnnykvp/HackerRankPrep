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

    /* Notes
    We want the top left quadrant to have the max possible values to sum
    Can only reverse the rows/columns
    Think about where the values will be after reversal
    
    4x4:
    a   b   b   a
    c   d   d   c
    c   d   d   c
    a   b   b   a
    Letters represent the spots they can swap with
    */

    /* Approach
    int stores sum
    for loop iterates through matrix rows, until length / 2 (first quadrant only)
        nested for loop iterates through matrix columns, until length / 2
            int stores opposite side row index, length - current row index - 1
            int stores opposite side column index, length - current column index - 1
            // Basically, this next part finds the max for the letter spots
            // For example, with 'a', it will consider all its possible corner values
            find max value of max([current row, current col], [current row, opposite col]), 
                max([opposite row, current col], [opposite row, opposite col])
            increment max to sum
    return sum
    */
    

        int sum = 0;
        for (int r = 0; r < matrix.size() / 2; r++) {
            for (int c = 0; c < matrix.size() / 2; c++) {
                int oppoRow = matrix.size() - r - 1;
                int oppoCol = matrix.size() - c - 1;
                sum += Math.max(
                    Math.max(matrix.get(r).get(c), matrix.get(r).get(oppoCol)),
                    Math.max(matrix.get(oppoRow).get(c), matrix.get(oppoRow).get(oppoCol)) );
            }
        }
        return sum;
        
    /* Complexity
    O(n^2) runtime, iterates through nested for loop based on given matrix size
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
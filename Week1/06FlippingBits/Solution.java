import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'flippingBits' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static long flippingBits(long n) {
    // Write your code here

    /* Questions
    Unsigned ints meaning positive values only? (Yes)
    */
    
    /* Approach
    convert long to binary string
    while loop iterates until string is 32 bits
        add 0 to the beginning of the string
    change char values from 0 to 1, 1 to 0, including a temp value
    convert binary num back into long
    */
        
        String binary = Long.toBinaryString(n);
        // Fill full 32 bits length after conversion
        while (binary.length() < 32) {
            binary = '0' + binary;
        }
        // Java Strings are immutable,
        // ex. need to write string = string.change, not just string.change
        // Temp value 9
        binary = binary.replace('0', '9');
        binary = binary.replace('1', '0');
        binary = binary.replace('9', '1');
        // 2nd parameter is the radix, which specifies the numeral system 
        // to convert from in the 1st parameter's string
        return Long.parseLong(binary, 2);
        
        /* Tests
        1 -> binary = 1; binary = 00000000000000000000000000000001;
        binary = 99999999999999999999999999999991; 
        binary = 99999999999999999999999999999990;
        binary = 11111111111111111111111111111110 -> return 4294967294
        */
        
        /* Optimize
        O(n) runtime, while loop & string replace based on given int length
        O(n) space, created string to store bits
        */
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            long n = Long.parseLong(bufferedReader.readLine().trim());

            long result = Result.flippingBits(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
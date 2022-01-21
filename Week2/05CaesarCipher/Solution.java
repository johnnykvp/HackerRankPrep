import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
    // Write your code here
        
    /* Questions
    Do non-letters get shifted? (No)
    Does different capitalization get shifted too? (Yes, keeps the same capitalization per letter)
    */
    
    /* Approach
    string stores new encrypyted string
    for loop iterates through given string length
        int stores k % 26 to find actual shift amount, avoiding many overlaps with larger k ints
        if statement checks char is a letter
            int stores ascii value
            add k to ascii value
            if statement checks ascii value is larger than upper/lowercase range
                subtract 26 from ascii value
            convert ascii to char
        add char to new string
    return encrypted string
    */
    
        String encrypt = "";
        int shift = k % 26;
        for (int i = 0; i < s.length(); i++) {
            char input = s.charAt(i);
            if (Character.isLetter(input)) {
                int ascii = input;
                ascii += shift;
                if ( (Character.isUpperCase(input) && ascii > 90) ||
                     (Character.isLowerCase(input) && ascii > 122) ) {
                    ascii -= 26;
                }
                input = (char) ascii;
            }
            encrypt += input;
        }
        return encrypt;
        
    /* Tests
    "Wx!", 3 -> shift = 3; i = 0, 'W' is letter, ascii = 87, 87 + 3 = 90, input = 'Z', encrypt = "Z";
    i = 1, 'x' is letter, ascii = 120, 120 + 3 = 123, 123 > 122, 123 - 26 = 97, input = 'a', 
    encrypt = "a"; '!' is not letter, encrypt = "Za!" -> return "Za!"
    */
    
    /* Optimize
    O(n) runtime, iterate through single for loop based on given string length
    O(n) space, created additional string to store encrypted chars
    */
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
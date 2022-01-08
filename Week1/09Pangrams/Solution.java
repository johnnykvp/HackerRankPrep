import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'pangrams' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String pangrams(String s) {
    // Write your code here
    
    /* Questions
    What is a pangram? (Sentence containing every letter of the alphabet)
    Does letter casing matter? (No, ignore case)
    */
    
    /* Approach
    alphabet contains 26 letters
    
    change string chars to lowercase only
    set to store unique letters
    for loop iterates through string chars
        add letter to set
    if statement checks set size == 26
        return pangram
    return not pangram
    */
    
        // Remember: Java Strings are immutable!
        s = s.toLowerCase();
        Set<Character> uniques = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            uniques.add(s.charAt(i));
        }
        System.out.println(uniques.size());
        if (uniques.size() == 26) {
            return "pangram";
        }
        return "not pangram";
    
    /* Tests
    "The quick brown fox jumps over the lazy dog"
    -> s = "the quick brown fox jumps over the lazy dog";
    uniques = [t,h,e,q,u,i,c,k,b,r,o,w,n,f,x,j,m,p,s,v,l,a,z,y,d,g];
    uniques size == 26 -> return "pangram"
    */
    
    /* Optimize
    O(n) runtime, single for loop iterates through given string length
    O(n) space, string & set created for char storage
    */
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
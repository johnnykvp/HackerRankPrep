import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
    // Write your code here

    /* Questions
    Does 12:00AM turn into 0:00? (Yes)
    Does 1:00PM turn into 13:00? (Yes)
    */
    
    /* Approach
    split ":" in string
    split last section using substring
    convert hour string to int
    if statement checks am
        if statement checks 12 hour
            change hour to 0
    else pm
        if statement checks !12 hour
            add 12 to hour
    return time string
    */
    
        String[] section = s.split(":");
        String seconds = section[2].substring(0,2);
        String amPm = section[2].substring(2);
        int hour = Integer.parseInt(section[0]);
        if (amPm.equals("AM")) {
            if (hour == 12) {
                section[0] = "00";
            }
        }
        else {
            if (hour != 12) {
                hour += 12;
                section[0] = Integer.toString(hour);
            }
        }
        return section[0] + ":" + section[1] + ":" + seconds;
        
    /* Tests
    "12:01:00PM" -> section[0] = "12", section[1] = "01", section[2] = "00PM";
    seconds = "00"; amPm = "PM"; hour = 12 -> return "12:01:00"
    
    "12:01:00AM" -> section[0] = "12", section[1] = "01", section[2] = "00AM";
    seconds = "00"; amPM = "AM"; hour = 12; section[0] = "00"
    -> return "00:01:00"
    */
    
    /* Optimize
    O(1) runtime, no loops used
    O(n) space, additional strings created
    */
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
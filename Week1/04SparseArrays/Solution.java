import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY strings
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
    // Write your code here
    
    /* Questions
    Are the given strings or queries sorted? (No, may be unsorted)
    Are there any duplicates in the queries? (No)
    */
    
    /* Approach
    int array stores occurances
    for loop iterates through array of queries
        for loop iterates through array of strings
            if statement checks query included in strings
                increment occurance
    return array of occurances
    */
    
        /*
        List<Integer> occurances = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            int count = 0;
            for (int j = 0; j < strings.size(); j++) {
                if (queries.get(i).equals(strings.get(j))) {
                    count++;
                }
            }
            occurances.add(count);
        }
        return occurances;
        */
        
    /* Tests
    queries = [ab,abc,bc]
    strings = [ab,ab,abc] -> i = 0, j = 0, ab == ab, count = 1; j = 1,
    ab == ab, count = 2; ab != abc, occurances = [2]; i = 1, j = 0, 
    abc != ab; j = 1, abc != ab; j = 2, abc == abc, count = 1, 
    occurances = [2,1]; i = 2, j = 0, bc != ab; j = 1, bc != ab; j = 2,
    bc != abc, occurances = [2,1,0] -> return [2,1,0]
    */
    
    /* Optimize
    O(n^2) runtime, iterates through nested for loop
    O(n) space, created arraylist based on given queries list size
    
    map stores strings, occurances
    for loop iterates through array of strings
        if statement checks map contains string
            increment occurance
        else
            add string to map, with occurance 1
    int array stores occurances
    for loop iterates through array of queries
        if statement checks map contains query
            add occurance to array
        else
            add 0 occurances
    return array of occurances
    */
    
        Map<String, Integer> occurances = new HashMap<>();
        for (int i = 0; i < strings.size(); i++) {
            String input = strings.get(i);
            if (occurances.containsKey(input)) {
                occurances.put(input, occurances.get(input) + 1);
            }
            else {
                occurances.put(input, 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            String query = queries.get(i);
            if (occurances.containsKey(query)) {
                result.add(occurances.get(query));
            }
            else {
                result.add(0);
            }
        }
        return result;
    
    /* Tests
    strings = [ab,ab,abc]
    queries = [ab,abc,bc] -> i = 0, add (ab,1); i = 1, replace (ab,2); i = 2
    add (abc,1); i = 0, contains ab, result = [2]; i = 1, contains abc,
    result = [2,1]; i = 2, !contains bc, result = [2,1,0] -> return [2,1,0]
    */
    
    /* Optimize
    O(n) runtime, iterate through 2 separate for loops
    O(n) space, create map & array with size based on given string/query arrays
    */
    
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> strings = new ArrayList<>();

        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = bufferedReader.readLine();
            strings.add(stringsItem);
        }

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> queries = new ArrayList<>();

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = bufferedReader.readLine();
            queries.add(queriesItem);
        }

        List<Integer> res = Result.matchingStrings(strings, queries);

        for (int i = 0; i < res.size(); i++) {
            bufferedWriter.write(String.valueOf(res.get(i)));

            if (i != res.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
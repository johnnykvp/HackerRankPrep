import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static String stringsXOR(String s, String t) {
        // Debug
        // XOR: only true if both values are the same
        
        String res = new String("");
        for(int i = 0; i < s.length(); i++) {
            // Change from '=' to '=='
            if(s.charAt(i) == t.charAt(i))
                // Change from '+' to '+='
                res += "0";
            else
                res += "1";
        }

        return res;
    }

    public static void main(String[] args) {

        String s, t;
        Scanner in = new Scanner(System.in);
        s = in.nextLine();
        t = in.nextLine();
        System.out.println(stringsXOR(s, t));

    }

}
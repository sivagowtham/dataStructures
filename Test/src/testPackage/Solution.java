package testPackage;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;
public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    	System.out.println("Entern string");
        Scanner inp = new Scanner(System.in);
		String myname = inp.nextLine();
//        String[] strarray = myname.split("");
//		StringBuffer strbuff = new StringBuffer();
//		HashMap<String, Integer> ht = new HashMap<String, Integer>();
//		for(int i=0;i<=(strarray.length)-1;i++)
//		{
//            
//            if(ht.containsKey(strarray[i]))
//            {
//            	int value = (int) ht.get(strarray[i]);
//            	ht.put(strarray[i], value+1);
//            }
//            else
//            {
//            	ht.put(strarray[i], 1);
//            }
//        }
//		System.out.println(ht);
		System.out.println(compressString(myname));
        
    }
    public static StringBuilder buildOutput(StringBuilder bdr, char target,
			int rep) {
		bdr.append(target);
		if (rep > 0) {
			bdr.append(Integer.toString(rep + 1));
		}
		return bdr;
	}

	public static String compressString(String s) {
		StringBuilder buf = new StringBuilder();
		if (s == null || s.length() < 2) {
			return s;
		}

		char cur = s.charAt(0);
		char pre = cur;
		int rep = 0;

		for (int i = 1; i < s.length(); i++) {
			cur = s.charAt(i);
			if (cur == pre) {
				rep++;
			} else {
				buf = buildOutput(buf, pre, rep);
				pre = cur;
				rep = 0;
			}
		}
		buf = buildOutput(buf, pre, rep);
		return buf.toString();
	}
}